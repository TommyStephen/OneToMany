package study.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import study.model.Parent;

public interface ParentRepository extends JpaRepository<Parent, Long> {

	@Query("FROM Parent p JOIN p.children c WHERE c.salary <= :salary")
    List<Parent> findAllParentsWithChildrenHavingSalaryLessThan(@Param("salary") long salary);
	
}
