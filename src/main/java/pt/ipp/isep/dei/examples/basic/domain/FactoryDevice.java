package pt.ipp.isep.dei.examples.basic.domain;

public class FactoryDevice {
    public Device makeDevice(String deviceName) {

        return new Device(deviceName);
    }

}

