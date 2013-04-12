package com.nitk.database.tables;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.nitk.database.*;

/**
	* <b>Class Name : </b>admin_master</br>
	* <b>Date : </b>Wed Nov 16 02:01:43 GMT+05:30 2011</br>
	* <b>Description  :</b> This class is for database's table admin_master and
	*		this class contain generated methods insert,update,delete,getById,getData</br>
	* <b>Author : </b>DB code generator
*/
public class admin_master {
	private static final String INSERT = "admin_masterInsert";
	private static final String UPDATE = "admin_masterUpdate";
	private static final String DELETE = "admin_masterDelete";
	private static final String GETBYID = "admin_masterGetById";
	private static final String GETDATA = "admin_masterGetData";

	public String admin_name;
	public String password;
	
	public admin_master(){
		admin_name = "";
		password = "";
	}


	/**
	* <b>Function Name : </b>insert</br>
	* <b>Description  : </b>This function is for insert value in database table admin_master</br>
	* @param obj is the object of class admin_master and its member will be used for insert in table
	*/
	public static long insert(admin_master obj){
		dbHandler db = null;
		try{
			ArrayList<SqlParameter> sqlparameters = new ArrayList<SqlParameter>();

			sqlparameters.add(new SqlParameter(
					"__admin_name",
					obj.admin_name,
					ProcedureParameterType.String,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__password",
					obj.password,
					ProcedureParameterType.String,
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
	* <b>Description  : </b>This function is for update values in database table admin_master</br>
	* @param obj is the object of class admin_master and its members will be used for update table's value
	*/
	public static long update(admin_master obj){
		dbHandler db = null;
		try{
			ArrayList<SqlParameter> sqlparameters = new ArrayList<SqlParameter>();

			sqlparameters.add(new SqlParameter(
					"__admin_name",
					obj.admin_name,
					ProcedureParameterType.String,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__password",
					obj.password,
					ProcedureParameterType.String,
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
	* <b>Description  : </b>This function is for delete values from database table admin_master
	* @param fileid is primary key based on which values will be delete from table admin_master
	*/
	public static long delete(String admin_name){
		dbHandler db = null;
		try{
			ArrayList<SqlParameter> sqlparameters = new ArrayList<SqlParameter>();

			sqlparameters.add(new SqlParameter(
					"__admin_name",
					admin_name,
					ProcedureParameterType.String,
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
	* <b>Description  : </b>This function is for get object of admin_master for given value of primary key</br>
	* @param fileid is primary key based on which object will be selected from table admin_master
	*/
	public static admin_master getById(String admin_name){
		dbHandler db = null;
		try{
			ArrayList<SqlParameter> sqlparameters = new ArrayList<SqlParameter>();

			sqlparameters.add(new SqlParameter(
					"__admin_name",
					admin_name,
					ProcedureParameterType.String,
					ProcedureParameterNature.In));

			db = new dbHandler();
			db.openConnection();
			ResultSet rs = db.callStoredProcedure(GETBYID, sqlparameters);

			admin_master retObj = null;
			if (rs.next()){
				retObj = new admin_master();
				retObj.admin_name = rs.getString("admin_name");
				retObj.password = rs.getString("password");
				
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
	* <b>Description  : </b>This function is for get list of objects of admin_master for given condition</br>
	* @param sSqlCondition is sql condition based on which list of objects of admin_master wiil be created
	*/
	public static ArrayList<admin_master> getData(String sSqlCondition){
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

			ArrayList<admin_master> liRetList = new ArrayList<admin_master>();
			while (rs.next()){
				admin_master tempObj = new admin_master();
				tempObj.admin_name = rs.getString("admin_name");
				tempObj.password = rs.getString("password");
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