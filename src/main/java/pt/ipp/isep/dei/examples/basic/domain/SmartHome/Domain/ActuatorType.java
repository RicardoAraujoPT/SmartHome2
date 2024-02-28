package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain;

/**
 * Represents an actuator type.
 * This class encapsulates the properties and behavior of an actuator type in the SmartHome domain.
 * Each actuator type has a description and a unit of measurement.
 */
public class ActuatorType {
    private final String _strDescription;
    private final Unit _unit;

    /**
     * Creates a new instance of ActuatorType.
     *
     * @param strDescription The description of the actuator type. This parameter must not be null or empty.
     * @param unit           The unit of measurement for the actuator type. This parameter must not be null.
     * @throws InstantiationException If the provided arguments are not valid (e.g., null or empty description).
     */
    public ActuatorType(String strDescription, Unit unit) throws InstantiationException {
        if (!isValidConstructorArgument(strDescription))
            throw (new InstantiationException("Invalid arguments"));

        this._strDescription = strDescription;
        this._unit = unit;
    }

    /**
     * Validates the constructor arguments.
     *
     * @param strDescription The description of the sensor type.
     * @return true if the description is not null and not empty, false otherwise.
     */
    private boolean isValidConstructorArgument(String strDescription) {
        return strDescription != null && !strDescription.isEmpty();

    }

    /**
     * Gets the description of the actuator type.
     *
     * @return The description of the actuator type.
     */
    public String getDescription() {
        return _strDescription;
    }

    /**
     * Gets the unit of measurement for the actuator type.
     *
     * @return The unit of measurement for the actuator type.
     */
    public Unit getUnit() {
        return _unit;
    }
}
