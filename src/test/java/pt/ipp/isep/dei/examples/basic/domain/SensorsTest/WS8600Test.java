package pt.ipp.isep.dei.examples.basic.domain.SensorsTest;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.plist.PropertyListConfiguration;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Catalogue;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.SensorType;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Unit;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Sensors.WS8600;
import static org.junit.jupiter.api.Assertions.*;

public class WS8600Test {

    /**
     * This test verifies that an exception is thrown when trying to create a WS8600 instance
     * with a non-existent sensor type.
     */
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

    /**
     * This test verifies that a valid WS8600 instance can be created and that its sensor type and value are correct.
     */
    @Test
    void validWS8600_ShouldCreateNewInstance() throws InstantiationException {
        // arrange
        Configuration config = new PropertyListConfiguration();
        Catalogue catalogue = new Catalogue( config );
        SensorType sensorType = catalogue.addSensorType( "Wind Sensor", Unit.Kmh );
        // act
        WS8600 ws8600 = new WS8600( catalogue );

        // assert
        assertEquals( ws8600.getSensorType(), sensorType );
        int value = Integer.parseInt( ws8600.getValue().toString());
        assertTrue(value >= 0 && value <= 400);
    }

    /**
     * This test verifies that the getWindDirection method returns the correct wind direction when the azimuth degree is 180.
     */
    @Test
    void shouldReturnWindDirection_South()throws InstantiationException {
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

    /**
     * This test verifies that the getWindDirection method returns the correct wind direction when the azimuth degree is 90.
     */
    @Test
    void shouldReturnWindDirection_E()throws InstantiationException {
        // arrange
        Configuration config = new PropertyListConfiguration();
        Catalogue catalogue = new Catalogue( config );
        SensorType sensorType = catalogue.addSensorType( "Wind Sensor", Unit.Kmh );

        // act
        WS8600 ws8600 = new WS8600( catalogue );
        String windDirection = ws8600.getWindDirection(90);

        // assert
        assertEquals( ws8600.getSensorType(), sensorType );
        assertEquals("E",windDirection);
    }

    /**
     * This test verifies that the getWindDirection method returns the correct wind direction when the azimuth degree is 270.
     */
    @Test
    void shouldReturnWindDirection_()throws InstantiationException {
        // arrange
        Configuration config = new PropertyListConfiguration();
        Catalogue catalogue = new Catalogue( config );
        SensorType sensorType = catalogue.addSensorType( "Wind Sensor", Unit.Kmh );

        // act
        WS8600 ws8600 = new WS8600( catalogue );
        String windDirection = ws8600.getWindDirection(270);

        // assert
        assertEquals( ws8600.getSensorType(), sensorType );
        assertEquals("W",windDirection);
    }

    /**
     * This test verifies that the getWindDirection method returns the correct wind direction when the azimuth degree is 315.
     */
    @Test
    void shouldReturnWindDirection_W () throws InstantiationException {
        // arrange
        Configuration config = new PropertyListConfiguration();
        Catalogue catalogue = new Catalogue( config );
        SensorType sensorType = catalogue.addSensorType( "Wind Sensor", Unit.Kmh );

        // act
        WS8600 ws8600 = new WS8600( catalogue );
        String windDirection = ws8600.getWindDirection(315);

        // assert
        assertEquals( ws8600.getSensorType(), sensorType );
        assertEquals("NW",windDirection);
    }


    /**
     * This test verifies that the getWindDirection method returns the correct wind direction when the azimuth degree is 135.
     */
    @Test
    void shouldReturnWindDirection_SE () throws InstantiationException {
        // arrange
        Configuration config = new PropertyListConfiguration();
        Catalogue catalogue = new Catalogue( config );
        SensorType sensorType = catalogue.addSensorType( "Wind Sensor", Unit.Kmh );

        // act
        WS8600 ws8600 = new WS8600( catalogue );
        String windDirection = ws8600.getWindDirection(135);

        // assert
        assertEquals( ws8600.getSensorType(), sensorType );
        assertEquals("SE",windDirection);
    }

    /**
     * This test verifies that the getWindDirection method returns the correct wind direction when the azimuth degree is 45.
     */
    @Test
    void shouldReturnWindDirection_NE () throws InstantiationException {
        // arrange
        Configuration config = new PropertyListConfiguration();
        Catalogue catalogue = new Catalogue( config );
        SensorType sensorType = catalogue.addSensorType( "Wind Sensor", Unit.Kmh );

        // act
        WS8600 ws8600 = new WS8600( catalogue );
        String windDirection = ws8600.getWindDirection(45);

        // assert
        assertEquals( ws8600.getSensorType(), sensorType );
        assertEquals("NE",windDirection);
    }

    /**
     * This test verifies that the getWindDirection method returns the correct wind direction when the azimuth degree is 0.
     */
    @Test
    void shouldReturnWindDirection_N () throws InstantiationException {
        // arrange
        Configuration config = new PropertyListConfiguration();
        Catalogue catalogue = new Catalogue( config );
        SensorType sensorType = catalogue.addSensorType( "Wind Sensor", Unit.Kmh );

        // act
        WS8600 ws8600 = new WS8600( catalogue );
        String windDirection = ws8600.getWindDirection(0);

        // assert
        assertEquals( ws8600.getSensorType(), sensorType );
        assertEquals("N",windDirection);
    }


    /**
     * This test verifies that an exception is thrown when the getWindDirection method is called with an invalid azimuth degree.
     */
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


