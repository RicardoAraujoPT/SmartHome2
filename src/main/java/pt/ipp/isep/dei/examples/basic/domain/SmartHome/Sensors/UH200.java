package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Sensors;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.*;

import java.util.Random;

public class UH200 implements Sensor {
    private final SensorType _sensorType;

    public UH200(Catalogue catalogue) throws InstantiationException {
        // this is a sensor of temperature
        SensorType sensorType = catalogue.getSensorType("Capacity");
        if (sensorType == null)
            throw new InstantiationException("SensorType with description 'Capacity' does not exist.");
        else
            this._sensorType = sensorType;
    }

    public SensorType getSensorType() {
        return this._sensorType;
    }

    public Value getValue() {

        Random rand = new Random();
        int capacidade = rand.nextInt(100); // valor entre 0 e 100
        return new UH200Value(capacidade);
    }

}