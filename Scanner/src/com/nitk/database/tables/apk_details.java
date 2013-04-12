package com.nitk.database.tables;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Hashtable;

import com.nitk.database.*;

/**
	* <b>Class Name : </b>apk_details</br>
	* <b>Date : </b>Wed Nov 16 02:44:54 GMT+05:30 2011</br>
	* <b>Description  :</b> This class is for database's table apk_details and
	*		this class contain generated methods insert,update,delete,getById,getData</br>
	* <b>Author : </b>DB code generator
*/
public class apk_details {
	private static final String INSERT = "apk_detailsInsert";
	private static final String UPDATE = "apk_detailsUpdate";
	private static final String DELETE = "apk_detailsDelete";
	private static final String GETBYID = "apk_detailsGetById";
	private static final String GETDATA = "apk_detailsGetData";
	private static final String GETSUBREPORT = "getSubmissionReport";

	public int apk_id;
	public String apk_name;
	public Date first_scan;
	public Date last_scan;
	public String file_pointer;
	public int last_count;
	public int yesterdays_count;
	public int current_count;
	public int scan_status;
	public String md5;
	
	public apk_details(){
		apk_id = 0;
		apk_name = "";
		first_scan = null;
		last_scan = null;
		file_pointer = "";
		last_count = 0;
		yesterdays_count = 0;
		current_count = 0;
		scan_status = 0;
		md5 = "";
	}


	/**
	* <b>Function Name : </b>insert</br>
	* <b>Description  : </b>This function is for insert value in database table apk_details</br>
	* @param obj is the object of class apk_details and its member will be used for insert in table
	*/
	public static long insert(apk_details obj){
		dbHandler db = null;
		try{
			ArrayList<SqlParameter> sqlparameters = new ArrayList<SqlParameter>();

			sqlparameters.add(new SqlParameter(
					"__apk_name",
					obj.apk_name,
					ProcedureParameterType.String,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__first_scan",
					obj.first_scan,
					ProcedureParameterType.Date,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__last_scan",
					obj.last_scan,
					ProcedureParameterType.Date,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__file_pointer",
					obj.file_pointer,
					ProcedureParameterType.String,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__last_count",
					obj.last_count,
					ProcedureParameterType.Integer,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__yesterdays_count",
					obj.yesterdays_count,
					ProcedureParameterType.Integer,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__current_count",
					obj.current_count,
					ProcedureParameterType.Integer,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__scan_status",
					obj.scan_status,
					ProcedureParameterType.Integer,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__md5",
					obj.md5,
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
	* <b>Description  : </b>This function is for update values in database table apk_details</br>
	* @param obj is the object of class apk_details and its members will be used for update table's value
	*/
	public static long update(apk_details obj){
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
					"__first_scan",
					obj.first_scan,
					ProcedureParameterType.Date,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__last_scan",
					obj.last_scan,
					ProcedureParameterType.Date,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__file_pointer",
					obj.file_pointer,
					ProcedureParameterType.String,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__last_count",
					obj.last_count,
					ProcedureParameterType.Integer,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__yesterdays_count",
					obj.yesterdays_count,
					ProcedureParameterType.Integer,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__current_count",
					obj.current_count,
					ProcedureParameterType.Integer,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__scan_status",
					obj.scan_status,
					ProcedureParameterType.Integer,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__md5",
					obj.md5,
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
	* <b>Description  : </b>This function is for delete values from database table apk_details
	* @param fileid is primary key based on which values will be delete from table apk_details
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
	* <b>Description  : </b>This function is for get object of apk_details for given value of primary key</br>
	* @param fileid is primary key based on which object will be selected from table apk_details
	*/
	public static apk_details getById(int apk_id){
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

			apk_details retObj = null;
			if (rs.next()){
				retObj = new apk_details();
				retObj.apk_id = rs.getInt("apk_id");
				retObj.apk_name = rs.getString("apk_name");
				retObj.first_scan = rs.getDate("first_scan");
				retObj.last_scan = rs.getDate("last_scan");
				retObj.file_pointer = rs.getString("file_pointer");
				retObj.last_count = rs.getInt("last_count");
				retObj.yesterdays_count = rs.getInt("yesterdays_count");
				retObj.current_count = rs.getInt("current_count");
				retObj.scan_status = rs.getInt("scan_status");
				retObj.md5 = rs.getString("md5");
				
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
	* <b>Description  : </b>This function is for get list of objects of apk_details for given condition</br>
	* @param sSqlCondition is sql condition based on which list of objects of apk_details wiil be created
	*/
	public static ArrayList<apk_details> getData(String sSqlCondition){
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

			ArrayList<apk_details> liRetList = new ArrayList<apk_details>();
			while (rs.next()){
				apk_details tempObj = new apk_details();
				tempObj.apk_id = rs.getInt("apk_id");
				tempObj.apk_name = rs.getString("apk_name");
				tempObj.first_scan = rs.getDate("first_scan");
				tempObj.last_scan = rs.getDate("last_scan");
				tempObj.file_pointer = rs.getString("file_pointer");
				tempObj.last_count = rs.getInt("last_count");
				tempObj.yesterdays_count = rs.getInt("yesterdays_count");
				tempObj.current_count = rs.getInt("current_count");
				tempObj.scan_status = rs.getInt("scan_status");
				tempObj.md5 = rs.getString("md5");
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
	
	/**
	* <b>Function Name : </b>getSubmissionReport</br>
	* <b>Description  : </b>This function is for get file submission report</br>
	* @param day is date for which you want report
	*/
	public static Hashtable<String, Integer> getSubmissionReport(java.util.Date day){
		try{
			ArrayList<SqlParameter> sqlparameters = new ArrayList<SqlParameter>();

			sqlparameters.add(new SqlParameter(
					"__day",
					new Date(day.getTime()),
					ProcedureParameterType.Date,
					ProcedureParameterNature.In));

			dbHandler db = new dbHandler();
			db.openConnection();
			ResultSet rs = db.callStoredProcedure(GETSUBREPORT, sqlparameters);

			Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
			if (rs.next()){
				ht.put("TotalAnalyzed", rs.getInt("totalAnalyzed"));
				ht.put("NewAnalyzed", rs.getInt("newAnalyzed"));
				ht.put("TotalDetected", rs.getInt("totalDetected"));
				ht.put("NewDetected", rs.getInt("newDetected"));
			}
			rs.close();
			db.closeConnection();
			return ht;
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}
}