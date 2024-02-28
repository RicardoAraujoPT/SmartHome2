package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain;

/**
 * Represents a sensor type.
 * This class encapsulates the properties and behavior of a sensor type in the SmartHome domain.
 * Each sensor type has a description and a unit of measurement.
 */
public class SensorType {
    private final String _strDescription;
    private final Unit _unit;

    /**
     * Creates a new instance of SensorType.
     *
     * @param strDescription The description of the sensor type. This parameter must not be null or empty.
     * @param unit           The unit of measurement for the sensor type. This parameter must not be null.
     * @throws InstantiationException If the provided arguments are not valid (e.g., null or empty description).
     */
    public SensorType(String strDescription, Unit unit) throws InstantiationException {
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
     * Gets the description of the sensor type.
     *
     * @return The description of the sensor type.
     */
    public String getDescription() {
        return _strDescription;
    }

    /**
     * Gets the unit of measurement for the sensor type.
     *
     * @return The unit of measurement for the sensor type.
     */
    public Unit getUnit() {
        return _unit;
    }
}