package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Sensors;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Value;

/**
 * Represents a value of a sensor of type SR001.
 * This class encapsulates the value of a sensor of type SR001 in the SmartHome domain.
 */
public class SR001Value implements Value
{

    public int _nValue;

    /**
     * Creates a new instance of SR001Value.
     *
     * @param nValue The value of the sensor. This parameter must be a positive integer.
     */
    public SR001Value(int nValue )
    {
        this._nValue = nValue;
    }

    /**
     * Gets the value of the sensor.
     *
     * @return The value of the sensor.
     */
    public String toString()
    {
        return this._nValue + "";
    }
}