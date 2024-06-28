package study.dto;

public class ChildParentSalary {

	private long id;
	private String childName;
	private long salary;
	private String parentName;
	
	ChildParentSalary(){}

	public ChildParentSalary(long id, String childName, long salary, String parentName) {
		super();
		this.id = id;
		this.childName = childName;
		this.salary = salary;
		this.parentName = parentName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	
	
	
	
}
