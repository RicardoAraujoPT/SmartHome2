package pt.ipp.isep.dei.examples.basic.domain.DomainTest.IntegrationTests;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.*;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.plist.PropertyListConfiguration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CatalogueTest {
    @Test
    void NewConfiguredCatalogueFromExistingFile() throws InstantiationException {
        // arrange

        // act
        Catalogue catalogue = new Catalogue("config.properties");

        // assert
        assertEquals(catalogue.getSensorModels().size(), 2);
    }

    @Test
    void NewConfiguredCatalogueFromInexistingFile() {
        // arrange
        String expectedMessage = "something went wrong in reading the configuration: ";

        // act + assert
        Exception exception = assertThrows(InstantiationException.class, () ->
                new Catalogue("asdfasdfasdf")
        );

        // assert
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void NewConfiguredEmptyCatalogue() {
        // arrange
        Configuration config = new PropertyListConfiguration();

        // act
        Catalogue catalogue = new Catalogue(config);

        // assert
        assertEquals(catalogue.getSensorModels().size(), 0);
    }

    @Test
    void GetExistingSensorType() throws InstantiationException {
        // arrange
        Configuration config = new PropertyListConfiguration();
        Catalogue catalogue = new Catalogue(config);

        // act
        SensorType sensorType = catalogue.addSensorType("Humidity", Unit.Percentage);

        // assert
        SensorType returned = catalogue.getSensorType("Humidity");
        assertEquals(returned, sensorType);
    }

    @Test
    void GetInexistingSensorType() throws InstantiationException {
        // arrange
        Configuration config = new PropertyListConfiguration();
        Catalogue catalogue = new Catalogue(config);

        // act
        SensorType sensorType = catalogue.addSensorType("Humidity", Unit.Percentage);

        // assert
        SensorType returned = catalogue.getSensorType("Temperature");
        assertNotNull(sensorType);
        assertNull(returned);
    }

    @Test
    void addValidSensorType() throws InstantiationException {
        // arrange
        Configuration config = new PropertyListConfiguration();
        Catalogue catalogue = new Catalogue(config);

        // act
        SensorType sensorType = catalogue.addSensorType("Humidity", Unit.Percentage);

        // assert
        SensorType returned = catalogue.getSensorType("Humidity");
        assertEquals(returned, sensorType);
    }

    @Test
    void addEmptyDescriptionSensorType() {
        // arrange
        Configuration config = new PropertyListConfiguration();
        Catalogue catalogue = new Catalogue(config);
        String expectedMessage = "Invalid arguments";

        // act + assert
        Exception exception = assertThrows(InstantiationException.class, () ->
                catalogue.addSensorType("", Unit.Percentage)
        );

        // assert
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void addNullDescriptionSensorType() {
        // arrange
        Configuration config = new PropertyListConfiguration();
        Catalogue catalogue = new Catalogue(config);
        String expectedMessage = "Invalid arguments";

        // act + assert
        Exception exception = assertThrows(InstantiationException.class, () ->
                catalogue.addSensorType(null, Unit.Percentage)
        );

        // assert
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void getSensorOfUniqueModel() throws InstantiationException {
        // arrange
        Configuration config = new PropertyListConfiguration();
        config.addProperty("sensor", "pt.ipp.isep.dei.examples.basic.domain.SmartHome.Sensors.TSY01");
        Catalogue catalogue = new Catalogue(config);
        SensorType sensorType = catalogue.addSensorType("Humidity", Unit.Percentage);

        // act
        Sensor sensor = catalogue.getSensor("pt.ipp.isep.dei.examples.basic.domain.SmartHome.Sensors.TSY01");

        // assert
        assertNotNull(sensor);
        assertEquals(sensor.getSensorType(), sensorType);
    }

    @Test
    void getSensorOfListOfTwoModels() throws InstantiationException {
        // arrange
        Configuration config = new PropertyListConfiguration();
        config.addProperty("sensor", "pt.ipp.isep.dei.examples.basic.domain.SmartHome.Sensors.GA100K");
        config.addProperty("sensor", "pt.ipp.isep.dei.examples.basic.domain.SmartHome.SensorsTSY01");
        Catalogue catalogue = new Catalogue(config);
        SensorType sensorType = catalogue.addSensorType("Temperature", Unit.Celsius);

        // act
        Sensor sensor = catalogue.getSensor("pt.ipp.isep.dei.examples.basic.domain.SmartHome.Sensors.GA100K");

        // assert
        assertNotNull(sensor);
        assertEquals(sensor.getSensorType(), sensorType);
    }

    @Test
    void getNullSensorOfEmptyListOfModels() throws InstantiationException {
        // arrange
        Configuration config = new PropertyListConfiguration();
        Catalogue catalogue = new Catalogue(config);
        catalogue.addSensorType("Humidity", Unit.Percentage);

        // act
        Sensor sensor = catalogue.getSensor("sensors.TSY01");

        // assert
        assertNull(sensor);
    }
}