package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.RoomDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.House;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Room;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Mappers.RoomMapper;

public class US02CreateRoomController {

    private House _myHouse;

    public US02CreateRoomController(House house) throws InstantiationException {
        if(house == null){
            throw new InstantiationException ("Invalid house");
        }

        this._myHouse = house;
    }

    public RoomDTO createRoom (RoomDTO roomDTO) throws InstantiationException {


            Room myRoom = _myHouse.createRoom(roomDTO.getName(), roomDTO.getHouseFloor(), roomDTO.getArea(), roomDTO.getHeight());

            RoomDTO myRoomDTO = RoomMapper.room_DomainToDTO(myRoom);

            return myRoomDTO;
    }
}
