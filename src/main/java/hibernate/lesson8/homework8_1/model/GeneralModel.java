package hibernate.lesson8.homework8_1.model;

public interface GeneralModel{

    long getId();

    static Class getClassType(){
        return GeneralModel.class.getComponentType();
    }
}