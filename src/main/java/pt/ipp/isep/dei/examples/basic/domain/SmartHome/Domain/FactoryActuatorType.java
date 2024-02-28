package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain;

/**
 * Represents a factory for creating ActuatorType objects.
 * This class encapsulates the creation of ActuatorType objects in the SmartHome domain.
 * It provides a method for creating a ActuatorType given a description and a unit of measurement.
 */
public class FactoryActuatorType {

    /**
     * Creates a new instance of ActuatorType.
     *
     * @param description The description of the actuator type. This parameter must not be null or empty.
     * @param unit        The unit of measurement for the actuator type. This parameter must not be null.
     * @return A new instance of ActuatorType.
     * @throws InstantiationException If the provided arguments are not valid (e.g., null or empty description).
     */
    public ActuatorType createActuatorType(String description, Unit unit) throws InstantiationException {

        return new ActuatorType(description, unit);
    }
}