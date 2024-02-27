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
                new WS8600( catalogue )
        );

        // assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}

