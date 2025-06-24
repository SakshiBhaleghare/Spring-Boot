package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Entity.Subject;

@Repository
public interface SubjectRepository  extends JpaRepository<Subject, Integer>{

}
