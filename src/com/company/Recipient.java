package com.company;

import java.io.Serializable;

public abstract class Recipient implements Serializable {
    private String Name;
    private String Email;

    public Recipient(String Name, String Email){
        this.Email = Email;
        this.Name  = Name;
    }
    public String getName(){
        return Name;
    }
    public String getEmail(){
        return Email;
    }

}
