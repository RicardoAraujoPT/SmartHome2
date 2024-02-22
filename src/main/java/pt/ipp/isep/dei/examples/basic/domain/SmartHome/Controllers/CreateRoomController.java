package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.RoomDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.House;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Room;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Mappers.RoomDTOMapper;

public class CreateRoomController {

    private House _myHouse;

    public CreateRoomController (House house){
        if(house == null){
            throw new IllegalArgumentException("Invalid house");
        }

        this._myHouse = house;
    }

    public RoomDTO createRoom (RoomDTO roomDTO) {

        try {

            Room myRoom = _myHouse.createRoom(roomDTO.getName(), roomDTO.getHouseFloor(), roomDTO.getArea(), roomDTO.getHeight());

            RoomDTO myRoomDTO = RoomDTOMapper.room_DomainToDTO(myRoom);

            return myRoomDTO;
        }

        catch (InstantiationException e){
            return null;
        }
    }
}
