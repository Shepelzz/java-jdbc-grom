package hibernate.lesson8.homework8_1.model;

import hibernate.lesson8.homework8_1.exception.InternalServerError;

public abstract class Entity{
    private long id;

    public Entity() {
        this.id = 0;
    }

    public long getId() {
        return id;
    }

    public Entity setId(long id) {
        this.id = id;
        return this;
    }

    public abstract Entity parseStringToObject(String input) throws InternalServerError;

}