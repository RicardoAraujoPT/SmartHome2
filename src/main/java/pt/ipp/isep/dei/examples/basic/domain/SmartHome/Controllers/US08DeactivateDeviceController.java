package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.DeviceDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.*;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Mappers.DeviceMapper;


/**
 * This class represents a controller for User Story 09 (US09).
 * It provides a method to deactivate a device in a House
 **/

public class US08DeactivateDeviceController {

    /**
     * The house where the device is located
     */
    private final House _house;

    /**
     * Constructs a new US09GetDevicesByTypeController with the specified house.
     * @param house the house from which the devices will be retrieved.
     */
    public US08DeactivateDeviceController(House house) {
        if (house == null) {
            throw new IllegalArgumentException("Invalid house");
        }
        this._house = house;
    }


    /**
     * Given a deviceName and a roomName, it deactivates an object Device present in a House.
     * @param deviceName the deviceName of the object Device to deactivate
     * @param roomName the room name in which the device is located
     * @return returns a deviceDTO
     */
    public DeviceDTO deactivateDevice(String deviceName, String roomName) {
        _house.getRoomByName(roomName).getDeviceByName(deviceName).deactivateDevice();
        return DeviceMapper.DeviceToDTOWithStatus(_house.getRoomByName(roomName).getDeviceByName(deviceName));
    }

}