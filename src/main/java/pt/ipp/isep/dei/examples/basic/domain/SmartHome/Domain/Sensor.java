package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain;

/**
 * Represents a sensor.
 * This interface defines the contract for a sensor in the SmartHome domain.
 * Each sensor has a sensor type.
 */
public interface Sensor {

    /**
     * Gets the sensor type of the sensor.
     *
     * @return The sensor type of the sensor.
     */
    SensorType getSensorType();


}


