package ru.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;


@SpringBootApplication
@RestController
public class RestEntryPoint {

    private volatile int progress = 0;
    private Map<String, FileDescriptor> uploadMap = new ConcurrentHashMap<>();
    private ObjectMapper mapper = new ObjectMapper();
    private volatile ProcessingStatus processingStatus = ProcessingStatus.IDLE;
    private Thread processThread;

    public static void main(String[] args) {
        SpringApplication.run(RestEntryPoint.class, args);
    }


    public RestEntryPoint() {
        processThread = new Thread(() -> {
            while (true) {
                if (processingStatus == ProcessingStatus.IN_PROCESS) {
                    if (progress < 100) {
                        progress = progress + 1;
                        if (progress == 100) {
                            processingStatus = ProcessingStatus.IDLE;
                        }
                    }
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        processThread.setName("processThread");
        processThread.setDaemon(true);
        processThread.start();
    }

    @GetMapping("/hello")
    public String hello(String request) {
        return "Свой сериализуемый объект";
    }

    @PostMapping("/clear")
    public String clear() {
        uploadMap.clear();
        return "OK";
    }

    @PostMapping("/startProcessing")
    public String startProcessing() {
        progress = 0;
        processingStatus = ProcessingStatus.IN_PROCESS;
        return "OK";
    }

    @PostMapping("/stopProcessing")
    public String stopProcessing() {
        processingStatus = ProcessingStatus.IDLE;
        return "OK";
    }

    @GetMapping("/getProgress")
    public Integer getProgress() {
        return progress;
    }

    @GetMapping("/getStatus")
    public String getStatus() {
        return processingStatus.toString();
    }

    @GetMapping("/getFiles")
    public Object getFiles() {
        List<FileViewDescriptor> res = uploadMap.entrySet().stream()
                .map(item -> item.getValue())
                .map(item -> new FileViewDescriptor(item.content.length, item.name, item.type))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        String resStr = "";
        try {
            resStr = mapper.writeValueAsString(res);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "FAIL";
        }
        return resStr;
    }

    @PostMapping("/loadFile")
    public String loadFile(@RequestParam("file") MultipartFile file,
                           RedirectAttributes redirectAttributes) {
        try {
            System.out.println(file.getResource().getFilename() +
                    " ---> " + file.getResource().contentLength() +
                    "  desc: " + file.getResource().getDescription() +
                    "  isFile: " + file.getResource().isFile());
            byte[] bytes = file.getBytes();
            System.out.println("===>" + new String(bytes));
            System.out.println("--------------------------------------------");
            uploadMap.put(file.getOriginalFilename(),
                    new FileDescriptor(file.getBytes(), file.getOriginalFilename(), file.getContentType()));
        } catch (IOException e) {
            e.printStackTrace();
            return "FAIL";
        }
        return "OK";
    }
}
