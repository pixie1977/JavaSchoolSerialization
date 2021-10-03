package ru.common;

public class FileDescriptor {
    public final byte[] content;
    public final String name;
    public final String type;


    public FileDescriptor(byte[] content, String name, String type) {
        this.content = content;
        this.name = name;
        this.type = type;
    }
}
