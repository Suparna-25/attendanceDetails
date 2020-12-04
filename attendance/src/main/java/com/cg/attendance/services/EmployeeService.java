package com.cg.attendance.services;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cg.attendance.entities.AttendanceDetail;
import com.cg.attendance.entities.Employee;
import com.cg.attendance.exception.EmployeeIDException;
import com.cg.attendance.exception.SupervisiorIDException;
import com.cg.attendance.repositories.EmployeeRepository;



@Service
public class EmployeeService implements IEmployeeService {
	private EmployeeRepository empRepo;

	@Override
	public Employee viewEmployeeById(String empId) {
		Employee emp = empRepo.findByEmpId(empId);
		if(emp==null)
		{
			throw new EmployeeIDException("No employee with such id "+empId);
		}
		return emp;
	}

	@Override
	public Employee addEmployee(Employee employee) {
		
		try {
			return empRepo.save(employee);
		} catch (Exception e) {
			throw new EmployeeIDException("Employee id " + employee.getEmpId() + " already available");
		}
	}

	@Override
	public List<Employee> viewEmployeesUnderSupervisior(String supervisiorId) {
		List<Employee> employee = empRepo.findEmployeesUnderSupervisior(supervisiorId);	
		if(employee==null)
		{
			throw new SupervisiorIDException("No employee works under supervisior whose id is "+supervisiorId);
		}
		return employee;
	}

	@Override
	public List<AttendanceDetail> viewAttendanceByEmpId(String empId) {
		Employee emp = viewEmployeeById(empId);
		if(emp==null)
		{
			throw new EmployeeIDException("No attendance with employee id as "+empId+" exists");
		}
		
		return emp.getAttendance();
	}

//	@Override
//	public String validateSupervisior(Employee emp, long supervisiorId) {
//		String message = null;
//		if (emp.getEmpId() != supervisiorId) {
//			message = "Correct Supervisior Id";
//		} else {
//			throw new SupervisiorIDException("Employee cannot be it's own Supervisior");
//		}
//		return message;
//	}

}