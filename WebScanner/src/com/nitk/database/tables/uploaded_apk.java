package com.nitk.database.tables;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.nitk.database.*;

/**
	* <b>Class Name : </b>uploaded_apk</br>
	* <b>Date : </b>Wed Nov 16 15:11:07 GMT+05:30 2011</br>
	* <b>Description  :</b> This class is for database's table uploaded_apk and
	*		this class contain generated methods insert,update,delete,getById,getData</br>
	* <b>Author : </b>DB code generator
*/
public class uploaded_apk {
	private static final String INSERT = "uploaded_apkInsert";
	private static final String UPDATE = "uploaded_apkUpdate";
	private static final String DELETE = "uploaded_apkDelete";
	private static final String GETBYID = "uploaded_apkGetById";
	private static final String GETDATA = "uploaded_apkGetData";

	public int apk_id;
	public String apk_name;
	public Date timestamp;
	public String file_path;
	public int checked;
	
	public uploaded_apk(){
		apk_id = 0;
		apk_name = "";
		timestamp = null;
		file_path = "";
		checked = 0;
	}


	/**
	* <b>Function Name : </b>insert</br>
	* <b>Description  : </b>This function is for insert value in database table uploaded_apk</br>
	* @param obj is the object of class uploaded_apk and its member will be used for insert in table
	*/
	public static long insert(uploaded_apk obj){
		dbHandler db = null;
		try{
			ArrayList<SqlParameter> sqlparameters = new ArrayList<SqlParameter>();

			sqlparameters.add(new SqlParameter(
					"__apk_name",
					obj.apk_name,
					ProcedureParameterType.String,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__timestamp",
					obj.timestamp,
					ProcedureParameterType.Date,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__file_path",
					obj.file_path,
					ProcedureParameterType.String,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__checked",
					obj.checked,
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
	* <b>Description  : </b>This function is for update values in database table uploaded_apk</br>
	* @param obj is the object of class uploaded_apk and its members will be used for update table's value
	*/
	public static long update(uploaded_apk obj){
		dbHandler db = null;
		try{
			ArrayList<SqlParameter> sqlparameters = new ArrayList<SqlParameter>();

			sqlparameters.add(new SqlParameter(
					"__apk_id",
					obj.apk_id,
					ProcedureParameterType.Integer,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__apk_name",
					obj.apk_name,
					ProcedureParameterType.String,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__timestamp",
					obj.timestamp,
					ProcedureParameterType.Date,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__file_path",
					obj.file_path,
					ProcedureParameterType.String,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__checked",
					obj.checked,
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
	* <b>Description  : </b>This function is for delete values from database table uploaded_apk
	* @param fileid is primary key based on which values will be delete from table uploaded_apk
	*/
	public static long delete(int apk_id){
		dbHandler db = null;
		try{
			ArrayList<SqlParameter> sqlparameters = new ArrayList<SqlParameter>();

			sqlparameters.add(new SqlParameter(
					"__apk_id",
					apk_id,
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
	* <b>Description  : </b>This function is for get object of uploaded_apk for given value of primary key</br>
	* @param fileid is primary key based on which object will be selected from table uploaded_apk
	*/
	public static uploaded_apk getById(int apk_id){
		dbHandler db = null;
		try{
			ArrayList<SqlParameter> sqlparameters = new ArrayList<SqlParameter>();

			sqlparameters.add(new SqlParameter(
					"__apk_id",
					apk_id,
					ProcedureParameterType.Integer,
					ProcedureParameterNature.In));

			db = new dbHandler();
			db.openConnection();
			ResultSet rs = db.callStoredProcedure(GETBYID, sqlparameters);

			uploaded_apk retObj = null;
			if (rs.next()){
				retObj = new uploaded_apk();
				retObj.apk_id = rs.getInt("apk_id");
				retObj.apk_name = rs.getString("apk_name");
				retObj.timestamp = rs.getDate("timestamp");
				retObj.file_path = rs.getString("file_path");
				retObj.checked = rs.getInt("checked");
				
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
	* <b>Description  : </b>This function is for get list of objects of uploaded_apk for given condition</br>
	* @param sSqlCondition is sql condition based on which list of objects of uploaded_apk wiil be created
	*/
	public static ArrayList<uploaded_apk> getData(String sSqlCondition){
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

			ArrayList<uploaded_apk> liRetList = new ArrayList<uploaded_apk>();
			while (rs.next()){
				uploaded_apk tempObj = new uploaded_apk();
				tempObj.apk_id = rs.getInt("apk_id");
				tempObj.apk_name = rs.getString("apk_name");
				tempObj.timestamp = rs.getDate("timestamp");
				tempObj.file_path = rs.getString("file_path");
				tempObj.checked = rs.getInt("checked");
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