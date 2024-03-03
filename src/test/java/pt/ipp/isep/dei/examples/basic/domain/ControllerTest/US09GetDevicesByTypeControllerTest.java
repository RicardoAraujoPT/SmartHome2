package pt.ipp.isep.dei.examples.basic.domain.ControllerTest;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers.US09GetDevicesByTypeController;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.DeviceDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
/**
 * This is a test class of the US09GetDevicesByTypeController. It contains tests for:
 * house with many devices;
 * house with no devices;
 * Non-existing House
 * Non-existing Catalogue
 */

class US09GetDevicesByTypeControllerTest {
    /*
     * Test for a house with 2 rooms and many devices.
     * The expected result is a map with 2 keys, "Temperature" and "Humidity", and a list of devices for each key.
     * The list of devices for "Temperature" should contain [d1, d3] from r0, and [d0, 0d1] from r1.
     * The list of devices for "Humidity" should contain devices [d2, d3,d4] from r0 and [d1] from r1.
     */
    @Test
    void successfully_ShouldReturnDevicesGroupedByType() throws InstantiationException {
        //Arrange
        FactorySensorType factorySensorType = new FactorySensorType();
        Catalogue catalogue = new Catalogue("config.properties",factorySensorType);
        catalogue.addSensorType("Humidity", Unit.Percentage);
        catalogue.addSensorType("Temperature", Unit.Celsius);
        FactoryGPSCoordinates factoryGPSCoordinates = new FactoryGPSCoordinates();
        FactoryDevice factoryDevice = new FactoryDevice();
        FactoryLocation factoryLocation = new FactoryLocation(factoryGPSCoordinates);
        FactoryRoom factoryRoom = new FactoryRoom(factoryDevice);
        House myHouse = new House(factoryLocation,factoryRoom);


        for (int i = 0; i < 2; i++) { // Adding 2 room
            myHouse.addRoom("r" + i, 0, 25, 10);
            if (i == 0) { //Choosing r0
                // Adding 5 devices to r0
                for (int j = 0; j < 5; j++) {

                    myHouse.getRoomList().get(i).addDevice("d" + j);
                    // Configuring sensors for each device
                    if (j == 0) {
                        // No sensor for device 0
                    } else if (j == 1) {
                        // Temperature sensor for device 1
                        myHouse.getRoomList().get(i).getDevices().get(j).addSensor("Sensors.GA100K",catalogue);
                    } else if (j == 2) {
                        // Humidity sensor for device 2
                        myHouse.getRoomList().get(i).getDevices().get(j).addSensor("Sensors.TSY01",catalogue);
                    } else if (j == 3) {// Humidity and Temperature sensorsfor device 3
                        myHouse.getRoomList().get(i).getDevices().get(j).addSensor("Sensors.GA100K",catalogue);
                        myHouse.getRoomList().get(i).getDevices().get(j).addSensor("Sensors.TSY01",catalogue);
                    }
                    else {//2 humidity sensors for device 4
                        myHouse.getRoomList().get(i).getDevices().get(j).addSensor("Sensors.TSY01",catalogue);
                        myHouse.getRoomList().get(i).getDevices().get(j).addSensor("Sensors.TSY01",catalogue);
                    }
                }
            }
            if (i == 1) { //Choosing r1
                // Adding 2 devices to r1
                for (int j = 0; j < 2; j++) {
                    myHouse.getRoomList().get(i).addDevice("d" + j);
                    if (j == 0) {//2 temperature sensors for device 0
                        myHouse.getRoomList().get(i).getDevices().get(j).addSensor("Sensors.GA100K",catalogue);
                        myHouse.getRoomList().get(i).getDevices().get(j).addSensor("Sensors.GA100K",catalogue);
                    } else {
                        // 2 temperature sensors and 2 humidity sensors for device 1
                        myHouse.getRoomList().get(i).getDevices().get(j).addSensor("Sensors.GA100K",catalogue);
                        myHouse.getRoomList().get(i).getDevices().get(j).addSensor("Sensors.GA100K",catalogue);
                        myHouse.getRoomList().get(i).getDevices().get(j).addSensor("Sensors.TSY01",catalogue);
                        myHouse.getRoomList().get(i).getDevices().get(j).addSensor("Sensors.TSY01",catalogue);
                    }
                }
            }
        }

        HashMap<String, List<DeviceDTO>> expected = new HashMap<>();
        expected.put("Temperature", new ArrayList<>());
        expected.get("Temperature").add(new DeviceDTO("d1", "r0"));
        expected.get("Temperature").add(new DeviceDTO("d3","r0"));
        expected.get("Temperature").add(new DeviceDTO("d0", "r1"));
        expected.get("Temperature").add(new DeviceDTO("d1", "r1"));
        expected.put("Humidity", new ArrayList<>());
        expected.get("Humidity").add(new DeviceDTO("d2", "r0"));
        expected.get("Humidity").add(new DeviceDTO("d3", "r0"));
        expected.get("Humidity").add(new DeviceDTO("d4", "r0"));
        expected.get("Humidity").add(new DeviceDTO("d1", "r1"));

        //Act
        US09GetDevicesByTypeController us09GetDevicesByTypeController = new US09GetDevicesByTypeController(myHouse,catalogue);
        HashMap<String, List<DeviceDTO>> actual = us09GetDevicesByTypeController.getDevicesByType();


        //Assert
        assertEquals(expected.size(), actual.size(), "HashMap sizes do not match");
        for (Map.Entry<String, List<DeviceDTO>> entry : expected.entrySet()) {
            String key = entry.getKey();
            List<DeviceDTO> expectedList = entry.getValue();
            assertTrue(actual.containsKey(key), "Key " + key + " not found in actual HashMap");
            List<DeviceDTO> actualList = actual.get(key);
            assertEquals(expectedList.size(), actualList.size(), "List sizes for key " + key + " do not match");
            for (int i = 0; i < actualList.size(); i++) {
                Objects.equals(actualList.get(i),expectedList.get(i));
            }
        }

    }
    /*
     * Test for a house with no devices.
     * The expected result is an empty map.
     */
    @Test
    void houseWithNoDevices_ShouldReturnEmptyMap() throws InstantiationException {
        //Arrange
        FactorySensorType factorySensorType = new FactorySensorType();
        Catalogue catalogue = new Catalogue("config.properties",factorySensorType);
        catalogue.addSensorType("Humidity", Unit.Percentage);
        catalogue.addSensorType("Temperature", Unit.Celsius);
        House myHouse = new House("123", "street", 90.0, 30.0);
        //Act
        US09GetDevicesByTypeController us09GetDevicesByTypeController = new US09GetDevicesByTypeController(myHouse,catalogue);
        HashMap<String, List<DeviceDTO>> actual = us09GetDevicesByTypeController.getDevicesByType();
        //Assert
        assertTrue(actual.isEmpty());
    }
    /*
     * Test for a house that does not exist.
     * The expected result is an exception.
     */
    @Test
    void nullHouse_shouldThrowIllegalArgumentException() throws IllegalArgumentException, InstantiationException {
        //Arrange
        String expectedMessage = "Invalid arguments";
        FactorySensorType factorySensorType = new FactorySensorType();
        Catalogue catalogue = new Catalogue("config.properties",factorySensorType);
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new US09GetDevicesByTypeController(null,catalogue));
        String actualMessage = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, actualMessage);
    }
    /**
     * This test checks if an exception is thrown in the event of trying to construct a controller object with a null catalogue
     * The expected result is an exception.
     */
    @Test
    void nullCatalogue_shouldThrowIllegalArgumentException() throws IllegalArgumentException, InstantiationException {
        //Arrange
        String expectedMessage = "Invalid arguments";
        House myHouse = new House("123", "street", 90.0, 30.0);

        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new US09GetDevicesByTypeController(myHouse,null));
        String actualMessage = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, actualMessage);
    }

}