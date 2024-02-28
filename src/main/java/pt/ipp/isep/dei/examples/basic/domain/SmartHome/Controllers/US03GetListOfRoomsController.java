package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.RoomDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.House;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Room;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Mappers.RoomMapper;

/**
 * The US03GetListOfRoomsController class is a controller for the use case US03 - Get List of Rooms.
 * It is responsible for handling the logic related to retrieving a list of rooms from a House object.
 * It contains methods to get the list of rooms, convert them to RoomDTO objects, and get their names.
 */
public class US03GetListOfRoomsController {

    /**
     * The House object from which the list of rooms will be retrieved.
     */
    private static House _myHouse;

    /**
     * A map that stores the Room objects and their corresponding RoomDTO objects.
     */
    private Map<String, Room> _rooms_DTOAndRooms = new HashMap<>();


    /**
     * Constructor for the US03GetListOfRoomsController class.
     * It initializes the House object and checks if it is null.
     *
     * @param myHouse The House object from which the list of rooms will be retrieved.
     * @throws IllegalArgumentException If the House object is null.
     */
    public US03GetListOfRoomsController(House myHouse){
        if(myHouse == null){
            throw new IllegalArgumentException("Invalid house");
        }

        this._myHouse = myHouse;
    }

    /**
     * This method accesses the list of rooms in the House object.
     * @return ArrayList<Room>.
     */
    public static ArrayList<RoomDTO> getRoomList(){
        ArrayList<Room> listOfRooms = _myHouse.getRoomList();
        ArrayList<RoomDTO> roomDTOList = RoomMapper.convertDomainToDTO(listOfRooms);
        return roomDTOList;
    }

}
