package pt.ipp.isep.dei.examples.basic.domain.DomainTest.IntegrationTests;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.GPSCoordinates;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The GPSCoordinatesTest class contains unit tests for the GPSCoordinates class.
 * A decimal degree (DD) notation with up to 6 decimal places is used for the coordinates.
 * The following tests test the creation of a GPS location with valid and invalid latitude and longitude values.
 * An additional test for the roundTo6DecimalPlaces method is included.
 * The valid range for the latitude coordinate is from -90.0 to 90.0.
 * The valid range for the longitude coordinate is from -180.0 to 180.0.
 */
public class GPSCoordinatesTest {

    /**
     * Test creating a valid GPS location and checking if latitude and longitude are set correctly.
     */
    @Test
    void shouldCreateValidGPSLocation() {

        // Arrange
        double expectedLatitude = 37.7749;
        double expectedLongitude = -122.4194;

        // Act
        GPSCoordinates location = new GPSCoordinates(expectedLatitude, expectedLongitude);

        // Assert
        assertEquals(expectedLatitude, location.getLatitude(), 1e-6);
        assertEquals(expectedLongitude, location.getLongitude(), 1e-6);
    }

    /**
     * Test attempting to create a GPS location with an invalid latitude value.
     * An IllegalArgumentException is expected.
     */
    @Test
    void shouldCreateGPSLocation_InvalidLatitude() {

        // Arrange
        double invalidLatitude = 100;
        double validLongitude = -122.4194;
        String expectedMessage = "Invalid GPS coordinates";

        // Act + Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new GPSCoordinates(invalidLatitude, validLongitude));
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    /**
     * Test attempting to create a GPS location with an invalid longitude value.
     * An IllegalArgumentException is expected.
     */
    @Test
    void shouldCreateGPSLocation_InvalidLongitude() {

        // Arrange
        double validLatitude = 37.7749;
        double invalidLongitude = -200;
        String expectedMessage = "Invalid GPS coordinates";

        // Act + Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new GPSCoordinates(validLatitude, invalidLongitude));
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    /**
     * Test setting a valid latitude value using the setLatitude method.
     */
    @Test
    void shouldSetLatitude_ValidValue() {

        // Arrange
        GPSCoordinates location = new GPSCoordinates(37.7749, -122.4194);
        double validLatitude = 40.7128;

        // Act
        location.setLatitude(validLatitude);

        // Assert
        assertEquals(validLatitude, location.getLatitude(), 1e-6);
    }

    /**
     * Test attempting to set an invalid latitude value using the setLatitude method.
     * An IllegalArgumentException is expected.
     */
    @Test
    void shouldSetLatitude_InvalidValue() {

        // Arrange
        GPSCoordinates location = new GPSCoordinates(37.7749, -122.4194);
        double invalidLatitude = 100;
        String expectedMessage = "Invalid latitude. Must be between -90.0 and 90.0.";

        // Act + Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> location.setLatitude(invalidLatitude));
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    /**
     * Test setting a valid longitude value using the setLongitude method.
     */
    @Test
    void shouldSetLongitude_ValidValue() {

        // Arrange
        GPSCoordinates location = new GPSCoordinates(37.7749, -122.4194);
        double validLongitude = -74.0060;

        // Act
        location.setLongitude(validLongitude);

        // Assert
        assertEquals(validLongitude, location.getLongitude(), 1e-6);
    }

    /**
     * Test attempting to set an invalid longitude value using the setLongitude method.
     * An IllegalArgumentException is expected.
     */
    @Test
    void shouldSetLongitude_InvalidValue() {

        // Arrange
        GPSCoordinates location = new GPSCoordinates(37.7749, -122.4194);
        double invalidLongitude = -200;
        String expectedMessage = "Invalid longitude. Must be between -180.0 and 180.0.";

        // Act + Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> location.setLongitude(invalidLongitude));
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    /**
     * Test rounding double values to 6 decimal places.
     */
    @Test
    void roundTo6DecimalPlaces() {

        // Arrange + Act
        GPSCoordinates location = new GPSCoordinates(37.7749382, -122.4194137);

        // Assert
        assertEquals(37.774938, location.getLatitude(), 1e-6);
        assertEquals(-122.419414, location.getLongitude(), 1e-6);
    }

    /**
     * Tests the method with the lower boundary latitude value. Expects the same latitude value as provided.
     */
    @Test
    void validLatitude_LowerBoundary() {

        // Arrange
        double lowerBoundaryLatitude = -90.0000000;
        double longitude = -122.4194137;

        // Act
        GPSCoordinates location = new GPSCoordinates(lowerBoundaryLatitude, longitude);

        // Assert
        assertEquals(lowerBoundaryLatitude, location.getLatitude(), 1e-6);
    }

    /**
     * Tests the method with the middle boundary latitude value. Expects the same latitude value as provided.
     */
    @Test
    void validLatitude_MiddleValue() {

        // Arrange
        double middleBoundaryLatitude = 0.0000000;
        double longitude = -122.4194137;

        // Act
        GPSCoordinates location = new GPSCoordinates(middleBoundaryLatitude, longitude);

        // Assert
        assertEquals(middleBoundaryLatitude, location.getLatitude(), 1e-6);
    }

    /**
     * Tests the method with the upper boundary latitude value. Expects the same latitude value as provided.
     */
    @Test
    void validLatitude_UpperBoundary() {

        // Arrange
        double upperBoundaryLatitude = 90.0000000;
        double longitude = -122.4194137;

        // Act
        GPSCoordinates location = new GPSCoordinates(upperBoundaryLatitude, longitude);

        // Assert
        assertEquals(upperBoundaryLatitude, location.getLatitude(), 1e-6);
    }

    /**
     * Tests the method with the lower boundary longitude value. Expects the same longitude value as provided.
     */
    @Test
    void validLongitude_LowerBoundary() {

        // Arrange
        double latitude = 37.7749295;
        double lowerBoundaryLongitude = -180.0000000;

        // Act
        GPSCoordinates location = new GPSCoordinates(latitude, lowerBoundaryLongitude);

        // Assert
        assertEquals(lowerBoundaryLongitude, location.getLongitude(), 1e-6, "Longitude should be equal to the lower boundary value.");
    }

    /**
     * Tests the method with the middle boundary longitude value. Expects the same longitude value as provided.
     */
    @Test
    void validLongitude_MiddleValue() {

        // Arrange
        double latitude = 37.7749295;
        double middleBoundaryLongitude = 0.0000000;

        // Act
        GPSCoordinates location = new GPSCoordinates(latitude, middleBoundaryLongitude);

        // Assert
        assertEquals(middleBoundaryLongitude, location.getLongitude(), 1e-6, "Longitude should be equal to the middle boundary value.");
    }

    /**
     * Tests the method with the upper boundary longitude value. Expects the same longitude value as provided.
     */
    @Test
    void validLongitude_UpperBoundary() {

        // Arrange
        double latitude = 37.7749295;
        double upperBoundaryLongitude = 180.0000000;

        // Act
        GPSCoordinates location = new GPSCoordinates(latitude, upperBoundaryLongitude);

        // Assert
        assertEquals(upperBoundaryLongitude, location.getLongitude(), 1e-6, "Longitude should be equal to the upper boundary value.");
    }
}