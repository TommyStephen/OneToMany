package study.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import study.dto.ChildParentSalaryDto;
import study.model.Child;

public interface ChildRepository extends JpaRepository<Child, Long>, JpaSpecificationExecutor<Child> {

	@Query("SELECT new study.dto.ChildParentSalaryDto(c.id, c.name, c.salary, p.name) " +
	           "FROM Child c LEFT JOIN c.parent p " +
	           "WHERE c.salary <= :salary")
	    List<ChildParentSalaryDto> findChildrenWithSalaryLessthan(@Param("salary") long salary);
	
	@Query("SELECT new study.dto.ChildParentSalaryDto(c.id, c.name, c.salary, p.name) " +
	           "FROM Child c LEFT JOIN c.parent p " +
	           "WHERE c.salary >= :salary")
	    List<ChildParentSalaryDto> findChildrenWithSalaryGreaterthan(@Param("salary") long salary);
	
	
}
