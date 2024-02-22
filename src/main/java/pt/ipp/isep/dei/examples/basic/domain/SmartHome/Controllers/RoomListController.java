package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.RoomDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.House;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Room;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Mappers.RoomDTOMapper;

import java.util.ArrayList;

public class RoomListController {

    private House _myHouse;



    public RoomListController(House myHouse){
        if(myHouse == null){
            throw new IllegalArgumentException("Invalid house");
        }

        this._myHouse = myHouse;
    }


    public ArrayList<RoomDTO> getHouseRoomList(){


        ArrayList<Room> listOfRoomsInHouse = this._myHouse.getRoomList();

        ArrayList<RoomDTO> listOfRoomsInHouseDTO = RoomDTOMapper.convertDomainToDTO(listOfRoomsInHouse);

        return listOfRoomsInHouseDTO;

    }

}
