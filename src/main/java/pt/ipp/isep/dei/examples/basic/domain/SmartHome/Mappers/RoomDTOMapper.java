package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Mappers;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.RoomDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.House;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomDTOMapper {
    private Map<RoomDTO, Room> _roomsDTOAndRooms = new HashMap<>();
    /**
     * The house object that this mapper is associated with.
     */
    private House _house;

    /**
     * GetRoomsMapper constructor with parameter house.
     *
     * @param house The house object that this mapper is associated with.
     */
    public RoomDTOMapper(House house) {
        this._house = house;
    }

    // Converts a RoomDTO to a Room
    public static Room room_DTOToDomain(RoomDTO roomDTO) throws InstantiationException {
        return new Room(roomDTO.getName(), roomDTO.getHouseFloor(), roomDTO.getArea(), roomDTO.getHeight());
    }

    // Converts a RoomDTO to a Room
    public static RoomDTO room_DomainToDTO(Room room) {
        return new RoomDTO(room.getRoomName(), room.getFloorNumber(), room.getArea(), room.getHeight());
    }

    /**
     * It converts each room object in the arraylist of rooms into DTO.
     *
     * @param listOfRoomsInHouse
     * @return ArrayList<RoomDTO>
     */
    public static ArrayList<RoomDTO> convertDomainToDTO(ArrayList<Room> listOfRoomsInHouse) {

        ArrayList<RoomDTO> listOfRoomsInHouseDTO = new ArrayList<>();

        for (int i = 0; i < listOfRoomsInHouse.size(); i++) {
            Room currentRoom = listOfRoomsInHouse.get(i);
            RoomDTO currentRoomDTO = room_DomainToDTO(currentRoom);
            listOfRoomsInHouseDTO.add(currentRoomDTO);
        }
        return listOfRoomsInHouseDTO;
    }

    public Map<RoomDTO, Room> RoomMap_DTOAndDomain(List<Room> rooms) {

        Map<RoomDTO, Room> roomsDTOAndRooms = new HashMap<>();

        rooms.forEach(room -> {
            RoomDTO roomDTO = RoomDTOMapper.room_DomainToDTO(room);
            roomsDTOAndRooms.put(roomDTO, room);
        });

        return roomsDTOAndRooms;
    }

}


