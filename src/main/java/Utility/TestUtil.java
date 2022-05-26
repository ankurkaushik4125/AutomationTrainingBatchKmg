package Utility;

import java.util.ArrayList;
import java.util.List;

import Base.Testbase;
import Excelutility.Xls_Reader;

public class TestUtil extends Testbase
{
	public static ArrayList<Object[]> getDataFromExcel()
	{
		String execute_status=null;
		String senario_name = null;
	   	ArrayList<Object[]> myData = new ArrayList<Object[]>();
		int rowCount= excel_reader.getRowCount(Master_Sheet_Name);   
		for (int i=1;i<rowCount;i++)
		{
			execute_status =excel_reader.getCellData( Master_Sheet_Name, "Execute", i);
			System.out.println("execute " + execute_status);
			senario_name=excel_reader.getCellData( Master_Sheet_Name, "Scenario_ID", i);
			System.out.println("execute " + senario_name);
		}
		Object ob[] = {execute_status,senario_name};
		myData.add(ob);
		System.out.println("My data : "+myData);
		return myData;
}
	public static ArrayList<Object[]> getDataFromExcel2()
	{
		ArrayList<Object[]> myData2 = new ArrayList<Object[]>();
		int row_Count= excel_reader.getRowCount(Login_Sheet_Name);
		for (int j=1;j<row_Count;j++)
		{
			String senarioname=excel_reader.getCellData( Login_Sheet_Name, "Scenario_ID", j);
			String Username=excel_reader.getCellData( Login_Sheet_Name, "Username", j);
			String Password=excel_reader.getCellData( Login_Sheet_Name, "Password", j);
			Object ob2[] = {senarioname,Username,senarioname,Password};
			myData2.add(ob2);
			System.out.println("My data : "+myData2);
		}
		return myData2;
	}
	
}
