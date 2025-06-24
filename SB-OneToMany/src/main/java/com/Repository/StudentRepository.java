package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
