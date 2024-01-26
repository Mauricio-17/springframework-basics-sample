package com.maurice.SpringTutorial.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class ClassRoom {

    private String classNumber;
    private String pavilion;
    private short capacity;

}
