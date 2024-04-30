package pl.java_application.usbdevice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class MemoryStick implements USBDevice{
    private final String name;
    private boolean ejected = false;
    Path path = Paths.get("C:\\Kuba\\Projekty\\Java\\oop-projekt\\src\\main\\resources\\output.txt");

    public MemoryStick(String name) {
        this.name = name;
    }

    @Override
    public boolean connect() throws IOException {
        String output = System.lineSeparator() + "Memory Stick connected";
        Files.write(path, output.getBytes(), StandardOpenOption.APPEND);
        return true;
    }

    @Override
    public boolean disconnect() {
        if (ejected){
            System.out.println("Memory Stick disconnected");
            return true;
        } else {
            System.out.println("Please Memory Stick disconnect first!");
            return false;
        }
    }

    @Override
    public String getName() {
        return name;
    }

    public void eject(){
        System.out.println("Ejected Memory Stick");
        ejected = true;
    }
}
