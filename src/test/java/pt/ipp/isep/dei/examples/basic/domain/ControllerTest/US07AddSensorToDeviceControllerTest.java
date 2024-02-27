package pt.ipp.isep.dei.examples.basic.domain.ControllerTest;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.DeviceDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.*;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers.US07AddSensorToDeviceController;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.plist.PropertyListConfiguration;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains tests for the AddSensorToDeviceController class.
 * It tests the behavior of the controller when interacting with a catalogue of sensors and a house.
 */

public class US07AddSensorToDeviceControllerTest {


    @Test
    void emptyCatalogue_shouldReturnEmptySensorModels() throws InstantiationException {
        // arrange
        Configuration config = new PropertyListConfiguration();
        Catalogue catalogue = new Catalogue( config );
        House myHouse = new House("address","zipcode",55,105);

        US07AddSensorToDeviceController controller = new US07AddSensorToDeviceController( myHouse, catalogue );

        // act
        List<String> sensorModels = controller.getSensorsModels();

        // assert
        assertEquals( sensorModels.size(), 0);
    }

    /**
     * This test checks if the getSensorsModels method returns a list with two sensor models when the catalogue contains two sensors.
     * @throws InstantiationException if the AddSensorToDeviceController cannot be instantiated.
     */
    @Test
    void catalogueWithTwoSensors_shouldReturnTwoSensorModels() throws InstantiationException {
        // arrange
        Configuration config = new PropertyListConfiguration();
        config.addProperty("sensor", "SmartHome.sensors.GA100K");
        config.addProperty("sensor", "SmartHome.sensors.TSY01");
        Catalogue catalogue = new Catalogue( config );
        House myHouse = new House("address","zipcode",55,105);

        US07AddSensorToDeviceController controller = new US07AddSensorToDeviceController( myHouse, catalogue );

        // act
        List<String> sensorModels = controller.getSensorsModels();

        // assert
        assertEquals( sensorModels.size(), 2);
    }

    /**
     * This test checks if the addSensorToDevice method returns null when the sensor model does not exist in the catalogue.
     * @throws InstantiationException if the AddSensorToDeviceController cannot be instantiated.
     */
    @Test
    void inexistingSensorModel_ShouldReturnNull() throws InstantiationException {
        // arrange
        Configuration config = new PropertyListConfiguration();
        Catalogue catalogue = new Catalogue( config );
        House myHouse = new House("address","zipcode",55,105);
        Room livingRoom = myHouse.createRoom( "Living Room", 0, 10, 10);
        Device device = livingRoom.createDevice("device1");
        DeviceDTO deviceDTO= new DeviceDTO("device1","","Living Room");

        US07AddSensorToDeviceController controller = new US07AddSensorToDeviceController( myHouse, catalogue );

        // act
        Sensor sensor = controller.addSensorToDevice(deviceDTO, "Sensors.GA100K" );

        // assert
        assertNull( sensor );
    }

    /**
     * TThis test checks if the addSensorToDevice method returns a sensor with the correct type when the sensor model
     * exists in the catalogue.
     * It asserts that the returned sensor is not null and that its type matches the type added to the catalogue
     * @throws InstantiationException if the AddSensorToDeviceController cannot be instantiated.
     */

    @Test
    void existingSensorModel_shouldReturnSensorWithCorrectType() throws InstantiationException {
        // arrange
        Configuration config = new PropertyListConfiguration();
        config.addProperty("sensor", "Sensors.GA100K");
        Catalogue catalogue = new Catalogue( config );
        SensorType sensorType = catalogue.addSensorType("Temperature", Unit.Celsius);

        House myHouse = new House("address","zipcode",55,105);
        Room livingRoom = myHouse.createRoom( "Living Room", 0, 10, 10);
        Device device = livingRoom.createDevice("device1");
        DeviceDTO deviceDTO= new DeviceDTO("device1","","Living Room");

        US07AddSensorToDeviceController controller = new US07AddSensorToDeviceController( myHouse, catalogue );

        // act
        Sensor sensor = controller.addSensorToDevice(deviceDTO, "Sensors.GA100K" );

        // assert
        assertNotNull( sensor );
        assertEquals(sensor.getSensorType(), sensorType);
    }






}
