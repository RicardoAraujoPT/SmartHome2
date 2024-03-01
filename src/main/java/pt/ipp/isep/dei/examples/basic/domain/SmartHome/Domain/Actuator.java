package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain;

/**
 * This interface defines the contract for an actuator in the SmartHome domain.
 * Each actuator has an actuator type.
 */
public interface Actuator {

    /**
     * Sets the current value of the actuator.
     *
     * @return The value of the actuator.
     */

    Value setValue(Value value);


    /**
     * Gets the type of the actuator.
     *
     * @return The type of the actuator.
     */
     public ActuatorType getActuatorType();

}
