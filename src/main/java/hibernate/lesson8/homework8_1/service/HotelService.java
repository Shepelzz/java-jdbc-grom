package hibernate.lesson8.homework8_1.service;

import hibernate.lesson8.homework8_1.dao.HotelDAO;
import hibernate.lesson8.homework8_1.exception.BadRequestException;
import hibernate.lesson8.homework8_1.exception.InternalServerError;
import hibernate.lesson8.homework8_1.model.Hotel;

import java.util.Set;

public class HotelService{
    private HotelDAO hotelDAO;

    public HotelService() throws InternalServerError {
        hotelDAO = new HotelDAO();
    }

    //ADMIN
    public Hotel addHotel(Hotel hotel) throws InternalServerError {
        if(hotel.getName().equals("") || hotel.getCountry().equals("") || hotel.getCity().equals("") || hotel.getStreet().equals(""))
            throw new BadRequestException("addHotel", "Values can not be empty");
        return hotelDAO.addHotel(hotel);
    }

    //ADMIN
    public void deleteHotel(long hotelId) throws InternalServerError {
        hotelDAO.deleteHotel(hotelId);
    }

    public Set<Hotel> findHotelByName(String name) throws InternalServerError {
        if(name.equals(""))
            throw new BadRequestException("findHotelByName", "Name can not be empty");

        return hotelDAO.findHotelByName(name);
    }

    public Set<Hotel> findHotelByCity(String name) throws InternalServerError {
        if(name.equals(""))
            throw new BadRequestException("findHotelByCity", "City can not be empty");

        return hotelDAO.findHotelByCity(name);
    }
}
