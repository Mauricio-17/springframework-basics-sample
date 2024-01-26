package com.maurice.SpringTutorial.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@AllArgsConstructor
public class Professor {

    public String name;
    public Grade grade;

}
