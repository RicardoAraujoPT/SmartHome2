package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain;

/**
 * The SensorTypeHumidityBosch class represents a humidity sensor from the model Bosch.
 * It implements the Sensor interface and provides methods to get and set sensor attributes such as name, unit of measurement, and value.
 * Usage:
 * Creating a sensor:
 * SensorTypeHumidityBosch sensor = new SensorTypeHumidityBosch(name, unitMeasurement, value)
 * The SensorTypeHumidityBosch class interacts with the following classes:
 * - Sensor: SensorTypeHumidityBosch implements the Sensor interface.
 */
public class SensorTypeHumidityBosch implements Sensor {
    /**
     * The name of the sensor.
     * It is a string that represents the unique identifier of the sensor.
     * It cannot be null or empty.
     */
    private String _name;
    /**
     * The unit of measurement of the sensor.
     * It is a string that represents the unit in which the sensor value is measured.
     * It cannot be null or empty.
     */
    private String _unitMeasurement;
    /**
     * The value of the sensor.
     * It is a double that represents the current reading of the sensor.
     * It must be between 0 and 100, representing the percentage of humidity.
     */
    private double _value;
    /**
     * The type of the sensor.
     * It is a string that represents the type of the sensor.
     * It is set to "Humidity" by default.
     */
    private final String _type = "Humidity";
    /**
     * The model of the sensor.
     * It is a string that represents the model of the sensor.
     * It is set to "Humidity Bosch" by default.
     */
    private final String _model = "Humidity Bosch";

    /**
     * SensorTypeHumidityBosch constructor with parameters name, unitMeasurement, value and type.
     * Throws IllegalArgumentException if name or unitMeasurement are null or empty.
     * Throws IllegalArgumentException if value is lower than absolute zero.
     *
     * @param name            name of the sensor
     * @param unitMeasurement unit of measurement of the sensor
     * @param value           value of the sensor
     */
    public SensorTypeHumidityBosch(String name, String unitMeasurement, double value) {
        if (name == null || unitMeasurement == null) {
            throw new IllegalArgumentException("Name and unit measurement must not be null.");
        }
        if (name.isEmpty() || unitMeasurement.isEmpty()) {
            throw new IllegalArgumentException("Name and unit measurement must not be empty.");
        }
        if (value < 0 || value > 100) {
            throw new IllegalArgumentException("Humidity value must be between 0 and 100.");
        }
        _name = name;
        _unitMeasurement = unitMeasurement;
        _value = value;
    }

    /**
     * Method that returns the name of the sensor.
     *
     * @return name of the sensor
     */
    public String getName() {
        return _name;
    }

    /**
     * Method that returns the unit of measurement of the sensor.
     *
     * @return unit of measurement of the sensor
     */

    public String getUnitOfMeasurement() {
        return _unitMeasurement;
    }

    /**
     * Method that returns the type of the sensor.
     *
     * @return type of the sensor
     */
    public String getType() {
        return _type;
    }


    public boolean isSensorNameDuplicated(String name) {
        return _name.equals(name);
    }


    public boolean isSensorUnitOfMeasurementDuplicated(String unitOfMeasurement) {
        return _unitMeasurement.equals(unitOfMeasurement);
    }

    /**
     * Method that returns the model of the sensor.
     *
     * @return model of the sensor
     */

    public String getModel() {
        return _model;
    }

    /**
     * Method that sets the name of the sensor.
     *
     * @param name name of the sensor
     */
    public void setName(String name) {
        _name = name;
    }

    /**
     * Method that sets the unit of measurement of the sensor.
     *
     * @param unitMeasurement unit of measurement of the sensor
     */
    public void setUnitMeasurement(String unitMeasurement) {
        _unitMeasurement = unitMeasurement;
    }

    /**
     * Method that sets the value of the sensor.
     * Throws IllegalArgumentException if value is lower than absolute zero.
     *
     * @param value value of the sensor
     */
    public void setValue(double value) {
        if (value < 0 || value > 100) {
            throw new IllegalArgumentException("Humidity value must be between 0 and 100.");
        }
        _value = value;
    }

    /**
     * Method that returns the name of the sensor.
     *
     * @return name of the sensor
     */

    public boolean getState() {
        return (true);
    }

    /**
     * Method that returns the measurement of the sensor.
     *
     * @return measurement of the sensor
     */

    public double getMeasurement() {
        return _value;
    }

    /**
     * Method that checks if the attributes of the sensor are valid.
     *
     * @param name              name of the sensor
     * @param unitOfMeasurement unit of measurement of the sensor
     * @return true if the attributes are valid, false otherwise
     */
    public boolean areSensorAttributesDuplicated(String name, String unitOfMeasurement) {
        return isSensorNameDuplicated(name) && isSensorUnitOfMeasurementDuplicated(unitOfMeasurement);
    }
}

