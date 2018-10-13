package hibernate.lesson8.homework8_1.model;


import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@Table(name = "FP_ROOM")
public class Room implements GeneralModel {
    @Id
    @SequenceGenerator(name = "ROOM_SEQ", sequenceName = "FP_ROOM_PK_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROOM_SEQ")
    @Column(name = "ID")
    private long id;
    @Column(name = "NUMBER_OF_GUESTS")
    private int numberOfGuests;
    @Column(name = "PRICE")
    private double price;
    @Column(name = "BREAKFAST_INCLUDED")
    private boolean breakfastIncluded;
    @Column(name = "PETS_ALLOWED")
    private boolean petsAllowed;
    @Column(name = "DATE_AVAILABLE_FROM")
    private Date dateAvailableFrom;
    @ManyToOne
    @JoinColumn(name="HOTEL_ID", nullable = false)
    private Hotel hotel;

    @Override
    public long getId() {
        return id;
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

    public void setId(long id) {
        this.id = id;
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

    public void setDateAvailableFrom(Date dateAvailableFrom) {
        this.dateAvailableFrom = dateAvailableFrom;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}