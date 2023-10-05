package com.company;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Personal extends Recipient {
    private String NickName;
    public LocalDate Birthday;

    public Personal(String Name, String NickName , String Email, String Birthday){
        super(Name,Email);

        DateTimeFormatter fomatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        this.Birthday = LocalDate.parse(Birthday,fomatter);
        this.NickName = NickName;
    }
    public String getNickName(){
        return NickName;
    }

    public LocalDate getBirthday(){
        return Birthday;
    }

}
