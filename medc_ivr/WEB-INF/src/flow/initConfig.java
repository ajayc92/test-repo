package flow;

import org.vn.medc.appdata.AppProps;
import org.vn.medc.db.DbManager;

import com.avaya.sce.runtime.tracking.TraceInfo;
import com.avaya.sce.runtimecommon.SCESession;

/**
 * The Data class handles many types of server-side operations including data
 * collection (from a data sources such as a database, or web service), variable
 * assignments and operations (like copying variable values, performing mathematic
 * operations, and collection iteration), conditional evaluation to control callflow
 * execution based on variable values, and logging/tracing statements.
 * 
 * Items created in the getDataActions() method are executed/evaluated in order
 * and if a condional branch condition evaluates to "true" then the branch is
 * activated and the execution of data actions is halted.  If no "true" conditions
 * are encountered, then all data actions will be executed/evaluated and the 
 * application will proceed to the "Default" servlet.
 * Last generated by Orchestration Designer at: 2021-APR-15  09:01:32 PM
 */
public class initConfig extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2021-APR-15  09:01:32 PM
	 */
	public initConfig() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	@Override
	public void requestBegin(SCESession mySession) {
		// TODO Auto-generated method stub
		String clid = mySession.getVariableField("session", "ani").getStringValue().replace("+", "");
	    String dnis = mySession.getVariableField("session", "dnis").getStringValue();
	    String ucid = mySession.getVariableField("session", "ucid").getStringValue();
	    if ((ucid.equalsIgnoreCase("undefined")) || (ucid.equalsIgnoreCase(""))) {
	      ucid = 
	      
	        mySession.getVariableField("date", "audio").getStringValue() + mySession.getVariableField("time", "audio").getStringValue() + clid + "_";
	    }
	    mySession.getVariableField("CLID").setValue(clid);
	    mySession.getVariableField("DNIS").setValue(dnis);
	    mySession.getVariableField("UCID").setValue(ucid);
	    
	    LoggerUtil.writeTrace(mySession, 1, ">>>   CLID : " + mySession.getVariableField("CLID").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>   UCID : " + mySession.getVariableField("UCID").getStringValue());
	    
	    mySession.getVariableField("DnisTransfer", "Bill_Outstanding").setValue(AppProps.getProps("BILL_OUTSTANDING"));
	    mySession.getVariableField("DnisTransfer", "Last_Transaction").setValue(AppProps.getProps("TO_KNOW_THE_LAST_TRANSACTION"));
	    mySession.getVariableField("DnisTransfer", "Premises_Number").setValue(AppProps.getProps("PREMISES_NUMBER"));
	    mySession.getVariableField("DnisTransfer", "Last_Token_Number").setValue(AppProps.getProps("LAST_TOKEN_NUMBER"));
	    mySession.getVariableField("DnisTransfer", "SMR").setValue(AppProps.getProps("SMR"));
	    mySession.getVariableField("DnisTransfer", "CSS").setValue(AppProps.getProps("CSS"));
	    mySession.getVariableField("DnisTransfer", "To_Know_Current_Shutdown").setValue(AppProps.getProps("TO_KNOW_THE_CURRENT_SHUTDOWN"));
	    mySession.getVariableField("DnisTransfer", "pay_bill").setValue(AppProps.getProps("PAY_BILL"));
	    mySession.getVariableField("DnisTransfer", "Recharge").setValue(AppProps.getProps("RECHARGE"));
	    

	    mySession.getVariableField("Mobile", "StartNumber").setValue(AppProps.getProps("MOBILESTART"));
	    TraceInfo.trace(2, "%%%%%%%%%%%%%MOBILE_START_NUMBER%%%%%%%%%%%%%" + mySession.getVariableField("Mobile", "StartNumber").getStringValue(), mySession);
	    


	    String Bill_Outstanding = mySession.getVariableField("DnisTransfer", "Bill_Outstanding").getStringValue();
	    String Last_Transaction = mySession.getVariableField("DnisTransfer", "Last_Transaction").getStringValue();
	    String Premises_Number = mySession.getVariableField("DnisTransfer", "Premises_Number").getStringValue();
	    String Last_Token_Number = mySession.getVariableField("DnisTransfer", "Last_Token_Number").getStringValue();
	    String SMR = mySession.getVariableField("DnisTransfer", "SMR").getStringValue();
	    String CSS = mySession.getVariableField("DnisTransfer", "CSS").getStringValue();
	    String Current_Shutdown = mySession.getVariableField("DnisTransfer", "To_Know_Current_Shutdown").getStringValue();
	    String Pay_Bill = mySession.getVariableField("DnisTransfer", "pay_bill").getStringValue();
	    String Recharge = mySession.getVariableField("DnisTransfer", "Recharge").getStringValue();
	    

	    mySession.getVariableField("dbInsertCallAndMenuHistory", "CLID").setValue(clid);
	    mySession.getVariableField("dbInsertCallAndMenuHistory", "UCID").setValue(ucid);
	    mySession.getVariableField("dbInsertCallAndMenuHistory", "DNIS").setValue(dnis);
	    
	    mySession.getVariableField("PropertyFileData", "DBDOWN_CD_FILE_PATH").setValue(AppProps.getProps("DBDOWN_CD_FILE_PATH"));
	    mySession.getVariableField("PropertyFileData", "AREA_FILE_PATH_ARABIC").setValue(AppProps.getProps("AREA_FILE_PATH_ARABIC"));
	    mySession.getVariableField("PropertyFileData", "AREA_FILE_PATH_ENGLISH").setValue(AppProps.getProps("AREA_FILE_PATH_ENGLISH"));
	    
	    mySession.getVariableField("PropertyFileData", "CONNECTION_TYPE_PREPAID").setValue(AppProps.getProps("CONNECTION_TYPE_PREPAID"));
	    mySession.getVariableField("PropertyFileData", "CONNECTION_TYPE_POSTPAID").setValue(AppProps.getProps("CONNECTION_TYPE_POSTPAID"));
	    
	    mySession.getVariableField("PropertyFileData", "DEFAULT_VDN_ARABIC").setValue(AppProps.getProps("DEFAULT_VDN_ARABIC"));
	    mySession.getVariableField("PropertyFileData", "DEFAULT_VDN_ENGLISH").setValue(AppProps.getProps("DEFAULT_VDN_ENGLISH"));
	    
	    mySession.getVariableField("PropertyFileData", "SEL_CUS_MASTER_PHONE_NUMBER").setValue(AppProps.getProps("SEL_CUS_MASTER_PHONE_NUMBER"));
	    mySession.getVariableField("PropertyFileData", "SEL_CRM_VIEW_GSM").setValue(AppProps.getProps("SEL_CRM_VIEW_GSM"));
	    mySession.getVariableField("PropertyFileData", "SEL_CRM_VIEW_CUSINFO").setValue(AppProps.getProps("SEL_CRM_VIEW_CUSINFO"));
	    mySession.getVariableField("PropertyFileData", "SEL_SHUT_DOWN_INFO").setValue(AppProps.getProps("SEL_SHUT_DOWN_INFO"));
	    mySession.getVariableField("PropertyFileData", "SEL_PREPAID_VIEW").setValue(AppProps.getProps("SEL_PREPAID_VIEW"));
	    mySession.getVariableField("PropertyFileData", "SEL_PREPAID_VIEW_LAST_TOKEN").setValue(AppProps.getProps("SEL_PREPAID_VIEW_LAST_TOKEN"));
	    mySession.getVariableField("PropertyFileData", "SEL_PREPAID_VIEW_LAST_TOKEN_ORD").setValue(AppProps.getProps("SEL_PREPAID_VIEW_LAST_TOKEN_ORD"));
	    System.out.println(mySession.getVariableField("PropertyFileData", "SEL_PREPAID_VIEW_LAST_TOKEN_ORD").getStringValue());
	    
	    mySession.getVariableField("PropertyFileData", "SEL_POSTPAID_VIEW_LAST3TRANS").setValue(AppProps.getProps("SEL_POSTPAID_VIEW_LAST3TRANS"));
	    mySession.getVariableField("PropertyFileData", "SEL_POSTPAID_VIEW_LAST3TRANS_ORD").setValue(AppProps.getProps("SEL_POSTPAID_VIEW_LAST3TRANS_ORD"));
	    
	    mySession.getVariableField("PropertyFileData", "BS_URL").setValue(AppProps.getProps("BILLING_SERVICES_URL"));
	    mySession.getVariableField("PropertyFileData", "BS_USERNAME").setValue(AppProps.getProps("BILLING_SERVICES_USERNAME"));
	    mySession.getVariableField("PropertyFileData", "BS_PASSWORD").setValue(AppProps.getProps("BILLING_SERVICES_PASSWORD"));
	    
	    mySession.getVariableField("PropertyFileData", "SMS_URL").setValue(AppProps.getProps("SMS_URL"));
	    mySession.getVariableField("PropertyFileData", "SMS_USERNAME").setValue(AppProps.getProps("SMS_USERNAME"));
	    mySession.getVariableField("PropertyFileData", "SMS_PASSWORD").setValue(AppProps.getProps("SMS_PASSWORD"));
	    mySession.getVariableField("PropertyFileData", "SMS_PRIORITY").setValue(AppProps.getProps("SMS_PRIORITY"));
	    mySession.getVariableField("PropertyFileData", "SMS_SENDER").setValue(AppProps.getProps("SMS_SENDER"));
	    mySession.getVariableField("PropertyFileData", "SMS_PREMISE_TEXT").setValue(AppProps.getProps("SMS_PREMISE_TEXT"));
	    mySession.getVariableField("PropertyFileData", "SMS_LAST_TOKEN_TEXT").setValue(AppProps.getProps("SMS_LAST_TOKEN_TEXT"));
	    mySession.getVariableField("PropertyFileData", "SMS_LAST_TOKEN_TEXT_1").setValue(AppProps.getProps("SMS_LAST_TOKEN_TEXT_1"));
	    




	    mySession.getVariableField("PropertyFileData", "SQL_IVR_IP_ADDRESS").setValue(AppProps.getProps("SQL_IVR_IP_ADDRESS"));
	    mySession.getVariableField("PropertyFileData", "SQL_IVR_PORT_NUMBER").setValue(AppProps.getProps("SQL_IVR_PORT_NUMBER"));
	    mySession.getVariableField("PropertyFileData", "SI_USERNAME").setValue(AppProps.getProps("SQL_IVR_USERNAME"));
	    mySession.getVariableField("PropertyFileData", "SI_PASSWORD").setValue(AppProps.getProps("SQL_IVR_PASSWORD"));
	    mySession.getVariableField("PropertyFileData", "SQL_IVR_DBNAME").setValue(AppProps.getProps("SQL_IVR_DBNAME"));
	    
	    mySession.getVariableField("PropertyFileData", "SQL_CRM_IP_ADDRESS").setValue(AppProps.getProps("SQL_CRM_IP_ADDRESS"));
	    mySession.getVariableField("PropertyFileData", "SQL_CRM_PORT_NUMBER").setValue(AppProps.getProps("SQL_CRM_PORT_NUMBER"));
	    mySession.getVariableField("PropertyFileData", "SQL_CRM_USERNAME").setValue(AppProps.getProps("SQL_CRM_USERNAME"));
	    mySession.getVariableField("PropertyFileData", "SQL_CRM_PASS").setValue(AppProps.getProps("SQL_CRM_PASSWORD"));
	    mySession.getVariableField("PropertyFileData", "SQL_CRM_DBNAME").setValue(AppProps.getProps("SQL_CRM_DBNAME"));
	    
	    mySession.getVariableField("PropertyFileData", "ORA_PREPAID_URL").setValue(AppProps.getProps("ORA_PREPAID_URL"));
	    
	    mySession.getVariableField("PropertyFileData", "ORA_PREPAID_USERNAME").setValue(AppProps.getProps("ORA_PREPAID_USERNAME"));
	    mySession.getVariableField("PropertyFileData", "ORA_PREPAID_PASSWORD").setValue(AppProps.getProps("ORA_PREPAID_PASSWORD"));
	    


	    mySession.getVariableField("PropertyFileData", "ORA_BILLING_URL").setValue(AppProps.getProps("ORA_BILLING_URL"));
	    
	    mySession.getVariableField("PropertyFileData", "ORA_BILLING_USERNAME").setValue(AppProps.getProps("ORA_BILLING_USERNAME"));
	    mySession.getVariableField("PropertyFileData", "ORA_BILLING_PASSWORD").setValue(AppProps.getProps("ORA_BILLING_PASSWORD"));
	    






	    mySession.getVariableField("Voice_Mail", "RecordVmPath").setValue(AppProps.getProps("AUDIO_FILE_TMP"));
	    mySession.getVariableField("Voice_Mail", "RecRenamePath").setValue(AppProps.getProps("AUDIO_RENAM_PATH"));
	    mySession.getVariableField("Voice_Mail", "RecToStoreTemp").setValue(AppProps.getProps("AUDIO_TMP_CREATE"));
	    
	    mySession.getVariableField("Voice_Mail", "Ipaddress").setValue(AppProps.getProps("IP_ADDRESS"));
	    mySession.getVariableField("Voice_Mail", "Port").setValue(AppProps.getProps("PORT"));
	    
	    mySession.getVariableField("Voice_Mail", "Recmaxlength").setValue(AppProps.getProps("MAX_LENGTH"));
	    mySession.getVariableField("Voice_Mail", "Recminsilence").setValue(AppProps.getProps("MIN_SILENT"));
	    
	    mySession.getVariableField("PropertyFileData", "DA_Xfer_Limit").setValue(AppProps.getProps("Dangerous_Asserts_Transfer_Limit"));
	    mySession.getVariableField("PropertyFileData", "DA_Xfer_Time_Limit").setValue(AppProps.getProps("Dangerous_Asserts_Transfer_Time_Limit"));
	    
	    mySession.getVariableField("PropertyFileData", "PAYMENT_ID_URL").setValue(AppProps.getProps("PAYMENT_ID_URL"));
	    mySession.getVariableField("PropertyFileData", "PROCESS_TRANSACTION_URL").setValue(AppProps.getProps("PROCESS_TRANSACTION_URL"));
	    mySession.getVariableField("PropertyFileData", "Channel").setValue(AppProps.getProps("CHANNEL"));
	    mySession.getVariableField("PropertyFileData", "RECHARGE_FLAG").setValue(AppProps.getProps("RECHARGE_FLAG"));
	    mySession.getVariableField("PropertyFileData", "MAX_AMOUNT").setValue(AppProps.getProps("MAX_AMOUNT"));
	    mySession.getVariableField("PropertyFileData", "SERVICE_TYPE_POSTPAID").setValue(AppProps.getProps("SERVICE_TYPE_POSTPAID"));
	    mySession.getVariableField("PropertyFileData", "SERVICE_TYPE_PREPAID").setValue(AppProps.getProps("SERVICE_TYPE_PREPAID"));
	    mySession.getVariableField("PropertyFileData", "TIME_OUT").setValue(AppProps.getProps("TIME_OUT"));
	    

	    mySession.getVariableField("PropertyFileData", "MIN_AMOUNT").setValue(AppProps.getProps("MIN_AMOUNT"));
	    

	    mySession.getVariableField("PropertyFileData", "GEN_PIN_USERNAME").setValue(AppProps.getProps("GEN_PIN_USERNAME"));
	    mySession.getVariableField("PropertyFileData", "GEN_PIN_PASSWORD").setValue(AppProps.getProps("GEN_PIN_PASSWORD"));
	    mySession.getVariableField("PropertyFileData", "GEN_PIN_URL").setValue(AppProps.getProps("GEN_PIN_URL"));
	    mySession.getVariableField("PropertyFileData", "PAYMENT_GATEWAY_URL").setValue(AppProps.getProps("PREPAID_PAYMENT_GATEWAY_URL"));
	    mySession.getVariableField("PropertyFileData", "UPDATE_MEDC_DB_URL").setValue(AppProps.getProps("UPDATE_MEDC_DB_URL"));
	    mySession.getVariableField("PropertyFileData", "SSL_JKS_PATH").setValue(AppProps.getProps("SSL_JKS_PATH"));
	    mySession.getVariableField("PropertyFileData", "SSL_JKS_PASSWORD").setValue(AppProps.getProps("SSL_JKS_PASSWORD"));
	    mySession.getVariableField("PropertyFileData", "SMS_PINGENERATION_TOKEN").setValue(AppProps.getProps("SMS_PINGENERATION_TOKEN"));
	    mySession.getVariableField("PropertyFileData", "PAYMENT_TESTING_FLAG").setValue(AppProps.getProps("PAYMENT_TESTING_FLAG"));
	    mySession.getVariableField("PropertyFileData", "TEST_ACCOUNT_NUMBERS").setValue(AppProps.getProps("TEST_ACCOUNT_NUMBERS"));
	    
	    mySession.getVariableField("PropertyFileData", "PinGenIP").setValue(AppProps.getProps("PIN_GEN_IP"));
	    mySession.getVariableField("PropertyFileData", "PinGenPort").setValue(AppProps.getProps("PIN_GEN_PORT"));
	    mySession.getVariableField("PropertyFileData", "LibertyUrl").setValue(AppProps.getProps("LIBERTY_URL"));
	    mySession.getVariableField("PropertyFileData", "SmrUrl").setValue(AppProps.getProps("SMR_URL"));
	    mySession.getVariableField("PropertyFileData", "SmrUsername").setValue(AppProps.getProps("SMR_USERNAME"));
	    mySession.getVariableField("PropertyFileData", "SmrPassword").setValue(AppProps.getProps("SMR_PASSWORD"));
	    
	    mySession.getVariableField("PropertyFileData", "SmrText").setValue(AppProps.getProps("SMR_TEXT"));
	    
	    LoggerUtil.writeTrace(mySession, 1, ">>>  DA_XFER_LIMIT : " + mySession.getVariableField("PropertyFileData", "DA_Xfer_Limit").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>  DA_XFER_TIME_LIMIT : " + mySession.getVariableField("PropertyFileData", "DA_Xfer_Time_Limit").getIntValue());
	    
	    String[] Mob = mySession.getVariableField("Mobile", "StartNumber").getStringValue().split(",");
	    if ((clid.startsWith(Mob[0])) || (clid.startsWith(Mob[1])) || (clid.startsWith(Mob[2])) || (clid.startsWith(Mob[3])) || (clid.startsWith(Mob[4])))
	    {
	      mySession.getVariableField("IsMobileNumber").setValue("true");
	      TraceInfo.trace(2, " $$$$$ CLID is Mobile Number $$$$$ " + clid, mySession);
	    }
	    else
	    {
	      mySession.getVariableField("IsMobileNumber").setValue("false");
	      TraceInfo.trace(2, " $$$$$ CLID is not Mobile Number $$$$$ " + clid, mySession);
	    }
	    int DA_TIME_LIMIT = mySession.getVariableField("PropertyFileData", "DA_Xfer_Time_Limit").getIntValue();
	    
	    sql_db_operation local_db = new sql_db_operation(
	    
	      mySession.getVariableField("PropertyFileData", "SQL_IVR_IP_ADDRESS").getStringValue(), 
	      mySession.getVariableField("PropertyFileData", "SI_USERNAME").getStringValue(), 
	      mySession.getVariableField("PropertyFileData", "SI_PASSWORD").getStringValue(), 
	      mySession.getVariableField("PropertyFileData", "SQL_IVR_DBNAME").getStringValue());
	    


	    mySession.setProperty("LOCAL_DB", local_db);
	    try
	    {
	      local_db.GetRecordingCount(clid, Integer.valueOf(DA_TIME_LIMIT), mySession);
	    }
	    catch (Exception e)
	    {
	      TraceInfo.trace(2, "Exception : To get recording count" + e, mySession);
	    }
	    DbManager crm_db = new DbManager(
	    
	      mySession.getVariableField("PropertyFileData", "SQL_CRM_IP_ADDRESS").getStringValue(), 
	      mySession.getVariableField("PropertyFileData", "SQL_CRM_USERNAME").getStringValue(), 
	      mySession.getVariableField("PropertyFileData", "SQL_CRM_PASS").getStringValue(), 
	      mySession.getVariableField("PropertyFileData", "SQL_CRM_DBNAME").getStringValue());
	    
	    mySession.setProperty("CRM_DB", crm_db);
	    
	    ora_db_operation prepaid_db = new ora_db_operation(
	    
	      mySession.getVariableField("PropertyFileData", "ORA_PREPAID_URL").getStringValue(), 
	      
	      mySession.getVariableField("PropertyFileData", "ORA_PREPAID_USERNAME").getStringValue(), 
	      mySession.getVariableField("PropertyFileData", "ORA_PREPAID_PASSWORD").getStringValue());
	    

	    mySession.setProperty("PREPAID_DB", prepaid_db);
	    
	    ora_db_operation billing_db = new ora_db_operation(
	    
	      mySession.getVariableField("PropertyFileData", "ORA_BILLING_URL").getStringValue(), 
	      
	      mySession.getVariableField("PropertyFileData", "ORA_BILLING_USERNAME").getStringValue(), 
	      mySession.getVariableField("PropertyFileData", "ORA_BILLING_PASSWORD").getStringValue());
	    

	    mySession.setProperty("BILLING_DB", billing_db);
	    

	    LoggerUtil.writeTrace(mySession, 1, ">>>  DNIS_BILL_OUTSATANDING : " + Bill_Outstanding);
	    LoggerUtil.writeTrace(mySession, 1, ">>>  DNIS_LAST_TRANSACTION : " + Last_Transaction);
	    LoggerUtil.writeTrace(mySession, 1, ">>>  DNIS_PREMISES_NUMBER : " + Premises_Number);
	    LoggerUtil.writeTrace(mySession, 1, ">>>  DNIS_LAST_TOKEN_NUMBER : " + Last_Token_Number);
	    LoggerUtil.writeTrace(mySession, 1, ">>>  DNIS_SMR : " + SMR);
	    LoggerUtil.writeTrace(mySession, 1, ">>>  DNIS_CSS : " + CSS);
	    LoggerUtil.writeTrace(mySession, 1, ">>>  DNIS_CURRENT_SHUTDOWN : " + Current_Shutdown);
	    LoggerUtil.writeTrace(mySession, 1, ">>>  DNIS_PAY_BILL : " + Pay_Bill);
	    LoggerUtil.writeTrace(mySession, 1, ">>>  DNIS_RECHARGE : " + Recharge);
	    LoggerUtil.writeTrace(mySession, 1, ">>>  SEL_CUSTOMER_MASTER_PHNUM : " + mySession.getVariableField("PropertyFileData", "SEL_CUS_MASTER_PHONE_NUMBER").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>  SEL_CRM_VIEW_GSM : " + mySession.getVariableField("PropertyFileData", "SEL_CRM_VIEW_GSM").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>  SEL_CRM_VIEW_CUSTINFO : " + mySession.getVariableField("PropertyFileData", "SEL_CRM_VIEW_CUSINFO").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>  SEL_PREPAID_VIEW : " + mySession.getVariableField("PropertyFileData", "SEL_PREPAID_VIEW").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>  SEL_SHUT_DOWN_INFO : " + mySession.getVariableField("PropertyFileData", "SEL_SHUT_DOWN_INFO").getStringValue());
	    
	    LoggerUtil.writeTrace(mySession, 1, ">>>  SEL_PREPAID_VIEW_LAST_TOKEN : " + mySession.getVariableField("PropertyFileData", "SEL_PREPAID_VIEW_LAST_TOKEN").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>  SEL_PREPAID_VIEW_LAST_TOKEN_ORD : " + mySession.getVariableField("PropertyFileData", "SEL_PREPAID_VIEW_LAST_TOKEN_ORD").getStringValue());
	    
	    LoggerUtil.writeTrace(mySession, 1, ">>>  SEL_POSTPAID_VIEW_LAST3TRANSACTION : " + mySession.getVariableField("PropertyFileData", "SEL_POSTPAID_VIEW_LAST3TRANS").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>  SEL_POSTPAID_VIEW_LAST3TRANSACTION_ORD : " + mySession.getVariableField("PropertyFileData", "SEL_POSTPAID_VIEW_LAST3TRANS_ORD").getStringValue());
	    
	    LoggerUtil.writeTrace(mySession, 1, ">>>  DBDOWN CALL DETAILS FILE PATH : " + mySession.getVariableField("PropertyFileData", "DBDOWN_CD_FILE_PATH").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>  AREA FILE PATH ARABIC : " + mySession.getVariableField("PropertyFileData", "AREA_FILE_PATH_ARABIC").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>  AREA FILE PATH ENGLISH : " + mySession.getVariableField("PropertyFileData", "AREA_FILE_PATH_ENGLISH").getStringValue());
	    
	    LoggerUtil.writeTrace(mySession, 1, ">>>  CONNECTION_TYPE_PREPAID : " + mySession.getVariableField("PropertyFileData", "CONNECTION_TYPE_PREPAID").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>  CONNECTION_TYPE_POSTPAID : " + mySession.getVariableField("PropertyFileData", "CONNECTION_TYPE_POSTPAID").getStringValue());
	    
	    LoggerUtil.writeTrace(mySession, 1, ">>>  SQL_IVR_IP_ADDRESS : " + mySession.getVariableField("PropertyFileData", "SQL_IVR_IP_ADDRESS").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>  SQL_IVR_PORT_NUMBER : " + mySession.getVariableField("PropertyFileData", "SQL_IVR_PORT_NUMBER").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>  SQL_IVR_USERNAME : " + mySession.getVariableField("PropertyFileData", "SI_USERNAME").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>  SQL_IVR_PASSWORD : " + mySession.getVariableField("PropertyFileData", "SI_PASSWORD").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>  SQL_IVR_DBNAME : " + mySession.getVariableField("PropertyFileData", "SQL_IVR_DBNAME").getStringValue());
	    
	    LoggerUtil.writeTrace(mySession, 1, ">>>   BILLING_SERVICES_URL : " + mySession.getVariableField("PropertyFileData", "BS_URL").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>   BILLING_SERVICES_USERNAME : " + mySession.getVariableField("PropertyFileData", "BS_USERNAME").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>   BILLING_SERVICES_PASSWORD : " + mySession.getVariableField("PropertyFileData", "BS_PASSWORD").getStringValue());
	    
	    LoggerUtil.writeTrace(mySession, 1, ">>>   SMS_URL : " + mySession.getVariableField("PropertyFileData", "SMS_URL").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>   SMS_USERNAME : " + mySession.getVariableField("PropertyFileData", "SMS_USERNAME").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>   SMS_PASSWORD : " + mySession.getVariableField("PropertyFileData", "SMS_PASSWORD").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>   SMS_PRIORITY : " + mySession.getVariableField("PropertyFileData", "SMS_PRIORITY").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>   SMS_SENDER : " + mySession.getVariableField("PropertyFileData", "SMS_SENDER").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>   SMS_PREMISE_TEXT : " + mySession.getVariableField("PropertyFileData", "SMS_PREMISE_TEXT").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>   SMS_LAST_TOKEN_TEXT : " + mySession.getVariableField("PropertyFileData", "SMS_LAST_TOKEN_TEXT").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>   SEL_SMS_TEMPLATE : " + mySession.getVariableField("PropertyFileData", "SEL_SMS_TEMPLATE").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>   SEL_LANG_DNIS : " + mySession.getVariableField("PropertyFileData", "SEL_LANG_DNIS").getStringValue());
	    
	    LoggerUtil.writeTrace(mySession, 1, ">>>  SQL_CRM_IP_ADDRESS : " + mySession.getVariableField("PropertyFileData", "SQL_CRM_IP_ADDRESS").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>  SQL_CRM_PORT_NUMBER : " + mySession.getVariableField("PropertyFileData", "SQL_CRM_PORT_NUMBER").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>  SQL_CRM_USERNAME : " + mySession.getVariableField("PropertyFileData", "SQL_CRM_USERNAME").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>  SQL_CRM_PASSWORD : " + mySession.getVariableField("PropertyFileData", "SQL_CRM_PASS").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>  SQL_CRM_DBNAME : " + mySession.getVariableField("PropertyFileData", "SQL_CRM_DBNAME").getStringValue());
	    
	    LoggerUtil.writeTrace(mySession, 1, ">>>  ORA_PREPAID_IP_ADDRESS : " + mySession.getVariableField("PropertyFileData", "ORA_PREPAID_URL").getStringValue());
	    
	    LoggerUtil.writeTrace(mySession, 1, ">>>  ORA_PREPAID_USERNAME : " + mySession.getVariableField("PropertyFileData", "ORA_PREPAID_USERNAME").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>  ORA_PREPAID_PASSWORD : " + mySession.getVariableField("PropertyFileData", "ORA_PREPAID_PASSWORD").getStringValue());
	    

	    LoggerUtil.writeTrace(mySession, 1, ">>>  ORA_BILLING_IP_ADDRESS : " + mySession.getVariableField("PropertyFileData", "ORA_BILLING_URL").getStringValue());
	    
	    LoggerUtil.writeTrace(mySession, 1, ">>>  ORA_BILLING__USERNAME : " + mySession.getVariableField("PropertyFileData", "ORA_BILLING_USERNAME").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>  ORA_BILLING_PASSWORD : " + mySession.getVariableField("PropertyFileData", "ORA_BILLING_PASSWORD").getStringValue());
	    

	    LoggerUtil.writeTrace(mySession, 1, ">>>  DEFAULT_VDN_ARABIC : " + mySession.getVariableField("PropertyFileData", "DEFAULT_VDN_ARABIC").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>  DEFAULT_VDN_ENGLISH : " + mySession.getVariableField("PropertyFileData", "DEFAULT_VDN_ENGLISH").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>  PAYMENT_ID_URL : " + mySession.getVariableField("PropertyFileData", "PAYMENT_ID_URL").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>  PROCESS_TRANSACTION_URL : " + mySession.getVariableField("PropertyFileData", "PROCESS_TRANSACTION_URL").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>  CHANNEL : " + mySession.getVariableField("PropertyFileData", "Channel").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>  RECHARGE_FLAG : " + mySession.getVariableField("PropertyFileData", "RECHARGE_FLAG").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>  MAX_AMOUNT : " + mySession.getVariableField("PropertyFileData", "MAX_AMOUNT").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>  TIME_OUT : " + mySession.getVariableField("PropertyFileData", "TIME_OUT").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>  SERVICE_TYPE_PREPAID : " + mySession.getVariableField("PropertyFileData", "SERVICE_TYPE_PREPAID").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>  SERVICE_TYPE_POSTPAID : " + mySession.getVariableField("PropertyFileData", "SERVICE_TYPE_POSTPAID").getStringValue());
	    

	    LoggerUtil.writeTrace(mySession, 1, ">>>  GENERATE_PIN_USERNAME : " + mySession.getVariableField("PropertyFileData", "GEN_PIN_USERNAME").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>  GENERATE_PIN_PASSWORD : " + mySession.getVariableField("PropertyFileData", "GEN_PIN_PASSWORD").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>  GENERATE_PIN_URL : " + mySession.getVariableField("PropertyFileData", "GEN_PIN_URL").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>  PAYMENT_GATEWAY_URL : " + mySession.getVariableField("PropertyFileData", "PAYMENT_GATEWAY_URL").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>  UPDATE_MEDC_URL : " + mySession.getVariableField("PropertyFileData", "UPDATE_MEDC_DB_URL").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>  SSL_JKS_PATH : " + mySession.getVariableField("PropertyFileData", "SSL_JKS_PATH").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>  SSL_JKS_PASSWORD : " + mySession.getVariableField("PropertyFileData", "SSL_JKS_PASSWORD").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>  TEST_ACCOUNT_NUMBERS : " + mySession.getVariableField("PropertyFileData", "TEST_ACCOUNT_NUMBERS").getStringValue());
	    LoggerUtil.writeTrace(mySession, 1, ">>>  PAYMENT_TESTING_FLAG : " + mySession.getVariableField("PropertyFileData", "PAYMENT_TESTING_FLAG").getStringValue());
	    if (Premises_Number.equalsIgnoreCase(dnis))
	    {
	      mySession.getVariableField("DnisTransfer", "IsDnisTransfer").setValue("true");
	      mySession.getVariableField("DnisTransfer", "DnisTransferMenu").setValue("premises number");
	    }
	    else if (Last_Token_Number.equalsIgnoreCase(dnis))
	    {
	      mySession.getVariableField("DnisTransfer", "IsDnisTransfer").setValue("true");
	      mySession.getVariableField("DnisTransfer", "DnisTransferMenu").setValue("Last Token Number");
	    }
	    else if (Bill_Outstanding.equalsIgnoreCase(dnis))
	    {
	      mySession.getVariableField("DnisTransfer", "IsDnisTransfer").setValue("true");
	      mySession.getVariableField("DnisTransfer", "DnisTransferMenu").setValue("billing info");
	    }
	    else if (Last_Transaction.equalsIgnoreCase(dnis))
	    {
	      mySession.getVariableField("DnisTransfer", "IsDnisTransfer").setValue("true");
	      mySession.getVariableField("DnisTransfer", "DnisTransferMenu").setValue("last 3 Transaction");
	    }
	    else if (CSS.equalsIgnoreCase(dnis))
	    {
	      mySession.getVariableField("DnisTransfer", "IsDnisTransfer").setValue("true");
	      mySession.getVariableField("DnisTransfer", "DnisTransferMenu").setValue("customer satisfaction survey");
	    }
	    else if (Current_Shutdown.equalsIgnoreCase(dnis))
	    {
	      mySession.getVariableField("DnisTransfer", "IsDnisTransfer").setValue("true");
	      mySession.getVariableField("DnisTransfer", "DnisTransferMenu").setValue("shutdown info");
	    }
	    else if (SMR.equalsIgnoreCase(dnis))
	    {
	      mySession.getVariableField("DnisTransfer", "IsDnisTransfer").setValue("true");
	      mySession.getVariableField("DnisTransfer", "DnisTransferMenu").setValue("self meter reading");
	    }
	    else if (Pay_Bill.equalsIgnoreCase(dnis))
	    {
	      mySession.getVariableField("DnisTransfer", "IsDnisTransfer").setValue("true");
	      mySession.getVariableField("DnisTransfer", "DnisTransferMenu").setValue("Pay Bill");
	    }
	    else if (Recharge.equalsIgnoreCase(dnis))
	    {
	      mySession.getVariableField("DnisTransfer", "IsDnisTransfer").setValue("true");
	      mySession.getVariableField("DnisTransfer", "DnisTransferMenu").setValue("Recharge");
	    }
	    else
	    {
	      mySession.getVariableField("DnisTransfer", "IsDnisTransfer").setValue("false");
	    }
	    if ("true".equalsIgnoreCase(mySession.getVariableField("DnisTransfer", "IsDnisTransfer").getStringValue())) {
	      try
	      {
	        sql_db_operation dnis_transfer_Lang = (sql_db_operation)mySession.getProperty("LOCAL_DB");
	        dnis_transfer_Lang.getDNISTransfer_CusLang(clid, mySession);
	      }
	      catch (db_exception e)
	      {
	        mySession.getVariableField("dbException").setValue("Yes");
	        mySession.getVariableField("ELABORATED_EXCEPTION").setValue(e);
	      }
	    }
	    TraceInfo.trace(2, " | DNIS TRANSFER LANGUAGE  : " + mySession.getCurrentLanguage(), mySession);
	    TraceInfo.trace(2, " | IS DNIS TRANSFER        : " + mySession.getVariableField("DnisTransfer", "IsDnisTransfer").getStringValue(), mySession);
	    TraceInfo.trace(2, " | DNIS TRANSFER MENU NAME : " + mySession.getVariableField("DnisTransfer", "DnisTransferMenu").getStringValue(), mySession);
	    
		super.requestBegin(mySession);
	}
	
	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2021-APR-16  12:30:05 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = null;
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2021-APR-16  12:30:05 PM
	 */
	public java.util.Collection<VariableInfo> getLocalVariables(){
		java.util.Collection<VariableInfo> variables = new java.util.ArrayList<VariableInfo>();

		return variables;
	}
	/**
	 * Creates and conditionally executes operations that have been configured
	 * in the Callflow.  This method will build a collection of operations and
	 * have the framework execute the operations by calling evaluateActions().
	 * If the evaluation causes the framework to forward to a different servlet
	 * then execution stops.
	 * Returning true from this method means that the framework has forwarded the
	 * request to a different servlet.  Returning false means that the default
	 * Next will be invoked.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2021-APR-16  12:30:05 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "DnisTransfer:IsDnisTransfer", com.avaya.sce.runtime.Expression.IS_TRUE).setDebugId(32)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("Play_SeasonalMsg", "Default").setDebugId(25));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		}

		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
