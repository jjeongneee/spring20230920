package com.example.spring20230920.domain;

public class MyDto7 {

    public String getName() {
        return "김봉석";
    }
    @Override
    public String toString() {
        return "내가 만든 클래스😛😛";
    }

    public String getAddress() {
        return "서울";
    }

    public String getEmail() {
        return "ggggg@aga";
    }

    public Integer getAge() {
        return 30;
    }
}

//<h1>${attr3.address}</h1>
//<h1>${attr3.email}</h1>
//<h1>${attr3.age}</h1>