package hibernate.lesson8.homework8_1.controller;

import hibernate.lesson8.homework8_1.dao.UserSession;
import hibernate.lesson8.homework8_1.exception.InternalServerError;
import hibernate.lesson8.homework8_1.model.Hotel;
import hibernate.lesson8.homework8_1.model.types.UserType;
import hibernate.lesson8.homework8_1.service.HotelService;

import java.util.List;

public class HotelController {
    private HotelService hotelService;

    public HotelController() {
        hotelService = new HotelService();
    }

    //ADMIN
    public Hotel addHotel(Hotel hotel) throws InternalServerError {
        UserSession.checkAuthorization("addHotel", UserType.ADMIN);
        return hotelService.addHotel(hotel);
    }

    //ADMIN
    public void deleteHotel(Hotel hotel) throws InternalServerError {
        UserSession.checkAuthorization("deleteHotel", UserType.ADMIN);
        hotelService.deleteHotel(hotel);
    }

    public List<Hotel> findHotelByName(String name) throws InternalServerError {
        UserSession.checkAuthorization("findHotelByName");
        return hotelService.findHotelByName(name);
    }

    public List<Hotel> findHotelByCity(String name) throws InternalServerError {
        UserSession.checkAuthorization("findHotelByCity");
        return hotelService.findHotelByCity(name);
    }

}
