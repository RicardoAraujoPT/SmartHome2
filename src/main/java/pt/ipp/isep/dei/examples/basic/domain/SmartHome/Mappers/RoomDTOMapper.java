package pt.ipp.isep.dei.examples.basic.domain.SmartHome.Mappers;

import java.util.ArrayList;

public class RoomDTOMapper {

        // Converts a RoomDTO to a Room
        public static Room DTOToRoom(RoomDTO roomDTO) {
            return new Room(roomDTO.getName(), roomDTO.getHouseFloor(), roomDTO.getArea(), roomDTO.getHeight());
        }

        // Converts a RoomDTO to a Room
        public static RoomDTO RoomToDTO(Room room) {
            return new RoomDTO(room.getName(), room.getHouseFloor(), room.getArea(), room.getHeight());
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

}
