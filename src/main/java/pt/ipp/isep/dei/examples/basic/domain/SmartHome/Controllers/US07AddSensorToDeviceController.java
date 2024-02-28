package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.AddSensorToDeviceDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.SensorDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.*;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Mappers.SensorDTOMapper;

import java.util.List;

/**
 * This class is responsible for controlling the operations related to adding a sensor to a device.
 * It uses a House object to get the room and device to which the sensor will be added.
 * It also uses a Catalogue object to get the sensor models.
 */
public class US07AddSensorToDeviceController {

    /**
     * The house object that contains the list of rooms and devices.
     */
    private House _house;

    /**
     * The catalogue object that contains the list of sensor models.
     */
    private Catalogue _catalogue;

    /**
     * Constructor for AddSensorToDeviceController.
     * @param house The house object that contains the list of rooms and devices.
     * @param catalogue The catalogue object that contains the list of sensor models.
     * @throws InstantiationException If the house or catalogue is null.
     */

    public US07AddSensorToDeviceController(House house, Catalogue catalogue) throws InstantiationException {
        if (!isValidConstructorArguments(house, catalogue))
            throw (new InstantiationException("Invalid arguments"));
        _house = house;
        _catalogue = catalogue;

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
     * This method returns a list of sensor models from the catalogue.
     * @return A list of sensor models.
     */
    public List<String> getSensorsModels() {
        return _catalogue.getSensorModels();
    }

    /**
     * This method adds a sensor to a device in a room.
     * It first gets the room and device from the house using the room name and device name from the DeviceDTO.
     * Then it adds a sensor to the device using the sensor model and the catalogue.
     * @param deviceDTO The DeviceDTO that contains the room name and device name.
     * @param strSensorModel The sensor model to add to the device.
     * @return The sensor that was added to the device.
     */
    public SensorDTO addSensorToDevice(AddSensorToDeviceDTO entryDTO) {

        Room room = _house.getRoomByName(entryDTO._roomName);

        Device device =room.getDeviceByName(entryDTO._deviceName);

        Sensor sensor = device.addSensor(entryDTO._strSensorModel, this._catalogue);

        return SensorDTOMapper.convertToDTO(sensor);
    }

}


