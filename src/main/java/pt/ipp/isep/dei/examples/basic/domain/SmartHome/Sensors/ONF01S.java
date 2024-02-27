package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Sensors;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Catalogue;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Sensor;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.SensorType;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Value;

import java.util.Random;

public class ONF01S implements Sensor {
    private final SensorType _sensorType;

    public ONF01S(Catalogue catalogue) throws InstantiationException
    {
        // this is a sensor of temperature
        SensorType sensorType = catalogue.getSensorType("Status");
        if( sensorType == null )
            throw new InstantiationException("SensorType with description 'Status' does not exist.");
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
        boolean bValue = rand.nextBoolean(); // valor true ou false (ON/OFF)

        return new ONF01SValue(bValue);
    }
}
