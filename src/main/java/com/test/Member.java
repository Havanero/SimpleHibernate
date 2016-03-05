package com.test;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Member implements Serializable {

    public Member() {}

    @Id
    @Column(name = "id", unique = true)
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="member_seq")
    @SequenceGenerator(name="member_seq", sequenceName="member_seq", allocationSize=1)
    Integer id;

    String name;
    String email;
    String phone_number;


    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "[" + getId()  + " "+ getName() + " " + getEmail() + " " + getPhone_number() + "]";
    }
}
