package pl.java_application.usbdevice;

import java.io.IOException;

public interface USBDevice {
    boolean connect() throws IOException;
    boolean disconnect() throws IOException;
    String getName();
}
