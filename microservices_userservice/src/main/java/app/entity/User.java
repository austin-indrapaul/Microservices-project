package app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "USER_TABLE")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int userId;
	public String userName;
	public String city;
	public int departmentId;
//
//	public Department() {
//	}
//
//	public Department(int id, String name, String block) {
//		this.departmentId = id;
//		this.departmentName = name;
//		this.block = block;
//	}
}
