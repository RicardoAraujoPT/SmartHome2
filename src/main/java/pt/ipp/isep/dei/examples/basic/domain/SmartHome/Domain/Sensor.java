package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain;

/**
 * Represents a sensor.
 * This interface defines the contract for a sensor in the SmartHome domain.
 * Each sensor has a sensor type.
 */

/**
 * This interface represents a Sensor with a name, unit of measurement, state, and measurement.
 * It provides methods to get the name, unit of measurement, state, and measurement of the sensor.
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





