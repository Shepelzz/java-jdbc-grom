package hibernate.lesson7.homework7_1.entity;

import javax.persistence.*;

@Entity
@Table(name = "HOTEL")
public class Hotel {
    private long id;
    private String name;
    private String country;
    private String city;
    private String street;

    @Id
    @SequenceGenerator(name = "HOTEL_SEQ", sequenceName = "HOTEL_PK_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HOTEL_SEQ")
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    @Column(name = "HOTEL_NAME")
    public String getName() {
        return name;
    }

    @Column(name = "HOTEL_COUNTRY")
    public String getCountry() {
        return country;
    }

    @Column(name = "HOTEL_CITY")
    public String getCity() {
        return city;
    }

    @Column(name = "HOTEL_STREET")
    public String getStreet() {
        return street;
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

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}