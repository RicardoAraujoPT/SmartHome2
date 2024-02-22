package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.DeviceDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.*;


/**
 * This class represents a controller for User Story 09 (US09).
 * It provides a method to get devices by type in a house.
 **/

public class DeactivateDeviceController {

    /**
     * The house from which the devices will be retrieved.
     */
    private House _house;

    /**
     * Constructs a new US09GetDevicesByTypeController with the specified house.
     * @param house the house from which the devices will be retrieved.
     */
    public DeactivateDeviceController(House house) {
        _house = house;
    }

    public boolean deactivateDevice(DeviceDTO myDeviceDTO) {
        //Device myDevice = DTOtoDomain(myDeviceDTO)
        //myDevice.deactivateDevice;
        return true;
    }
}
