package hibernate.lesson8.test;

import hibernate.lesson8.test.dao.HotelDAO;
import hibernate.lesson8.test.dao.RoomDAO;

public class Demo {
    public static void main(String[] args) throws Exception{
        HotelDAO hotelDAO = new HotelDAO();
        RoomDAO roomDAO = new RoomDAO();

        System.out.println(hotelDAO.findById(2));
        System.out.println(roomDAO.findById(1));

//        Hotel hotel = new Hotel();
//            hotel.setName("O_hotel");
//            hotel.setCountry("UA");
//            hotel.setCity("Odessa");
//            hotel.setStreet("Unnamed1");
//
//        hotelDAO.save(hotel);

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
