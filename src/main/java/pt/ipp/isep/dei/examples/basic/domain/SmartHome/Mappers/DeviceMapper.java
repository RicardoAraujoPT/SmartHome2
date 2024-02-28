package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Mappers;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.DeviceDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Device;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeviceMapper {

    // Converts a RoomDTO to a Room
    public static DeviceDTO DeviceToDTO(Device device) {
        return new DeviceDTO(device.getDeviceName(),null);
    }

    public static DeviceDTO device_DomainToDTOWithLocation(Device device,String roomName) {
        return new DeviceDTO(device.getDeviceName(),roomName);
    }
    public static List<DeviceDTO> devices_DomainToDTO(List<Device> devices) {
        List<DeviceDTO> devicesDTO = new ArrayList<>();
        for (Device device : devices) {
            devicesDTO.add(DeviceToDTO(device));
        }
        return devicesDTO;
    }

    //Converts a RoomDTO with name and status to a Room
    public static DeviceDTO DeviceToDTOWithStatus(Device device) {
        return new DeviceDTO(device.getDeviceName(), device.getDeviceIsActive());
    }

    public Map<DeviceDTO, Device> DeviceMap_DTOToDomain(List<Device> devices) {

        Map<DeviceDTO, Device> devicesDTOAndDevices = new HashMap<>();

        devices.forEach(device -> {
            DeviceDTO deviceDTO = DeviceToDTO(device);
            devicesDTOAndDevices.put(deviceDTO, device);
        });

        return devicesDTOAndDevices;
    }
    public static HashMap<String, List<DeviceDTO>> devicesMap_DomainToDTO(HashMap<String, HashMap<Room, List<Device>>> groupDevicesByType) {
        HashMap<String, List<DeviceDTO>> hashMapDTO =  new HashMap<>();
        for (HashMap.Entry<String, HashMap<Room, List<Device>>> SensorType : groupDevicesByType.entrySet()) {
            String functionality = SensorType.getKey();
            HashMap<Room, List<Device>> secondMapContent = SensorType.getValue();
            List<DeviceDTO> deviceDTOList = new ArrayList<>();
            for (HashMap.Entry<Room, List<Device>> Room : secondMapContent.entrySet()) {
                List<Device> devices = Room.getValue();
                for (Device device : devices) {
                    DeviceDTO deviceDTO = device_DomainToDTOWithLocation(device, Room.getKey().getRoomName());
                    deviceDTOList.add(deviceDTO);
                }
            }
            hashMapDTO.put(functionality, deviceDTOList);
        }
        return hashMapDTO;
    }
}
