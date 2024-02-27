package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Device;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.House;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Room;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.DeviceDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.RoomDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Mappers.DeviceDTOMapper;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Mappers.RoomDTOMapper;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is responsible for controlling the operations related to getting devices of a specific room.
 * It uses DeviceDTOMapper and RoomDTOMapper to map between DTO and domain objects.
 * It also uses a House object to get the list of rooms.
 */

public class US06GetDevicesOfASpecificRoomController {

    /**
     * The house object that contains the list of rooms.
     */
    private House _house;
    /**
     * Map that stores the rooms and their corresponding RoomDTOs.
     */
    private Map<String, Room> rooms_DTOAndRooms;

    /**
     * Constructor for GetDevicesOfASpecificRoomController.
     * @param house The house object that contains the list of rooms.
     * @throws IllegalArgumentException if the provided house is null.
     */

    public US06GetDevicesOfASpecificRoomController(House house) {
        if (house == null) {
            throw new IllegalArgumentException("Provided house cannot be null");
        }
        this._house = house;
    }

    /**
     * This method returns a list of DeviceDTOs of a specific room.
     * If the RoomDTO is null, it throws an InstantiationException.
     * If the RoomDTO does not exist in the map, it returns an empty list.
     * @param roomDTO The RoomDTO to get the devices from.
     * @return A list of DeviceDTOs of the specific room.
     * @throws InstantiationException If the RoomDTO is null.
     */
    public List<DeviceDTO> getDevicesOfASpecificRoom(RoomDTO roomDTO){

        List<Room> rooms = _house.getRoomList();
        RoomDTOMapper myRoomMapper = new RoomDTOMapper(_house);
        this.rooms_DTOAndRooms = myRoomMapper.roomMap_DTOAndDomain(rooms);
        Room room = rooms_DTOAndRooms.get(roomDTO.getName());
        List<Device> devices = room.getDevices();
        return DeviceDTOMapper.devices_DomainToDTO(devices);
        }
}

