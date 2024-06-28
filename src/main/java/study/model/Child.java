package study.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Child {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private LocalDate dob;
	private long salary;
	
	@ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id") // Use JoinColumn to specify the foreign key column
	@JsonBackReference
	private Parent parent;
	
	
	
	
}
