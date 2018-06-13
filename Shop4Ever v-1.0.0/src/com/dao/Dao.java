package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bean.Customer;
import com.bean.Employee;
import com.bean.Transfer;

public class Dao {
	
	public static final String url="jdbc:oracle:thin:@localhost:1521:xe";
	public static final String username="sys as sysdba";
	public static final String password="mydb";
	
	public static Connection con= null;
	
	public ResultSet rs= null;
	
	public static boolean addemp (Employee employee, String empId, String empPw) {
		boolean status = false;
		try {
			//System.out.println(empId+" "+empPw);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con= DriverManager.getConnection(url,username,password);
			String insertQuery="insert into employee values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(insertQuery);
			ps.setString(1, employee.getFirstName());
			ps.setString(2, employee.getMiddleName());
			ps.setString(3, employee.getLastName());
			ps.setString(4, employee.getRole());
			ps.setString(5, employee.getType());
			ps.setFloat(6, employee.getSalary());
			java.sql.Date sqlStartDate = new java.sql.Date(employee.getDate().getTime());
			ps.setDate(7, sqlStartDate);
			ps.setString(8, employee.getCity());
			ps.setString(9, employee.getStatus());
			ps.setString(10, empId);
			ps.setString(11, empPw);
			
			int count =ps.executeUpdate();
			
			if(count > 0)
				status = true;
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		}
		return status;
	}

