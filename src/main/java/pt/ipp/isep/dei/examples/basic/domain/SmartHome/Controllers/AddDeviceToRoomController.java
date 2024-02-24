package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.DeviceDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Device;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.House;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Room;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Mappers.DeviceDTOMapper;

import java.util.ArrayList;

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
        try {
            // get room by name from house
            Room myRoom = this._myHouse.getRoomByName(roomName);
            // add device  to room
            Device device = myRoom.createDevice(deviceName);
            //create deviceDTO
            DeviceDTO deviceDTO = DeviceDTOMapper.DeviceToDTO(device);
            // return deviceDTO to indicate successful addition of the device
            return deviceDTO;
        }
        catch (IllegalArgumentException e){
            // catch IllegalArgumentException and return null if it occurs
            return null;
        }

    }


}
