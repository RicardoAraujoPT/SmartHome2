package pt.ipp.isep.dei.examples.basic.domain;

    public class ImplementFactoryDevice implements FactoryAlojamento {
    public Device createDevice(String deviceName) {

        return new Device(deviceName);
    }
}

