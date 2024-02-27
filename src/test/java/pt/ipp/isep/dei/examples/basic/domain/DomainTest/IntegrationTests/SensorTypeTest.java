package pt.ipp.isep.dei.examples.basic.domain.DomainTest.IntegrationTests;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.SensorType;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Unit;

import static org.junit.jupiter.api.Assertions.*;

class SensorTypeTest
{

    @Test
    void testConstructor_ValidParameters_ShouldNotThrowException() throws InstantiationException
    {
        // arrange

        // act
        SensorType sensorType = new SensorType( "Humidity", Unit.Percentage );

        // assert
        assertEquals("Humidity", sensorType.getDescription());
        assertEquals( sensorType.getUnit(), Unit.Percentage);
    }

    @Test
    void testConstructor_EmptyDescription_ShouldThrowException()
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
    void testConstructor_NullDescription_ShouldThrowException()
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
