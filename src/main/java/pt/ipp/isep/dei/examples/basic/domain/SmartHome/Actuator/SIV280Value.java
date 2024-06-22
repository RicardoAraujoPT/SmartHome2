package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Actuator;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Value;

public class SIV280Value implements Value {

    public int _nValue;

    public SIV280Value(int nValue)
    {
        this._nValue = nValue;
    }

    public String toString()
    {
        return this._nValue + "";
    }

    public int getValue()
    {
        return this._nValue;
    }
}
