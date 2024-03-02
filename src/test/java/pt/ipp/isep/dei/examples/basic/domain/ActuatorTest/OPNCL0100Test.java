package pt.ipp.isep.dei.examples.basic.domain.ActuatorTest;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.plist.PropertyListConfiguration;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Actuator.OPNCL0100;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Actuator.OPNCL0100Value;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.*;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Sensors.TSY01;

import static org.junit.jupiter.api.Assertions.*;

public class OPNCL0100Test {

    @Test
    void validOPNCL0100_ShouldCreateNewInstance() throws InstantiationException {
        // arrange
        FactorySensorType factorySensorType = new FactorySensorType();
        Catalogue catalogue = new Catalogue("config.properties",factorySensorType);
        ActuatorType actuatorType = catalogue.addActuatorType("Open-Close", Unit.Percentage);
        // act
        OPNCL0100 opncl0100 = new OPNCL0100(catalogue);
        // assert
        assertEquals(opncl0100.getActuatorType(), actuatorType);
    }

    @Test
    void invalidOPNCL0100_ShouldThrowInstantiationException() throws InstantiationException {
        // arrange
        FactorySensorType factorySensorType = new FactorySensorType();
        Catalogue catalogue = new Catalogue("config.properties",factorySensorType);
        String expectedMessage = "ActuatorType with description 'Open-Close' does not exist.";
        // act
        Exception exception = assertThrows(InstantiationException.class, () ->
                new OPNCL0100(catalogue)
        );
        String actualMessage = exception.getMessage();
        // assert
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void validOPNCL0100_SetValidValue() throws InstantiationException {
        // arrange
        FactorySensorType factorySensorType = new FactorySensorType();
        Catalogue catalogue = new Catalogue("config.properties",factorySensorType);
        ActuatorType actuatorType = catalogue.addActuatorType("Open-Close", Unit.Percentage);
        OPNCL0100 opncl0100 = new OPNCL0100(catalogue);
        Value expectedValue = new OPNCL0100Value(50);
        // act
        Value foundValue = opncl0100.setValue(expectedValue);
        // assert
        assertEquals(((OPNCL0100Value) expectedValue).getValue(), ((OPNCL0100Value) foundValue).getValue());
    }

    @Test
    void validOPNCL0100_SetInvalidMinValue() throws InstantiationException {
        // arrange
        FactorySensorType factorySensorType = new FactorySensorType();
        Catalogue catalogue = new Catalogue("config.properties",factorySensorType);
        ActuatorType actuatorType = catalogue.addActuatorType("Open-Close", Unit.Percentage);
        OPNCL0100 opncl0100 = new OPNCL0100(catalogue);
        Value expectedValue = new OPNCL0100Value(-1);
        String expectedMessage = "Value out of range";
        // act
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                opncl0100.setValue(expectedValue)
        );
        String actualMessage = exception.getMessage();

        // assert
        assertEquals(expectedMessage,actualMessage);
    }
    @Test
    void validOPNCL0100_SetInvalidMaxValue() throws InstantiationException {
        // arrange
        FactorySensorType factorySensorType = new FactorySensorType();
        Catalogue catalogue = new Catalogue("config.properties",factorySensorType);
        ActuatorType actuatorType = catalogue.addActuatorType("Open-Close", Unit.Percentage);
        OPNCL0100 opncl0100 = new OPNCL0100(catalogue);
        Value expectedValue = new OPNCL0100Value(101);
        String expectedMessage = "Value out of range";
        // act
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                opncl0100.setValue(expectedValue)
        );
        String actualMessage = exception.getMessage();

        // assert
        assertEquals(expectedMessage,actualMessage);
    }



}
