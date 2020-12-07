package com.cg.attendance.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.attendance.dto.AttendanceDto;
import com.cg.attendance.entities.AttendanceDetail;
import com.cg.attendance.entities.Employee;
import com.cg.attendance.exception.EmployeeIDException;
import com.cg.attendance.repositories.AttendanceDetailRepository;
import com.cg.attendance.repositories.EmployeeRepository;

@SpringBootTest
class AttendanceDetailServiceTest {

	@InjectMocks
	AttendanceDetailService service;

	@Mock
	AttendanceDetailRepository repo;
	@Mock
	EmployeeRepository empRepo;
	@Mock
	private EmployeeService empService;

	@Test
	void addAttendanceDetailTest() {

		Employee employee = new Employee("46045170", "Suparna Arya", "7980064539", "suparna.arya@capgemini.com",
				"Bangalore", "46045157", null);

		AttendanceDetail attendance = new AttendanceDetail("10:10", "14:30", null, "", "", "APPLIED", employee);

		AttendanceDto attendanceDto = new AttendanceDto("10:10", "14:30", null, null, "", "", "APPLIED");

		when(empService.viewEmployeeByEmpId(any(String.class))).thenReturn(employee);
		when(repo.save(any(AttendanceDetail.class))).thenReturn(attendance);

		AttendanceDetail savedObj = service.addAttendanceDetail(attendanceDto);

		assertNotNull(savedObj);
		assertEquals("APPLIED",savedObj.getStatus());
		assertEquals("10:10",savedObj.getInTime());
		assertEquals( "14:30",savedObj.getOutTime());
		assertEquals(null,savedObj.getAttendanceDate());
		assertEquals("",savedObj.getReason());
		assertEquals("",savedObj.getTypeId());
		
		

	}

	@Test
	void updateAttendanceStatusTest() {

		Employee employee = new Employee("46045170", "Suparna Arya", "7980064539", "suparna.arya@capgemini.com",
				"Bangalore", "46045157", null);

		AttendanceDetail attendance = new AttendanceDetail("10:10", "14:30", null, "", "", "APPLIED", employee);

		when(repo.findById(any(Long.class))).thenReturn(Optional.of(attendance));

		AttendanceDetail updateObj = service.updateAttendanceStatus("1", "REJECT");

		assertEquals("REJECT",attendance.getStatus());

	}

	@Test
    void viewAttendanceByAttendanceIdTest() {

		Employee employee = new Employee("46045170", "Suparna Arya", "7980064539", "suparna.arya@capgemini.com",
				"Bangalore", "46045157", null);

		AttendanceDetail attendance = new AttendanceDetail("10:10", "14:30", null, "", "", "APPLIED", employee);

		when(repo.findById(any(Long.class))).thenReturn(Optional.of(attendance));

		AttendanceDetail savedObj = service.viewAttendanceByAttendanceId("1");

		assertNotNull(savedObj);
		assertEquals("APPLIED",savedObj.getStatus());

	}
	@Test 
	void EmployeeNotFoundException() throws Exception{
		AttendanceDto attendanceDto = new AttendanceDto("10:10", "14:30", null, null, "", "", "APPLIED");
		BDDMockito.given(empRepo.findByEmpId("4690345")).willThrow(new EmployeeIDException());
		assertThrows(EmployeeIDException.class, ()->service.addAttendanceDetail(attendanceDto));
	
	}
}