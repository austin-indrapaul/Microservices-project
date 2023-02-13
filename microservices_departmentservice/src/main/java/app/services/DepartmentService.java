package app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Department;
import app.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository repository;

	public Department saveDepartment(Department department) {
		return repository.save(department);
	}

	public Department fetchDepartment(int departmentId) {
		Optional<Department> department = repository.findById(departmentId);
		return department.isEmpty() ? null : department.get();
	}

	public Department updateDepartment(Department department, int departmentId) {
		Optional<Department> departmentDB = repository.findById(departmentId);
		if (departmentDB.isPresent()) {
			Department deptDB = departmentDB.get();
			deptDB.block = department.block;
			deptDB.departmentName = department.departmentName;
			return repository.save(deptDB);
		} else {
			return null;
		}
	}

	public String deleteDepartment(int departmentId) {
		// repository.deleteById(departmentId);
		Optional<Department> department = repository.findById(departmentId);
		if (department.isPresent())
			repository.delete(department.get());
		return department.isEmpty() ? "failure" : "success";
	}

	public List<Department> fetchAllDepartments() {
		return repository.findAll();
	}

	public List<Department> saveAllDepartments(List<Department> dptList) {
		List<Department> dpts = repository.saveAll(dptList);
		return dpts;
	}

}
