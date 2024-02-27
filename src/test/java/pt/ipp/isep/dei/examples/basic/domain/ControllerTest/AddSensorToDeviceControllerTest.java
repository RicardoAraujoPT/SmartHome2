package pt.ipp.isep.dei.examples.basic.domain.ControllerTest;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.DeviceDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.*;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers.AddSensorToDeviceController;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.plist.PropertyListConfiguration;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AddSensorToDeviceControllerTest {


    @Test
    void emptySensorModels_ShouldReturnZero() throws InstantiationException {
        // arrange
        Configuration config = new PropertyListConfiguration();
        Catalogue catalogue = new Catalogue( config );
        House myHouse = new House("address","zipcode",55,105);

        AddSensorToDeviceController controller = new AddSensorToDeviceController( myHouse, catalogue );

        // act
        List<String> sensorModels = controller.getSensorsModels();

        // assert
        assertEquals( sensorModels.size(), 0);
    }

    @Test
    void nonEmptySensorModels_ShouldReturnTwo() throws InstantiationException {
        // arrange
        Configuration config = new PropertyListConfiguration();
        config.addProperty("sensor", "SmartHome.sensors.GA100K");
        config.addProperty("sensor", "SmartHome.sensors.TSY01");
        Catalogue catalogue = new Catalogue( config );
        House myHouse = new House("address","zipcode",55,105);

        AddSensorToDeviceController controller = new AddSensorToDeviceController( myHouse, catalogue );

        // act
        List<String> sensorModels = controller.getSensorsModels();

        // assert
        assertEquals( sensorModels.size(), 2);
    }

    @Test
    void inexistingSensorModel_ShouldReturnNull() throws InstantiationException {
        // arrange
        Configuration config = new PropertyListConfiguration();
        Catalogue catalogue = new Catalogue( config );
        House myHouse = new House("address","zipcode",55,105);
        Room livingRoom = myHouse.createRoom( "Living Room", 0, 10, 10);
        Device device = livingRoom.createDevice("device1");
        DeviceDTO deviceDTO= new DeviceDTO("device1","","Living Room");

        AddSensorToDeviceController controller = new AddSensorToDeviceController( myHouse, catalogue );

        // act
        Sensor sensor = controller.addSensorToDevice(deviceDTO, "pt.ipp.isep.dei.examples.basic.domain.SmartHome.Sensors.GA100K" );

        // assert
        assertNull( sensor );
    }

    @Test
    void existingSensorModel_ShouldReturnSensor() throws InstantiationException {
        // arrange
        Configuration config = new PropertyListConfiguration();
        config.addProperty("sensor", "Sensors.GA100K");
        Catalogue catalogue = new Catalogue( config );
        SensorType sensorType = catalogue.addSensorType("Temperature", Unit.Celsius);

        House myHouse = new House("address","zipcode",55,105);
        Room livingRoom = myHouse.createRoom( "Living Room", 0, 10, 10);
        Device device = livingRoom.createDevice("device1");
        DeviceDTO deviceDTO= new DeviceDTO("device1","","Living Room");

        AddSensorToDeviceController controller = new AddSensorToDeviceController( myHouse, catalogue );

        // act
        Sensor sensor = controller.addSensorToDevice(deviceDTO, "Sensors.GA100K" );

        // assert
        assertNotNull( sensor );
        assertEquals(sensor.getSensorType(), sensorType);
    }






}
