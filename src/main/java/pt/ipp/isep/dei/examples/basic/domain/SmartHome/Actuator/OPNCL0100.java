package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Actuator;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.*;

public class OPNCL0100 implements Actuator {

    private final ActuatorType _actuatorType;

    private final int _minValue;
    private final int _maxValue;

    private int _value;

    public OPNCL0100(Catalogue catalogue) throws InstantiationException {
        // this is an actuator of Open-Close
        ActuatorType actuatorType = catalogue.getActuatorType("Open-Close");
        if( actuatorType == null )
            throw new InstantiationException("ActuatorType with description 'Open-Close' does not exist.");
        else
            this._actuatorType = actuatorType;
        _minValue=0;
        _maxValue=100;
    }

    public ActuatorType getActuatorType() {
        return this._actuatorType;
    }

    @Override
    public Value setValue(Value value) {
        if (value instanceof OPNCL0100Value) {
            OPNCL0100Value v = (OPNCL0100Value) value;
            if (v._dValue < _minValue || v._dValue > _maxValue) {
                throw new IllegalArgumentException("Value out of range");
            }
            _value = v._dValue;
        }
        return new OPNCL0100Value(_value); // return the current value;
    }


}
