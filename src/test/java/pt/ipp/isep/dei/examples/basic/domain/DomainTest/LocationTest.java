package pt.ipp.isep.dei.examples.basic.domain.DomainTest;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Location;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.GPSCoordinates;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LocationTest {

    /**
     * This test verifies that the Location constructor correctly creates a new Location instance and the getAddress and getZipCode methods return the correct values.
     * It does this by creating a new Location instance with valid parameters and then checking that the getAddress and getZipCode methods return the expected values.
     */
    @Test
    void testConstructor_ValidParameters_ShouldNotThrowException() {
        String expectedAddress = "Address";
        String expectedZipCode = "ZipCode";
        Double expectedLatitude = 90.0000;
        Double expectedLongitude = 180.0000;

        Location location = new Location(expectedAddress, expectedZipCode, expectedLatitude, expectedLongitude);

        assertEquals(expectedAddress, location.getAddress());
        assertEquals(expectedZipCode, location.getZipCode());
        assertEquals(expectedLatitude, location.getGpsCoordinates().getLatitude());
        assertEquals(expectedLongitude, location.getGpsCoordinates().getLongitude());
    }

    /**
     * This test verifies that the Location constructor correctly throws an IllegalArgumentException when given a null address.
     * It does this by attempting to create a new Location instance with a null address and then checking that an IllegalArgumentException is thrown.
     */
    @Test
    void testConstructor_NullAddress_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new Location(null, "ZipCode",90.0000, 180.0000));
    }

    /**
     * This test verifies that the Location constructor correctly throws an IllegalArgumentException when given a null zip code.
     * It does this by attempting to create a new Location instance with a null zip code and then checking that an IllegalArgumentException is thrown.
     */
    @Test
    void testConstructor_NullZipCode_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new Location("Address", null, 90.0000, 180.0000));
    }

    /**
     * This test verifies that the getAddress method in the Location class correctly returns the address of the Location instance.
     * It does this by creating a new Location instance with a valid address and then checking that the getAddress method returns the expected address.
     */
    @Test
    void testGetAddress_ValidAddress_ShouldReturnCorrectAddress() {
        Location location = new Location("Address", "ZipCode",90.0000, 180.0000);
        assertEquals("Address", location.getAddress());
    }

    /**
     * This test verifies that the getZipCode method in the Location class correctly returns the zip code of the Location instance.
     * It does this by creating a new Location instance with a valid zip code and then checking that the getZipCode method returns the expected zip code.
     */
    @Test
    void testGetZipCode_ValidZipCode_ShouldReturnCorrectZipCode() {
        Location location = new Location("Address", "ZipCode",90.0000, 180.0000);
        assertEquals("ZipCode", location.getZipCode());
    }

    /**
     * This test verifies that the Location constructor correctly throws an IllegalArgumentException when given an empty address.
     * It does this by attempting to create a new Location instance with an empty address and then checking that an IllegalArgumentException is thrown.
     */
    @Test
    void testConstructor_EmptyAddress_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new Location("", "ZipCode",90.0000, 180.0000));
    }

    /**
     * This test verifies that the Location constructor correctly throws an IllegalArgumentException when given an empty zip code.
     * It does this by attempting to create a new Location instance with an empty zip code and then checking that an IllegalArgumentException is thrown.
     */
    @Test
    void testConstructor_EmptyZipCode_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new Location("Address", "",90.0000, 180.0000));
    }

    /**
     * This test verifies that the setAddress method in the Location class correctly updates the address of the Location instance and returns true.
     * It does this by creating a new Location instance, setting a new address, and then checking that the setAddress method returns true and the getAddress method returns the new address.
     */
    @Test
    void testSetAddress_ValidAddress_ShouldReturnTrue() {
        Location location = new Location("Address", "ZipCode",90.0000, 180.0000);
        boolean result = location.setAddress("New Address");
        assertTrue(result);
        assertEquals("New Address", location.getAddress());
    }

    /**
     * This test verifies that the setAddress method in the Location class correctly returns false when given a null address.
     * It does this by creating a new Location instance, attempting to set a null address, and then checking that the setAddress method returns false.
     */
    @Test
    void testSetAddress_NullAddress_ShouldReturnFalse() {
        Location location = new Location("Address", "ZipCode",90.0000, 180.0000);
        boolean result = location.setAddress(null);
        assertFalse(result);
    }

    /**
     * This test verifies that the setAddress method in the Location class correctly returns false when given an empty address.
     * It does this by creating a new Location instance, attempting to set an empty address, and then checking that the setAddress method returns false.
     */
    @Test
    void testSetAddress_EmptyAddress_ShouldReturnFalse() {
        Location location = new Location("Address", "ZipCode",90.0000, 180.0000);
        boolean result = location.setAddress("");
        assertFalse(result);
    }

    /**
     * This test verifies that the setZipCode method in the Location class correctly updates the zip code of the Location instance and returns true.
     * It does this by creating a new Location instance, setting a new zip code, and then checking that the setZipCode method returns true and the getZipCode method returns the new zip code.
     */
    @Test
    void testSetZipCode_ValidZipCode_ShouldReturnTrue() {
        Location location = new Location("Address", "ZipCode",90.0000, 180.0000);
        boolean result = location.setZipCode("New ZipCode");
        assertTrue(result);
        assertEquals("New ZipCode", location.getZipCode());
    }

    /**
     * This test verifies that the setZipCode method in the Location class correctly returns false when given a null zip code.
     * It does this by creating a new Location instance, attempting to set a null zip code, and then checking that the setZipCode method returns false.
     */
    @Test
    void testSetZipCode_NullZipCode_ShouldReturnFalse() {
        Location location = new Location("Address", "ZipCode",90.0000, 180.0000);
        boolean result = location.setZipCode(null);
        assertFalse(result);
    }

    /**
     * This test verifies that the setZipCode method in the Location class correctly returns false when given an empty zip code.
     * It does this by creating a new Location instance, attempting to set an empty zip code, and then checking that the setZipCode method returns false.
     */
    @Test
    void testSetZipCode_EmptyZipCode_ShouldReturnFalse() {
        Location location = new Location("Address", "ZipCode",90.0000, 180.0000);
        boolean result = location.setZipCode("");
        assertFalse(result);
    }

    /**
     * This test verifies that the getAddress method in the Location class correctly returns the address of the Location instance.
     * It does this by creating a new Location instance with a valid address and then checking that the getAddress method returns the expected address.
     */
    @Test
    void testGetAddress() {
        Location location = new Location("Address", "ZipCode",90.0000, 180.0000);
        String expected = "Address";
        assertEquals(expected, location.getAddress());
    }

    /**
     * This test verifies that the getZipCode method in the Location class correctly returns the zip code of the Location instance.
     * It does this by creating a new Location instance with a valid zip code and then checking that the getZipCode method returns the expected zip code.
     */
    @Test
    void testGetZipCode() {
        Location location = new Location("Address", "ZipCode",90.0000, 180.0000);
        String expected = "ZipCode";
        assertEquals(expected, location.getZipCode());
    }

    /**
     * This test verifies that the setAddress method in the Location class correctly updates the address of the Location instance.
     * It does this by creating a new Location instance, setting a new address, and then checking that the getAddress method returns the new address.
     */

    @Test
    void testGetGpsCoordinates() {
        Double expectedLatitude = 90.0000;
        Double expectedLongitude = 180.0000;
        Location location = new Location("Address", "ZipCode", expectedLatitude, expectedLongitude);

        GPSCoordinates result = location.getGpsCoordinates();

        assertEquals(expectedLatitude, result.getLatitude());
        assertEquals(expectedLongitude, result.getLongitude());
    }

    @Test
    void testSetAddress() {
        Location location = new Location("Address", "ZipCode",90.0000, 180.0000);
        location.setAddress("New Address");
        String expected = "New Address";
        assertEquals(expected, location.getAddress());
    }

    /**
     * This test verifies that the setZipCode method in the Location class correctly updates the zip code of the Location instance.
     * It does this by creating a new Location instance, setting a new zip code, and then checking that the getZipCode method returns the new zip code.
     */
    @Test
    void testSetZipCode() {
        Location location = new Location("Address", "ZipCode",90.0000, 180.0000);
        location.setZipCode("New ZipCode");
        String expected = "New ZipCode";
        assertEquals(expected, location.getZipCode());
    }

    /**
     * This test verifies that the setAddress method in the Location class correctly handles a null address input.
     * It does this by creating a new Location instance, attempting to set a null address, and then checking that the setAddress method returns false.
     */
    @Test
    void testSetAddress_Null() {
        Location location = new Location("Address", "ZipCode",90.0000, 180.0000);
        assertFalse(location.setAddress(null));
    }

    /**
     * This test verifies that the setAddress method in the Location class correctly handles an empty address input.
     * It does this by creating a new Location instance, attempting to set an empty address, and then checking that the setAddress method returns false.
     */
    @Test
    void testSetAddress_Empty() {
        Location location = new Location("Address", "ZipCode",90.0000, 180.0000);
        assertFalse(location.setAddress(""));
    }

    /**
     * This test verifies that the setZipCode method in the Location class correctly handles a null zip code input.
     * It does this by creating a new Location instance, attempting to set a null zip code, and then checking that the setZipCode method returns false.
     */
    @Test
    void testSetZipCode_Null() {
        Location location = new Location("Address", "ZipCode",90.0000, 180.0000);
        assertFalse(location.setZipCode(null));
    }

    /**
     * This test verifies that the setZipCode method in the Location class correctly handles an empty zip code input.
     * It does this by creating a new Location instance, attempting to set an empty zip code, and then checking that the setZipCode method returns false.
     */
    @Test
    void testSetZipCode_Empty() {
        Location location = new Location("Address", "ZipCode",90.0000, 180.0000);
        assertFalse(location.setZipCode(""));
    }

    /**
     * This test verifies that the setGpsCoordinates method in the Location class correctly updates the GPS coordinates of the Location instance.
     * It does this by creating a new Location instance, setting new GPS coordinates, and then checking that the getGpsCoordinates method returns the new GPS coordinates.
     */
    @Test
    void testSetGpsCoordinates() {
        Double expectedLatitude = 90.0000;
        Double expectedLongitude = 180.0000;
        Location location = new Location("Address", "ZipCode", 0.0000, 0.0000);

        boolean result = location.setGpsCoordinates(expectedLatitude, expectedLongitude);

        assertTrue(result);
        assertEquals(expectedLatitude, location.getGpsCoordinates().getLatitude());
        assertEquals(expectedLongitude, location.getGpsCoordinates().getLongitude());
    }
}