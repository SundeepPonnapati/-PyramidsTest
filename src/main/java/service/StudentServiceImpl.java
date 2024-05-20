package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dto.StudentDTO;
import entity.StudentEntity;
import repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {

	
	@Autowired 
   private StudentRepo repo; 
     
	@Override
	public StudentEntity saveStudentDetails(StudentDTO studentDto) {
	    StudentEntity studentEntity = new StudentEntity();
	    studentEntity.setDateOfBirth(studentDto.getDateOfBirth());
	    studentEntity.setJoiningDate(studentDto.getJoiningDate());
	    studentEntity.setName(studentDto.getName());
	    studentEntity.setStudentClass(studentDto.getStudentClass());
	    StudentEntity studentEntityDb= repo.save(studentEntity);
		return studentEntityDb;
		
	}

	@Override
	public ResponseEntity<StudentEntity> getById(long id) {
		  Optional<StudentEntity> student = repo.findById(id);
	        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	   
	}

	@Override
	public ResponseEntity<StudentEntity> updateById(long id,StudentDTO studentDto) {
		  Optional<StudentEntity> student = repo.findById(id);
	        if (student.isPresent()) {
	        	StudentEntity updatedStudent = student.get();
	            updatedStudent.setName(studentDto.getName());
	            updatedStudent.setDateOfBirth(studentDto.getDateOfBirth());
	            updatedStudent.setJoiningDate(studentDto.getJoiningDate());
	            updatedStudent.setStudentClass(studentDto.getStudentClass());
	            repo.save(updatedStudent);
	            return ResponseEntity.ok(updatedStudent);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	}

	@Override
	public ResponseEntity<List<StudentEntity>> getByName(String name) {
		List<StudentEntity> studentEntity = repo.findByName(name);
		return ResponseEntity.ok(studentEntity);
	}

	@Override
	public ResponseEntity<List<StudentEntity>> getByStudentClass(String studentClass) {
		List<StudentEntity> studentEntity = repo.findByStudentClass(studentClass);
		return ResponseEntity.ok(studentEntity);
	}

}
