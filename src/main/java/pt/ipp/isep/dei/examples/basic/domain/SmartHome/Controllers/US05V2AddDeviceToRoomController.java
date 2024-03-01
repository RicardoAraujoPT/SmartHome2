package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.DeviceDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Device;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.House;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Room;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Mappers.DeviceMapper;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Mappers.RoomMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class US05V2AddDeviceToRoomController {

    /**
     * The house object that contains the list of rooms.
     */
    private House _myHouse;

    /**
     * Constructor for the AddDeviceToRoomController.
     *
     * @param house The house to which the devices will be added.
     * @throws IllegalArgumentException if the provided house is null.
     */
    public US05V2AddDeviceToRoomController(House house) {
        if (house == null) {
            throw new IllegalArgumentException("Provided house cannot be null");
        }
        this._myHouse = house;
    }


    /**
     * Adds a device to a specified room in the house.
     *
     * @param roomName   The name of the room to which the device will be added.
     * @param deviceName The name of the device to be added.
     * @return deviceDTO if the device is successfully added, otherwise an IllegalArgumentException is thrown
     */
    /*
    public DeviceDTO addDeviceToRoom(String roomName, String deviceName) {
            // get room by name from house
            Room myRoom = this._myHouse.getRoomByName(roomName);
            // add device  to room
            Device device = myRoom.createDevice(deviceName);
            //create deviceDTO
            DeviceDTO deviceDTO = DeviceDTOMapper.DeviceToDTO(device);
            // return deviceDTO to indicate successful addition of the device
            return deviceDTO;
    }
     */

    /**
     * This method adds a device to a specific room and returns a list of DeviceDTOs for that room.
     * It first gets the list of rooms from the house, then maps the rooms to their DTOs.
     * It then retrieves the room that matches the provided roomName from the map.
     * A device with the provided deviceName is created in the retrieved room.
     * Finally, it gets the updated list of devices from the room and maps them to their DTOs before returning them.
     *
     * @param roomName The name of the room to which the device will be added.
     * @param deviceName The name of the device to be added.
     * @return A list of DeviceDTOs for the specified room after the device addition.
     * @throws IllegalArgumentException If the device with the provided name already exists in the room.
     */

    //Implementacao alternativa com o HashMap
    private Map<String, Room> _rooms_DTOAndRooms = new HashMap<>();

    public List<DeviceDTO> addDeviceToRoom(String roomName, String deviceName) throws InstantiationException {
        List<Room> rooms = _myHouse.getRoomList();
        this._rooms_DTOAndRooms = RoomMapper.roomMap_NameAndDomain(rooms);
        Room room = _rooms_DTOAndRooms.get( roomName );
        room.addDevice(deviceName);
        List<Device> devices = room.getDevices();
        return DeviceMapper.devices_DomainToDTO(devices);
    }

}
