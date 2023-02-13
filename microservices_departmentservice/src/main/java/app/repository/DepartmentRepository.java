package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
