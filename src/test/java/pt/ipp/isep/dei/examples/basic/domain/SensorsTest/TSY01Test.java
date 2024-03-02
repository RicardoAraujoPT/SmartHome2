package pt.ipp.isep.dei.examples.basic.domain.SensorsTest;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.*;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Sensors.TSY01;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.plist.PropertyListConfiguration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TSY01Test {
    @Test
    void validTSY01_ShouldCreateNewInstance() throws InstantiationException {
        // arrange
        Configuration config = new PropertyListConfiguration();
        FactorySensorType factorySensorType = new FactorySensorType();
        Catalogue catalogue = new Catalogue(config,factorySensorType);
        SensorType sensorType = catalogue.addSensorType("Humidity", Unit.Percentage);
        // act
        TSY01 tsy01 = new TSY01(catalogue);

        // assert
        assertEquals(tsy01.getSensorType(), sensorType);
        double value = Double.parseDouble(tsy01.getValue().toString());
        assertTrue(value >= 0 && value <= 100);
    }

    @Test
    void inexistentSensorTypeForTSY01_ShouldThrowException() throws InstantiationException{
        // arrange
        Configuration config = new PropertyListConfiguration();
        FactorySensorType factorySensorType = new FactorySensorType();
        Catalogue catalogue = new Catalogue(config,factorySensorType);
        // SensorType sensorType = catalogue.addSensorType( "Humidity", Unit.Humidity );
        String expectedMessage = "SensorType with description 'Humidity' does not exist.";

        // act + assert
        Exception exception = assertThrows(InstantiationException.class, () ->
                new TSY01(catalogue)
        );

        // assert
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}