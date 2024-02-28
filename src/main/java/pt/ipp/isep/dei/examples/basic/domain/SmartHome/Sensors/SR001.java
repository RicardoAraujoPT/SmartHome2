package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Sensors;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.*;
import java.util.Random;

/**
 * Represents a sensor of type SR001.
 * This class encapsulates the creation of SR001 sensors in the SmartHome domain.
 */
public class SR001 implements Sensor
{
    private final SensorType _sensorType;

    /**
     * Creates a new instance of SR001.
     *
     * @param catalogue The catalogue of sensor types. This parameter must not be null.
     * @throws InstantiationException If the provided argument is not valid (e.g., null catalogue).
     */
    public SR001(Catalogue catalogue) throws InstantiationException
    {
        // this is a sensor of temperature
        SensorType sensorType = catalogue.getSensorType("Solar Irradiation");
        if( sensorType == null )
            throw new InstantiationException("SensorType with description 'Solar Irradiation' does not exist.");
        else
            this._sensorType = sensorType;
    }

    /**
     * Gets the sensor type of the sensor.
     *
     * @return The sensor type of the sensor.
     */
    public SensorType getSensorType()
    {
        return this._sensorType;
    }

    /**
     * Gets the value of the sensor.
     *
     * @return The value of the sensor.
     */
    public Value getValue()
    {
        Random rand = new Random();

        int nValue = rand.nextInt(1001);

        return new SR001Value( nValue );
    }
}
