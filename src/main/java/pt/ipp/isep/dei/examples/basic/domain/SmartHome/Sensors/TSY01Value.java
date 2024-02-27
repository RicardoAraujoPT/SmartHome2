package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Sensors;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Value;

public class TSY01Value implements Value
{
    public int _dValue;

    public TSY01Value(int dValue )
    {
        this._dValue = dValue;
    }

    public String toString()
    {
        return this._dValue + "";
    }
}
