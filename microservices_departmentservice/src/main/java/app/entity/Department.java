package app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int departmentId;
	public String departmentName;
	public String block;
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
