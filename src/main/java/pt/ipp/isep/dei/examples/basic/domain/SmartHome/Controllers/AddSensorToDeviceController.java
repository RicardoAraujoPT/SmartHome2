package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.DeviceDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.*;

import java.util.List;


public class AddSensorToDeviceController {

    private House _house;
    private Catalogue _catalogue;

    public AddSensorToDeviceController(House house, Catalogue catalogue) throws InstantiationException {
        if (!isValidConstructorArguments(house, catalogue))
            throw (new InstantiationException("Invalid arguments"));
        _house = house;
        _catalogue = catalogue;

    }

    private boolean isValidConstructorArguments(House house, Catalogue catalogue) {
        return house != null && catalogue != null;
    }


    public List<String> getSensorsModels() {
        return _catalogue.getSensorModels();
    }


    public Sensor addSensorToDevice(DeviceDTO deviceDTO, String strSensorModel) {

        Room room = _house.getRoomByName(deviceDTO.getRoomName());

        Device device =room.getDeviceByName(deviceDTO.getDeviceName());

        Sensor sensor = device.addSensor(strSensorModel, this._catalogue);

        return sensor;
    }

}
