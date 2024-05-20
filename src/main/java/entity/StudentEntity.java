package entity;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class StudentEntity {
	 
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	 	private Long id;
	 	
	    private String name;

	    @Column(name = "date_of_birth")
	    private LocalDate dateOfBirth;

	    @Column(name = "joining_date")
	    private LocalDate joiningDate;
        
	    @Column(name="class")
	    private String studentClass;
	    
	 	public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public LocalDate getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(LocalDate dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}

		public LocalDate getJoiningDate() {
			return joiningDate;
		}

		public void setJoiningDate(LocalDate joiningDate) {
			this.joiningDate = joiningDate;
		}

		public String getStudentClass() {
			return studentClass;
		}

		public void setStudentClass(String studentClass) {
			this.studentClass = studentClass;
		}

		


}
