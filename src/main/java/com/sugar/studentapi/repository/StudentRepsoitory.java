package com.sugar.studentapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sugar.studentapi.modal.Student;

// Repository allows save, find, etc in the databse
@Repository
public interface StudentRepsoitory extends JpaRepository<Student, Long>  {}