	public static boolean addcust(Customer customer, String cusId, String cusPw) {
		boolean status = false;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con= DriverManager.getConnection(url,username,password);
			String insertQuery="insert into customer values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(insertQuery);
			ps.setString(1, customer.getFirstName());
			ps.setString(2, customer.getMiddleName());
			ps.setString(3, customer.getLastName());
			java.sql.Date dob = new java.sql.Date(customer.getDate().getTime());
			ps.setDate(4, dob);
			ps.setString(5, customer.getGender());
			ps.setString(6, customer.getPermanantAddress());
			ps.setString(7, customer.getPresentAddress());
			ps.setString(8, customer.getEmail());
			ps.setLong(9, customer.getNumber());
			ps.setString(10, cusId);
			ps.setString(11, cusPw);
			int count =ps.executeUpdate();
			
			if(count > 0)
				status = true;
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		}
		return status;
	}

	public static boolean TransferEmp(Transfer transfer) {
		String role = null;
		boolean status = false;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con= DriverManager.getConnection(url,username,password);
			
			String insertQuery="insert into transfer (empid, currentcity, preferredcity, reason, role)values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(insertQuery);
			
			String q2 = "select emprole from employee where id=?";
			PreparedStatement p2 = con.prepareStatement(q2);
			p2.setString(1, transfer.getId() );
			ResultSet rs = p2.executeQuery();
			while(rs.next())
				role = rs.getString(1);
			
			ps.setString(1, transfer.getId());
			ps.setString(2, transfer.getCurrentCity());
			ps.setString(3, transfer.getPreferredCity());
			ps.setString(4, transfer.getReason());
			ps.setString(5, role);
			
			int count = ps.executeUpdate();
			
			if(count > 0)
				status = true;
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		}
		return status;
		
	}

	public static List<Customer> getCustomerDetails() {
		List<Customer> customerDetails = new ArrayList<>();
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con= DriverManager.getConnection(url,username,password);
			String insertQuery="select FIRSTNAME, MIDDLENAME, LASTNAME, DOB, GENDER, PERMANENTADDRESS, PRESENTADDRESS, EMAIL, PHONE, ID from customer";
			PreparedStatement ps = con.prepareStatement(insertQuery);
			ResultSet rs =ps.executeQuery();
			
			while(rs.next()){
				
				Customer customer = new Customer();
				customer.setFirstName(rs.getString(1));
				customer.setMiddleName(rs.getString(2));
				customer.setLastName(rs.getString(3));
				customer.setDate(rs.getDate(4));;
				customer.setGender(rs.getString(5));
				customer.setPermanantAddress(rs.getString(6));
				customer.setPresentAddress(rs.getString(7));
				customer.setEmail(rs.getString(8));
				customer.setNumber(rs.getLong(9));
				customer.setId(rs.getString(10));
				customerDetails.add(customer);
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		}
		return customerDetails;
	}

	public static boolean deleteCustomer(String id) {
		boolean status = false;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con= DriverManager.getConnection(url,username,password);
			String insertQuery="delete from customer where ID=?";
			PreparedStatement ps = con.prepareStatement(insertQuery);
			ps.setString(1, id);
			int count =ps.executeUpdate();
			if(count>0)
					return true;
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		}
		return status;
	}

	public static boolean Check(String id, String pw, String role) {
		boolean status = false;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con= DriverManager.getConnection(url,username,password);
			String insertQuery="select emppw, emprole from employee where empid= ? ";
			PreparedStatement ps = con.prepareStatement(insertQuery);
			ps.setString(1, id);
			ResultSet rs =ps.executeQuery();
			String pass = null, r=null;
			while(rs.next()){
				pass=rs.getString(1);
				r=rs.getString(2);
			}
			if(pass.equals(pw) && r.equals(role))
				status=true;
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		}
		return status;
	}

	public static String getEmpCity(String id) {
		String city=null;Date date=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con= DriverManager.getConnection(url,username,password);
			String insertQuery="select city,joining from employee where empid= ?";
			PreparedStatement ps = con.prepareStatement(insertQuery);
			ps.setString(1, id);
			ResultSet rs =ps.executeQuery();
			while(rs.next()){
				city=rs.getString(1);
				date=rs.getDate(2);
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		}
		return city+" "+date;
	}
	
	public static List<Transfer> TransferDetails(String role1, String role2) {
		List<Transfer> transferDetails = new ArrayList<>();
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con= DriverManager.getConnection(url,username,password);
			String insertQuery="select currentcity, preferredcity, rreason, empid from transfer where role= ? OR role=?";
			PreparedStatement ps = con.prepareStatement(insertQuery);
			ps.setString(1, role1);
			ps.setString(2, role2);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
				Transfer transfer = new Transfer();
				transfer.setCurrentCity((rs.getString(1)));
				transfer.setPreferredCity((rs.getString(2)));
				transfer.setReason((rs.getString(3)));
				transfer.setId(rs.getString(4));
				transferDetails.add(transfer);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		}
		return transferDetails;
	}

	public static boolean TransferStatus(String id, String status, String reason) {
		boolean s=false;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con= DriverManager.getConnection(url,username,password);
			String insertQuery="insert into status values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(insertQuery);
			ps.setString(1, status);
			ps.setString(2, reason);
			ps.setString(3, id);
			int  count = ps.executeUpdate();
			if(count > 0)
				s=true;
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		}
		return s;
	}

	public static String ShowStatus(String id) {
		String s = null, r = null, ret = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con= DriverManager.getConnection(url,username,password);
			String insertQuery="Select status, reason from status where id=?";
			PreparedStatement ps = con.prepareStatement(insertQuery);
			ps.setString(1, id);
			ResultSet  rs = ps.executeQuery();
			
			while(rs.next()) {
				
				s = rs.getString(1);
				r = rs.getString(2);
				
			}
			if(s==null) {
				
				ret = "Not decided yet";
				
			}
			else
				ret = s+" "+r;
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		}
		return ret;
	}

	public static boolean UpdateCustomer(Customer customer) {
		boolean status = false;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con= DriverManager.getConnection(url,username,password);
			String insertQuery="update customer set FIRSTNAME = ?, MIDDLENAME = ?, LASTNAME = ?, DOB = ?, GENDER = ?, PERMANENTADDRESS = ?, PRESENTADDRESS = ?, EMAIL = ?, PHONE = ?"
					+ "where id=?";
			PreparedStatement ps = con.prepareStatement(insertQuery);
			ps.setString(1, customer.getFirstName());
			ps.setString(2, customer.getMiddleName());
			ps.setString(3, customer.getLastName());
			java.sql.Date dob = new java.sql.Date(customer.getDate().getTime());
			ps.setDate(4, dob);
			ps.setString(5, customer.getGender());
			ps.setString(6, customer.getPermanantAddress());
			ps.setString(7, customer.getPresentAddress());
			ps.setString(8, customer.getEmail());
			ps.setLong(9, customer.getNumber());
			ps.setString(10, customer.getId());
			int count =ps.executeUpdate();
			
			if(count > 0)
				status = true;
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		}
		return status;
	}

	public static List<Employee> getEmpDetails(String r) {
		List<Employee> employeeDetails = new ArrayList<>();
		Employee employee = new Employee();
		String[] role = r.split("  ");
		String role1 = null, role2 = null;
		if(role.length==2) {
			role2 = role[1];
		}
		role1 = role[0];
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con= DriverManager.getConnection(url,username,password);
			String insertQuery="select * from employee where emprole=? or emprole=?";
			PreparedStatement ps = con.prepareStatement(insertQuery);
			ps.setString(1, role1);
			ps.setString(2, role2);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				//System.out.println("INSIDE");
				employee.setFirstName(rs.getString(1));
				employee.setMiddleName(rs.getString(2));
				employee.setLastName(rs.getString(3));
				employee.setRole(rs.getString(4));
				employee.setType(rs.getString(5));
				employee.setSalary(rs.getFloat(6));
				employee.setDate(rs.getDate(7));
				employee.setCity(rs.getString(8));
				employee.setStatus(rs.getString(9));
				employee.setId(rs.getString(10));
				employeeDetails.add(employee);
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		}
		return employeeDetails;
	}

	public static boolean UpdateEmployee(Employee employee) {
		boolean status = false;
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con= DriverManager.getConnection(url,username,password);
			String insertQuery="UPDATE employee set firstname=?, middlename=?, lastname=?, emprole=?, emptype=?, salary=?, joining=?, city=?, status=? where empid=?";
			
			PreparedStatement ps = con.prepareStatement(insertQuery);
			ps.setString(1, employee.getFirstName());
			ps.setString(2, employee.getMiddleName());
			ps.setString(3, employee.getLastName());
			ps.setString(4, employee.getRole());
			ps.setString(5, employee.getType());
			ps.setFloat(6, employee.getSalary());
			java.sql.Date sqlStartDate = new java.sql.Date(employee.getDate().getTime());
			ps.setDate(7, sqlStartDate);
			ps.setString(8, employee.getCity());
			ps.setString(9, employee.getStatus());
			ps.setString(10, employee.getId());
			
			int count = ps.executeUpdate();
			
			if(count > 0)
				status = true;
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		}
		return status;
	}

	public static boolean EmpValidity(String id, String headrole) {
		boolean valid = false;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con= DriverManager.getConnection(url,username,password);
			String insertQuery="Select emprole from employee where empid=?";
			PreparedStatement ps = con.prepareStatement(insertQuery);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
            String r = null;
			while(rs.next()) {
				
				r = rs.getString(1);
				
			}
			//System.out.println(r);
			 if(headrole.equals("Sales and Marketing Head"))
				 if(r.equals("Delivery Executive") || r.equals("Sales Executive"))
					 valid = true;
				 else if(headrole.equals("Inventory Head"))
					 if(r.equals("Store Keeper"))
						 valid = true;
		}catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		}
			
		return valid;
	}

}
