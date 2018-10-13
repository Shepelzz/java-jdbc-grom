package hibernate.lesson8.homework8_1.model;

import hibernate.lesson8.homework8_1.model.types.UserType;

import javax.persistence.*;
import java.util.List;

@javax.persistence.Entity

@Table(name = "FP_USER")
public class User implements GeneralModel {
    @Id
    @SequenceGenerator(name = "USER_SEQ", sequenceName = "FP_USER_PK_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
    @Column(name = "ID")
    private long id;
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "COUNTRY")
    private String country;
    @ManyToOne
    @JoinColumn(name="USER_TYPE_ID", nullable = false)
    private UserType userType;
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
    private List<Order> orders;

    @Override
    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getCountry() {
        return country;
    }

    public UserType getUserType() {
        return userType;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}