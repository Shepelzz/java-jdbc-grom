package hibernate.lesson8.homework8_1.model;

import hibernate.lesson8.homework8_1.exception.InternalServerError;

public class Hotel extends Entity {
    private String name;
    private String country;
    private String city;
    private String street;

    public Hotel(){}

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
    public Hotel parseStringToObject(String input) throws InternalServerError {
        String[] data = input.split(",");
        try {
            setId(Long.valueOf(data[0]));
            name = data[1];
            country = data[2];
            city = data[3];
            street = data[4];
            return this;
        }catch (Exception e){
            throw new InternalServerError(getClass().getName(), "parseStringToObject","error parsing text data ["+input+"]", e.getMessage());
        }
    }

    @Override
    public String toString() {
        return
                (getId() == 0 ? "" : getId()+",")+
                        name+","+
                        country+","+
                        city+","+
                        street;
    }
}