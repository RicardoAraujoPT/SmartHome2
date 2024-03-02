package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.SensorType;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Unit;

/**
 * Represents a factory for creating SensorType objects.
 * This class encapsulates the creation of SensorType objects in the SmartHome domain.
 * It provides a method for creating a SensorType given a description and a unit of measurement.
 */
public class FactorySensorType {

    /**
     * Creates a new instance of SensorType.
     *
     * @param description The description of the sensor type. This parameter must not be null or empty.
     * @param unit        The unit of measurement for the sensor type. This parameter must not be null.
     * @return A new instance of SensorType.
     * @throws InstantiationException If the provided arguments are not valid (e.g., null or empty description).
     */
    public SensorType newSensorType(String description, Unit unit) throws InstantiationException {

        return new SensorType(description, unit);
    }
}
