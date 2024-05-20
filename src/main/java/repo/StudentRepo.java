package repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.StudentEntity;

@Repository
public interface StudentRepo extends JpaRepository<StudentEntity, Long> {
	List<StudentEntity> findByName(String name);
    List<StudentEntity> findByStudentClass(String studentClass);
}
