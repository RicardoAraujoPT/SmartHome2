package pt.ipp.isep.dei.examples.basic.domain;

public class FactoryDevice {
    public Device createDevice(String deviceName) {

        return new Device(deviceName);
    }

}

