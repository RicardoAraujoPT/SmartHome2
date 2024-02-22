package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Mappers;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.DeviceDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.RoomDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Device;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Room;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeviceDTOMapper {

    // Converts a DeviceDTO to a Device
    public static Device DTOToDevice(DeviceDTO deviceDTO) throws InstantiationException {
        return new Device(deviceDTO.getDeviceName());
    }

    // Converts a RoomDTO to a Room
    public static DeviceDTO DeviceToDTO(Device device) {
        return new DeviceDTO(device.getDeviceName(), device.getDeviceID());
    }

    public Map<DeviceDTO, Device> DeviceMap_DTOAndDomain(List<Device> devices) {

        Map<DeviceDTO, Device> devicesDTOAndDevices = new HashMap<>();

        devices.forEach(device -> {
            DeviceDTO deviceDTO = DeviceDTOMapper.DeviceToDTO(device);
            devicesDTOAndDevices.put(deviceDTO, device);
        });

        return devicesDTOAndDevices;
    }
}
