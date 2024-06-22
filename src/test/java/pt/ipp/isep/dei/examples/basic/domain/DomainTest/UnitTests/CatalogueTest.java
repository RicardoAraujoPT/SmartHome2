package pt.ipp.isep.dei.examples.basic.domain.DomainTest.UnitTests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.*;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.plist.PropertyListConfiguration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CatalogueTest {


    @Test
    void existingFile_ShouldCreateConfiguredCatalogue() throws InstantiationException, IOException {
        // arrange
        long lineCountExpected = Files.lines(Paths.get("config.properties")).count() - 3; // Subtract 3 for title line and actuators.
        FactorySensorType factorySensorTypeDouble = mock(FactorySensorType.class);
        // 1 Title line
        // 5 Sensors
        // 2 Actuators

        // act
        Catalogue catalogue = new Catalogue("config.properties", factorySensorTypeDouble);

        // assert
        assertEquals(lineCountExpected, catalogue.getSensorModels().size());
    }

    @Test
    void inexistentFile_ShouldThrowException() {
        // arrange
        String expectedMessage = "something went wrong in reading the configuration: ";
        String wrongPath = "This path doesnt exist";
        FactorySensorType factorySensorTypeDouble = mock(FactorySensorType.class);

        // act + assert
        Exception exception = assertThrows(InstantiationException.class, () ->
                new Catalogue(wrongPath, factorySensorTypeDouble)
        );

        // assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"", "\t", "\n"})
    void multipleTypesOfNullPathName_ShouldThrowException(String input) {
        // arrange
        String expectedMessage = "Invalid arguments";
        FactorySensorType factorySensorTypeDouble = mock(FactorySensorType.class);

        // act + assert
        Exception exception = assertThrows(InstantiationException.class, () ->
                new Catalogue(input, factorySensorTypeDouble)
        );

        // assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void nullSensorTypeFactoryGoodConfig_ShouldThrowException() {
        // arrange
        String expectedMessage = "Invalid arguments";
        FactorySensorType factorySensorTypeDouble = null;
        Configuration config = new PropertyListConfiguration();

        // act + assert
        Exception exception = assertThrows(InstantiationException.class, () ->
                new Catalogue(config, factorySensorTypeDouble)
        );

        // assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void nullConfigGoodSensorTypeFactory_ShouldThrowException() {
        // arrange
        String expectedMessage = "Invalid arguments";
        FactorySensorType factorySensorTypeDouble = mock(FactorySensorType.class);
        Configuration config = null;

        // act + assert
        Exception exception = assertThrows(InstantiationException.class, () ->
                new Catalogue(config, factorySensorTypeDouble)
        );

        // assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void nullSensorTypeFactoryGoodPathName_ShouldThrowException() {
        // arrange
        String expectedMessage = "Invalid arguments";
        FactorySensorType factorySensorTypeDouble = null;

        // act + assert
        Exception exception = assertThrows(InstantiationException.class, () ->
                new Catalogue("config.properties", factorySensorTypeDouble)
        );

        // assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void emptyCatalogue_ShouldCreateConfiguredCatalogue() throws InstantiationException {
        // arrange
        Configuration config = new PropertyListConfiguration();
        FactorySensorType factorySensorTypeDouble = mock(FactorySensorType.class);

        // act
        Catalogue catalogue = new Catalogue(config, factorySensorTypeDouble);

        // assert
        assertEquals(catalogue.getSensorModels().size(), 0);
    }

    @Test
    void existingSensorType_ShouldGetSensorType() throws InstantiationException {
        // arrange
        String strDescription = "Humidity";
        Unit unit = Unit.Percentage;

        SensorType sensorTypeDouble = mock(SensorType.class);
        when(sensorTypeDouble.getDescription()).thenReturn(strDescription);

        FactorySensorType factorySensorTypeDouble = mock(FactorySensorType.class);
        when(factorySensorTypeDouble.newSensorType(strDescription, unit)).thenReturn(sensorTypeDouble);

        Configuration config = new PropertyListConfiguration();
        Catalogue catalogue = new Catalogue(config, factorySensorTypeDouble);

        // act
        SensorType sensorType = catalogue.addSensorType(strDescription, Unit.Percentage);
        SensorType returned = catalogue.getSensorType(strDescription);

        // assert
        assertEquals(sensorTypeDouble, sensorType);
        assertEquals(returned, sensorType);
    }

    @Test
    void inexistentSensorType_ShouldReturnNull() throws InstantiationException {
        // arrange
        String strDescription = "Humidity";
        Unit unit = Unit.Percentage;

        SensorType sensorTypeDouble = mock(SensorType.class);
        when(sensorTypeDouble.getDescription()).thenReturn(strDescription);

        FactorySensorType factorySensorTypeDouble = mock(FactorySensorType.class);
        when(factorySensorTypeDouble.newSensorType(strDescription, unit)).thenReturn(sensorTypeDouble);

        Configuration config = new PropertyListConfiguration();
        Catalogue catalogue = new Catalogue(config, factorySensorTypeDouble);

        // act
        SensorType sensorType = catalogue.addSensorType(strDescription, unit);

        // assert
        SensorType returned = catalogue.getSensorType("Temperature");
        assertNotNull(sensorType);
        assertNull(returned);
    }

    @Test
    void validSensorType_ShouldAddSensorType() throws InstantiationException {
        // arrange
        String strDescription = "Humidity";
        Unit unit = Unit.Percentage;

        SensorType sensorTypeDouble = mock(SensorType.class);
        when(sensorTypeDouble.getDescription()).thenReturn(strDescription);

        FactorySensorType factorySensorTypeDouble = mock(FactorySensorType.class);
        when(factorySensorTypeDouble.newSensorType(strDescription, unit)).thenReturn(sensorTypeDouble);

        Configuration config = new PropertyListConfiguration();
        Catalogue catalogue = new Catalogue(config, factorySensorTypeDouble);

        // act
        SensorType sensorType = catalogue.addSensorType(strDescription, unit);

        // assert
        SensorType returned = catalogue.getSensorType(strDescription);
        assertEquals(sensorType, returned);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"", "\t", "\n"})
    void emptyDescriptionSensorType_ShouldThrowException(String input) throws InstantiationException {
        // arrange
        String expectedMessage = "Invalid arguments";
        Unit unit = Unit.Percentage;

        SensorType sensorTypeDouble = mock(SensorType.class);
        when(sensorTypeDouble.getDescription()).thenReturn(input);

        FactorySensorType factorySensorTypeDouble = mock(FactorySensorType.class);
        when(factorySensorTypeDouble.newSensorType(input, unit)).thenThrow(new InstantiationException(expectedMessage));

        Configuration config = new PropertyListConfiguration();
        Catalogue catalogue = new Catalogue(config, factorySensorTypeDouble);

        // act + assert
        Exception exception = assertThrows(InstantiationException.class, () ->
                catalogue.addSensorType(input, unit)
        );

        // assert
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void uniqueModel_ShouldGetSensor() throws InstantiationException {
        // arrange
        String strDescription = "Humidity";
        Unit unit = Unit.Percentage;

        Configuration config = new PropertyListConfiguration();
        config.addProperty("sensor", "Sensors.TSY01");

        SensorType sensorTypeDouble = mock(SensorType.class);
        when(sensorTypeDouble.getDescription()).thenReturn(strDescription);

        FactorySensorType factorySensorTypeDouble = mock(FactorySensorType.class);
        when(factorySensorTypeDouble.newSensorType(strDescription, unit)).thenReturn(sensorTypeDouble);

        Catalogue catalogue = new Catalogue(config, factorySensorTypeDouble);
        SensorType sensorType = catalogue.addSensorType(strDescription, unit);

        // act
        Sensor sensor = catalogue.getSensor("Sensors.TSY01");

        // assert
        assertNotNull(sensor);
        assertEquals(sensor.getSensorType(), sensorType);
    }

    @Test
    void listOfTwoModels_ShouldGetSensor() throws InstantiationException {
        // arrange
        String strDescription = "Temperature";
        Unit unit = Unit.Celsius;

        Configuration config = new PropertyListConfiguration();
        config.addProperty("sensor", "Sensors.GA100K");
        config.addProperty("sensor", "Sensors.TSY01");

        SensorType sensorTypeDouble = mock(SensorType.class);
        when(sensorTypeDouble.getDescription()).thenReturn(strDescription);

        FactorySensorType factorySensorTypeDouble = mock(FactorySensorType.class);
        when(factorySensorTypeDouble.newSensorType(strDescription, unit)).thenReturn(sensorTypeDouble);

        Catalogue catalogue = new Catalogue(config, factorySensorTypeDouble);
        SensorType sensorType = catalogue.addSensorType(strDescription, unit);
        SensorType sensorType2 = catalogue.addSensorType("Humidity", Unit.Percentage);

        // act
        Sensor sensor = catalogue.getSensor("Sensors.GA100K");

        // assert
        assertNotNull(sensor);
        assertEquals(sensor.getSensorType(), sensorType);
    }

    @Test
    void emptyConfigListOfModels_ShouldReturnNullSensor() throws InstantiationException {
        // arrange
        String strDescription = "Humidity";
        Unit unit = Unit.Percentage;
        //Empty configuration file.
        Configuration config = new PropertyListConfiguration();

        SensorType sensorTypeDouble = mock(SensorType.class);
        when(sensorTypeDouble.getDescription()).thenReturn(strDescription);

        FactorySensorType factorySensorTypeDouble = mock(FactorySensorType.class);
        when(factorySensorTypeDouble.newSensorType(strDescription, unit)).thenReturn(sensorTypeDouble);

        Catalogue catalogue = new Catalogue(config, factorySensorTypeDouble);
        catalogue.addSensorType("Humidity", Unit.Percentage);

        // act
        Sensor sensor = catalogue.getSensor("sensors.TSY01");

        // assert
        assertNull(sensor);
    }


    @Test
    void sensorModelInConfigButNoRelativeClassPresent_ShouldReturnNull() throws InstantiationException
    {
        // arrange
        String strDescription = "Humidity";
        Unit unit = Unit.Percentage;
        String strSensorModel = "sensors.DoesntExist";

        Configuration config = new PropertyListConfiguration();
        config.addProperty("sensor", strSensorModel);

        FactorySensorType factorySensorTypeDouble = mock(FactorySensorType.class);

        Catalogue catalogue = new Catalogue(config, factorySensorTypeDouble);

        catalogue.addSensorType(strDescription, unit);

        // act
        Sensor sensor = catalogue.getSensor(strSensorModel);

        // assert
        assertNull(sensor);
    }
}