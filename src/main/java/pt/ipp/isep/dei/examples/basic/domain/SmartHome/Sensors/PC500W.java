package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Sensors;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Catalogue;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Sensor;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.SensorType;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Value;

import java.util.Random;

/**
 * This class represents a PC500W sensor in a smart home system.
 * It implements the Sensor interface and provides concrete implementations for the getSensorType and getValue methods.
 * The sensor type is determined by the catalogue provided at instantiation, and the value is randomly generated within
 * the range of 0 to 500.
 *
*/
 public class PC500W implements Sensor{

    /**
     * The sensor type of the PC500W sensor.
     */
    private final SensorType _sensorType;

    /**
     * Constructs a new PC500W sensor with the specified catalogue.
     *
     * @param catalogue The catalogue to determine the sensor type.
     * @throws InstantiationException If the sensor type with description 'Power Consumption' does not exist in the
     * catalogue.
     */
    public PC500W(Catalogue catalogue) throws InstantiationException {
        // this is a sensor of power consumption
        SensorType sensorType = catalogue.getSensorType("Power Consumption");
        if( sensorType == null )
            throw new InstantiationException("SensorType with description 'Power Consumption' does not exist.");
        else
            this._sensorType = sensorType;
    }
    /**
     * Returns the sensor type of the PC500W sensor.
     *
     * @return The sensor type of the PC500W sensor.
     */
    public SensorType getSensorType()
    {
        return this._sensorType;
    }
    /**
     * Generates and returns a new value for the PC500W sensor.
     * The value is randomly generated within the range of 0 to 500.
     *
     * @return A new value for the PC500W sensor.
     */
    public Value getValue()
    {
        Random rand = new Random();
        int nValue = rand.nextInt(500);

        return new PC500WValue(nValue);
    }

}
