package com.maurice.SpringTutorial.config;

import com.maurice.SpringTutorial.entities.*;
import com.maurice.SpringTutorial.entities.Class;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class RegistrationConfigConfig {

    // TODOS los Beans TIENEN que ser definidos public

    @Bean(name = "course")
    @Scope("prototype")
    public Course getCourse(){
        return new Course("Discrete Math", "Computer Science");
    }

    /*
    @Scope("singleton") por defecto
     */
    @Bean // el Bean tendra como nombre el nombre del método ("getSecondCourse") por defecto
    @Qualifier("secondCourse")
    public Course getSecondCourse(){
        return new Course("Analytical Math", "Computer Science");
    }

    @Bean()
    public Professor getProfessor(){
        return new Professor("Adam", Grade.MASTER);
    }

    @Bean
    public ClassRoom getClassRoom(){
        return new ClassRoom("308", "B", (short)50);
    }

    // Debido a que definimos 2 Beans instanciando a la misma clase le otorgamos prioridad a uno con ...
    // la anotación @Primary
    @Bean
    @Primary
    public ClassRoom getSecondClassRoom(){
        return new ClassRoom("404", "A", (short)45);
    }

    // Cuando existen más de 1 Bean intanciando la misma clase TENEMOS que especificar cual de ellos ...
    // se utilizará nombrando el parámetro con el mismo nombre del Bean a llamar, de otro modo se tendra que utilizar ...
    // la anotación @Qualfier referenciando a un Bean en específico
    @Bean
    public Class getClassObject(Course course) {
        return new Class(Shift.NIGHT, course);
    }
    @Bean
    public Class getClassObjectByQualifier(@Qualifier("secondCourse") Course course) {
        return new Class(Shift.NIGHT, course);
    }

}
