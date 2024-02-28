package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain;


public class FactoryRoom {

    FactoryDevice _factoryDevice;

    public FactoryRoom(FactoryDevice factoryDevice)
    {
        _factoryDevice = factoryDevice;
    }

    public Room createRoom( String roomName, Integer floorNumber, double area, double height) throws InstantiationException {
        return new Room(roomName, floorNumber, area, height, _factoryDevice);
    }

}
