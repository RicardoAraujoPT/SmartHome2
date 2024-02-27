package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Sensors;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.*;
import java.util.Random;

public class SR001 implements Sensor
{
    private final SensorType _sensorType;

    public SR001(Catalogue catalogue) throws InstantiationException
    {
        // this is a sensor of temperature
        SensorType sensorType = catalogue.getSensorType("Solar Irradiation");
        if( sensorType == null )
            throw new InstantiationException("SensorType with description 'Solar Irradiation' does not exist.");
        else
            this._sensorType = sensorType;
    }

    public SensorType getSensorType()
    {
        return this._sensorType;
    }

    public Value getValue()
    {
        Random rand = new Random();

        int nValue = rand.nextInt(1000);

        return new SR001Value( nValue );
    }
}
