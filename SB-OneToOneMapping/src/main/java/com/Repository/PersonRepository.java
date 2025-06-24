package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {



}
