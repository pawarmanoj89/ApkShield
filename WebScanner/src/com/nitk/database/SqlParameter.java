package com.nitk.database;

public class SqlParameter{
	public String ParameterName;
	public Object ParameterValue;
	public ProcedureParameterType ParameterType;
	public ProcedureParameterNature ParameterNature;
	
	public SqlParameter(String parameterName,Object parameterValue,
			ProcedureParameterType parameterType,ProcedureParameterNature parameterNature){
		ParameterName = parameterName;
		ParameterValue = parameterValue;
		ParameterType = parameterType;
		ParameterNature = parameterNature;
	}
}
