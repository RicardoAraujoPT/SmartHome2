package pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Actuator;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Sensor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * The DeviceDTO class represents a Data Transfer Object (DTO) for a device in the SmartHomeProject.
 * It encapsulates the device's name, device ID, active status, and lists of associated sensors and actuators.
 * The class provides methods to get these attributes.
 *
 * The DeviceDTO class interacts with the following classes:
 * - Sensor: The DeviceDTO class has a list of Sensor names.
 * - Actuator: The DeviceDTO class has a list of Actuator names.
 *
 * The name of the device is a string that cannot be null or empty.
 *
 * The device ID is a unique identifier for the device generated when the device is created and used to identify it in
 * the system. It is a string and cannot be null or empty. It is immutable and cannot be changed after it is set.
 *
 * The active status is a boolean that represents whether the device is currently active or not.
 *
 * The list of sensors is a list of Sensor names that are associated with the device.
 *
 * The list of actuators is a list of Actuator names that are associated with the device.
 *
 * Usage:
 * Creating a device DTO:
 * DeviceDTO deviceDTO = new DeviceDTO(deviceName, deviceID, isActive, sensors, actuators);
 */

public class DeviceDTO {
    /**
     * The name of the device.
     * It is a string and cannot be null or empty.
     */
    private String _deviceName;

    /**
     * The device ID. This is a unique identifier for the device generated when the device is created and used to
     * identify it in the system.
     * It is generated using the UUID class.
     * It is a string and cannot be null or empty. It is immutable and cannot be changed after it is set.
     */
    private final String _deviceID;

    /**
     * Indicates whether the device is currently active or not.
     * By default, the device is not active.
     */
    private boolean _isActive;

    /**
     * List of available sensors for the device.
     * It is a list of strings.
     */
    private final ArrayList<Sensor> _sensors;

    /**
     * List of available actuators for the device.
     * It is a list of strings.
     */

    private final ArrayList<Actuator> _actuators;

    /**
     * Constructs a new DeviceDTO with the specified device name and device ID.
     * The device is initially inactive, and the lists of sensors and actuators are empty.
     *
     * @param deviceName The name of the device. It cannot be null or empty.
     * @param deviceID The unique identifier of the device. It cannot be null or empty.
     */

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


    /**
     * Method that returns the device ID.
     * @return The device ID.
     */
    public String getDeviceID() {
        return _deviceID;
    }

    /**
     * Method that returns the active status of the device.
     * @return The active status of the device.
     */
    public boolean getIsActive() {
        return _isActive;
    }

//Falta colocar getter de sensores e actuadores, quando necessário

}


