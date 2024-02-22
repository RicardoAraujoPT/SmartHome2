package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Device {


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
    private final boolean _isActive;

    /**
     * List of available sensors for the device.
     */
    private final ArrayList<Sensor> _sensors;

    /**
     * List of available actuators for the device.
     */
    private final ArrayList<Actuator> _actuators;

    /**
     * Constructs a new Device with the specified name, sensor name, and sensor type.
     *
     * @param deviceName    The name of the device.
     * @throws IllegalArgumentException If the deviceName is invalid (null or empty).
     */
    public Device(String deviceName) {
        if (deviceName == null || deviceName.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid arguments for Device");
        }

        _deviceName = deviceName;
        _deviceID = UUID.randomUUID().toString();
        _sensors = new ArrayList<>();
        _actuators = new ArrayList<>();
        _isActive = false;
    }

    /**
     * Gets the name of the device.
     *
     * @return The name of the device.
     */
    public String getDeviceName() {
        return _deviceName;
    }

    /**
     * Gets the device ID.
     * @return The name of the device ID.
     */
    public String getDeviceID() {
        return _deviceID;
    }

    /**
     * Retrieves the current activation status of the device.
     * @return true if the device is active, false otherwise.
     */
    public Boolean getDeviceIsActive() { return _isActive; }

    /**
     * Gets a copy of the list of available sensors.
     * @return A list of available sensors.
     */
    public List<Sensor> getAvailableSensors() {
        return new ArrayList<>(_sensors);
    }

    /**
     * Gets a copy of the list of available actuators.
     * @return A list of available actuators.
     */
    public List<Actuator> getAvailableActuators() {
        return new ArrayList<>(_actuators);
    }


    /**
     * Set the name of the device.
     *
     * @param name The new name for the device.
     * @throws IllegalArgumentException If the provided name is null or empty.
     */
    public void setDeviceName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Device name cannot be null or empty");
        }
        this._deviceName = name;
    }



}
