package pt.ipp.isep.dei.examples.basic.domain.SensorsTest;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.*;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Sensors.SR001;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.plist.PropertyListConfiguration;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SR001Test
{

    /**
     * Test of validSR001_ShouldCreateNewInstance method, of class SR001.
     * @throws InstantiationException
     */
    @Test
    void validSR001_ShouldCreateNewInstance() throws InstantiationException
    {
        // arrange
        Configuration config = new PropertyListConfiguration();
        Catalogue catalogue = new Catalogue( config );
        SensorType sensorType = catalogue.addSensorType( "Solar Irradiation", Unit.Watt_m2 );
        // act
        SR001 sr001 = new SR001( catalogue );

        // assert
        assertEquals( sr001.getSensorType(), sensorType );
        int value = Integer.parseInt( sr001.getValue().toString() );
        assertTrue( value >= 0 && value < 1000 );
    }

    /**
     * Test of inexistentSensorTypeForSR001_ShouldThrowException method, of class SR001.
     */
    @Test
    void inexistentSensorTypeForSR001_ShouldThrowException()
    {
        // arrange
        Configuration config = new PropertyListConfiguration();
        Catalogue catalogue = new Catalogue( config );
        String expectedMessage = "SensorType with description 'Solar Irradiation' does not exist.";

        // act + assert
        Exception exception = assertThrows( InstantiationException.class, () ->
                new SR001( catalogue )
        );

        // assert
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
