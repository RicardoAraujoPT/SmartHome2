package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain;

import java.util.ArrayList;
import java.util.List;

public class FactoryRoom {

    public Room createRoom( String roomName, Integer floorNumber, double area, double height) throws InstantiationException
    {
        return new Room(roomName, floorNumber, area, height);
    }

    public ArrayList<Room> initRooms(){

        return new ArrayList<Room>();
    }

}
