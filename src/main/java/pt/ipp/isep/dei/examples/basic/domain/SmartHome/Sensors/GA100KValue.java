package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Sensors;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Value;

public class GA100KValue implements Value
{
    public int _nValue;

    public GA100KValue(int nValue )
    {
        this._nValue = nValue;
    }

    public String toString()
    {
        return this._nValue + "";
    }
}
