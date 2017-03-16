package employee;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import employee.Employee;

public class EmployeeDAO {
	static String dbHost = "localhost";
	static String dbUser = "root";
	static String dbPassword ="";
	static String dbDatabase = "softdev2";
	static String tableName = "employee";
	static String createTableSQL = "create table employee (id BIGINT, name varchar(250), dob timesamp);";

	static String dbURL="jdbc:mysql://"+dbHost+"/"+dbDatabase+"?user="+dbUser+"&password="+dbPassword;

	static boolean databaseSetup = setUpDatabase();
	
	/**
	 * this gets run when the class is first loaded
	 * it registers the driver,
	 * checks the connction and database
	 * and checks that the table exists (create it if it doesn't
	 * @return
	 */
	
	
	static boolean setUpDatabase(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("driver not loaded");
		}	
		Connection connection = null;
		try {
			connection =  DriverManager.getConnection(dbURL);
			// check if the table is there
			String sql = "show tables like ?;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1,tableName);
			ResultSet rs = ps.executeQuery();
			// if we don't get anything then table does not exist so create it
			if (!rs.next()){
				ps = connection.prepareStatement(createTableSQL);
				ps.executeUpdate();
			}
			connection.close();
			return true;
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void create(Employee employee){
		Connection connection = null;
		try {
			connection =  DriverManager.getConnection(dbURL);
			String sql = "insert into employee (id, name, dob) values (?,?,?);";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setLong(1,employee.getId());
			ps.setString(2,employee.getName());
			ps.setDate(3, new java.sql.Date(employee.getDob().getTime()));
				ps.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void update(Employee employee){
		Connection connection = null;
		try {
			connection =  DriverManager.getConnection(dbURL);
			String sql = "update employee set name= ?, dob=? where id =?;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setLong(3,employee.getId());
			ps.setString(1,employee.getName());
			ps.setTimestamp(2, new java.sql.Timestamp(employee.getDob().getTime()));
			
			ps.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	public void delete(long id){
		Connection connection = null;
		try {
			connection =  DriverManager.getConnection(dbURL);
			String sql = "delete from employee  where id =?;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setLong(1,id);
			ps.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	public Employee findById(long id){
		Connection connection = null;
		Employee employee = null;
		try {
			connection =  DriverManager.getConnection(dbURL);
			String sql = "select * from employee  where id =?;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setLong(1,id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()){
				employee = new Employee();
				employee.setId(rs.getLong("id"));
				employee.setName(rs.getString("name"));
				employee.setDob(rs.getTimestamp("dob"));
				}
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return employee;
	}
	public List<Employee> getAll(){
		Connection connection = null;
		List<Employee> employees = new ArrayList<Employee>();
		try {
			connection =  DriverManager.getConnection(dbURL);
			String sql = "select * from employee ;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				Employee employee = new Employee();
				employee = new Employee();
				employee.setId(rs.getLong("id"));
				employee.setName(rs.getString("name"));
				employee.setDob(rs.getTimestamp("dob"));
				
				employees.add(employee);
				}
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return employees;
	}
	
	

}
