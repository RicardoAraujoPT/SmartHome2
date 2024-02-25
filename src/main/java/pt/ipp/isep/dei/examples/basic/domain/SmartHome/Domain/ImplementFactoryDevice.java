package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain;

   public class ImplementFactoryDevice implements FactoryDevice {
    public Device createDevice(String deviceName) {

        return new Device(deviceName);
    }
}

