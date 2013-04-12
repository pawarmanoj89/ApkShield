package com.nitk.database.tables;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.nitk.database.*;

/**
	* <b>Class Name : </b>link_within_dns</br>
	* <b>Date : </b>Wed Nov 16 02:29:29 GMT+05:30 2011</br>
	* <b>Description  :</b> This class is for database's table link_within_dns and
	*		this class contain generated methods insert,update,delete,getById,getData</br>
	* <b>Author : </b>DB code generator
*/
public class link_within_dns {
	private static final String INSERT = "link_within_dnsInsert";
	private static final String UPDATE = "link_within_dnsUpdate";
	private static final String DELETE = "link_within_dnsDelete";
	private static final String GETBYID = "link_within_dnsGetById";
	private static final String GETDATA = "link_within_dnsGetData";

	public int link_id;
	public String url_link;
	public int site_id;
	public int parsed;
	
	public link_within_dns(){
		link_id = 0;
		url_link = "";
		site_id = 0;
		parsed = 0;
	}


	/**
	* <b>Function Name : </b>insert</br>
	* <b>Description  : </b>This function is for insert value in database table link_within_dns</br>
	* @param obj is the object of class link_within_dns and its member will be used for insert in table
	*/
	public static long insert(link_within_dns obj){
		dbHandler db = null;
		try{
			ArrayList<SqlParameter> sqlparameters = new ArrayList<SqlParameter>();

			sqlparameters.add(new SqlParameter(
					"__url_link",
					obj.url_link,
					ProcedureParameterType.String,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__site_id",
					obj.site_id,
					ProcedureParameterType.Integer,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__parsed",
					obj.parsed,
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
	* <b>Description  : </b>This function is for update values in database table link_within_dns</br>
	* @param obj is the object of class link_within_dns and its members will be used for update table's value
	*/
	public static long update(link_within_dns obj){
		dbHandler db = null;
		try{
			ArrayList<SqlParameter> sqlparameters = new ArrayList<SqlParameter>();

			sqlparameters.add(new SqlParameter(
					"__link_id",
					obj.link_id,
					ProcedureParameterType.Integer,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__url_link",
					obj.url_link,
					ProcedureParameterType.String,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__site_id",
					obj.site_id,
					ProcedureParameterType.Integer,
					ProcedureParameterNature.In));

			sqlparameters.add(new SqlParameter(
					"__parsed",
					obj.parsed,
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
	* <b>Description  : </b>This function is for delete values from database table link_within_dns
	* @param fileid is primary key based on which values will be delete from table link_within_dns
	*/
	public static long delete(int link_id){
		dbHandler db = null;
		try{
			ArrayList<SqlParameter> sqlparameters = new ArrayList<SqlParameter>();

			sqlparameters.add(new SqlParameter(
					"__link_id",
					link_id,
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
	* <b>Description  : </b>This function is for get object of link_within_dns for given value of primary key</br>
	* @param fileid is primary key based on which object will be selected from table link_within_dns
	*/
	public static link_within_dns getById(int link_id){
		dbHandler db = null;
		try{
			ArrayList<SqlParameter> sqlparameters = new ArrayList<SqlParameter>();

			sqlparameters.add(new SqlParameter(
					"__link_id",
					link_id,
					ProcedureParameterType.Integer,
					ProcedureParameterNature.In));

			db = new dbHandler();
			db.openConnection();
			ResultSet rs = db.callStoredProcedure(GETBYID, sqlparameters);

			link_within_dns retObj = null;
			if (rs.next()){
				retObj = new link_within_dns();
				retObj.link_id = rs.getInt("link_id");
				retObj.url_link = rs.getString("url_link");
				retObj.site_id = rs.getInt("site_id");
				retObj.parsed = rs.getInt("parsed");
				
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
	* <b>Description  : </b>This function is for get list of objects of link_within_dns for given condition</br>
	* @param sSqlCondition is sql condition based on which list of objects of link_within_dns wiil be created
	*/
	public static ArrayList<link_within_dns> getData(String sSqlCondition){
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

			ArrayList<link_within_dns> liRetList = new ArrayList<link_within_dns>();
			while (rs.next()){
				link_within_dns tempObj = new link_within_dns();
				tempObj.link_id = rs.getInt("link_id");
				tempObj.url_link = rs.getString("url_link");
				tempObj.site_id = rs.getInt("site_id");
				tempObj.parsed = rs.getInt("parsed");
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