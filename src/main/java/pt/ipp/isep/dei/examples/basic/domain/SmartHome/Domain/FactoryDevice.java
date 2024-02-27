package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain;

public class FactoryDevice {
    public Device newDevice(String deviceName) throws InstantiationException{
        return new Device(deviceName);
    }
}
