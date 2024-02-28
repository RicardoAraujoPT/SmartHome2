package pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO;

public class AddSensorToDeviceDTO {

    public String _deviceName;
    public String _roomName;
    public String _strSensorModel;

    public AddSensorToDeviceDTO(String deviceName, String roomName, String strSensorModel) {
        _deviceName = deviceName;
        _roomName = roomName;
        _strSensorModel = strSensorModel;
    }
}
