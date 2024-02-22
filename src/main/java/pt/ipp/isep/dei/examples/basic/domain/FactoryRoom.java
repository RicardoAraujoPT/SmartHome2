package pt.ipp.isep.dei.examples.basic.domain;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Room;

public class FactoryRoom {

    public Room createRoom(String roomName, Integer floorNumber, double area, Double height) throws InstantiationException {

        return new Room(roomName, floorNumber, area,height);
    }
}
