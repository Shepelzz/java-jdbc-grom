package hibernate.lesson8.homework8_1.controller;

import hibernate.lesson8.homework8_1.dao.UserSession;
import hibernate.lesson8.homework8_1.exception.InternalServerError;
import hibernate.lesson8.homework8_1.service.OrderService;

public class OrderController {
    private OrderService orderService;

    public OrderController() throws InternalServerError {
        orderService = new OrderService();
    }

    public void bookRoom(long roomId, long userId, double moneyPaid) throws InternalServerError {
        UserSession.checkAuthorization("bookRoom");
        orderService.bookRoom(roomId, userId, moneyPaid);
    }

    public void cancelReservation(long roomId, long userId) throws InternalServerError {
        UserSession.checkAuthorization("cancelReservation");
        orderService.cancelReservation(roomId, userId);
    }
}
