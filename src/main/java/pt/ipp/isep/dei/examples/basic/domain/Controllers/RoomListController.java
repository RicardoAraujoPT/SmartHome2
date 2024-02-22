package pt.ipp.isep.dei.examples.basic.domain.Controllers;

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
