package jsp_employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jsp_employee.EmployeeInfo;

public class EmployeeCRUD {

	public Connection getConnection() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspdb", "root", "root");
		return connection;
	}
	
	public int signUp(EmployeeInfo employeeInfo) throws Exception
	{
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("insert into empinfo values (?,?,?,?,?,?)");
		preparedStatement.setInt(1, employeeInfo.getId());
		preparedStatement.setString(2, employeeInfo.getName());
		preparedStatement.setLong(3, employeeInfo.getPhone());
		preparedStatement.setString(4, employeeInfo.getAddress());
		preparedStatement.setString(5, employeeInfo.getEmail());
		preparedStatement.setString(6, employeeInfo.getPassword());
		
		int result = preparedStatement.executeUpdate();
		connection.close();
		return result;
		
	}
	
	public String login(String email) throws Exception
	{
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select password from empinfo where email=?");
		preparedStatement.setString(1, email);
		
		String password = null;
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next())
		{
			password = resultSet.getString("password");
		}
		connection.close();
		return password;
	}
	
	public List<EmployeeInfo> getEmployeeDetails() throws Exception
	{
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from empinfo");
		ResultSet resultSet = preparedStatement.executeQuery();
		List<EmployeeInfo> emp = new ArrayList<>();
		while(resultSet.next())
		{
			EmployeeInfo employeeInfo = new EmployeeInfo();
			
			employeeInfo.setId(resultSet.getInt("id"));
			employeeInfo.setName(resultSet.getString("name"));
			employeeInfo.setPhone(resultSet.getLong("phone"));
			employeeInfo.setAddress(resultSet.getString("address"));
			employeeInfo.setEmail(resultSet.getString("email"));
			employeeInfo.setPassword(resultSet.getString("password"));
			
			emp.add(employeeInfo);
		}
		connection.close();
		return emp;
	}
	

	public List<EmployeeInfo> getEmployeeDetails(int id) throws Exception
	{
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from empinfo where id=?");
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		List<EmployeeInfo> emp = new ArrayList<>();
		while(resultSet.next())
		{
			EmployeeInfo employeeInfo = new EmployeeInfo();
			
			employeeInfo.setId(resultSet.getInt("id"));
			employeeInfo.setName(resultSet.getString("name"));
			employeeInfo.setPhone(resultSet.getLong("phone"));
			employeeInfo.setAddress(resultSet.getString("address"));
			employeeInfo.setEmail(resultSet.getString("email"));
			employeeInfo.setPassword(resultSet.getString("password"));
			
			emp.add(employeeInfo);
		}
		connection.close();
		return emp;
	}

	public int deleteEmployeeDetails(int id) throws Exception
	{
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("delete from empinfo where id=?");
		preparedStatement.setInt(1, id);
		int resultSet = preparedStatement.executeUpdate();
	
		connection.close();
		return resultSet;
	}
	
	public int updateEmployeeDetails(EmployeeInfo employeeInfo) throws Exception
	{
		
		Connection connection = getConnection();
		int id = employeeInfo.getId();
		PreparedStatement preparedStatement = connection.prepareStatement("update empinfo set name = ?, phone = ?, address = ?, email=?, password=? where id=?");
		preparedStatement.setInt(6, id);
		preparedStatement.setString(1, employeeInfo.getName());
		preparedStatement.setLong(2, employeeInfo.getPhone());
		preparedStatement.setString(3, employeeInfo.getAddress());
		preparedStatement.setString(4, employeeInfo.getEmail());
		preparedStatement.setString(5, employeeInfo.getPassword());
		
		int result = preparedStatement.executeUpdate();
		
		connection.close();
		return result;
		
	}
	
}
