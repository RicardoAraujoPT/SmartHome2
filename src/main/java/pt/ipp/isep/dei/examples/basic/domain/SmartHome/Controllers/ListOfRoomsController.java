package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers;

import java.util.ArrayList;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.RoomDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.House;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Room;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Mappers.RoomDTOMapper;

public class ListOfRoomsController {


    private House _myHouse;

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
    public ArrayList<Room> getRoomList(){

        ArrayList<Room> listOfRooms = this._myHouse.getRoomList();

        return listOfRooms;

    }


    public ArrayList<RoomDTO> getRoomDTOList(){


        ArrayList<Room> listOfRoomsInHouse = this._myHouse.getRoomList();

        ArrayList<RoomDTO> listOfRoomsInHouseDTO = RoomDTOMapper.convertDomainToDTO(listOfRoomsInHouse);

        return listOfRoomsInHouseDTO;

    }


}
