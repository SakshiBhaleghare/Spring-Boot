package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Entity.FileUpload;

@Repository
public interface FileRepo extends JpaRepository<FileUpload, Integer> {

}
