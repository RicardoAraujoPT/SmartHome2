package pt.ipp.isep.dei.examples.basic.domain.SensorsTest;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.plist.PropertyListConfiguration;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Catalogue;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.SensorType;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Unit;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Sensors.SR001;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Sensors.WS8600;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WS8600Test {


    @Test
    void inexistentWS8600_ShouldThrowException()
    {
        // arrange
        Configuration config = new PropertyListConfiguration();
        Catalogue catalogue = new Catalogue( config );
        String expectedMessage = "SensorType with description 'Wind Sensor' does not exist.";

        // act + assert
        Exception exception = assertThrows( InstantiationException.class, () ->
                new WS8600( catalogue ));

        // assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void validWS8600_ShouldCreateNewInstance() throws InstantiationException
    {
        // arrange
        Configuration config = new PropertyListConfiguration();
        Catalogue catalogue = new Catalogue( config );
        SensorType sensorType = catalogue.addSensorType( "Wind Sensor", Unit.Kmh );
        // act
        WS8600 ws8600 = new WS8600( catalogue );

        // assert
        assertEquals( ws8600.getSensorType(), sensorType );
        int value = Integer.parseInt( ws8600.getValue().toString() );
        assertTrue( value >= 0 && value <= 400 );
    }

    @Test
    void shouldReturnWindDirection()throws InstantiationException {
        // arrange
        Configuration config = new PropertyListConfiguration();
        Catalogue catalogue = new Catalogue( config );
        SensorType sensorType = catalogue.addSensorType( "Wind Sensor", Unit.Kmh );

        // act
        WS8600 ws8600 = new WS8600( catalogue );
        String windDirection = ws8600.getWindDirection(180);

        // assert
        assertEquals( ws8600.getSensorType(), sensorType );
        assertEquals("S",windDirection);
    }

    @Test
    void shouldReturnWindDirection_ShouldThrowException()throws InstantiationException{
        // arrange
        String expected = "Azimuth degree not valid";
        Configuration config = new PropertyListConfiguration();
        Catalogue catalogue = new Catalogue( config );
        SensorType sensorType = catalogue.addSensorType( "Wind Sensor", Unit.Kmh );

        WS8600 ws8600 = new WS8600( catalogue );
        // act
        assertEquals( ws8600.getSensorType(), sensorType );
        Exception exception =
                assertThrows(IllegalArgumentException.class, ()
                        -> {
                    ws8600.getWindDirection(-180);
                });

        // assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expected));
    }

}


