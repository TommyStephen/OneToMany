package study.dto;

import java.util.List;

import lombok.Data;
import study.model.Child;

@Data
public class ParentDTO {

	private long id;
	private String name;
	private String email;
	private List<Child> children;
}
