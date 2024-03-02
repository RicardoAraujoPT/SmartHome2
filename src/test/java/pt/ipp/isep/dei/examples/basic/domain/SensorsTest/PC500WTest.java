package pt.ipp.isep.dei.examples.basic.domain.SensorsTest;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.plist.PropertyListConfiguration;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Catalogue;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.SensorType;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Unit;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Sensors.PC500W;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This class contains tests for the PC500W sensor in the SmartHome domain.
 * It tests the creation of a new instance of PC500W with valid parameters and checks if an exception is thrown when
 * trying to create a new instance with an inexistent sensor type.
 * It includes the following tests:
 *  - inexistentPC500W_ShouldThrowException
 *  - validPC500W_ShouldCreateNewInstance
 *
 */
public class PC500WTest {

    /**
     * Test case for when the sensor type for PC500W does not exist.
     * This test checks if an exception is thrown when trying to create a new instance of PC500W with an inexistent
     * sensor type.
     */
    @Test
    void inexistentPC500W_ShouldThrowException()
    {
        // arrange
        Configuration config = new PropertyListConfiguration();
        Catalogue catalogue = new Catalogue( config );
        String expectedMessage = "SensorType with description 'Power Consumption' does not exist.";

        // act + assert
        Exception exception = assertThrows( InstantiationException.class, () ->
                new PC500W( catalogue ));

        // assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    /**
     * Test case for creating a new instance of PC500W with valid parameters.
     * This test checks if a new instance of PC500W can be created with valid parameters and if the sensor type and
     * value are as expected.
     */
    @Test
    void validPC500W_ShouldCreateNewInstance() throws InstantiationException
    {
        // arrange
        Configuration config = new PropertyListConfiguration();
        Catalogue catalogue = new Catalogue( config );
        SensorType sensorType = catalogue.addSensorType( "Power Consumption", Unit.Watt);
        // act
        PC500W pc500WSensor = new PC500W( catalogue );

        // assert
        assertEquals(pc500WSensor.getSensorType(), sensorType );
        int value = Integer.parseInt( pc500WSensor.getValue().toString() );
        assertTrue( value >= 0 && value <= 500 );
    }

}
