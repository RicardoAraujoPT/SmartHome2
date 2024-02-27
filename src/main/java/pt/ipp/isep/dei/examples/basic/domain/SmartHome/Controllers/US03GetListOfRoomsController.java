package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.RoomDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.House;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Room;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Mappers.RoomDTOMapper;

public class US03GetListOfRoomsController {


    private static House _myHouse;
    private Map<String, Room> _rooms_DTOAndRooms = new HashMap<>();

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
    public static ArrayList<Room> getRoomList(){

        ArrayList<Room> listOfRooms = _myHouse.getRoomList();

        return new ArrayList<>(listOfRooms);

    }


    public ArrayList<RoomDTO> getRoomDTOList(){


        ArrayList<Room> listOfRoomsInHouse = this._myHouse.getRoomList();

        RoomDTOMapper myRoomMapper = new RoomDTOMapper(_myHouse);

        ArrayList<RoomDTO> listOfRoomsInHouseDTO = myRoomMapper.convertDomainToDTO(listOfRoomsInHouse);

        return new ArrayList<>(listOfRoomsInHouseDTO);

    }

    public List<String> getRooms() {
        List<Room> rooms = _myHouse.getRoomList();

        RoomDTOMapper myRoomDTOMapper = new RoomDTOMapper(_myHouse);

        this._rooms_DTOAndRooms = myRoomDTOMapper.roomMap_DTOAndDomain(rooms);

        return _rooms_DTOAndRooms.keySet().stream().toList();
    }


}