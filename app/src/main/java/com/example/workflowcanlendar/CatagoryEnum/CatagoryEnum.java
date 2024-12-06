package com.example.workflowcanlendar.CatagoryEnum;

public enum CatagoryEnum {
    HOME("Home" , 0 ),
    WORK("Work" , 1),
    SCHOOL("School" , 2),
    FRIENDS("Friends" , 3);

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
