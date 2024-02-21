package pt.ipp.isep.dei.examples.basic.domain;

    public class ImplementFactoryAlojamento implements FactoryAlojamento {
    public Device createDevice(String deviceName) {

        return new Device(deviceName);
    }
}

