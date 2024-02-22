package pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Actuator;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Sensor;

import java.util.ArrayList;
import java.util.UUID;

/**
 * The DeviceDTO class represents a Data Transfer Object (DTO) for a device in the SmartHomeProject.
 * It encapsulates the device's name, model, floor number, room name, and a list of associated sensors.
 * The class provides methods to get these attributes.
 *
 * The DeviceDTO class interacts with the following classes:
 * - Sensor: The DeviceDTO class has a list of Sensor objects.
 *
 * The name of the device is a string that represents the unique identifier of the device.
 * It cannot be null or empty.
 *
 * The model of the device is a string that represents the model of the device.
 * It cannot be null or empty.
 *
 * The floor number is an integer that represents the floor where the device is located.
 *
 * The room name is a string that represents the name of the room where the device is located.
 * It cannot be null or empty.
 *
 * The list of sensors is a list of Sensor objects that are associated with the device.
 *
 * Usage:
 * Creating a device DTO:
 * DeviceDTO deviceDTO = new DeviceDTO(deviceName, model, floorNumber, roomName);
 */

public class DeviceDTO {
    /**
     * The name of the device.
     */
    private String _deviceName;

    /**
     * The device ID.
     */
    private final String _deviceID;

    /**
     * Indicates whether the device is currently active or not.
     * By default, the device is not active.
     */
    private boolean _isActive;

    /**
     * List of available sensors for the device.
     */
    private final ArrayList<Sensor> _sensors;

    /**
     * List of available actuators for the device.
     */
    private final ArrayList<Actuator> _actuators;

    public DeviceDTO(String deviceName, String deviceID) {
        _deviceName = deviceName;
        _deviceID = UUID.randomUUID().toString();
        _sensors = new ArrayList<>();
        _actuators = new ArrayList<>();
        _isActive = false;
    }

    /**
     * Method that returns the name of the device.
     *
     * @return The name of the device.
     */
    public String getDeviceName() {
        return _deviceName;
    }

}


