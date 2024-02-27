package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.DeviceDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.RoomDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Device;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.House;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Room;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Mappers.DeviceDTOMapper;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Mappers.RoomDTOMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddDeviceToRoomController {

    private House _myHouse;

    /**
     * Constructor for the AddDeviceToRoomController.
     *
     * @param house The house to which the devices will be added.
     * @throws IllegalArgumentException if the provided house is null.
     */
    public AddDeviceToRoomController(House house) {
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
    //Implementacao alternativa com o HashMap
    private Map<String, Room> _rooms_DTOAndRooms = new HashMap<>();

    public List<DeviceDTO> addDeviceToRoom(RoomDTO roomDTO, String deviceName) {
        List<Room> rooms = _myHouse.getRoomList();
        this._rooms_DTOAndRooms = RoomDTOMapper.roomMap_DTOAndDomain(rooms);
        Room room = _rooms_DTOAndRooms.get( roomDTO.getName() );
        room.createDevice(deviceName);
        List<Device> devices = room.getDevices();
        return DeviceDTOMapper.devices_DomainToDTO(devices);
    }

}
