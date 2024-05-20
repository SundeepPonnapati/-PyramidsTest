package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dto.StudentDTO;
import entity.StudentEntity;
import service.StudentService;

@RestController("/api/v1/student")
public class StudentController {
	
	
	@Autowired
    private StudentService studentService;
	
	@PostMapping
	public StudentEntity saveStudentDetails(@RequestBody StudentDTO studentdto){
		return studentService.saveStudentDetails(studentdto);
		
	}
	@GetMapping("/{id}")
    public ResponseEntity<StudentEntity> getStudentById(@PathVariable Long id) {
		return studentService.getById(id);
       
    }
	@GetMapping("/name/{name}")
    public ResponseEntity<List<StudentEntity>> getStudentByName(@PathVariable String name) {
		return studentService.getByName(name);
       
    }
	@GetMapping("/class-name/{className}")
    public ResponseEntity<List<StudentEntity>> getStudentByClassName(@PathVariable String className) {
		return studentService.getByStudentClass(className);
       
    }
	
	@PutMapping("/{id}")
	public ResponseEntity<StudentEntity> updateById(@PathVariable Long id,@RequestBody StudentDTO studentdto) {
		return studentService.updateById(id,studentdto);
       
    }
	
}
