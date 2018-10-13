package hibernate.lesson8.homework8_1.model;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.List;

@Entity
@Table(name = "FP_HOTEL")
public class Hotel implements GeneralModel {
    @Id
    @SequenceGenerator(name = "HOTEL_SEQ", sequenceName = "FP_HOTEL_PK_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HOTEL_SEQ")
    @Column(name = "ID")
    private long id;
    @Column(name = "HOTEL_NAME")
    private String name;
    @Column(name = "HOTEL_COUNTRY")
    private String country;
    @Column(name = "HOTEL_CITY")
    private String city;
    @Column(name = "HOTEL_STREET")
    private String street;
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "hotel", fetch = FetchType.EAGER)
    private List<Room> rooms;

    @Override
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}