package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Mappers;

import pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO.RoomDTO;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Room;

import java.util.ArrayList;

public class RoomDTOMapper {

        // Converts a RoomDTO to a Room
        public static Room DTOToRoom(RoomDTO roomDTO) throws InstantiationException {
            return new Room(roomDTO.getName(), roomDTO.getHouseFloor(), roomDTO.getArea(), roomDTO.getHeight());
        }

        // Converts a RoomDTO to a Room
        public static RoomDTO RoomToDTO(Room room) {
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
                RoomDTO currentRoomDTO = RoomToDTO(currentRoom);
                listOfRoomsInHouseDTO.add(currentRoomDTO);
            }
            return listOfRoomsInHouseDTO;
        }


    }


