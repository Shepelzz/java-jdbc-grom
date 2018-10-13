package hibernate.lesson8.test.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "HOTEL")
public class Hotel {
    @Id
    @SequenceGenerator(name = "HOTEL_SEQ", sequenceName = "HOTEL_PK_SEQ", allocationSize = 1)
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
    @Enumerated(EnumType.ORDINAL)
    private Type type;
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "hotel", fetch = FetchType.EAGER)
    private List<Room> rooms;


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

    public Type getType() {
        return type;
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

    public void setType(Type type) {
        this.type = type;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", type=" + type.toString() +
                ", rooms=" + rooms.size() +
                '}';
    }
}