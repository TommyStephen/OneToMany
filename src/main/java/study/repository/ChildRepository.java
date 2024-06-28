package study.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import study.dto.ChildParentSalary;
import study.model.Child;

public interface ChildRepository extends JpaRepository<Child, Long> {

	@Query("SELECT new study.dto.ChildParentSalary(c.id, c.name, c.salary, p.name) " +
	           "FROM Child c LEFT JOIN c.parent p " +
	           "WHERE c.salary <= :salary")
	    List<ChildParentSalary> findChildrenWithSalaryLessthan(@Param("salary") long salary);
	
	@Query("SELECT new study.dto.ChildParentSalary(c.id, c.name, c.salary, p.name) " +
	           "FROM Child c LEFT JOIN c.parent p " +
	           "WHERE c.salary >= :salary")
	    List<ChildParentSalary> findChildrenWithSalaryGreaterthan(@Param("salary") long salary);
	
	
}
