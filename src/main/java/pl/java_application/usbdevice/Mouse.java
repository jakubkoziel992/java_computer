package pl.java_application.usbdevice;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Mouse implements USBDevice {
    private final String name;

    Path path = Paths.get("C:\\Kuba\\Projekty\\Java\\oop-projekt\\src\\main\\resources\\output.txt");

    public Mouse(String name) {
        this.name = name;
    }

    @Override
    public boolean connect() throws IOException {
//        Path fileName = Path.of("C:\\Kuba\\Projekty\\Java\\oop-projekt\\src\\main\\resources\\output.txt");
          String output = System.lineSeparator() + "Mouse connected";
          Files.write(path, output.getBytes(),StandardOpenOption.WRITE,StandardOpenOption.TRUNCATE_EXISTING);
        /* System.out.println("Mouse connected"); */
        return true;
    }

    @Override
    public boolean disconnect() throws IOException {
//        Path fileName = Path.of("C:\\Kuba\\Projekty\\Java\\oop-projekt\\src\\main\\resources\\output.txt");
        String output = System.lineSeparator() + "Mouse disconnected";
        Files.write(path, output.getBytes(),StandardOpenOption.APPEND);
//      System.out.println("Mouse disconnected");
        return true;
    }

    @Override
    public String getName() {
        return name;
    }
}
