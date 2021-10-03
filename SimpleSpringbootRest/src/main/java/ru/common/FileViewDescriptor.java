package ru.common;

public class FileViewDescriptor {
    public final int contentLength;
    public final String name;
    public final String type;


    public FileViewDescriptor(int contentLength, String name, String type) {
        this.contentLength = contentLength;
        this.name = name;
        this.type = type;
    }
}
