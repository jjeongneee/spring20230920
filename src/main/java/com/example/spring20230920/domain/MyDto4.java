package com.example.spring20230920.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// /main6/sub2?signed=true&email=ab@gmail.com&gender=male
@Getter
@Setter
@ToString
public class MyDto4 {
    private Boolean signed;
    private String email;
    private String gender;
}
