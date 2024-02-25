package pt.ipp.isep.dei.examples.basic.domain.DomainTest.UnitTests;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.SensorType;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Unit;

import static org.junit.jupiter.api.Assertions.*;

class SensorTypeTest
{

    @Test
    void NewValidSensorType() throws InstantiationException
    {
        // arrange

        // act
        SensorType sensorType = new SensorType( "Humidity", Unit.Percentage );

        // assert
        assertEquals("Humidity", sensorType.getDescription());
        assertEquals( sensorType.getUnit(), Unit.Percentage);
    }

    @Test
    void NewEmptyDescriptionSensorType()
    {
        // arrange
        String expectedMessage = "Invalid arguments";

        // act + assert
        Exception exception = assertThrows( InstantiationException.class, () ->
                new SensorType( "", Unit.Percentage)
        );

        // assert
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void NewNullDescriptionSensorType()
    {
        // arrange
        String expectedMessage = "Invalid arguments";

        // act + assert
        Exception exception = assertThrows( InstantiationException.class, () ->
                new SensorType( null, Unit.Percentage)
        );

        // assert
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
