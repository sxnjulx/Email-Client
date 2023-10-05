package com.company;

public class Official extends Recipient{
    private String designation;

    public Official( String Name, String Email ,String designation){
        super(Name,Email);
        this.designation = designation;
    }
    public String getDesignation(){
        return designation;
    }

}
