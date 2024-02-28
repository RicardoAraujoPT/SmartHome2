package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Sensors;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Value;

/**
 * This class represents a value of a PC500W sensor in a smart home system.
 * It implements the Value interface and provides a concrete implementation for the toString method.
 * The value is represented as an integer.
 *
 */
public class PC500WValue implements Value {

    /**
     * The value of the PC500W sensor.
     */
    public int _nValue;

    /**
     * Constructs a new PC500WValue with the specified value.
     *
     * @param nValue The value of the PC500W sensor.
     */
    public PC500WValue(int nValue )
    {
        this._nValue = nValue;
    }

    /**
     * Returns a string representation of the PC500W sensor value.
     *
     * @return A string representation of the PC500W sensor value.
     */
    public String toString()
    {
        return this._nValue + "";
    }

}

