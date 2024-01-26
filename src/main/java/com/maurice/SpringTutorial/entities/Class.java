package com.maurice.SpringTutorial.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

@ToString
public class Class {

    @Getter
    @Setter
    public Shift shift;
    @Getter
    @Setter
    public Course course;

    @Autowired // Permitir la inyección de dependencia automáticamente
    public Professor professor;

    @Getter
    public ClassRoom classRoom;

    public Class(Shift shift, Course course) {
        this.shift = shift;
        this.course = course;
    }

    @Autowired
    public void setClassRoom(ClassRoom classRoom){
        this.classRoom = classRoom;
    }


}
