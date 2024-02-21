package pt.ipp.isep.dei.examples.basic.domain;

public class FactoryRoom {

    public Room createRoom(String RoomName, int houseFloor, double area, double height) {

        return new Room(RoomName,houseFloor,area,height);
    }

}
