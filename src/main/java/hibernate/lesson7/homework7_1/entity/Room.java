package hibernate.lesson7.homework7_1.entity;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "ROOM")
public class Room {
    private long id;
    private int numberOfGuests;
    private double price;
    private boolean breakfastIncluded;
    private boolean petsAllowed;
    private Date dateAvailableFrom;
    private Hotel hotel;

    @Id
    @SequenceGenerator(name = "ROOM_SEQ", sequenceName = "ROOM_PK_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROOM_SEQ")
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    @Column(name = "NUMBER_OF_GUESTS")
    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    @Column(name = "PRICE")
    public double getPrice() {
        return price;
    }

    @Column(name = "BREAKFAST_INCLUDED")
    public boolean isBreakfastIncluded() {
        return breakfastIncluded;
    }

    @Column(name = "PETS_ALLOWED")
    public boolean isPetsAllowed() {
        return petsAllowed;
    }

    @Column(name = "DATE_AVALIABLE_FROM")
    public Date getDateAvailableFrom() {
        return dateAvailableFrom;
    }

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "HOTEL_ID", referencedColumnName = "ID")
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

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", numberOfGuests=" + numberOfGuests +
                ", price=" + price +
                ", breakfastIncluded=" + breakfastIncluded +
                ", petsAllowed=" + petsAllowed +
                ", dateAvailableFrom=" + dateAvailableFrom +
                ", hotel=" + hotel +
                '}';
    }
}