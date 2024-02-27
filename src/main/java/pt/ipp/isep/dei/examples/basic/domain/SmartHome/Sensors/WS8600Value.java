package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Sensors;

public class WS8600Value {

    public double _dValue;

    public WS8600Value(int dValue )
    {
        this._dValue = dValue;
    }

    public String toString()
    {
        return this._dValue + "";
    }
}
