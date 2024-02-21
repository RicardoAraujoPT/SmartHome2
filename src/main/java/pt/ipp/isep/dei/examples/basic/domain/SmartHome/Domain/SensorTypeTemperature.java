package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain;

/**
 * The SensorTypeTemperatureBosch class represents a temperature sensor from the brand Bosch.
 * It implements the Sensor interface and provides methods to get and set sensor attributes such as name, unit of measurement, and value.
 * The sensor value must not be lower than absolute zero (-273.15 degrees Celsius).
 * The class also provides a method to validate the sensor attributes.
 * Usage:
 * Creating a sensor:
 * SensorTypeTemperatureBosch sensor = new SensorTypeTemperatureBosch(name, unitMeasurement, value)
 * The SensorTypeTemperatureBosch class interacts with the following classes:
 * - Sensor: SensorTypeTemperatureBosch implements the Sensor interface.
 */
public class SensorTypeTemperature implements Sensor {
    /**
     * The name of the sensor. This is a unique identifier for the sensor.
     * It cannot be null or empty.
     */
    private String _name;
    /**
     * The unit of measurement of the sensor. This represents the unit in which the sensor value is measured.
     * It cannot be null or empty.
     */
    private String _unitMeasurement;
    /**
     * The current value of the sensor. This represents the current reading of the sensor.
     * It cannot be lower than absolute zero (-273.15 degrees Celsius).
     */
    private double _value;
    /**
     * The type of the sensor. This represents the type of the sensor. This is set to "Temperature" by default.
     */
    private String _type = "Temperature";
    /**
     * The model of the sensor. This represents the model of the sensor. This is set to "Temperature Bosch" by default.
     */
    private String _model = "Temperature Bosch";

    /**
     * SensorTypeTemperatureBosch constructor with parameters name, unitMeasurement, value and type.
     * Throws IllegalArgumentException if name or unitMeasurement are null or empty.
     * Throws IllegalArgumentException if value is lower than absolute zero.
     * @param name            name of the sensor
     * @param unitMeasurement unit of measurement of the sensor
     * @param value           value of the sensor
     */
    public SensorTypeTemperature(String name, String unitMeasurement, double value) {
        if (name == null || unitMeasurement == null) {
            throw new IllegalArgumentException("Name and unit measurement must not be null.");
        }
        if (name.isEmpty() || unitMeasurement.isEmpty()) {
            throw new IllegalArgumentException("Name and unit measurement must not be empty.");
        }
        if (value < -273.15) {
            throw new IllegalArgumentException("Temperature value must not be lower than absolute zero.");
        }

        _name = name;
        _unitMeasurement = unitMeasurement;
        _value = value;
    }

    /**
     * Method that returns the name of the sensor.
     * @return name of the sensor
     */
    public String getName() {
        return _name;
    }

    /**
     * Method that returns the unit of measurement of the sensor.
     * @return unit of measurement of the sensor
     */
    public String getUnitOfMeasurement() {
        return _unitMeasurement;
    }


    /**
     * Method that returns the type of the sensor.
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
     * @return model of the sensor
     */
    public String getModel() {
        return _model;
    }

    /**
     * Method that sets the name of the sensor.
     * @param name name of the sensor
     */
    public void setName(String name) {
        _name = name;
    }

    /**
     * Method that sets the unit of measurement of the sensor.
     * @param unitMeasurement unit of measurement of the sensor
     */
    public void setUnitMeasurement(String unitMeasurement) {
        _unitMeasurement = unitMeasurement;
    }

    /**
     * Method that sets the value of the sensor.
     * Throws IllegalArgumentException if value is lower than absolute zero.
     * @param value value of the sensor
     */
    public void setValue(double value) {
        if (value < -273.15) {
            throw new IllegalArgumentException("Temperature value must not be lower than absolute zero.");
        }
        _value = value;
    }

    /**
     * Method that returns the state of the sensor.
     * @return state of the sensor
     */

    public boolean getState() {
        // Implement this method based on your requirements
        return false;
    }

    /**
     * Method that returns the measurement of the sensor.
     * @return measurement of the sensor
     */

    public double getMeasurement() {
        return _value;
    }

    /**
     * This method checks if the attributes of the sensor are valid.
     * It takes two parameters: the name of the sensor and the unit of measurement of the sensor.
     * The name of the sensor is a string that represents the unique identifier of the sensor.
     * It cannot be null or empty.
     * The unit of measurement of the sensor is a string that represents the unit in which the sensor value is measured.
     * It cannot be null or empty.
     * The method uses the static methods `isSensorNameValid` and `isSensorUnitOfMeasurementValid` from the Sensor interface to validate the attributes.
     * If both attributes are valid, the method returns true. Otherwise, it returns false.
     * @param name              name of the sensor
     * @param unitOfMeasurement unit of measurement of the sensor
     * @return true if the attributes are valid, false otherwise
     */

    public boolean areSensorAttributesDuplicated(String name, String unitOfMeasurement) {
        return isSensorNameDuplicated(name) && isSensorUnitOfMeasurementDuplicated(unitOfMeasurement);
    }
}
