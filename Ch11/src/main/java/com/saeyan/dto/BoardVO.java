package com.saeyan.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
@Setter
@Getter
@ToString
public class BoardVO {
    int num;
    String pass;
    String name;
    String email;
    String title;
    String content;
    int readcount;
    private Timestamp writedate;
}
