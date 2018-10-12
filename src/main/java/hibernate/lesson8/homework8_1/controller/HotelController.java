package hibernate.lesson8.homework8_1.controller;

import hibernate.lesson8.homework8_1.dao.Session;
import hibernate.lesson8.homework8_1.exception.InternalServerError;
import hibernate.lesson8.homework8_1.model.Hotel;
import hibernate.lesson8.homework8_1.model.types.UserType;
import hibernate.lesson8.homework8_1.service.HotelService;

import java.util.Set;

public class HotelController {
    private HotelService hotelService;

    public HotelController() throws InternalServerError {
        hotelService = new HotelService();
    }

    //ADMIN
    public Hotel addHotel(Hotel hotel) throws InternalServerError {
        Session.checkAuthorization("addHotel", UserType.ADMIN);
        return hotelService.addHotel(hotel);
    }

    //ADMIN
    public void deleteHotel(long hotelId) throws InternalServerError {
        Session.checkAuthorization("deleteHotel", UserType.ADMIN);
        hotelService.deleteHotel(hotelId);
    }

    public Set<Hotel> findHotelByName(String name) throws InternalServerError {
        Session.checkAuthorization("findHotelByName");
        return hotelService.findHotelByName(name);
    }

    public Set<Hotel> findHotelByCity(String name) throws InternalServerError {
        Session.checkAuthorization("findHotelByCity");
        return hotelService.findHotelByCity(name);
    }

}