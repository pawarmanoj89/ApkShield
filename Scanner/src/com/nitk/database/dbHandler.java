package com.nitk.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.CallableStatement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;


public class dbHandler {
	private String driverName = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://10.100.42.99/apkshielddb?user=root&password=root";
	
	private Connection connect = null;
	
	public void openConnection()
	{
		try 
		{
			Class.forName(driverName);
			connect = DriverManager.getConnection(url);
		} 
		catch (ClassNotFoundException e) {e.printStackTrace();}
		catch (SQLException e) {e.printStackTrace();}
	}

	public void closeConnection()
	{
		try 
		{
			if (!connect.isClosed())
				connect.close();
		} 
		catch (SQLException e) {e.printStackTrace();}
	}
	public ResultSet executeQuery(String sSqlString)
	{
		try {
			Statement statement = connect.createStatement();
			return statement.executeQuery(sSqlString);
		} catch (SQLException e) {
			e.printStackTrace();
				return null;
		}
	}
	public ResultSet callStoredProcedure(String sProcedureName,ArrayList<SqlParameter> sqlParameters)
	{
		try {
			String str = "";
			if (sqlParameters != null){
				for (int i = 1;i<=sqlParameters.size();i++){
					if (str == "")
						str = "?";
					else
						str = str + ",?";
				}
			}
			String procedureCall = "{call "+sProcedureName+"("+str+")}";
			CallableStatement procStatement;
		
				procStatement = connect.prepareCall(procedureCall);
	
			
			for (SqlParameter par:sqlParameters){
				
				switch (par.ParameterType) {
				
				case String:
					procStatement.setString(par.ParameterName, String.valueOf(par.ParameterValue));
					if (par.ParameterNature == ProcedureParameterNature.Out)
						procStatement.registerOutParameter(par.ParameterName, java.sql.Types.VARCHAR);
					break;
				case Integer:
					procStatement.setInt(par.ParameterName, (Integer)par.ParameterValue);
					if (par.ParameterNature == ProcedureParameterNature.Out)
						procStatement.registerOutParameter(par.ParameterName, java.sql.Types.INTEGER);
					break;
				case Double:
					procStatement.setDouble(par.ParameterName, (Double)par.ParameterValue);
					if (par.ParameterNature == ProcedureParameterNature.Out)
						procStatement.registerOutParameter(par.ParameterName, java.sql.Types.DOUBLE);
					break;
				case Long:
					procStatement.setLong(par.ParameterName, (Long)par.ParameterValue);
					if (par.ParameterNature == ProcedureParameterNature.Out)
						procStatement.registerOutParameter(par.ParameterName, java.sql.Types.INTEGER);
					break;
				case Bool:
					procStatement.setBoolean(par.ParameterName, (Boolean)par.ParameterValue);
					if (par.ParameterNature == ProcedureParameterNature.Out)
						procStatement.registerOutParameter(par.ParameterName, java.sql.Types.BOOLEAN);
					break;
				case Date:
					procStatement.setDate(par.ParameterName, (Date)par.ParameterValue);
					if (par.ParameterNature == ProcedureParameterNature.Out)
						procStatement.registerOutParameter(par.ParameterName, java.sql.Types.DATE);
					break;
				case Time:
					procStatement.setTime(par.ParameterName, (Time)(par.ParameterValue));
					if (par.ParameterNature == ProcedureParameterNature.Out)
						procStatement.registerOutParameter(par.ParameterName, java.sql.Types.TIME);
					break;
				case TimeStamp:
					procStatement.setTimestamp(par.ParameterName, (Timestamp)(par.ParameterValue));
					if (par.ParameterNature == ProcedureParameterNature.Out)
						procStatement.registerOutParameter(par.ParameterName, java.sql.Types.TIMESTAMP);
					break;
					
				}	
			}
			ResultSet resultSet = procStatement.executeQuery();
			return resultSet;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
