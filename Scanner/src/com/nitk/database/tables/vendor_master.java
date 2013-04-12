package com.nitk.database.tables;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.nitk.database.*;

/**
	* <b>Class Name : </b>vendor_master</br>
	* <b>Date : </b>Wed Nov 16 02:32:21 GMT+05:30 2011</br>
	* <b>Description  :</b> This class is for database's table vendor_master and
	*		this class contain generated methods insert,update,delete,getById,getData</br>
	* <b>Author : </b>DB code generator
*/
public class vendor_master {
	private static final String INSERT = "vendor_masterInsert";
	private static final String UPDATE = "vendor_masterUpdate";
	private static final String DELETE = "vendor_masterDelete";
	private static final String GETBYID = "vendor_masterGetById";
	private static final String GETDATA = "vendor_masterGetData";

	public int vendor_id;
	public String vender_name;
	public String email_id;
	
	public vendor_master(){
		vendor_id = 0;
		vender_name = "";
		email_id = "";
	}


	/**
	* <b>Function Name : </b>insert</br>
	* <b>Description  : </b>This function is for insert value in database table vendor_master</br>
	* @param obj is the object of class vendor_master and its member will be used for insert in table
	*/
	public static long insert(vendor_master obj){
		dbHandler db = null;
		try{
			ArrayList<SqlParameter> sqlparameters = new ArrayList<SqlParameter>();

			sqlparameters.add(new SqlParameter(
					"__vender_name",
					obj.vender_name,
					ProcedureParameterType.String,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__email_id",
					obj.email_id,
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
	* <b>Description  : </b>This function is for update values in database table vendor_master</br>
	* @param obj is the object of class vendor_master and its members will be used for update table's value
	*/
	public static long update(vendor_master obj){
		dbHandler db = null;
		try{
			ArrayList<SqlParameter> sqlparameters = new ArrayList<SqlParameter>();

			sqlparameters.add(new SqlParameter(
					"__vendor_id",
					obj.vendor_id,
					ProcedureParameterType.Integer,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__vender_name",
					obj.vender_name,
					ProcedureParameterType.String,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__email_id",
					obj.email_id,
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
	* <b>Description  : </b>This function is for delete values from database table vendor_master
	* @param fileid is primary key based on which values will be delete from table vendor_master
	*/
	public static long delete(int vendor_id){
		dbHandler db = null;
		try{
			ArrayList<SqlParameter> sqlparameters = new ArrayList<SqlParameter>();

			sqlparameters.add(new SqlParameter(
					"__vendor_id",
					vendor_id,
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
	* <b>Description  : </b>This function is for get object of vendor_master for given value of primary key</br>
	* @param fileid is primary key based on which object will be selected from table vendor_master
	*/
	public static vendor_master getById(int vendor_id){
		dbHandler db = null;
		try{
			ArrayList<SqlParameter> sqlparameters = new ArrayList<SqlParameter>();

			sqlparameters.add(new SqlParameter(
					"__vendor_id",
					vendor_id,
					ProcedureParameterType.Integer,
					ProcedureParameterNature.In));

			db = new dbHandler();
			db.openConnection();
			ResultSet rs = db.callStoredProcedure(GETBYID, sqlparameters);

			vendor_master retObj = null;
			if (rs.next()){
				retObj = new vendor_master();
				retObj.vendor_id = rs.getInt("vendor_id");
				retObj.vender_name = rs.getString("vender_name");
				retObj.email_id = rs.getString("email_id");
				
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
	* <b>Description  : </b>This function is for get list of objects of vendor_master for given condition</br>
	* @param sSqlCondition is sql condition based on which list of objects of vendor_master wiil be created
	*/
	public static ArrayList<vendor_master> getData(String sSqlCondition){
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

			ArrayList<vendor_master> liRetList = new ArrayList<vendor_master>();
			while (rs.next()){
				vendor_master tempObj = new vendor_master();
				tempObj.vendor_id = rs.getInt("vendor_id");
				tempObj.vender_name = rs.getString("vender_name");
				tempObj.email_id = rs.getString("email_id");
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