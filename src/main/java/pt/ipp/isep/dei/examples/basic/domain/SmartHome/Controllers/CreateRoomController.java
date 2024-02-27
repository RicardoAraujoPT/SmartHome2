package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.RoomDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.House;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Room;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Mappers.RoomDTOMapper;

public class CreateRoomController {

    private House _myHouse;

    public CreateRoomController (House house) throws InstantiationException {
        if(house == null){
            throw new InstantiationException ("Invalid house");
        }

        this._myHouse = house;
    }

    public RoomDTO createRoom (RoomDTO roomDTO) throws InstantiationException {


            Room myRoom = _myHouse.createRoom(roomDTO.getName(), roomDTO.getHouseFloor(), roomDTO.getArea(), roomDTO.getHeight());

            RoomDTOMapper myRoomMapper = new RoomDTOMapper(_myHouse);

            RoomDTO myRoomDTO = myRoomMapper.room_DomainToDTO(myRoom);

            return myRoomDTO;
    }
}
