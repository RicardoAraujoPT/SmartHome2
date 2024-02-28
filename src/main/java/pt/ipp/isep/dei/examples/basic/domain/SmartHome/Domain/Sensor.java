package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain;

/**
 * This interface defines the contract for a sensor in the SmartHome domain.
 * Each sensor has a sensor type.
 */
public interface Sensor {

    /**
     * Gets the current value of the sensor.
     *
     * @return The value of the sensor.
     */
    Value getValue();

    /**
     * Gets the type of the sensor.
     *
     * @return The type of the sensor.
     */
    SensorType getSensorType();

}