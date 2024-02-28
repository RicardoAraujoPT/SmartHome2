package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.RoomDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.House;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Room;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Mappers.RoomMapper;

/**
 * The CreateRoomController Class
 */

public class US02CreateRoomController {

    private House _myHouse;

    /**
     * Constructs a US02CreateRoomController with the given house.
     *
     * @param house The house object where the Room will be added.
     * @throws InstantiationException if the house is null.
     */

    public US02CreateRoomController(House house) throws InstantiationException {
        if(house == null){
            throw new InstantiationException ("Invalid house");
        }

        this._myHouse = house;
    }

    /**
     * Creates and adds a Room to the house.
     * @param roomDTO the roomDTO object that contains information to create the room.
     * @return RoomDTO of the room created and added to the house.
     * @throws InstantiationException if the arguments for creating the room aren't valid.
     */

    public RoomDTO createRoom (RoomDTO roomDTO) throws InstantiationException {


            Room myRoom = _myHouse.addRoom(roomDTO.getName(), roomDTO.getHouseFloor(), roomDTO.getArea(), roomDTO.getHeight());

            RoomDTO myRoomDTO = RoomMapper.room_DomainToDTO(myRoom);

            return myRoomDTO;
    }
}
