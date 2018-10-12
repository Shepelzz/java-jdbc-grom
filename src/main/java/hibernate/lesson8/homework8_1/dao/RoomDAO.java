package hibernate.lesson8.homework8_1.dao;

import hibernate.lesson8.homework8_1.exception.InternalServerError;
import hibernate.lesson8.homework8_1.model.Filter;
import hibernate.lesson8.homework8_1.model.Room;

import java.util.Set;
import java.util.stream.Collectors;

public class RoomDAO extends GeneralDAO<Room>{
    private static final String path = "files/RoomDb.txt";

    public RoomDAO() throws InternalServerError {
        super(path);
    }

    //ADMIN
    public Room addRoom(Room room) throws InternalServerError {
        return writeToFile(room);
    }

    //ADMIN
    public void deleteRoom(long roomId) throws InternalServerError {
        deleteFromFileById(roomId);
    }

    public Set<Room> findRooms(Filter filter) throws InternalServerError {
        return getAll().stream()
                .filter(room -> (filter.getNumberOfGuests() == 0 || room.getNumberOfGuests() == filter.getNumberOfGuests()))
                .filter(room -> (filter.getPrice() == 0 || room.getPrice() <= filter.getPrice()))
                .filter(room -> room.isBreakfastIncluded() == filter.isBreakfastIncluded())
                .filter(room -> room.isPetsAllowed() == filter.isPetsAllowed())
                .filter(room -> room.getDateAvailableFrom().before(filter.getDateAvailableFrom()))
                .filter(room -> (filter.getName()== null || room.getHotel().getName().equals(filter.getName())))
                .filter(room -> (filter.getCountry()== null || room.getHotel().getCountry().equals(filter.getCountry())))
                .filter(room -> (filter.getCity()== null || room.getHotel().getCity().equals(filter.getCity())))
                .collect(Collectors.toSet());
    }

    @Override
    public Room parseStringToObject(String input) throws InternalServerError {
        return new Room().parseStringToObject(input);
    }
}