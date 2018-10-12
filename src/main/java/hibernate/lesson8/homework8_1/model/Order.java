package hibernate.lesson8.homework8_1.model;

import hibernate.lesson8.homework8_1.dao.RoomDAO;
import hibernate.lesson8.homework8_1.dao.UserDAO;
import hibernate.lesson8.homework8_1.exception.InternalServerError;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Order extends Entity {
    private User user;
    private Room room;
    private Date dateFrom;
    private Date dateTo;
    private double moneyPaid;

    public Order(){}

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

    @Override
    public Order parseStringToObject(String input) throws InternalServerError {
        String[] data = input.split(",");
        try {
            setId(Long.valueOf(data[0]));
            user = new UserDAO().getEntityById(Long.valueOf(data[1]));
            room = new RoomDAO().getEntityById(Long.valueOf(data[2]));
            dateFrom = new SimpleDateFormat("dd-MM-yyyy").parse(data[3]);
            dateTo = new SimpleDateFormat("dd-MM-yyyy").parse(data[4]);
            moneyPaid = Double.valueOf(data[5]);
            return this;
        }catch (Exception e){
            throw new InternalServerError(getClass().getName(), "parseStringToObject","error parsing text data ["+input+"]", e.getMessage());
        }
    }

    @Override
    public String toString() {
        return
                (getId() == 0 ? "" : getId()+",")+
                        user.getId()+","+
                        room.getId()+","+
                        new SimpleDateFormat("dd-MM-yyyy").format(dateFrom)+","+
                        new SimpleDateFormat("dd-MM-yyyy").format(dateTo)+","+
                        moneyPaid;
    }
}