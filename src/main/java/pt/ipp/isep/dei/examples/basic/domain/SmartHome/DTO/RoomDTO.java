package pt.ipp.isep.dei.examples.basic.domain.SmartHome.DTO;

public class RoomDTO {

        private String _name;
        private int _houseFloor;
        private double _area;
        private double _height;

        public RoomDTO(String name, int houseFloor, double area, double height) {
            this._name = name;
            this._houseFloor = houseFloor;
            this._area = area;
            this._height = height;
        }


        /** Method to get the room name.
         * @return the room name.
         */
        public String getName() {
            return _name;
        }

        /** Method to get the house floor of the room.
         * @return the house floor where the room is located.
         */

        public int getHouseFloor() {
            return _houseFloor;
        }

        /** Method to get the area of the room.
         * @return the area of the room
         */

        public double getArea() {
            return _area;
        }

        /** Method to get the height of the room.
         * @return the height of the room.
         */

        public double getHeight() {
            return _height;
        }

    }


