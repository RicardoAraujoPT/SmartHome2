package pt.ipp.isep.dei.examples.basic.domain.SensorsTest;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.*;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Sensors.GA100K;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.plist.PropertyListConfiguration;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GA100KTest
{
    @Test
    void validGA100K_ShouldCreateNewInstance() throws InstantiationException
    {
        // arrange
        Configuration config = new PropertyListConfiguration();
        Catalogue catalogue = new Catalogue( config );
        SensorType sensorType = catalogue.addSensorType( "Temperature", Unit.Celsius );
        // act
        GA100K ga100k = new GA100K( catalogue );

        // assert
        assertEquals( ga100k.getSensorType(), sensorType );
        int value = Integer.parseInt( ga100k.getValue().toString() );
        assertTrue( value >= -70 && value <= 70 );
    }

    @Test
    void inexistentSensorTypeForGA100K_ShouldThrowException()
    {
        // arrange
        Configuration config = new PropertyListConfiguration();
        Catalogue catalogue = new Catalogue( config );
        //SensorType sensorType = catalogue.addSensorType( "Temperature", Unit.Temperature );
        String expectedMessage = "SensorType with description 'Temperature' does not exist.";

        // act + assert
        Exception exception = assertThrows( InstantiationException.class, () ->
                new GA100K( catalogue )
        );

        // assert
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}