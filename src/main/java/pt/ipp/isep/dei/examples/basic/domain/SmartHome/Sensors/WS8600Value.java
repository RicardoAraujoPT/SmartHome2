package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Sensors;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Value;


/**
 * Represents a value of a sensor model WS8600.
 * This class encapsulates the value of a sensor model WS8600 in the SmartHome domain.
 */
public class WS8600Value implements Value {

    public int _dValue;


    /**
     * Creates a new instance of WS8600Value.
     *
     * @param dValue The value of the sensor. This parameter must be a positive integer.
     */
    public WS8600Value(int dValue) {

        this._dValue = dValue;
    }


    /**
     * Gets the value of the sensor.
     *
     * @return The value of the sensor.
     */
    public String toString() {
        return this._dValue + "";
    }
}
