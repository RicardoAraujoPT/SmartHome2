package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Sensors;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.*;

import java.util.Random;

public class CAP200 implements Sensor {
    private final SensorType _sensorType;
    public int _capacity;

    public CAP200(Catalogue catalogue, int _capacity) throws InstantiationException {
        // this is a sensor of temperature
        SensorType sensorType = catalogue.getSensorType("Capacity");
        if (sensorType == null)
            throw new InstantiationException("SensorType with description 'Capacity' does not exist.");
        else
            this._sensorType = sensorType;
        this._capacity = _capacity;

    }

    public SensorType getSensorType() {
        return this._sensorType;
    }

    public Value getValue() {
        return new CAP200Value(_capacity);
    }

}