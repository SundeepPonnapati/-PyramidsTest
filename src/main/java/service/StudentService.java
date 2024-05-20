package service;


import java.util.List;

import org.springframework.http.ResponseEntity;

import dto.StudentDTO;
import entity.StudentEntity;

public interface StudentService {
  public StudentEntity saveStudentDetails(StudentDTO studentDto);
  public ResponseEntity<StudentEntity>  getById(long id);
  public ResponseEntity<List<StudentEntity>>  getByName(String name);
  public ResponseEntity<List<StudentEntity>>  getByStudentClass(String studentClass);
  public ResponseEntity<StudentEntity> 	updateById(long id,StudentDTO studentDto);
}
