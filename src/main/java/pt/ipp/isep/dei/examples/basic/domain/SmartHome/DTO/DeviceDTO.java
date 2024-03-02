package pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Actuator;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Device;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Sensor;

import java.util.ArrayList;
import java.util.UUID;


/**
 * The DeviceDTO class represents a Data Transfer Object (DTO) for a device in the SmartHomeProject.
 * It encapsulates the device's name, active status, and lists of associated sensors and actuators.
 * The class provides methods to get these attributes.
 * <p>
 * The DeviceDTO class interacts with the following classes:
 * - Sensor: The DeviceDTO class has a list of Sensor names.
 * - Actuator: The DeviceDTO class has a list of Actuator names.
 * <p>
 * The name of the device is a string that cannot be null or empty.
 * <p>
 * The device ID is a unique identifier for the device generated when the device is created and used to identify it in
 * the system. It is a string and cannot be null or empty. It is immutable and cannot be changed after it is set.
 * <p>
 * The active status is a boolean that represents whether the device is currently active or not.
 * <p>
 * The list of sensors is a list of Sensor names that are associated with the device.
 * <p>
 * The list of actuators is a list of Actuator names that are associated with the device.
 * <p>
 * Usage:
 * Creating a device DTO:
 * DeviceDTO deviceDTO = new DeviceDTO(deviceName, isActive, sensors, actuators);
 */

public class DeviceDTO {
    /**
     * The name of the device.
     * It is a string and cannot be null or empty.
     */
    private String _deviceName;

   // private String _deviceID;

    /**
     * Indicates whether the device is currently active or not.
     * By default, the device is not active.
     */
    private boolean _isActive;

    /**
     * List of available sensors for the device.
     * It is a list of strings.
     */
    private final ArrayList<Sensor> _sensors = new ArrayList<>();

    /**
     * List of available actuators for the device.
     * It is a list of strings.
     */

    private final ArrayList<Actuator> _actuators = new ArrayList<>();

    /**
     * Room name where device is located.
     * String identifier of a room.
     */
    private String _roomName;

    /**
     * Constructs a new DeviceDTO with the specified device name and room name.
     * The device is initially active.
     *
     * @param deviceName The name of the device. It cannot be null or empty.
     * @param roomName   The name of the room where the device is located. It cannot be null or empty.
     */

    public DeviceDTO(String deviceName, String deviceID, String roomName) {
        _deviceName = deviceName;
       // _deviceID = deviceID;
        _roomName = roomName;
        _isActive = true;
    }

    /**
     * Constructs a new DeviceDTO with the specified device name and active status
     * The device is initially active, and the lists of sensors and actuators are empty.
     *
     * @param deviceName The name of the device. It cannot be null or empty.
     * @param isActive   The active status of the device.
     */

    public DeviceDTO(String deviceName, boolean isActive) {
        this._deviceName = deviceName;
        this._isActive = isActive;
    }

    /**
     * Constructs a new DeviceDTO with the specified device name and room name.
     * The device is initially inactive, and the lists of sensors and actuators are empty.
     *
     * @param deviceName The name of the device. It cannot be null or empty.
     * @param roomName   The name of the room where the device is located. It cannot be null or empty.
     */

    public DeviceDTO(String deviceName, String roomName) {
        this._deviceName = deviceName;
        this._roomName = roomName;
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
     * The method returns the name of the room where the device is located.
     *
     * @return The name of the room where the device is located.
     */
    public  String getRoomName() {
        return _roomName;
    }

    //public String getDeviceID() { return _deviceID;}

    /**
     * Method that returns the active status of the device.
     *
     * @return The active status of the device.
     */
    public boolean getIsActive() {
        return _isActive;
    }

//Falta colocar getter de sensores e actuadores, quando necessário

/*
    public ArrayList<Sensor> get_sensors() {
        return _sensors;
    }

    public ArrayList<Actuator> get_actuators() {
        return _actuators;
    }
    */

}


