package com.nitk.database.tables;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.nitk.database.*;

/**
	* <b>Class Name : </b>antivirus_master</br>
	* <b>Date : </b>Wed Nov 16 02:08:41 GMT+05:30 2011</br>
	* <b>Description  :</b> This class is for database's table antivirus_master and
	*		this class contain generated methods insert,update,delete,getById,getData</br>
	* <b>Author : </b>DB code generator
*/
public class antivirus_master {
	private static final String INSERT = "antivirus_masterInsert";
	private static final String UPDATE = "antivirus_masterUpdate";
	private static final String DELETE = "antivirus_masterDelete";
	private static final String GETBYID = "antivirus_masterGetById";
	private static final String GETDATA = "antivirus_masterGetData";

	public int antivirus_id;
	public String antivirus_name;
	public String version_no;
	public int vendor_id;
	
	public antivirus_master(){
		antivirus_id = 0;
		antivirus_name = "";
		version_no = "";
		vendor_id = 0;
	}


	/**
	* <b>Function Name : </b>insert</br>
	* <b>Description  : </b>This function is for insert value in database table antivirus_master</br>
	* @param obj is the object of class antivirus_master and its member will be used for insert in table
	*/
	public static long insert(antivirus_master obj){
		dbHandler db = null;
		try{
			ArrayList<SqlParameter> sqlparameters = new ArrayList<SqlParameter>();

			sqlparameters.add(new SqlParameter(
					"__antivirus_name",
					obj.antivirus_name,
					ProcedureParameterType.String,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__version_no",
					obj.version_no,
					ProcedureParameterType.String,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__vendor_id",
					obj.vendor_id,
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
	* <b>Description  : </b>This function is for update values in database table antivirus_master</br>
	* @param obj is the object of class antivirus_master and its members will be used for update table's value
	*/
	public static long update(antivirus_master obj){
		dbHandler db = null;
		try{
			ArrayList<SqlParameter> sqlparameters = new ArrayList<SqlParameter>();

			sqlparameters.add(new SqlParameter(
					"__antivirus_id",
					obj.antivirus_id,
					ProcedureParameterType.Integer,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__antivirus_name",
					obj.antivirus_name,
					ProcedureParameterType.String,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__version_no",
					obj.version_no,
					ProcedureParameterType.String,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__vendor_id",
					obj.vendor_id,
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
	* <b>Description  : </b>This function is for delete values from database table antivirus_master
	* @param fileid is primary key based on which values will be delete from table antivirus_master
	*/
	public static long delete(int antivirus_id){
		dbHandler db = null;
		try{
			ArrayList<SqlParameter> sqlparameters = new ArrayList<SqlParameter>();

			sqlparameters.add(new SqlParameter(
					"__antivirus_id",
					antivirus_id,
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
	* <b>Description  : </b>This function is for get object of antivirus_master for given value of primary key</br>
	* @param fileid is primary key based on which object will be selected from table antivirus_master
	*/
	public static antivirus_master getById(int antivirus_id){
		dbHandler db = null;
		try{
			ArrayList<SqlParameter> sqlparameters = new ArrayList<SqlParameter>();

			sqlparameters.add(new SqlParameter(
					"__antivirus_id",
					antivirus_id,
					ProcedureParameterType.Integer,
					ProcedureParameterNature.In));

			db = new dbHandler();
			db.openConnection();
			ResultSet rs = db.callStoredProcedure(GETBYID, sqlparameters);

			antivirus_master retObj = null;
			if (rs.next()){
				retObj = new antivirus_master();
				retObj.antivirus_id = rs.getInt("antivirus_id");
				retObj.antivirus_name = rs.getString("antivirus_name");
				retObj.version_no = rs.getString("version_no");
				retObj.vendor_id = rs.getInt("vendor_id");
				
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
	* <b>Description  : </b>This function is for get list of objects of antivirus_master for given condition</br>
	* @param sSqlCondition is sql condition based on which list of objects of antivirus_master wiil be created
	*/
	public static ArrayList<antivirus_master> getData(String sSqlCondition){
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

			ArrayList<antivirus_master> liRetList = new ArrayList<antivirus_master>();
			while (rs.next()){
				antivirus_master tempObj = new antivirus_master();
				tempObj.antivirus_id = rs.getInt("antivirus_id");
				tempObj.antivirus_name = rs.getString("antivirus_name");
				tempObj.version_no = rs.getString("version_no");
				tempObj.vendor_id = rs.getInt("vendor_id");
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