package app.Entity;

import java.io.Serializable;

/**
 * Created by hasee on 2017/12/26.
 */
public class UserForFeign implements Serializable{

    private String name;
    private int age;

    public UserForFeign(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public UserForFeign() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
