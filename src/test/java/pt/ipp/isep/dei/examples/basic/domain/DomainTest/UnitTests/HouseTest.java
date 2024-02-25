package pt.ipp.isep.dei.examples.basic.domain.DomainTest.UnitTests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.House;
import pt.ipp.isep.dei.examples.basic.domain.SmartHome.Domain.Room;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HouseTest {

        @Test
        public void shouldCreateValidHouse() {
            //arrange
            House myHouse = new House("address","zipcode",55,105);
            //act
            String houseAddress = myHouse.getLocation().getAddress();
            double houseLatitude = myHouse.getLocation().getGpsCoordinates().getLatitude();
            double houseLongitude = myHouse.getLocation().getGpsCoordinates().getLongitude();
            String houseZipCode = myHouse.getLocation().getZipCode();
            //assert
            assertEquals("address", houseAddress);
            assertEquals("zipcode", houseZipCode);
            assertEquals(55, houseLatitude);
            assertEquals(105, houseLongitude);
        }

        @Test
        @Disabled
        public void createHouseWithInvalidAddress() {

            //arrange
            String expected = "Invalid ZIP code or address";
            String houseZipCode = "zipCode";
            double houseLatitude = 55;
            double houseLongitude = 100;
            //act
            Exception exception = assertThrows(
                    IllegalArgumentException.class, ()
                            -> new House(null,houseZipCode,houseLatitude,houseLongitude));
            //assert
            String actualMessage = exception.getMessage();
            assertTrue(actualMessage.contains(expected));
        }

        @Test
        @Disabled
        public void createHouseWithInvalidZipCode() {

            //arrange
            String expected = "Invalid ZIP code or address";
            String houseAddress = "address";
            double houseLatitude = 55;
            double houseLongitude = 100;
            //act
            Exception exception = assertThrows(
                    IllegalArgumentException.class, ()
                            -> new House(houseAddress,null,houseLatitude,houseLongitude));
            //assert
            String actualMessage = exception.getMessage();
            assertTrue(actualMessage.contains(expected));
        }


        @Test
        public void createHouseWithInvalidLatitude() {

            //arrange
            String expected = "Invalid GPS coordinates";
            String houseAddress = "address";
            String houseZipCode = "zipCode";
            double houseLongitude = 100;
            //act
            Exception exception = assertThrows(
                    IllegalArgumentException.class, ()
                            -> new House(houseAddress,houseZipCode,-180,houseLongitude));
            //assert
            String actualMessage = exception.getMessage();
            assertTrue(actualMessage.contains(expected));
        }


        @Test
        public void createHouseWithInvalidLongitude() {

            //arrange
            String expected = "Invalid GPS coordinates";
            String houseAddress = "address";
            String houseZipCode = "zipCode";
            double houseLatitude = 55;
            //act
            Exception exception = assertThrows(
                    IllegalArgumentException.class, ()
                            -> new House(houseAddress,houseZipCode,houseLatitude,300));
            //assert
            String actualMessage = exception.getMessage();
            assertTrue(actualMessage.contains(expected));
        }

    @Test
    void HouseWithoutRooms() {

        //arrange
        House myHouse = new House("address","zipcode",55,105);
        // act
        List<Room> listRooms = myHouse.getRoomList();
        // assert
        assertEquals(listRooms.size(), 0);
        }

    @Test
    public void create1ValidRoom() throws InstantiationException {

        //arrange
        House myHouse = new House("address","zipcode",55,105);
        // act
        myHouse.createRoom("bedroom",1,2,3);
        int roomListSize = myHouse.getRoomList().size();
        // assert
        assertEquals(1,roomListSize);
    }

        @Test
        public void create2ValidRooms() throws InstantiationException {

        //arrange
        House myHouse = new House("address","zipcode",55,105);
        // act
        myHouse.createRoom("bedroom",1,2,3);
        myHouse.createRoom("bathroom",1,2,3);
        int roomListSize = myHouse.getRoomList().size();
        // assert
        assertEquals(2,roomListSize);
        }

        @Test
        public void createInvalidRoom() {

            //arrange
            String expected = "Invalid arguments";
            House myHouse = new House("address","zipcode",55,105);
            int floorNumber = 1;
            double roomArea = 25;
            double roomHeight = 2.5;
            //act
            Exception exception = assertThrows(InstantiationException.class, ()
                            -> { myHouse.createRoom(null,floorNumber,roomArea,roomHeight);
            });
            //assert
            String actualMessage = exception.getMessage();
            assertTrue(actualMessage.contains(expected));
        }

        @Test
        public void testGetRoomByName() throws InstantiationException {

            //arrange
            House myHouse = new House("address","zipcode",55,105);

            //act
            myHouse.createRoom("bedroom",1,2,3);
            myHouse.createRoom("bathroom",1,2,3);
            String expected = myHouse.getRoomList().get(0).getRoomName();
            String result = myHouse.getRoomByName("bedroom").getRoomName();

            //assert
            assertEquals(expected,result);

        }

        @Test
        public void getInexistentRoom() throws InstantiationException {

            //arrange
            String expected = "Room name doesn't exist in the list";
            House myHouse = new House("address","zipcode",55,105);

            //act
            myHouse.createRoom("bedroom",1,2,3);
            myHouse.createRoom("bathroom",1,2,3);
            Exception exception =
                    assertThrows(IllegalArgumentException.class, ()
                            -> { myHouse.getRoomByName("living room");
            });
            //assert
            String actualMessage = exception.getMessage();
            assertTrue(actualMessage.contains(expected));

        }



        @Test
        public void getInvalidRoom() throws InstantiationException {

            //arrange
            String expected = "Room name doesn't exist in the list";
            House myHouse = new House("address","zipcode",55,105);

            //act
            myHouse.createRoom("bedroom",1,2,3);
            myHouse.createRoom("bathroom",1,2,3);
            Exception exception =
                    assertThrows(IllegalArgumentException.class, ()
                            -> { myHouse.getRoomByName(null);
                    });
            //assert
            String actualMessage = exception.getMessage();
            assertTrue(actualMessage.contains(expected));


        }




}
