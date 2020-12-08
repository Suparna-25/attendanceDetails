package com.cg.attendance.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.attendance.entities.AttendanceDetail;
import com.cg.attendance.entities.Employee;
import com.cg.attendance.exception.EmployeeIDException;
import com.cg.attendance.exception.SupervisiorIDException;
import com.cg.attendance.repositories.EmployeeRepository;

@SpringBootTest
class EmployeeServiceTest {

	@InjectMocks
	EmployeeService service;

	@Mock
	private EmployeeRepository empRepo;

	@Test
	void viewEmployeeByEmpIdTest() {

		Employee employee = new Employee("46045170", "Suparna Arya", "7980064539", "suparna.arya@capgemini.com",
				"Bangalore", "46045157", null);
		when(empRepo.findByEmpId(any(String.class))).thenReturn(employee);

		Employee fetchedObj = service.viewEmployeeByEmpId("46045170");

		assertEquals(fetchedObj.getEmpEmail(), employee.getEmpEmail());

	}

	@Test
	void addEmployeeTest1() {

		Employee employee = new Employee("46045170", "Suparna Arya", "7980064539", "suparna.arya@capgemini.com",
				"Bangalore", "46045170", null);
		when(empRepo.save(any(Employee.class))).thenReturn(employee);

		assertThrows(SupervisiorIDException.class, () -> service.addEmployee(employee));
	}

	@Test
	void viewEmployeesUnderSupervisiorTest1() {

		when(empRepo.findEmployeesUnderSupervisior(any(String.class))).thenReturn(null);

		assertThrows(SupervisiorIDException.class, () -> service.viewEmployeesUnderSupervisior("1233"));
	}
	
	
	@Test
	void viewEmployeesUnderSupervisiorTest2() {
		
		Employee employee1 = new Employee("46045170", "Suparna Arya", "7980064539", "suparna.arya@capgemini.com",
				"Bangalore", "46045157", null);
		
		Employee employee2 = new Employee("46045171", "Suparna Arya", "7980064539", "suparna.arya@capgemini.com",
				"Bangalore", "46045157", null);
		
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(employee1);
		employeeList.add(employee2);
		

		when(empRepo.findEmployeesUnderSupervisior(any(String.class))).thenReturn(employeeList);
		
		List<Employee> fetchedList = service.viewEmployeesUnderSupervisior("7980064539");

		assertEquals(2,fetchedList.size());
	}
	@Test
	void testAddEmployee() throws Exception {
		Employee employee=new Employee("456045158","Suparna Arya","12345","suparna@1997gmail.com",
				"Banglore","34216",null);
		Mockito.when(empRepo.save(employee)).thenReturn(employee);
		Employee emp=service.addEmployee(employee);
		assertEquals(employee.getEmpId(),emp.getEmpId());
		
	}
	@Test
	void employeeAlreadyExists() throws Exception{
		Employee employee=new Employee("456045158","Suparna Arya","12345","suparna@1997gmail.com",
				"Banglore","34216",null);
		BDDMockito.given(service.addEmployee(employee)).willThrow(new EmployeeIDException());
		assertThrows(EmployeeIDException.class,()->service.addEmployee(employee));
	}
	@Test
	void employeeCantBeItsOwnSupervisior() throws Exception{
		Employee employee=new Employee("456045159","Suparna Arya","1234","suparna.arya@gmail.com",
				"Banglore","456045159",null);	 
		Mockito.when(empRepo.save(employee)).thenReturn(employee).thenThrow(new SupervisiorIDException());
		assertThrows(SupervisiorIDException.class,()->service.addEmployee(employee));
		}
	@Test
	void viewEmployeeByEmpId()throws Exception{
		Employee employee=new Employee("456045159","Suparna Arya","1234","suparna.arya@gmail.com",
				"Banglore","456045159",null);	 
		String empId=employee.getEmpId();
		Mockito.when(empRepo.findByEmpId(empId)).thenReturn(employee);
		assertEquals(empId,service.viewEmployeeByEmpId(empId).getEmpId());
	}
	@Test
	void viewAttendanceByEmpId()throws Exception{
		AttendanceDetail attendance=new AttendanceDetail(null,null,null,null, null,"APPLIED",null);
		Employee employee=new Employee("456045159","Suparna Arya","1234","suparna.arya@gmail.com",
				"Banglore","456045159",List.of(attendance));
		List<AttendanceDetail> attendanceList=employee.getAttendance();
		Mockito.when(empRepo.save(employee)).thenReturn(employee);
		assertEquals(1,attendanceList.size());	
	}
}