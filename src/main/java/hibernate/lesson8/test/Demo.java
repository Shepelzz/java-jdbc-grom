package hibernate.lesson8.test;

import hibernate.lesson8.test.dao.HotelDAO;
import hibernate.lesson8.test.dao.RoomDAO;
import hibernate.lesson8.test.entity.Hotel;
import hibernate.lesson8.test.entity.Type;

public class Demo {
    public static void main(String[] args) throws Exception{
        HotelDAO hotelDAO = new HotelDAO();
        RoomDAO roomDAO = new RoomDAO();

//        System.out.println(hotelDAO.findById(3));
//        System.out.println(roomDAO.findById(1));

        Hotel hotel = new Hotel();
            hotel.setName("4_hotel");
            hotel.setCountry("UA");
            hotel.setCity("Lviv");
            hotel.setStreet("Errrr");
            hotel.setType(Type.ONE_STAR);
//
        hotelDAO.save(hotel);

//        Room room = new Room();
//            room.setBreakfastIncluded(true);
//            room.setDateAvailableFrom(new Date());
//            room.setNumberOfGuests(2);
//            room.setPetsAllowed(false);
//            room.setPrice(120);
//            room.setHotel(hotelDAO.findById(2));

        //roomDAO.save(room);
    }
}
