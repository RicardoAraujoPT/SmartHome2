package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.RoomDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.House;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Room;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Mappers.RoomDTOMapper;

public class ListOfRoomsController {


    private static House _myHouse;
    private Map<String, Room> _rooms_DTOAndRooms = new HashMap<>();

    public ListOfRoomsController(House myHouse){
        if(myHouse == null){
            throw new IllegalArgumentException("Invalid house");
        }

        this._myHouse = myHouse;
    }

    /**
     * This method accesses the list of rooms in the House object.
     * @return ArrayList<Room>.
     */
    public static ArrayList<Room> getRoomList(){

        ArrayList<Room> listOfRooms = _myHouse.getRoomList();

        return new ArrayList<>(listOfRooms);

    }


    public ArrayList<RoomDTO> getRoomDTOList(){


        ArrayList<Room> listOfRoomsInHouse = this._myHouse.getRoomList();

        ArrayList<RoomDTO> listOfRoomsInHouseDTO = RoomDTOMapper.convertDomainToDTO(listOfRoomsInHouse);

        return new ArrayList<>(listOfRoomsInHouseDTO);

    }

    public List<String> getRooms() {
        List<Room> rooms = _myHouse.getRoomList();

        this._rooms_DTOAndRooms = RoomDTOMapper.roomMap_DTOAndDomain(rooms);

        return _rooms_DTOAndRooms.keySet().stream().toList();
    }


}
