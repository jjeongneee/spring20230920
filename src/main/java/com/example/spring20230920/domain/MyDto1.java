package com.example.spring20230920.domain;

public class MyDto1 {
    // property 명 : get/set 없애고 소문자로 시작

    // name property
    // homeAddress property

    private String name;
    private String homeAddress;
    private String MYHOME;
    private Boolean married;
    private boolean checked;

    public boolean isChecked() {
        return checked;
    }

    // set은 할당해야하니까 파라미터가 있음!@!!
    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Boolean isMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getMYHOME() {
        return MYHOME;
    }

    public void setMYHOME(String MYHOME) {
        this.MYHOME = MYHOME;
    }
}
