package pt.ipp.isep.dei.examples.basic.domain.DomainTest.UnitTests;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.FactoryGPSCoordinates;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.GPSCoordinates;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Location;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LocationTest {

    /**
     * This test verifies that the Location constructor correctly creates a new Location instance.
     */
    @Test
    void validParameters_ShouldNotThrowException() {

        // Arrange
        GPSCoordinates gpsCoordinatesDouble = mock(GPSCoordinates.class);
        String expectedAddress = "Address";
        String expectedZipCode = "ZipCode";
        double expectedLatitude = 90.0000;
        double expectedLongitude = 180.0000;

        FactoryGPSCoordinates factoryGPSCoordinatesDouble = mock(FactoryGPSCoordinates.class);
        when(factoryGPSCoordinatesDouble.createGPSCoordinates(expectedLatitude, expectedLongitude)).thenReturn(gpsCoordinatesDouble);
        when(gpsCoordinatesDouble.getLatitude()).thenReturn(expectedLatitude);
        when(gpsCoordinatesDouble.getLongitude()).thenReturn(expectedLongitude);

        // Act
        Location location = new Location(expectedAddress, expectedZipCode, factoryGPSCoordinatesDouble, expectedLatitude, expectedLongitude);

        // Assert
        assertEquals(expectedAddress, location.getAddress());
        assertEquals(expectedZipCode, location.getZipCode());
        assertEquals(gpsCoordinatesDouble, location.getGpsCoordinates());
        assertEquals(expectedLatitude, location.getGpsCoordinates().getLatitude());
        assertEquals(expectedLongitude, location.getGpsCoordinates().getLongitude());
    }

    /**
     * Verifies that the Location constructor correctly throws an IllegalArgumentException when given a null address.
     * It does this by attempting to create a new Location instance with a null address and then checking that
     * an IllegalArgumentException is thrown with the message "Invalid address, ZIP code, latitude or longitude".
     */
    @Test
    void nullAddress_ShouldThrowException() {

        // Arrange
        GPSCoordinates gpsCoordinatesDouble = mock(GPSCoordinates.class);
        String address = null;
        String zipCode = "ZipCode";
        double latitude = 90.0000;
        double longitude = 180.0000;
        String expectedMessage = "Invalid address or ZIP code";

        FactoryGPSCoordinates factoryGPSCoordinatesDouble = mock(FactoryGPSCoordinates.class);
        when(factoryGPSCoordinatesDouble.createGPSCoordinates(latitude, longitude)).thenReturn(gpsCoordinatesDouble);

        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Location(address, zipCode, factoryGPSCoordinatesDouble, latitude, longitude));

        // Assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    /**
     * Verifies that the Location constructor correctly throws an IllegalArgumentException when given a null zip code.
     * It does this by attempting to create a new Location instance with a null zip code and then checking that
     * an IllegalArgumentException is thrown with the message "Invalid address, ZIP code, latitude or longitude".
     */
    @Test
    void nullZipCode_ShouldThrowException() {

        // Arrange
        GPSCoordinates gpsCoordinatesDouble = mock(GPSCoordinates.class);
        String address = "Address";
        String zipCode = null;
        double latitude = 90.0000;
        double longitude = 180.0000;
        String expectedMessage = "Invalid address or ZIP code";

        FactoryGPSCoordinates factoryGPSCoordinatesDouble = mock(FactoryGPSCoordinates.class);
        when(factoryGPSCoordinatesDouble.createGPSCoordinates(latitude, longitude)).thenReturn(gpsCoordinatesDouble);

        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Location(address, zipCode, factoryGPSCoordinatesDouble, latitude, longitude));

        // Assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    /**
     * Verifies that the Location constructor correctly throws an IllegalArgumentException when given an empty address.
     * It does this by attempting to create a new Location instance with an empty address and then checking that
     * an IllegalArgumentException is thrown with the message "Invalid address, ZIP code, latitude or longitude".
     */
    @Test
    void emptyAddress_ShouldThrowException() {

        // Arrange
        GPSCoordinates gpsCoordinatesDouble = mock(GPSCoordinates.class);
        String address = "";
        String zipCode = "ZipCode";
        double latitude = 90.0000;
        double longitude = 180.0000;
        String expectedMessage = "Invalid address or ZIP code";

        FactoryGPSCoordinates factoryGPSCoordinatesDouble = mock(FactoryGPSCoordinates.class);
        when(factoryGPSCoordinatesDouble.createGPSCoordinates(latitude, longitude)).thenReturn(gpsCoordinatesDouble);

        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Location(address, zipCode, factoryGPSCoordinatesDouble, latitude, longitude));

        // Assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    /**
     * Verifies that the Location constructor correctly throws an IllegalArgumentException when given an empty zip code.
     * It does this by attempting to create a new Location instance with an empty zip code and then checking that
     * an IllegalArgumentException is thrown with the message "Invalid address, ZIP code, latitude or longitude".
     */
    @Test
    void emptyZipCode_ShouldThrowException() {

        // Arrange
        GPSCoordinates gpsCoordinatesDouble = mock(GPSCoordinates.class);
        String address = "Address";
        String zipCode = "";
        double latitude = 90.0000;
        double longitude = 180.0000;
        String expectedMessage = "Invalid address or ZIP code";

        FactoryGPSCoordinates factoryGPSCoordinatesDouble = mock(FactoryGPSCoordinates.class);
        when(factoryGPSCoordinatesDouble.createGPSCoordinates(latitude, longitude)).thenReturn(gpsCoordinatesDouble);

        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Location(address, zipCode, factoryGPSCoordinatesDouble, latitude, longitude));

        // Assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    /**
     * Verifies that the setAddress method in the Location class correctly updates the address of the Location instance and returns true.
     * It does this by creating a new Location instance, setting a new address, and then checking that
     * the setAddress method returns true and the getAddress method returns the new address.
     */
    @Test
    void setAddress_ValidAddress_ShouldReturnTrue() {

        // Arrange
        GPSCoordinates gpsCoordinatesDouble = mock(GPSCoordinates.class);
        String initialAddress = "Address";
        String initialZipCode = "ZipCode";
        double initialLatitude = 90.0000;
        double initialLongitude = 180.0000;

        FactoryGPSCoordinates factoryGPSCoordinatesDouble = mock(FactoryGPSCoordinates.class);
        when(factoryGPSCoordinatesDouble.createGPSCoordinates(initialLatitude, initialLongitude)).thenReturn(gpsCoordinatesDouble);
        Location location = new Location(initialAddress, initialZipCode, factoryGPSCoordinatesDouble, initialLatitude, initialLongitude);
        String newAddress = "New Address";

        // Act
        boolean result = location.setAddress(newAddress);

        // Assert
        assertTrue(result);
        assertEquals(newAddress, location.getAddress());
    }

    /**
     * Verifies that the setAddress method in the Location class correctly returns false when given a null address.
     * It does this by creating a new Location instance, attempting to set a null address, and then checking that
     * the setAddress method returns false.
     */
    @Test
    void setAddress_NullAddress_ShouldReturnFalse() {

        // Arrange
        GPSCoordinates gpsCoordinatesDouble = mock(GPSCoordinates.class);
        String initialAddress = "Address";
        String initialZipCode = "ZipCode";
        double initialLatitude = 90.0000;
        double initialLongitude = 180.0000;

        FactoryGPSCoordinates factoryGPSCoordinatesDouble = mock(FactoryGPSCoordinates.class);
        when(factoryGPSCoordinatesDouble.createGPSCoordinates(initialLatitude, initialLongitude)).thenReturn(gpsCoordinatesDouble);
        Location location = new Location(initialAddress, initialZipCode, factoryGPSCoordinatesDouble, initialLatitude, initialLongitude);

        // Act
        boolean result = location.setAddress(null);

        // Assert
        assertFalse(result);
    }

    /**
     * Verifies that the setAddress method in the Location class correctly returns false when given an empty address.
     * It does this by creating a new Location instance, attempting to set an empty address, and then checking that
     * the setAddress method returns false.
     */
    @Test
    void setAddress_EmptyAddress_ShouldReturnFalse() {

        // Arrange
        GPSCoordinates gpsCoordinatesDouble = mock(GPSCoordinates.class);
        String initialAddress = "Address";
        String initialZipCode = "ZipCode";
        double initialLatitude = 90.0000;
        double initialLongitude = 180.0000;

        FactoryGPSCoordinates factoryGPSCoordinatesDouble = mock(FactoryGPSCoordinates.class);
        when(factoryGPSCoordinatesDouble.createGPSCoordinates(initialLatitude, initialLongitude)).thenReturn(gpsCoordinatesDouble);
        Location location = new Location(initialAddress, initialZipCode, factoryGPSCoordinatesDouble, initialLatitude, initialLongitude);

        // Act
        boolean result = location.setAddress("");

        // Assert
        assertFalse(result);
    }

    /**
     * Verifies that the setZipCode method in the Location class correctly updates the zip code of the Location instance and returns true.
     * It does this by creating a new Location instance, setting a new zip code, and then checking that
     * the setZipCode method returns true and the getZipCode method returns the new zip code.
     */
    @Test
    void setZipCode_ValidZipCode_ShouldReturnTrue() {

        // Arrange
        GPSCoordinates gpsCoordinatesDouble = mock(GPSCoordinates.class);
        String initialAddress = "Address";
        String initialZipCode = "ZipCode";
        double initialLatitude = 90.0000;
        double initialLongitude = 180.0000;

        FactoryGPSCoordinates factoryGPSCoordinatesDouble = mock(FactoryGPSCoordinates.class);
        when(factoryGPSCoordinatesDouble.createGPSCoordinates(initialLatitude, initialLongitude)).thenReturn(gpsCoordinatesDouble);
        Location location = new Location(initialAddress, initialZipCode, factoryGPSCoordinatesDouble, initialLatitude, initialLongitude);
        String newZipCode = "New ZipCode";

        // Act
        boolean result = location.setZipCode(newZipCode);

        // Assert
        assertTrue(result);
        assertEquals(newZipCode, location.getZipCode());
    }

    /**
     * Verifies that the setZipCode method in the Location class correctly returns false when given a null zip code.
     * It does this by creating a new Location instance, attempting to set a null zip code, and then checking that
     * the setZipCode method returns false.
     */
    @Test
    void setZipCode_NullZipCode_ShouldReturnFalse() {

        // Arrange
        GPSCoordinates gpsCoordinatesDouble = mock(GPSCoordinates.class);
        String initialAddress = "Address";
        String initialZipCode = "ZipCode";
        double initialLatitude = 90.0000;
        double initialLongitude = 180.0000;

        FactoryGPSCoordinates factoryGPSCoordinatesDouble = mock(FactoryGPSCoordinates.class);
        when(factoryGPSCoordinatesDouble.createGPSCoordinates(initialLatitude, initialLongitude)).thenReturn(gpsCoordinatesDouble);
        Location location = new Location(initialAddress, initialZipCode, factoryGPSCoordinatesDouble, initialLatitude, initialLongitude);

        // Act
        boolean result = location.setZipCode(null);

        // Assert
        assertFalse(result);
    }

    /**
     * Verifies that the setZipCode method in the Location class correctly returns false when given an empty zip code.
     * It does this by creating a new Location instance, attempting to set an empty zip code, and then checking that
     * the setZipCode method returns false.
     */
    @Test
    void setZipCode_EmptyZipCode_ShouldReturnFalse() {

        // Arrange
        GPSCoordinates gpsCoordinatesDouble = mock(GPSCoordinates.class);
        String initialAddress = "Address";
        String initialZipCode = "ZipCode";
        double initialLatitude = 90.0000;
        double initialLongitude = 180.0000;

        FactoryGPSCoordinates factoryGPSCoordinatesDouble = mock(FactoryGPSCoordinates.class);
        when(factoryGPSCoordinatesDouble.createGPSCoordinates(initialLatitude, initialLongitude)).thenReturn(gpsCoordinatesDouble);
        Location location = new Location(initialAddress, initialZipCode, factoryGPSCoordinatesDouble, initialLatitude, initialLongitude);

        // Act
        boolean result = location.setZipCode("");

        // Assert
        assertFalse(result);
    }

    /**
     * Verifies that the getAddress method in the Location class correctly returns the address of the Location instance.
     * It does this by creating a new Location instance with a valid address and then checking that
     * the getAddress method returns the expected address.
     */
    @Test
    void shouldGetAddress() {

        // Arrange
        GPSCoordinates gpsCoordinatesDouble = mock(GPSCoordinates.class);
        String expectedAddress = "Address";
        String initialZipCode = "ZipCode";
        double initialLatitude = 90.0000;
        double initialLongitude = 180.0000;

        FactoryGPSCoordinates factoryGPSCoordinatesDouble = mock(FactoryGPSCoordinates.class);
        when(factoryGPSCoordinatesDouble.createGPSCoordinates(initialLatitude, initialLongitude)).thenReturn(gpsCoordinatesDouble);
        Location location = new Location(expectedAddress, initialZipCode, factoryGPSCoordinatesDouble, initialLatitude, initialLongitude);

        // Act
        String result = location.getAddress();

        // Assert
        assertEquals(expectedAddress, result);
    }

    /**
     * Verifies that the getZipCode method in the Location class correctly returns the zip code of the Location instance.
     * It does this by creating a new Location instance with a valid zip code and then checking that
     * the getZipCode method returns the expected zip code.
     */
    @Test
    void shouldGetZipCode() {

        // Arrange
        GPSCoordinates gpsCoordinatesDouble = mock(GPSCoordinates.class);
        String initialAddress = "Address";
        String expectedZipCode = "ZipCode";
        double initialLatitude = 90.0000;
        double initialLongitude = 180.0000;

        FactoryGPSCoordinates factoryGPSCoordinatesDouble = mock(FactoryGPSCoordinates.class);
        when(factoryGPSCoordinatesDouble.createGPSCoordinates(initialLatitude, initialLongitude)).thenReturn(gpsCoordinatesDouble);
        Location location = new Location(initialAddress, expectedZipCode, factoryGPSCoordinatesDouble, initialLatitude, initialLongitude);

        // Act
        String result = location.getZipCode();

        // Assert
        assertEquals(expectedZipCode, result);
    }

    /**
     * Verifies that the getGpsCoordinates method in the Location class correctly returns the GPS coordinates of the Location instance.
     * It does this by creating a new Location instance with valid latitude and longitude coordinates and then checking that
     * the getGpsCoordinates method returns the expected coordinates.
     */
    @Test
    void shouldGetGpsCoordinates() {

        // Arrange
        GPSCoordinates gpsCoordinatesDouble = mock(GPSCoordinates.class);
        double expectedLatitude = 90.0000;
        double expectedLongitude = 180.0000;

        FactoryGPSCoordinates factoryGPSCoordinatesDouble = mock(FactoryGPSCoordinates.class);
        when(factoryGPSCoordinatesDouble.createGPSCoordinates(expectedLatitude, expectedLongitude)).thenReturn(gpsCoordinatesDouble);
        when(gpsCoordinatesDouble.getLatitude()).thenReturn(expectedLatitude);
        when(gpsCoordinatesDouble.getLongitude()).thenReturn(expectedLongitude);
        Location location = new Location("Address", "ZipCode", factoryGPSCoordinatesDouble, expectedLatitude, expectedLongitude);

        // Act
        GPSCoordinates result = location.getGpsCoordinates();

        // Assert
        assertEquals(gpsCoordinatesDouble, result);
        assertEquals(expectedLatitude, result.getLatitude());
        assertEquals(expectedLongitude, result.getLongitude());
    }

    /**
     * This test verifies that the setGpsCoordinates method in the Location class correctly updates the GPS coordinates of the Location instance.
     * It does this by creating a new Location instance, setting new GPS coordinates, and then checking that
     * the getGpsCoordinates method returns the new GPS coordinates.
     */
    @Test
    void shouldSetGpsCoordinatesAndReturnTrue() {

        // Arrange
        GPSCoordinates gpsCoordinatesDouble = mock(GPSCoordinates.class);
        double initialLatitude = 90.0000;
        double initialLongitude = 180.0000;
        FactoryGPSCoordinates factoryGPSCoordinatesDouble = mock(FactoryGPSCoordinates.class);
        when(factoryGPSCoordinatesDouble.createGPSCoordinates(initialLatitude, initialLongitude)).thenReturn(gpsCoordinatesDouble);
        Location location = new Location("Address", "ZipCode", factoryGPSCoordinatesDouble, initialLatitude, initialLongitude);

        GPSCoordinates newCoordinates = mock(GPSCoordinates.class);
        double newLatitude = 80.0000;
        double newLongitude = 170.0000;
        when(factoryGPSCoordinatesDouble.createGPSCoordinates(newLatitude, newLongitude)).thenReturn(newCoordinates);
        when(newCoordinates.getLatitude()).thenReturn(newLatitude);
        when(newCoordinates.getLongitude()).thenReturn(newLongitude);

        // Act
        location.setGpsCoordinates(newCoordinates);

        // Assert
        assertEquals(newCoordinates, location.getGpsCoordinates());
        assertEquals(newLatitude, location.getGpsCoordinates().getLatitude());
        assertEquals(newLongitude, location.getGpsCoordinates().getLongitude());
        assertTrue(location.setGpsCoordinates(newCoordinates));
    }

    /**
     * This test verifies that the setGpsCoordinates method in the Location class correctly returns false when given an invalid latitude.
     * It does this by creating a new Location instance and then attempting to set invalid latitude coordinates, and then checking that
     * the setGpsCoordinates method returns false.
     */
    @Test
    void setGpsCoordinates_NullGpsCoordinates_ShouldReturnFalse() {

        // Arrange
        GPSCoordinates gpsCoordinatesDouble = mock(GPSCoordinates.class);
        double initialLatitude = 90.0000;
        double initialLongitude = 180.0000;
        FactoryGPSCoordinates factoryGPSCoordinatesDouble = mock(FactoryGPSCoordinates.class);
        when(factoryGPSCoordinatesDouble.createGPSCoordinates(initialLatitude, initialLongitude)).thenReturn(gpsCoordinatesDouble);
        Location location = new Location("Address", "ZipCode", factoryGPSCoordinatesDouble, initialLatitude, initialLongitude);

        // Act
        boolean result = location.setGpsCoordinates(null);

        // Assert
        assertFalse(result);
    }
}
