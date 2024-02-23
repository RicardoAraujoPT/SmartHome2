package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.DeviceDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.*;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Mappers.DeviceDTOMapper;

import java.util.HashMap;


/**
 * This class represents a controller for User Story 09 (US09).
 * It provides a method to get devices by type in a house.
 **/

public class DeactivateDeviceController {

    /**
     * The house where the device is located
     */
    private House _house;

    /**
     * Constructs a new US09GetDevicesByTypeController with the specified house.
     * @param house the house from which the devices will be retrieved.
     */
    public DeactivateDeviceController(House house) {
        this._house = house;
    }

    /**
     * Deactivates an object Device present in a House.
     *
     * @param myDeviceDTO a deviceDTO
     * @return DeviceDTO (deactivated device)
     */
    public DeviceDTO deactivateDevice(DeviceDTO myDeviceDTO) {
        Device myDevice = getDeviceFromDomain(myDeviceDTO);
        myDevice.deactivateDevice();
        return DeviceDTOMapper.DeviceToDTOWithStatus(myDevice);
    }

    public Device getDeviceFromDomain(DeviceDTO deviceDTO) {
        DeviceDTOMapper deviceDTOMapper = new DeviceDTOMapper(_house);
        HashMap<DeviceDTO,Device> deviceDTODeviceHashMap = deviceDTOMapper.getMapDevicesDTO();
        return deviceDTODeviceHashMap.get(deviceDTO);
    }
}
