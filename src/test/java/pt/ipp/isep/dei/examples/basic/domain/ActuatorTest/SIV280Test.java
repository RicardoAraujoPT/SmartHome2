package pt.ipp.isep.dei.examples.basic.domain.ActuatorTest;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Actuator.SIV280;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Actuator.SIV280Value;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SIV280Test {

    @Test
    void validSIV280_ShouldCreateNewInstance() throws InstantiationException {
        // arrange
        FactorySensorType factorySensorType = new FactorySensorType();
        Catalogue catalogue = new Catalogue("config.properties",factorySensorType);
        ActuatorType actuatorType = catalogue.addActuatorType("Set Integer Value", Unit.Celsius);
        // act
        SIV280 siv280 = new SIV280(catalogue, 10, 35);
        // assert
        assertEquals(siv280.getActuatorType(), actuatorType);
    }

    @Test
    void invalidSIV280_ShouldThrowInstantiationException() throws InstantiationException {
        // arrange
        FactorySensorType factorySensorType = new FactorySensorType();
        Catalogue catalogue = new Catalogue("config.properties",factorySensorType);
        String expectedMessage = "Actuator Type with description 'Set Integer Value' does not exist.";
        // act
        Exception exception = assertThrows(InstantiationException.class, () ->
                new SIV280(catalogue, 10, 35)
        );
        String actualMessage = exception.getMessage();
        // assert
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void invalidMinMaxSIV280_ShouldThrowInstantiationException() throws InstantiationException {
        // arrange
        FactorySensorType factorySensorType = new FactorySensorType();
        Catalogue catalogue = new Catalogue("config.properties",factorySensorType);
        ActuatorType actuatorType = catalogue.addActuatorType("Set Integer Value", Unit.Celsius);
        String expectedMessage = "Max value is lower than min value";
        // act
        Exception exception = assertThrows(InstantiationException.class, () ->
                new SIV280(catalogue, 35, 10)
        );
        String actualMessage = exception.getMessage();
        // assert
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void validSIV280_SetValidValue() throws InstantiationException {
        // arrange
        FactorySensorType factorySensorType = new FactorySensorType();
        Catalogue catalogue = new Catalogue("config.properties",factorySensorType);
        ActuatorType actuatorType = catalogue.addActuatorType("Set Integer Value", Unit.Celsius);
        SIV280 siv280 = new SIV280(catalogue, 10, 35);
        Value expectedValue = new SIV280Value(22);
        // act
        Value foundValue = siv280.setValue(expectedValue);
        // assert
        assertEquals(((SIV280Value) expectedValue).getValue(), ((SIV280Value) foundValue).getValue());
    }

    @Test
    void validSIV280_SetInvalidMinValue() throws InstantiationException {
        // arrange
        FactorySensorType factorySensorType = new FactorySensorType();
        Catalogue catalogue = new Catalogue("config.properties",factorySensorType);
        ActuatorType actuatorType = catalogue.addActuatorType("Set Integer Value", Unit.Celsius);
        SIV280 siv280 = new SIV280(catalogue, 10, 35);
        Value expectedValue = new SIV280Value(8);
        String expectedMessage = "Value out of range";
        // act
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                siv280.setValue(expectedValue)
        );
        String actualMessage = exception.getMessage();

        // assert
        assertEquals(expectedMessage,actualMessage);
    }

    @Test
    void validSIV280_SetInvalidMaxValue() throws InstantiationException {
        // arrange
        FactorySensorType factorySensorType = new FactorySensorType();
        Catalogue catalogue = new Catalogue("config.properties",factorySensorType);
        ActuatorType actuatorType = catalogue.addActuatorType("Set Integer Value", Unit.Celsius);
        SIV280 siv280 = new SIV280(catalogue, 10, 35);
        Value expectedValue = new SIV280Value(40);
        String expectedMessage = "Value out of range";
        // act
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                siv280.setValue(expectedValue)
        );
        String actualMessage = exception.getMessage();

        // assert
        assertEquals(expectedMessage,actualMessage);
    }

}
