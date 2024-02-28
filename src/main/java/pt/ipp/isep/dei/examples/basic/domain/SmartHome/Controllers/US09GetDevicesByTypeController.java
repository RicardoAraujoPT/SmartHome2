package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.DeviceDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.*;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Mappers.DeviceMapper;

import java.util.HashMap;
import java.util.List;

public class US09GetDevicesByTypeController {
    /**
     * The house from which the devices will be retrieved.
     */
    private House _house;

    /**
     * The catalogue object that contains the list of sensor models.
     */
    private Catalogue _catalogue;


    /**
     * Constructs a new US09GetDevicesByTypeController with the specified house.
     * @param house the house from which the devices will be retrieved.
     */
    public US09GetDevicesByTypeController(House house, Catalogue catalogue) throws IllegalArgumentException{
        if (!isValidConstructorArguments(house, catalogue))
            throw (new IllegalArgumentException("Invalid arguments"));
        this._house = house;
        this._catalogue = catalogue;

    }
    /**
     * This method checks if the house and catalogue are not null.
     * @param house The house object to check.
     * @param catalogue The catalogue object to check.
     * @return true if both the house and catalogue are not null, false otherwise.
     */

    private boolean isValidConstructorArguments(House house, Catalogue catalogue) {
        return house != null && catalogue != null;
    }

    /**
     * Returns a map of device types and their corresponding devices in the house.
     * @return a map of device types and their corresponding devices in the house.
     */
    public HashMap<String, List<DeviceDTO>> getDevicesByType() {
        HashMap<String, HashMap<Room,List<Device>>> groupDevicesByType = _house.groupDevicesByType();
        HashMap<String, List<DeviceDTO>> groupDevicesByTypeDTO = DeviceMapper.devicesMap_DomainToDTO(groupDevicesByType);
        return groupDevicesByTypeDTO;
    }
}
