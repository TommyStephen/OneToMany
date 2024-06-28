package study.dto;

import java.time.LocalDate;

import lombok.Data;
@Data
public class ChildDTO {

	private long id;
	private String name;
	private LocalDate dob;
	private long salary;
}
