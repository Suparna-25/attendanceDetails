
package com.cg.attendance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cg.attendance.domain.Employee;
/**
 * This a Employee repository that performs all the crud operation on employee details
 * @author Suparna Arya & Aswitha 
 *
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	
// TODO ALL THE CRUD OPERATIONS ON EMPLOYEE BEAN

	Employee findByEmpId(long empId);
    @Query("SELECT a FROM employees a where a.supervisiorId =:supervisiorId ")
	List<Employee> findEmployeesUnderSupervisior(@Param("supervisiorId") long supervisiorId);
}