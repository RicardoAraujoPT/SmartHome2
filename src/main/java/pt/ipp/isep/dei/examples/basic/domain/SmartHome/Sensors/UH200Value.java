package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Sensors;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Value;

public class UH200Value implements Value
{
    public int _dValue;

    public UH200Value(int dValue )
    {
        this._dValue = dValue;
    }

    public String toString()
    {
        return this._dValue + "";
    }
}