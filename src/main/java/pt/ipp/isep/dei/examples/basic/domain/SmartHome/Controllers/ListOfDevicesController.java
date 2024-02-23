package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.DeviceDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.RoomDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Device;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Room;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Mappers.DeviceDTOMapper;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Mappers.RoomDTOMapper;

import java.util.ArrayList;
import java.util.List;

public class ListOfDevicesController {
    private Room _myRoom;

    public ListOfDevicesController(Room myRoom) {
        if (myRoom == null) {
            throw new IllegalArgumentException("Invalid room");
        }

        this._myRoom = myRoom;
    }

    public List<Device> getDeviceList() {
        return _myRoom.getDevices();
    }

    public ArrayList<DeviceDTO> getDeviceDTOList() {
        List<Device> listOfDevicesInRoom = this._myRoom.getDevices();
        ArrayList<DeviceDTO> listOfDevicesInRoomDTO = new ArrayList<>();

        for (Device device : listOfDevicesInRoom) {
            DeviceDTO deviceDTO = DeviceDTOMapper.DeviceToDTO(device);
            listOfDevicesInRoomDTO.add(deviceDTO);
        }
        return listOfDevicesInRoomDTO;
    }

}

