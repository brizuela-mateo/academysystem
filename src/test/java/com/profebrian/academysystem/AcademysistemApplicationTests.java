package com.profebrian.academysystem;

import com.profebrian.academysystem.student.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AcademysistemApplicationTests {

	@Autowired
	StudentService studentService;

	@Test
	void contextLoads() {
		Assertions.assertNotNull(studentService);
	}

}
