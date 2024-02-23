package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.DeviceDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.RoomDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Device;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Room;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Mappers.DeviceDTOMapper;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Mappers.RoomDTOMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for managing the list of devices in a room.
 */

public class ListOfDevicesController {

    /**
     * The room managed by this controller.
     */
    private Room _myRoom;

    /**
     * Constructs a new ListOfDevicesController with the specified room.
     * @param myRoom the room to be managed by this controller. It must not be null.
     * @throws IllegalArgumentException if the provided room is null.
     */

    public ListOfDevicesController(Room myRoom) {
        if (myRoom == null) {
            throw new IllegalArgumentException("Invalid room");
        }

        this._myRoom = myRoom;
    }

    /**
     * Returns a list of devices in the room managed by this controller.
     * @return a list of devices in the room.
     */
    public List<Device> getDeviceList() {
        return _myRoom.getDevices();
    }

    /**
     * Returns a list of DeviceDTOs representing the devices in the room managed by this controller.
     * @return a list of DeviceDTOs representing the devices in the room.
     */
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

