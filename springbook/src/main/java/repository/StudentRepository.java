package repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import domain.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{
	List<Student> findByFeedbackId(int feedbackId);
}