package hibernate.lesson8.homework8_1.model;

import hibernate.lesson8.homework8_1.dao.RoomDAO;
import hibernate.lesson8.homework8_1.dao.UserDAO;
import hibernate.lesson8.homework8_1.exception.InternalServerError;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@javax.persistence.Entity
@Table(name = "FP_ORDER")
public class Order implements GeneralModel {
    @Id
    @SequenceGenerator(name = "ORDER_SEQ", sequenceName = "FP_ORDER_PK_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_SEQ")
    @Column(name = "ID")
    private long id;
    @ManyToOne
    @JoinColumn(name="USER_ID", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name="ROOM_ID", nullable = false)
    private Room room;
    @Column(name = "DATE_FROM")
    private Date dateFrom;
    @Column(name = "DATE_TO")
    private Date dateTo;
    @Column(name = "MONEY_PAID")
    private double moneyPaid;

    @Override
    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Room getRoom() {
        return room;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public double getMoneyPaid() {
        return moneyPaid;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public void setMoneyPaid(double moneyPaid) {
        this.moneyPaid = moneyPaid;
    }
}