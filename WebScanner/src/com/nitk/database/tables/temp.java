package com.nitk.database.tables;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.nitk.database.*;

/**
	* <b>Class Name : </b>temp</br>
	* <b>Date : </b>Wed Nov 16 01:15:55 GMT+05:30 2011</br>
	* <b>Description  :</b> This class is for database's table temp and
	*		this class contain generated methods insert,update,delete,getById,getData</br>
	* <b>Author : </b>DB code generator
*/
public class temp {
	private static final String INSERT = "tempInsert";
	private static final String UPDATE = "tempUpdate";
	private static final String DELETE = "tempDelete";
	private static final String GETBYID = "tempGetById";
	private static final String GETDATA = "tempGetData";

	public int id;
	public String name;
	public Date bdate;
	public int status;
	
	public temp(){
		id = 0;
		name = "";
		bdate = null;
		status = 0;
	}


	/**
	* <b>Function Name : </b>insert</br>
	* <b>Description  : </b>This function is for insert value in database table temp</br>
	* @param obj is the object of class temp and its member will be used for insert in table
	*/
	public static long insert(temp obj){
		dbHandler db = null;
		try{
			ArrayList<SqlParameter> sqlparameters = new ArrayList<SqlParameter>();

			sqlparameters.add(new SqlParameter(
					"__name",
					obj.name,
					ProcedureParameterType.String,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__bdate",
					obj.bdate,
					ProcedureParameterType.Date,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__status",
					obj.status,
					ProcedureParameterType.Integer,
					ProcedureParameterNature.In));

			db = new dbHandler();
			db.openConnection();
			ResultSet rs = db.callStoredProcedure(INSERT, sqlparameters);
			int iReturnValue = 0;
			if (rs.first())
				iReturnValue = rs.getInt("iReturnValue");
			rs.close();
			db.closeConnection();

			return iReturnValue;
		}catch (Exception e){
			e.printStackTrace();
			return 0;
		}
		finally{
			if (db != null)
				db.closeConnection();
		}
	}

	/**
	* <b>Function Name : </b>update</br>
	* <b>Description  : </b>This function is for update values in database table temp</br>
	* @param obj is the object of class temp and its members will be used for update table's value
	*/
	public static long update(temp obj){
		dbHandler db = null;
		try{
			ArrayList<SqlParameter> sqlparameters = new ArrayList<SqlParameter>();

			sqlparameters.add(new SqlParameter(
					"__id",
					obj.id,
					ProcedureParameterType.Integer,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__name",
					obj.name,
					ProcedureParameterType.String,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__bdate",
					obj.bdate,
					ProcedureParameterType.Date,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__status",
					obj.status,
					ProcedureParameterType.Integer,
					ProcedureParameterNature.In));

			db = new dbHandler();
			db.openConnection();
			ResultSet rs =db.callStoredProcedure(UPDATE, sqlparameters);
			int iReturnValue = 0;
			if (rs.first())
				iReturnValue = rs.getInt("iReturnValue");
			rs.close();
			db.closeConnection();

			return iReturnValue;
		}catch (Exception e){
			e.printStackTrace();
			return 0;
		}
		finally{
			if (db != null)
				db.closeConnection();
		}
	}

	/**
	* <b>Function Name : </b>delete</br>
	* <b>Description  : </b>This function is for delete values from database table temp
	* @param fileid is primary key based on which values will be delete from table temp
	*/
	public static long delete(int id){
		dbHandler db = null;
		try{
			ArrayList<SqlParameter> sqlparameters = new ArrayList<SqlParameter>();

			sqlparameters.add(new SqlParameter(
					"__id",
					id,
					ProcedureParameterType.Integer,
					ProcedureParameterNature.In));

			db = new dbHandler();
			db.openConnection();
			ResultSet rs =db.callStoredProcedure(DELETE, sqlparameters);
			int iReturnValue = 0;
			if (rs.first())
				iReturnValue = rs.getInt("iReturnValue");
			rs.close();
			db.closeConnection();

			return iReturnValue;
		}catch (Exception e){
			e.printStackTrace();
			return 0;
		}
		finally{
			if (db != null)
				db.closeConnection();
		}
	}

	/**
	* <b>Function Name : </b>getById</br>
	* <b>Description  : </b>This function is for get object of temp for given value of primary key</br>
	* @param fileid is primary key based on which object will be selected from table temp
	*/
	public static temp getById(int id){
		dbHandler db = null;
		try{
			ArrayList<SqlParameter> sqlparameters = new ArrayList<SqlParameter>();

			sqlparameters.add(new SqlParameter(
					"__id",
					id,
					ProcedureParameterType.Integer,
					ProcedureParameterNature.In));

			db = new dbHandler();
			db.openConnection();
			ResultSet rs = db.callStoredProcedure(GETBYID, sqlparameters);

			temp retObj = null;
			if (rs.next()){
				retObj = new temp();
				retObj.id = rs.getInt("id");
				retObj.name = rs.getString("name");
				retObj.bdate = rs.getDate("bdate");
				retObj.status = rs.getInt("status");
				
			}
			rs.close();
			db.closeConnection();
			return retObj;
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
		finally{
			if (db != null)
				db.closeConnection();
		}
	}

	/**
	* <b>Function Name : </b>getData</br>
	* <b>Description  : </b>This function is for get list of objects of temp for given condition</br>
	* @param sSqlCondition is sql condition based on which list of objects of temp wiil be created
	*/
	public static ArrayList<temp> getData(String sSqlCondition){
		dbHandler db = null;
		try{
			ArrayList<SqlParameter> sqlparameters = new ArrayList<SqlParameter>();

			sqlparameters.add(new SqlParameter(
					"__sqlCondition",
					sSqlCondition,
					ProcedureParameterType.String,
					ProcedureParameterNature.In));

			db = new dbHandler();
			db.openConnection();
			ResultSet rs = db.callStoredProcedure(GETDATA, sqlparameters);

			ArrayList<temp> liRetList = new ArrayList<temp>();
			while (rs.next()){
				temp tempObj = new temp();
				tempObj.id = rs.getInt("id");
				tempObj.name = rs.getString("name");
				tempObj.bdate = rs.getDate("bdate");
				tempObj.status = rs.getInt("status");
				liRetList.add(tempObj);
			}
			rs.close();
			db.closeConnection();
			return liRetList;
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
		finally{
			if (db != null)
				db.closeConnection();
		}
	}
}