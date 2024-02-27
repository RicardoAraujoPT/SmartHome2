package pt.ipp.isep.dei.examples.basic.domain.ControllerTest;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers.US09GetDevicesByTypeController;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.DeviceDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class US09GetDevicesByTypeControllerTest {
    @Test
    void successfully_ShouldReturnDevicesGroupedByType() throws InstantiationException {
        //Arrange
        Catalogue catalogue = new Catalogue("config.properties");
        catalogue.addSensorType("Humidity", Unit.Percentage);
        catalogue.addSensorType("Temperature", Unit.Celsius);
        House myHouse = new House("123", "street", 90.0, 30.0);


        for (int i = 0; i < 2; i++) { // Adding 2 room
            myHouse.createRoom("r" + i, 0, 25, 10);
            if (i == 0) { //Choosing r0
                // Adding 5 devices to r0
                for (int j = 0; j < 5; j++) {

                    myHouse.getRoomList().get(i).createDevice("d" + j);
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
                    myHouse.getRoomList().get(i).createDevice("d" + j);
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
    @Test
    void houseWithNoDevices_ShouldReturnEmptyMap() throws InstantiationException {
        //Arrange
        Catalogue catalogue = new Catalogue("config.properties");
        catalogue.addSensorType("Humidity", Unit.Percentage);
        catalogue.addSensorType("Temperature", Unit.Celsius);
        House myHouse = new House("123", "street", 90.0, 30.0);
        //Act
        US09GetDevicesByTypeController us09GetDevicesByTypeController = new US09GetDevicesByTypeController(myHouse,catalogue);
        HashMap<String, List<DeviceDTO>> actual = us09GetDevicesByTypeController.getDevicesByType();
        //Assert
        assertTrue(actual.isEmpty());


    }

    @Test
    void nullHouse_shouldThrowIllegalArgumentException() throws IllegalArgumentException, InstantiationException {
        //Arrange
        String expectedMessage = "Invalid arguments";
        Catalogue catalogue = new Catalogue("config.properties");
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new US09GetDevicesByTypeController(null,catalogue));
        String actualMessage = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, actualMessage);
    }
    @Test
    void nullCatalogue_shouldThrowIllegalArgumentException() throws IllegalArgumentException {
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