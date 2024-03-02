package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Actuator;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Actuator;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.ActuatorType;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Catalogue;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Value;

public class SIV280 implements Actuator {

    private final ActuatorType _actuatorType;

    private int _value;

    private int _maxValue;

    private int _minValue;


    public SIV280(Catalogue catalogue, int minValue, int maxValue) throws InstantiationException {

        ActuatorType actuatorType = catalogue.getActuatorType("Set Integer Value");
        if (actuatorType == null)
            throw new InstantiationException("Actuator Type with description 'Set Integer Value' does not exist.");
        if (maxValue < minValue)
            throw new InstantiationException("Max value is lower than min value");
        else {
            this._actuatorType = actuatorType;
            this._minValue = minValue;
            this._maxValue = maxValue;

        }
    }

    public int getMaxValue() {
        return _maxValue;
    }

    public int getMinValue() {
        return _minValue;
    }

    @Override
    public ActuatorType getActuatorType() {
        return this._actuatorType;
    }

    @Override
    public Value setValue(Value value) {
        if (value instanceof SIV280Value) {
            SIV280Value v = (SIV280Value) value;
            if (v._nValue < _minValue || v._nValue > _maxValue) {
                throw new IllegalArgumentException("Value out of range");
            }
            _value = v._nValue;
        }
        return new SIV280Value(_value); // return the current value;
    }

}


