package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Entity.Adhar;

@Repository
public interface AdharRepository extends JpaRepository<Adhar, Integer> {

}
