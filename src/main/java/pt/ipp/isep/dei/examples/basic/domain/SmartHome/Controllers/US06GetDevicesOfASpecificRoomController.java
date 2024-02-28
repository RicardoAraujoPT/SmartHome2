package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Device;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.House;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Room;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.DeviceDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Mappers.DeviceDTOMapper;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Mappers.RoomDTOMapper;

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
     * This method retrieves a list of DeviceDTOs for a specific room.
     * It first gets the list of rooms from the house, then maps the rooms to their DTOs.
     * It then retrieves the room that matches the provided roomDTOName from the map.
     * Finally, it gets the devices from the room and maps them to their DTOs before returning them.
     *
     * @param roomDTOName The name of the room for which to retrieve the devices.
     * @return A list of DeviceDTOs for the specified room.
     */
    public List<DeviceDTO> getDevicesOfASpecificRoom(String roomDTOName){

        List<Room> rooms = _house.getRoomList();
        this.rooms_DTOAndRooms = RoomDTOMapper.roomMap_DTOAndDomain(rooms);
        Room room = rooms_DTOAndRooms.get(roomDTOName);
        List<Device> devices = room.getDevices();
        return DeviceDTOMapper.devices_DomainToDTO(devices);
        }
}

