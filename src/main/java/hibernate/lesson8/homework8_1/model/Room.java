package hibernate.lesson8.homework8_1.model;

import hibernate.lesson8.homework8_1.dao.HotelDAO;
import hibernate.lesson8.homework8_1.exception.InternalServerError;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Room extends Entity {
    private int numberOfGuests;
    private double price;
    private boolean breakfastIncluded;
    private boolean petsAllowed;
    private Date dateAvailableFrom;
    private Hotel hotel;

    public Room(){}

    public void setDateAvailableFrom(Date dateAvailableFrom) {
        this.dateAvailableFrom = dateAvailableFrom;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public double getPrice() {
        return price;
    }

    public boolean isBreakfastIncluded() {
        return breakfastIncluded;
    }

    public boolean isPetsAllowed() {
        return petsAllowed;
    }

    public Date getDateAvailableFrom() {
        return dateAvailableFrom;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBreakfastIncluded(boolean breakfastIncluded) {
        this.breakfastIncluded = breakfastIncluded;
    }

    public void setPetsAllowed(boolean petsAllowed) {
        this.petsAllowed = petsAllowed;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return
                (getId() == 0 ? "" : getId()+",")+
                        numberOfGuests+","+
                        price+","+
                        breakfastIncluded+","+
                        petsAllowed+","+
                        new SimpleDateFormat("dd-MM-yyyy").format(dateAvailableFrom)+","+
                        hotel.getId();
    }

    @Override
    public Room parseStringToObject(String input) throws InternalServerError {
        String[] data = input.split(",");
        try {
            setId(Long.valueOf(data[0]));
            numberOfGuests = Integer.valueOf(data[1]);
            price = Double.valueOf(data[2]);
            breakfastIncluded = Boolean.valueOf(data[3]);
            petsAllowed = Boolean.valueOf(data[4]);
            dateAvailableFrom = new SimpleDateFormat("dd-MM-yyyy").parse(data[5]);
            hotel = new HotelDAO().getEntityById(Long.valueOf(data[6]));
            return this;
        }catch (Exception e){
            throw new InternalServerError(getClass().getName(), "parseStringToObject","error parsing text data ["+input+"]", e.getMessage());
        }
    }
}