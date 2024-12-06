package com.example.workflowcanlendar.CatagoryEnum;

public enum CatagoryEnum {
    HOME("HOME" , 0 ),
    WORK("WORK" , 1),
    SCHOOL("SCHOOL" , 2),
    FRIENDS("FRIENDS" , 3);

    private final String catagoryName;
    private final int catagoryCode;


    CatagoryEnum(String catagoryName, int catagoryCode) {
        this.catagoryName = catagoryName;
        this.catagoryCode = catagoryCode;
    }

    public String getCatagoryName() {
        return catagoryName;
    }

    public int getCatagoryCode() {
        return catagoryCode;
    }
}
