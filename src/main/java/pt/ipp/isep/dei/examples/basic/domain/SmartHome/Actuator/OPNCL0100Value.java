package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Actuator;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Value;

public class OPNCL0100Value implements Value {

    public int _dValue;

    public OPNCL0100Value(int dValue )
    {
        this._dValue = dValue;
    }

    public String toString()
    {
        return this._dValue + "";
    }

    public int getValue()
    {
        return this._dValue;
    }

}
