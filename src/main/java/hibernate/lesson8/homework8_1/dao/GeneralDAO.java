package hibernate.lesson8.homework8_1.dao;

import hibernate.lesson8.homework8_1.exception.InternalServerError;
import hibernate.lesson8.homework8_1.model.Entity;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public abstract class GeneralDAO<T extends Entity>{
    private String path;

    public GeneralDAO(String path){
        this.path = path;
    }

    public abstract T parseStringToObject(String input) throws InternalServerError;

    public T getEntityById(long id) throws InternalServerError {
        for(T t : getAll())
            if(t.getId() == id)
                return t;
        return null;
    }

    public Set<T> getAll() throws InternalServerError {
        Set<T> result = new HashSet<>();
        try(BufferedReader br = new BufferedReader(getFileReader())){
            String line;
            while ((line = br.readLine()) != null)
                result.add(parseStringToObject(line));
        } catch (IOException e){
            throw new InternalServerError(getClass().getName(), "getAll","Reading from file "+path+" failed", e.getMessage());
        }
        return result;
    }

    T writeToFile(T t) throws InternalServerError {
        t.setId(ThreadLocalRandom.current().nextLong(Long.MAX_VALUE));
        try(BufferedReader br = new BufferedReader(getFileReader()); BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
            if(br.readLine() != null)
                bw.append("\r\n");
            bw.append(t.toString());
        } catch (IOException e){
            throw new InternalServerError(getClass().getName(), "writeToFile","Writing to file error: can`t save "+t.toString()+" to file "+path+" "+e.getMessage(), e.getMessage());
        }
        return t;
    }

    void deleteFromFileById(long id) throws InternalServerError {
        StringBuffer tempData = new StringBuffer();
        try(BufferedReader br = new BufferedReader(getFileReader())){
            String line;
            while((line = br.readLine()) != null) {
                if (!Long.valueOf(line.split(",")[0]).equals(id)) {
                    tempData.append(line);
                    tempData.append("\r\n");
                }
            }
            if(tempData.length()>=2)
                tempData.replace(tempData.length() - 2, tempData.length(), "");
        } catch (IOException e){
            throw new InternalServerError(getClass().getName(),"deleteFromFileById","Can`t delete from file "+path, e.getMessage());
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path), false))){
            bw.append(tempData);
        } catch (IOException e){
            throw new InternalServerError(getClass().getName(), "deleteFromFileById","Deleting from file "+path+" failed.", e.getMessage());
        }
    }

    void updateEntity(T newObject) throws InternalServerError {
        deleteFromFileById(newObject.getId());
        try(BufferedReader br = new BufferedReader(getFileReader()); BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
            if(br.readLine() != null)
                bw.append("\r\n");
            bw.append(newObject.toString());
        } catch (IOException e){
            throw new InternalServerError(getClass().getName(), "updateEntity","Can`t save "+newObject.toString()+" to file "+path, e.getMessage());
        }
    }

    private FileReader getFileReader() throws InternalServerError {
        try {
            return new FileReader(path);
        }catch (FileNotFoundException e){
            throw new InternalServerError(getClass().getName(), "getFileReader","File "+path+" does not exist", e.getMessage());
        }
    }
}
