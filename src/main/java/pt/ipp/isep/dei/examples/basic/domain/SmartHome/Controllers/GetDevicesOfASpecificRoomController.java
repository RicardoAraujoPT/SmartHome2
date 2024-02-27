package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Controllers;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Device;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.House;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Room;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.DeviceDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.RoomDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Mappers.DeviceDTOMapper;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Mappers.RoomDTOMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetDevicesOfASpecificRoomController {
    private DeviceDTOMapper deviceDTOMapper;
    private RoomDTOMapper RoomDTOMapper;
    private House _house;

    public GetDevicesOfASpecificRoomController(DeviceDTOMapper deviceDTOMapper, RoomDTOMapper roomDTOMapper, House house) {
        this.deviceDTOMapper = deviceDTOMapper;
        this.RoomDTOMapper = roomDTOMapper;
        this._house = house;
    }

    public List<DeviceDTO> getDevicesOfASpecificRoom(RoomDTO roomDTO) throws InstantiationException {

        if (roomDTO == null) {
            throw new InstantiationException("RoomDTO cannot be null");
        }

        List<Room> rooms = _house.getRoomList();
        Map<RoomDTO, Room> roomsDTOAndRooms = RoomDTOMapper.roomMap_DTOAndDomain(rooms);
        Room room = roomsDTOAndRooms.get(roomDTO);

        if (room == null) {
            return new ArrayList<>();
        }

        //Como estava antes:
        //    Room room = RoomDTOMapper.room_DTOToDomain(roomDTO);
            List<Device> devices = room.getDevices();
            List<DeviceDTO> deviceDTOs = new ArrayList<>();
            for (Device device : devices) {
                DeviceDTO deviceDTO = DeviceDTOMapper.DeviceToDTO(device);
                deviceDTOs.add(deviceDTO);
            }
            return deviceDTOs;
        }

    public DeviceDTOMapper getDeviceDTOMapper() {
        return deviceDTOMapper;
    }

}

