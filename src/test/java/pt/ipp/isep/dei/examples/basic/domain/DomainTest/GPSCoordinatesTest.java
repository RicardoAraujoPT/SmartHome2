package pt.ipp.isep.dei.examples.basic.domain.DomainTest;

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
    public void createValidGPSLocation() {
        GPSCoordinates location = new GPSCoordinates(37.7749, -122.4194);
        assertEquals(37.7749, location.getLatitude(), 1e-6);
        assertEquals(-122.4194, location.getLongitude(), 1e-6);
    }

    /**
     * Test attempting to create a GPS location with an invalid latitude value.
     * An IllegalArgumentException is expected.
     */
    @Test
    public void createGPSLocationInvalidLatitude() {
        assertThrows(IllegalArgumentException.class, () -> new GPSCoordinates(100, -122.4194));
    }

    /**
     * Test attempting to create a GPS location with an invalid longitude value.
     * An IllegalArgumentException is expected.
     */
    @Test
    public void createGPSLocationInvalidLongitude() {
        assertThrows(IllegalArgumentException.class, () -> new GPSCoordinates(37.7749, -200));
    }

    /**
     * Test setting a valid latitude value using the setLatitude method.
     */
    @Test
    public void setValidLatitude() {
        GPSCoordinates location = new GPSCoordinates(37.7749, -122.4194);
        location.setLatitude(40.7128);
        assertEquals(40.7128, location.getLatitude(), 1e-6);
    }

    /**
     * Test attempting to set an invalid latitude value using the setLatitude method.
     * An IllegalArgumentException is expected.
     */
    @Test
    public void setInvalidLatitude() {
        GPSCoordinates location = new GPSCoordinates(37.7749, -122.4194);
        assertThrows(IllegalArgumentException.class, () -> location.setLatitude(100));
    }

    /**
     * Test setting a valid longitude value using the setLongitude method.
     */
    @Test
    public void setValidLongitude() {
        GPSCoordinates location = new GPSCoordinates(37.7749, -122.4194);
        location.setLongitude(-74.0060);
        assertEquals(-74.0060, location.getLongitude(), 1e-6);
    }

    /**
     * Test attempting to set an invalid longitude value using the setLongitude method.
     * An IllegalArgumentException is expected.
     */
    @Test
    public void setInvalidLongitude() {
        GPSCoordinates location = new GPSCoordinates(37.7749, -122.4194);
        assertThrows(IllegalArgumentException.class, () -> location.setLongitude(-200));
    }

    /**
     * Test rounding double values to 6 decimal places.
     */
    @Test
    public void testRoundTo6DecimalPlaces() {
        GPSCoordinates location = new GPSCoordinates(37.7749382, -122.4194137);
        assertEquals(37.774938, location.getLatitude(), 1e-6);
        assertEquals(-122.419414, location.getLongitude(), 1e-6);
    }

    /**
     * Tests the method with the lower boundary latitude value.
     * The expected result is the same as the provided latitude value.
     */
    @Test
    public void testValidLatitudeLowerBoundary() {
        GPSCoordinates location = new GPSCoordinates(-90.0000000, -122.4194137);
        assertEquals(-90.0000000, location.getLatitude(), 1e-6);
    }
    /**
     * Tests the method with the middle boundary latitude value.
     * The expected result is the same as the provided latitude value.
     */
    @Test
    public void testValidLatitudeMiddleValue() {
        GPSCoordinates location = new GPSCoordinates(0.0000000, -122.4194137);
        assertEquals(0.0000000, location.getLatitude(), 1e-6);
    }

    /**
     * Tests the method with the upper boundary latitude value.
     * The expected result is the same as the provided latitude value.
     */
    @Test
    public void testValidLatitudeUpperBoundary() {
        GPSCoordinates location = new GPSCoordinates(90.0000000, -122.4194137);
        assertEquals(90.0000000, location.getLatitude(), 1e-6);
    }

    /**
     * Tests the method with the lower boundary longitude value.
     * The expected result is the same as the provided longitude value.
     */
    @Test
    public void testValidLongitudeLowerBoundary() {
        GPSCoordinates location = new GPSCoordinates(37.7749295, -180.0000000);
        assertEquals(-180.0000000, location.getLongitude(), 1e-6, "Longitude should be equal to the lower boundary value.");
    }

    /**
     * Tests the method with the middle boundary longitude value.
     * The expected result is the same as the provided longitude value.
     */
    @Test
    public void testValidLongitudeMiddleValue() {
        GPSCoordinates location = new GPSCoordinates(37.7749295, 0.0000000);
        assertEquals(0.0000000, location.getLongitude(), 1e-6, "Longitude should be equal to the middle boundary value.");
    }

    /**
     * Tests the method with the upper boundary longitude value.
     * The expected result is the same as the provided longitude value.
     */
    @Test
    public void testValidLongitudeUpperBoundary() {
        // Arrange
        GPSCoordinates location = new GPSCoordinates(37.7749295, 180.0000000);
        assertEquals(180.0000000, location.getLongitude(), 1e-6, "Longitude should be equal to the upper boundary value.");
    }
}