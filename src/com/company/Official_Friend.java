package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Official_Friend extends Official {
    public LocalDate Birthday;

    public Official_Friend(String Name, String Email ,String designation , String Birthday){
        super(Name, Email, designation);
        DateTimeFormatter fomatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        this.Birthday = LocalDate.parse(Birthday,fomatter);
    }
    public LocalDate getBirthday(){
        return Birthday;
    }


}
