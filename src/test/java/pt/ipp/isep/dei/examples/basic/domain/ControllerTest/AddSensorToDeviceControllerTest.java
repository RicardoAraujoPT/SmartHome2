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
    void GetEmptySensorModels() throws InstantiationException {
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
    void GetNonEmptySensorModels() throws InstantiationException {
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
    void AddInexistingSensorModelToDevice() throws InstantiationException {
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
    void AddExistingSensorModelToDevice() throws InstantiationException {
        // arrange
        Configuration config = new PropertyListConfiguration();
        config.addProperty("sensor", "pt.ipp.isep.dei.examples.basic.domain.SmartHome.Sensors.GA100K");
        Catalogue catalogue = new Catalogue( config );
        catalogue.addSensorType("Temperature", Unit.Celsius);

        House myHouse = new House("address","zipcode",55,105);
        Room livingRoom = myHouse.createRoom( "Living Room", 0, 10, 10);
        Device device = livingRoom.createDevice("device1");
        DeviceDTO deviceDTO= new DeviceDTO("device1","","Living Room");

        AddSensorToDeviceController controller = new AddSensorToDeviceController( myHouse, catalogue );

        // act
        Sensor sensor = controller.addSensorToDevice(deviceDTO, "pt.ipp.isep.dei.examples.basic.domain.SmartHome.Sensors.GA100K" );

        // assert
        assertNotNull( sensor );
    }






}
