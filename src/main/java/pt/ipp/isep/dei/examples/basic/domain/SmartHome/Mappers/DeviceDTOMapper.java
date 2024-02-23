package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Mappers;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.DeviceDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Device;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.House;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeviceDTOMapper {

    private House _house;
    private HashMap<DeviceDTO, Device> _mapDevicesDTO = new HashMap<>();

    public HashMap<DeviceDTO, Device> getMapDevicesDTO() {
        return new HashMap<>(_mapDevicesDTO);
    }

    public DeviceDTOMapper(House house) {
        this._house = house;
    }

    // Converts a DeviceDTO to a Device
    public static Device DTOToDevice(DeviceDTO deviceDTO) throws InstantiationException {
        return new Device(deviceDTO.getDeviceName());
    }

    // Converts a RoomDTO to a Room
    public static DeviceDTO DeviceToDTO(Device device) {
        return new DeviceDTO(device.getDeviceName(), device.getDeviceID());
    }

    //Converts a RoomDTO with name and status to a Room
    public static DeviceDTO DeviceToDTOWithStatus(Device device) {
        return new DeviceDTO(device.getDeviceName(), device.getDeviceIsActive());
    }

    public Map<DeviceDTO, Device> DeviceMap_DTOToDomain(List<Device> devices) {

        Map<DeviceDTO, Device> devicesDTOAndDevices = new HashMap<>();

        devices.forEach(device -> {
            DeviceDTO deviceDTO = DeviceDTOMapper.DeviceToDTO(device);
            devicesDTOAndDevices.put(deviceDTO, device);
        });

        return devicesDTOAndDevices;
    }
}
