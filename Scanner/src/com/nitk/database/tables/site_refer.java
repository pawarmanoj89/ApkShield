package com.nitk.database.tables;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.nitk.database.*;

/**
	* <b>Class Name : </b>site_refer</br>
	* <b>Date : </b>Wed Nov 16 02:31:49 GMT+05:30 2011</br>
	* <b>Description  :</b> This class is for database's table site_refer and
	*		this class contain generated methods insert,update,delete,getById,getData</br>
	* <b>Author : </b>DB code generator
*/
public class site_refer {
	private static final String INSERT = "site_referInsert";
	private static final String UPDATE = "site_referUpdate";
	private static final String DELETE = "site_referDelete";
	private static final String GETBYID = "site_referGetById";
	private static final String GETDATA = "site_referGetData";

	public int site_id;
	public String site_name;
	public String url;
	
	public site_refer(){
		site_id = 0;
		site_name = "";
		url = "";
	}


	/**
	* <b>Function Name : </b>insert</br>
	* <b>Description  : </b>This function is for insert value in database table site_refer</br>
	* @param obj is the object of class site_refer and its member will be used for insert in table
	*/
	public static long insert(site_refer obj){
		dbHandler db = null;
		try{
			ArrayList<SqlParameter> sqlparameters = new ArrayList<SqlParameter>();

			sqlparameters.add(new SqlParameter(
					"__site_name",
					obj.site_name,
					ProcedureParameterType.String,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__url",
					obj.url,
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
	* <b>Description  : </b>This function is for update values in database table site_refer</br>
	* @param obj is the object of class site_refer and its members will be used for update table's value
	*/
	public static long update(site_refer obj){
		dbHandler db = null;
		try{
			ArrayList<SqlParameter> sqlparameters = new ArrayList<SqlParameter>();

			sqlparameters.add(new SqlParameter(
					"__site_id",
					obj.site_id,
					ProcedureParameterType.Integer,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__site_name",
					obj.site_name,
					ProcedureParameterType.String,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__url",
					obj.url,
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
	* <b>Description  : </b>This function is for delete values from database table site_refer
	* @param fileid is primary key based on which values will be delete from table site_refer
	*/
	public static long delete(int site_id){
		dbHandler db = null;
		try{
			ArrayList<SqlParameter> sqlparameters = new ArrayList<SqlParameter>();

			sqlparameters.add(new SqlParameter(
					"__site_id",
					site_id,
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
	* <b>Description  : </b>This function is for get object of site_refer for given value of primary key</br>
	* @param fileid is primary key based on which object will be selected from table site_refer
	*/
	public static site_refer getById(int site_id){
		dbHandler db = null;
		try{
			ArrayList<SqlParameter> sqlparameters = new ArrayList<SqlParameter>();

			sqlparameters.add(new SqlParameter(
					"__site_id",
					site_id,
					ProcedureParameterType.Integer,
					ProcedureParameterNature.In));

			db = new dbHandler();
			db.openConnection();
			ResultSet rs = db.callStoredProcedure(GETBYID, sqlparameters);

			site_refer retObj = null;
			if (rs.next()){
				retObj = new site_refer();
				retObj.site_id = rs.getInt("site_id");
				retObj.site_name = rs.getString("site_name");
				retObj.url = rs.getString("url");
				
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
	* <b>Description  : </b>This function is for get list of objects of site_refer for given condition</br>
	* @param sSqlCondition is sql condition based on which list of objects of site_refer wiil be created
	*/
	public static ArrayList<site_refer> getData(String sSqlCondition){
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

			ArrayList<site_refer> liRetList = new ArrayList<site_refer>();
			while (rs.next()){
				site_refer tempObj = new site_refer();
				tempObj.site_id = rs.getInt("site_id");
				tempObj.site_name = rs.getString("site_name");
				tempObj.url = rs.getString("url");
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