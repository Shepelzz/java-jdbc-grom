package hibernate.lesson7.homework7_1;

import hibernate.lesson7.homework7_1.dao.HotelDAO;
import hibernate.lesson7.homework7_1.dao.RoomDAO;
import hibernate.lesson7.homework7_1.entity.Hotel;
import hibernate.lesson7.homework7_1.entity.Room;

import java.util.Date;

public class Demo {
    public static void main(String[] args) throws Exception{
        HotelDAO hotelDAO = new HotelDAO();
        RoomDAO roomDAO = new RoomDAO();

        Hotel hotel = new Hotel();
            hotel.setName("test_hotel");
            hotel.setCountry("UA");
            hotel.setCity("Kiev");
            hotel.setStreet("Unnamed");

        //hotelDAO.save(hotel);

        Room room = new Room();
            room.setBreakfastIncluded(true);
            room.setDateAvailableFrom(new Date());
            room.setNumberOfGuests(2);
            room.setPetsAllowed(false);
            room.setPrice(120);
            room.setHotel(hotelDAO.findById(2));

        roomDAO.save(room);
    }
}
