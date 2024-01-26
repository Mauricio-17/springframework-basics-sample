package com.maurice.SpringTutorial;


import com.maurice.SpringTutorial.config.RegistrationConfigConfig;
import com.maurice.SpringTutorial.entities.Course;
import com.maurice.SpringTutorial.entities.Professor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTutorialApplication {

	public static void main(String[] args) {

		// La clase AnnotationConfigApplicationContext hereda de ApplicationContext que representa al IoC
		// Esta subclase nos permite agregar configuración sobre el IoC
		// La clase asociada a configurar el IoC debe tener la anotación @Configuration: RegistrationConfigConfig
		try(var context = new AnnotationConfigApplicationContext(
				RegistrationConfigConfig.class)){

// ------   No necesitamos instanciar explicitamente, solo debemos invocar a IoC para obtener las dependencias

			// Definiendo 2 objetos de la clase Curso de un mismo Bean tipo prototype
			var course = (Course) context.getBean("course");
			var secondCourse = (Course) context.getBean("course");
			System.out.println(course);

			// Definiendo 2 objetos de la clase Curso de un mismo Bean tipo singleton
			var courseSingleton = (Course) context.getBean("getSecondCourse");
			var secondCourseSingleton = (Course) context.getBean("getSecondCourse");
			System.out.println(courseSingleton);

			var classObject = context.getBean("getClassObjectByQualifier");
			System.out.println(classObject);

			var professor = context.getBean(Professor.class); // Utilizará el bean que instancia a dicha clase (Professor)
			System.out.println(professor);

			// Prototype scope en acción
			System.out.println("ANTES: " +secondCourse);
			course.setCareer("Data Science");
			System.out.println("DESPUES: " +secondCourse); // no altera

			// Singleton scope en acción
			System.out.println("ANTES: " +courseSingleton);
			secondCourseSingleton.setName("Financial Math");
			secondCourseSingleton.setCareer("Economy");
			System.out.println("DESPUES: " +courseSingleton); // si altera

		}

	}


}
