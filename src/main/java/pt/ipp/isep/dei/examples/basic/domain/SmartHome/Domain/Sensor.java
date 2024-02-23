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
     * Gets the name of the sensor.
     * @return The name of the sensor.
     */
    String getName();

    /**
     * Gets the unit of measurement of the sensor.
     * @return The unit of measurement of the sensor.
     */
    String getUnitOfMeasurement();

    /**
     * Gets the state of the sensor.
     * @return The state of the sensor.
     */
    boolean getState();

    /**
     * Gets the measurement of the sensor.
     *
     * @return The measurement of the sensor.
     */
    double getMeasurement();

    /**
     * Gets the type of the sensor.
     *
     * @return The type of the sensor.
     */
    String getType();

    /**
     * Validates the name of the sensor.
     * @param name The name of the sensor.
     * @return true if the name is valid, false otherwise.
     */

    boolean isSensorNameDuplicated(String name);

    /**
     * Validates the unit of measurement of the sensor.
     * @param unitOfMeasurement The unit of measurement of the sensor.
     * @return true if the unit of measurement is valid, false otherwise.
     */
    boolean isSensorUnitOfMeasurementDuplicated(String unitOfMeasurement);

}





