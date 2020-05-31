package com.store.ManagerService;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.store.ManagerService.dao.EmployeeDao;
import com.store.ManagerService.entity.DepartmentEntity;
import com.store.ManagerService.entity.EmployeeEntity;
import com.store.ManagerService.entity.UserEntity;
import com.store.ManagerService.model.DepartmentPojo;
import com.store.ManagerService.model.EmployeePojo;
import com.store.ManagerService.model.UserPojo;
import com.store.ManagerService.service.ManagerServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
class ManagerServiceApplicationTests {

	@Autowired
	private ManagerServiceImpl managerService;
	
	@MockBean
	private EmployeeDao empDao;
	
	UserEntity userEntity;
	UserPojo userPojo;
	
	DepartmentEntity deptEntity;
	DepartmentPojo deptPojo;
	
	EmployeeEntity empEntity;
	EmployeePojo expectedOutput;
	EmployeePojo employeeInput;
	EmployeeEntity expectedempEntity;
	
	

	@BeforeEach
    public void init() {
		
		
		deptEntity = new DepartmentEntity(1234,"billing","hyd");
		deptPojo= new DepartmentPojo(1234,"billing","hyd");
		
		
		userEntity = new UserEntity(1,"abc","abc456","456","employee");
		userPojo = new UserPojo(1,"abc","abc456","456","employee");
		empEntity = new EmployeeEntity(1,"abc","small",10000,"2020-01-06",deptEntity,userEntity);
		expectedOutput= new EmployeePojo(1,"abc","small",10000,"2020-01-06",deptPojo,userPojo);
		
		employeeInput = new EmployeePojo();
		employeeInput.setEmpName("pqr");
		employeeInput.setEmpLevel("large");
		employeeInput.setEmpSal(12220);
		employeeInput.setEmpHiredate("2020-05-15");
		employeeInput.setDept(deptPojo);
		employeeInput.setUser(userPojo);
		
		
		expectedempEntity = new EmployeeEntity(1,"abc","small",10000,"2020-01-06",deptEntity,userEntity);
		
		
    }
	
	@Test
	void addEmployeeTest() {

		expectedempEntity = new EmployeeEntity(1,"abc","small",10000,"2020-01-06",deptEntity,userEntity);
		when(empDao.save(expectedempEntity)).thenReturn(empEntity);
		assertEquals(true,managerService.addEmployee(employeeInput));
	}

	@Test
	void getEmployeeTest() {
		
		when(empDao.findById(1)).thenReturn(Optional.of(empEntity));
		
		assertEquals(expectedOutput.getEmpId(),managerService.getEmployee(1).getEmpId());
		assertEquals(expectedOutput.getEmpName(),managerService.getEmployee(1).getEmpName());

//		assertNotEquals(expectedOutput,prodservice.getProductDetails(101));
//		assertSame(expectedOutput, prodservice.getProductDetails(101));
//		assertNotNull(prodservice.getProductDetails(101));
	}
	
}
