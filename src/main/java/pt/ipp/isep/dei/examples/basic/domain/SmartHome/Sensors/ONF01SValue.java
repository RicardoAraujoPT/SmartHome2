package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Sensors;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Value;

public class ONF01SValue implements Value {

    public boolean _bValue;

    public ONF01SValue(boolean bValue )
    {
        this._bValue = bValue;
    }

    public String toString()
    {
        return this._bValue + "";
    }
}
