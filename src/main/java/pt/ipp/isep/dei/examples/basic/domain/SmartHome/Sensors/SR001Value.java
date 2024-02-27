package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Sensors;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Value;

public class SR001Value implements Value
{
    public int _nValue;

    public SR001Value(int nValue )
    {
        this._nValue = nValue;
    }

    public String toString()
    {
        return this._nValue + "";
    }
}