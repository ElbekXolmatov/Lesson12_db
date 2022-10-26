package com.company.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    private int id;
    private String fullname;
    private short course;
    private String univeristy;
}
