package org.bean;

/**
 * @author yjt
 * @create 2022-05-05-20:30
 */
public class Student {
    private Integer id;
    private String name;
    private String gender;
    private Integer age;
    private String phone;
    private String cla;

    public Student() {
    }

    public Student(Integer id, String name, String gender, Integer age, String phone, String cla) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.cla = cla;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCla() {
        return cla;
    }

    public void setCla(String cla) {
        this.cla = cla;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", cla='" + cla + '\'' +
                '}';
    }
}