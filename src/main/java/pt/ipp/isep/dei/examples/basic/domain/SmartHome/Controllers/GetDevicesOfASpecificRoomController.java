package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Device;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.House;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Room;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.DeviceDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.RoomDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Mappers.DeviceDTOMapper;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Mappers.RoomDTOMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This class is responsible for controlling the operations related to getting devices of a specific room.
 * It uses DeviceDTOMapper and RoomDTOMapper to map between DTO and domain objects.
 * It also uses a House object to get the list of rooms.
 */

public class GetDevicesOfASpecificRoomController {

    /**
     * The mapper for Device and DeviceDTO.
     */
    private DeviceDTOMapper deviceDTOMapper;

    /**
     * The mapper for Room and RoomDTO.
     */
    private RoomDTOMapper RoomDTOMapper;

    /**
     * The house object that contains the list of rooms.
     */
    private House _house;

    /**
     * Constructor for GetDevicesOfASpecificRoomController.
     * @param deviceDTOMapper The mapper for Device and DeviceDTO.
     * @param roomDTOMapper The mapper for Room and RoomDTO.
     * @param house The house object that contains the list of rooms.
     */

    public GetDevicesOfASpecificRoomController(DeviceDTOMapper deviceDTOMapper, RoomDTOMapper roomDTOMapper, House house) {
        this.deviceDTOMapper = deviceDTOMapper;
        this.RoomDTOMapper = roomDTOMapper;
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
    public List<DeviceDTO> getDevicesOfASpecificRoom(RoomDTO roomDTO) throws InstantiationException {

        if (roomDTO == null) {
            throw new InstantiationException("RoomDTO cannot be null");
        }

        List<Room> rooms = _house.getRoomList();
        Map<String, Room> roomsDTOAndRooms = RoomDTOMapper.roomMap_DTOAndDomain(rooms);
        Room room = roomsDTOAndRooms.get(roomDTO);

        if (room == null) {
            return new ArrayList<>();
        }

        //Como estava antes:
        //    Room room = RoomDTOMapper.room_DTOToDomain(roomDTO);
            List<Device> devices = room.getDevices();
            List<DeviceDTO> deviceDTOs = new ArrayList<>();
            for (Device device : devices) {
                DeviceDTO deviceDTO = DeviceDTOMapper.DeviceToDTO(device);
                deviceDTOs.add(deviceDTO);
            }
            return deviceDTOs;
        }

    /**
     * This method returns the DeviceDTOMapper used by this controller.
     * @return The DeviceDTOMapper used by this controller.
     */

    public DeviceDTOMapper getDeviceDTOMapper() {
        return deviceDTOMapper;
    }

}

