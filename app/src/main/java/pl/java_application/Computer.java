package pl.java_application;


import pl.java_application.drive.Drive;
import pl.java_application.file.File;
import pl.java_application.usbdevice.USBDevice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private Monitor monitor;
    private Drive drive;
    private Headphones headphones;

    List<USBDevice> usbDevices = new ArrayList<>();

    public Computer(Monitor monitor, Drive drive){
        this.monitor = monitor;
        this.drive = drive;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Drive getDrive() {
        return drive;
    }

    public void setDrive(Drive drive) {
        this.drive = drive;
    }

    public Headphones getHeadphones() {
        return headphones;
    }

    public void setHeadphones(Headphones headphones) {
        this.headphones = headphones;
    }

    public List<USBDevice> getUsbDevices() {
        return usbDevices;
    }

    public void addUSBDevice(USBDevice usbDevice) throws IOException {
        boolean isConnected = usbDevice.connect();

        if (isConnected){
            usbDevices.add(usbDevice);
        }


    }

    public void removeUSBDevice(USBDevice usbDevice) throws IOException {
        boolean isDisconnected = usbDevice.disconnect();

        if (!isDisconnected){
            System.out.println("USB Device forcefully disconnected");
        }
        usbDevices.remove(usbDevice);


    }

    public void addFile(File file){
        drive.addFile(file);
    }

    public void listFiles(){
        drive.listFiles();
    }

    public File findFile(String fileName){
        return drive.findFile(fileName);
    }
}
