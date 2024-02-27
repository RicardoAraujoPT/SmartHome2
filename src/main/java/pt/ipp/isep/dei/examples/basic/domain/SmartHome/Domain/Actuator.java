package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain;

/**
 * This interface defines the contract for an actuator in the SmartHome domain.
 * Each actuator has an actuator type.
 */
public interface Actuator {

    /**
     * Gets the current value of the sensor.
     *
     * @return The value of the sensor.
     */
    public Value getValue();

    /**
     * Gets the type of the actuator.
     *
     * @return The type of the actuator.
     */
    // public ActuatorType getActuatorType();

}
