package Report;

import org.apache.logging.log4j.*;


public class log {
	// Initialize Log4j logs
    private static Logger Log = LogManager.getLogger(log.class.getName()); 
// This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite
    
    public static void startTestCase(String TestCaseName,String Endrose_num,String Interface_name){
   	  
   	    Log.info("Starting the Testcase with details :  "+TestCaseName+ " , "+Endrose_num+ " , "+Interface_name);
   	  
   	    }
public static void startTestCase_execution(String reinstype,String  ContractExcelPath,String   M_Contract_num,String transaction,String  Scenario_m,String M_EDS_NUM){
 

   Log.info("Test cases Execution Starts with values reinstype -"+reinstype+", ContractExcelPath-"+ContractExcelPath+", M_Contract_num-"+M_Contract_num+", transaction-"+transaction+", Scenario_m-"+Scenario_m+", M_EDS_NUM-"+M_EDS_NUM);
 
   }

   //This is to print log for the ending of the test case
public static void end_Testcase(String TestCaseName,String Endrose_num,String Interface_name){
	  
	 
   Log.info("Ending the execution"+TestCaseName+ " , "+Endrose_num+ " , "+Interface_name);
 
   }

   // Need to create these methods, so that they can be called  
public static void info( String message) {
       Log.info( message);
       }
public static void warn(String message) {
   Log.warn(message);
   }
public static void error(String message) {
   Log.error(message);
   }
public static void fatal(String message) {
   Log.fatal(message);
   }
public static void debug(String message) {
   Log.debug(message);
   }
}




