package com.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import com.bean.Customer;
import com.bean.Employee;
import com.bean.Transfer;
import com.dao.Dao;

public class StoreService {
	
	public static boolean employeeDetails(Employee employee, String empId, String empPw) {
		
		boolean x = false;
		x = Dao.addemp(employee, empId, empPw);
		return x;
		
	}

	public static String getId() {
		String s = null;
		final String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 5);
	    final String pw = UUID.randomUUID().toString().replace("-", "").substring(5, 15);
	    Random rand = new Random();
	    int random = rand.nextInt(100);
	    String id = uuid+String.valueOf(random);
	    s=id+" "+pw;
		return s;
	}

	public static boolean customerDetails(Customer customer, String cusId, String cusPw) {
		
		boolean x = false;
		x = Dao.addcust(customer, cusId, cusPw);
		return x;
		
	}
	
	public static boolean empEligibility(String empId) {
		boolean status = false;
		String dateandcity = Dao.getEmpCity(empId);
		String arr[] = dateandcity.split(" ");
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		
	    String joining = arr[1];
	    String current = formatter.format(new Date());
	    String[] j = joining.split("-");
	    String[] c = current.split("-");
	    //System.out.println(Integer.parseInt(j[2])+" "+Integer.parseInt(j[1])+" "+Integer.parseInt(j[0])+" "+Integer.parseInt(c[0])+" "+c[1]+" "+c[2]);
	    if(Integer.parseInt(c[2]) > Integer.parseInt(j[0])+1){
            status=true;
            }
            else if(Integer.parseInt(c[2]) > Integer.parseInt(j[0])){
                if(Integer.parseInt(c[1]) > Integer.parseInt(j[1]))
                    status=true;
                else if(Integer.parseInt(c[1]) == Integer.parseInt(j[1]))
                    if(Integer.parseInt(c[0]) >= Integer.parseInt(j[2]))
                    status=true;
            }
	    return status;
	}

	public static boolean transEmp(Transfer transfer) {
		
		boolean status = false;
		status = Dao.TransferEmp(transfer);
		return status;
		
	}

	public static List<Customer> viewCustomer() {
		List<Customer> customerDetails = new ArrayList<>();
		customerDetails = Dao.getCustomerDetails();
		return customerDetails;
	}

	public static boolean deleteCustomer(String id) {
		boolean status = Dao.deleteCustomer(id);
		return status;
	}

	public static boolean Check(String id, String pw, String role) {
		boolean status = false;
		status = Dao.Check(id, pw, role);
		return status;
	}

	public static String getCity(String id) {
		String city = Dao.getEmpCity(id);
		return city;
	}
	
	public static List<Transfer> viewTransfer(String role1, String role2) {
		List<Transfer> transferDetails = new ArrayList<>();
		transferDetails = Dao.TransferDetails(role1, role2);
		return transferDetails;
	}

	public static boolean TransferStatus(String id, String status, String reason) {
		boolean s = false;
		s = Dao.TransferStatus(id, status, reason);
		return s;
	}

	public static String showStatus(String id) {
		
		String s = Dao.ShowStatus(id);
		return s;
	}

	public static boolean UpdateCustomer(Customer customer) {
		boolean status = false;
		status = Dao.UpdateCustomer(customer);
		return status;
	}

	public static List<Employee> getEmpDetails(String r) {
		List<Employee> employeeDetails = new ArrayList<>();
		employeeDetails = Dao.getEmpDetails(r);
		return employeeDetails;
	}

	public static boolean UpdateEmployee(Employee employee) {
		boolean status = false;
		status = Dao.UpdateEmployee(employee);
		return status;
	}

	public static boolean EmpValidity(String id, String role) {
		boolean valid = false;
		valid = Dao.EmpValidity(id, role);
		return valid;
	}

}
