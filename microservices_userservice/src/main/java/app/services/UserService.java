package app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import app.VO.DepartmentVO;
import app.VO.ResultVO;
import app.entity.User;
import app.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	@Autowired
	RestTemplate restTemplate;

	public User saveDepartment(User user) {
		if (fetchDepartment(user.departmentId) != null) {
			return repository.save(user);
		} else {
			return null;
		}
	}

	public ResultVO fetchUser(int userId) {
		Optional<User> userCO = repository.findById(userId);
		if (userCO.isPresent()) {
			ResultVO obj = new ResultVO();
			obj.user = userCO.get();
			obj.department = fetchDepartment(obj.user.departmentId);
			return obj;
		} else {
			return null;
		}

	}

	public DepartmentVO fetchDepartment(int departmentId) {
		return restTemplate.getForObject("http://DEPARTMENT-SERVICE/api/department/" + departmentId,
				DepartmentVO.class);

	}

	public User updateUser(User user, int userId) {
		Optional<User> userDB = repository.findById(userId);
		if (userDB.isPresent() && fetchDepartment(userDB.get().departmentId) != null) {
			User userDBO = userDB.get();
			userDBO.userName = user.userName;
			userDBO.city = user.city;
			userDBO.departmentId = user.departmentId;
			return repository.save(userDBO);
		} else {
			return null;
		}
	}

	public User deleteUser(int userId) {
		Optional<User> user = repository.findById(userId);
		if (user.isPresent()) {
			repository.delete(user.get());
			return user.get();
		} else {
			return null;
		}
	}

	public List<ResultVO> fetchAllUsers() {
		List<User> users = repository.findAll();
		List<ResultVO> resultVOs = new ArrayList<>();
		for (User u : users) {
			ResultVO resultVO = new ResultVO();
			resultVO.user = u;
			resultVO.department = fetchDepartment(u.departmentId);

			resultVOs.add(resultVO);
		}
		return resultVOs;

	}

}
