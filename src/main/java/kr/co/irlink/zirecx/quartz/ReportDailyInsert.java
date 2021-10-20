package kr.co.irlink.zirecx.quartz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class ReportDailyInsert implements Job{
	/**
	 * 통계메뉴 조회를 위한 orkreportdaily 테이블 insert
	 */
	private static Logger logger = Logger.getLogger(QuartzCronTrigger.class);
	
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		
		int result = -1;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			logger.info("=========== reportdailyinsert start ===========");
			
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			//DEV
			//String url = "jdbc:sqlserver://localhost:1433;databaseName=morecx_welcomeloan;";
			//String username = "sa";
			//String password = "irlink00!";
			
			
			//PROD 
			String url = "jdbc:sqlserver://localhost:1433;databaseName=morecx_welcomeloan;";
			String username = "ziphone";
			String password = "irlink";
			
			logger.debug("url: " + url);
			logger.debug("username: " + username);
			logger.debug("password: " + password);
			
			conn = DriverManager.getConnection(url, username, password);
			conn.setAutoCommit(false);
			
			StringBuffer sb = new StringBuffer();
			
			//DEV
			//sb.append("insert into orksecurity (encryption) values (convert(int,getdate(),120))");
			
			//PROD
			sb.append(
				"INSERT INTO orkreportdaily ("
				+ "   USERID"
				+ " , ZIRECXID"
				+ ", IN_DURATION_CALL"
				+ ", IN_DURATION_RING"
				+ ", IN_DURATION_TALK"
				+ ", IN_DURATION_WRAPUP"
				+ ", IN_COUNT_CALL"
				+ ", IN_COUNT_CALL_CONNECT"
				+ ", IN_COUNT_CALL_PARTNERBY"
				+ ", OUT_DURATION_CALL"
				+ ", OUT_DURATION_RING"
				+ ", OUT_DURATION_TALK"
				+ ", OUT_DURATION_WRAPUP"
				+ ", OUT_COUNT_CALL"
				+ ", OUT_COUNT_CALL_CONNECT"
				+ ", OUT_COUNT_CALL_PARTNERBY"
				+ ", IN_DURATION_CALL_00_01"
				+ ", IN_DURATION_CALL_01_02"
				+ ", IN_DURATION_CALL_02_03"
				+ ", IN_DURATION_CALL_03_04"
				+ ", IN_DURATION_CALL_04_05"
				+ ", IN_DURATION_CALL_05_06"
				+ ", IN_DURATION_CALL_06_07"
				+ ", IN_DURATION_CALL_07_08"
				+ ", IN_DURATION_CALL_08_09"
				+ ", IN_DURATION_CALL_09_10"
				+ ", IN_DURATION_CALL_10_11"
				+ ", IN_DURATION_CALL_11_12"
				+ ", IN_DURATION_CALL_12_13"
				+ ", IN_DURATION_CALL_13_14"
				+ ", IN_DURATION_CALL_14_15"
				+ ", IN_DURATION_CALL_15_16"
				+ ", IN_DURATION_CALL_16_17"
				+ ", IN_DURATION_CALL_17_18"
				+ ", IN_DURATION_CALL_18_19"
				+ ", IN_DURATION_CALL_19_20"
				+ ", IN_DURATION_CALL_20_21"
				+ ", IN_DURATION_CALL_21_22"
				+ ", IN_DURATION_CALL_22_23"
				+ ", IN_DURATION_CALL_23_24"
				+ ", IN_COUNT_CALL_00_01 "
				+ ", IN_COUNT_CALL_01_02 "
				+ ", IN_COUNT_CALL_02_03 "
				+ ", IN_COUNT_CALL_03_04 "
				+ ", IN_COUNT_CALL_04_05 "
				+ ", IN_COUNT_CALL_05_06 "
				+ ", IN_COUNT_CALL_06_07 "
				+ ", IN_COUNT_CALL_07_08 "
				+ ", IN_COUNT_CALL_08_09 "
				+ ", IN_COUNT_CALL_09_10 "
				+ ", IN_COUNT_CALL_10_11 "
				+ ", IN_COUNT_CALL_11_12 "
				+ ", IN_COUNT_CALL_12_13 "
				+ ", IN_COUNT_CALL_13_14 "
				+ ", IN_COUNT_CALL_14_15 "
				+ ", IN_COUNT_CALL_15_16 "
				+ ", IN_COUNT_CALL_16_17 "
				+ ", IN_COUNT_CALL_17_18 "
				+ ", IN_COUNT_CALL_18_19 "
				+ ", IN_COUNT_CALL_19_20 "
				+ ", IN_COUNT_CALL_20_21 "
				+ ", IN_COUNT_CALL_21_22 "
				+ ", IN_COUNT_CALL_22_23 "
				+ ", IN_COUNT_CALL_23_24 "
				+ ", OUT_DURATION_CALL_00_01"
				+ ", OUT_DURATION_CALL_01_02"
				+ ", OUT_DURATION_CALL_02_03"
				+ ", OUT_DURATION_CALL_03_04"
				+ ", OUT_DURATION_CALL_04_05"
				+ ", OUT_DURATION_CALL_05_06"
				+ ", OUT_DURATION_CALL_06_07"
				+ ", OUT_DURATION_CALL_07_08"
				+ ", OUT_DURATION_CALL_08_09"
				+ ", OUT_DURATION_CALL_09_10"
				+ ", OUT_DURATION_CALL_10_11"
				+ ", OUT_DURATION_CALL_11_12"
				+ ", OUT_DURATION_CALL_12_13"
				+ ", OUT_DURATION_CALL_13_14"
				+ ", OUT_DURATION_CALL_14_15"
				+ ", OUT_DURATION_CALL_15_16"
				+ ", OUT_DURATION_CALL_16_17"
				+ ", OUT_DURATION_CALL_17_18"
				+ ", OUT_DURATION_CALL_18_19"
				+ ", OUT_DURATION_CALL_19_20"
				+ ", OUT_DURATION_CALL_20_21"
				+ ", OUT_DURATION_CALL_21_22"
				+ ", OUT_DURATION_CALL_22_23"
				+ ", OUT_DURATION_CALL_23_24"
				+ ", OUT_COUNT_CALL_00_01"
				+ ", OUT_COUNT_CALL_01_02"
				+ ", OUT_COUNT_CALL_02_03"
				+ ", OUT_COUNT_CALL_03_04"
				+ ", OUT_COUNT_CALL_04_05"
				+ ", OUT_COUNT_CALL_05_06"
				+ ", OUT_COUNT_CALL_06_07"
				+ ", OUT_COUNT_CALL_07_08"
				+ ", OUT_COUNT_CALL_08_09"
				+ ", OUT_COUNT_CALL_09_10"
				+ ", OUT_COUNT_CALL_10_11"
				+ ", OUT_COUNT_CALL_11_12"
				+ ", OUT_COUNT_CALL_12_13"
				+ ", OUT_COUNT_CALL_13_14"
				+ ", OUT_COUNT_CALL_14_15"
				+ ", OUT_COUNT_CALL_15_16"
				+ ", OUT_COUNT_CALL_16_17"
				+ ", OUT_COUNT_CALL_17_18"
				+ ", OUT_COUNT_CALL_18_19"
				+ ", OUT_COUNT_CALL_19_20"
				+ ", OUT_COUNT_CALL_20_21"
				+ ", OUT_COUNT_CALL_21_22"
				+ ", OUT_COUNT_CALL_22_23"
				+ ", OUT_COUNT_CALL_23_24"
				+ ", CALL_DATE"
				+ ", DATECREATED"
				+ ")"
				+ "SELECT	USER_ID"
				+ ", ZIRECXID"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' THEN DURATION_CALL ELSE 0 END) AS IN_DURATION_CALL"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' THEN DURATION_RING ELSE 0 END) AS IN_DURATION_RING"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' THEN DURATION_TALK ELSE 0 END) AS IN_DURATION_TALK"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' THEN DURATION_WRAPUP ELSE 0 END) AS IN_DURATION_WRAPUP"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' THEN 1 ELSE 0 END) AS IN_COUNT_CALL"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND DURATION_TALK > 0 THEN 1 ELSE 0 END) AS IN_COUNT_CALL_CONNECT"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND PARTNERBY_FLAG = 1 THEN 1 ELSE 0 END) AS IN_COUNT_CALL_PARTNERBY"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' THEN DURATION_CALL ELSE 0 END) AS OUT_DURATION_CALL"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' THEN DURATION_RING ELSE 0 END) AS OUT_DURATION_RING"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' THEN DURATION_TALK ELSE 0 END) AS OUT_DURATION_TALK"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' THEN DURATION_WRAPUP ELSE 0 END) AS OUT_DURATION_WRAPUP"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' THEN 1 ELSE 0 END) AS OUT_COUNT_CALL"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND DURATION_TALK > 0 THEN 1 ELSE 0 END) AS OUT_COUNT_CALL_CONNECT"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND PARTNERBY_FLAG = 1 THEN 1 ELSE 0 END) AS OUT_COUNT_CALL_PARTNERBY"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '00' AND CALL_START_TIME < '01' AND CALL_START_TIME < '' THEN DURATION_CALL ELSE 0 END) AS IN_DURATION_CALL_00_01"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '01' AND CALL_START_TIME < '02' THEN DURATION_CALL ELSE 0 END) AS IN_DURATION_CALL_01_02"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '02' AND CALL_START_TIME < '03' THEN DURATION_CALL ELSE 0 END) AS IN_DURATION_CALL_02_03"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '03' AND CALL_START_TIME < '04' THEN DURATION_CALL ELSE 0 END) AS IN_DURATION_CALL_03_04"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '04' AND CALL_START_TIME < '05' THEN DURATION_CALL ELSE 0 END) AS IN_DURATION_CALL_04_05"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '05' AND CALL_START_TIME < '06' THEN DURATION_CALL ELSE 0 END) AS IN_DURATION_CALL_05_06"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '06' AND CALL_START_TIME < '07' THEN DURATION_CALL ELSE 0 END) AS IN_DURATION_CALL_06_07"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '07' AND CALL_START_TIME < '08' THEN DURATION_CALL ELSE 0 END) AS IN_DURATION_CALL_07_08"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '08' AND CALL_START_TIME < '09' THEN DURATION_CALL ELSE 0 END) AS IN_DURATION_CALL_08_09"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '09' AND CALL_START_TIME < '10' THEN DURATION_CALL ELSE 0 END) AS IN_DURATION_CALL_09_10"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '10' AND CALL_START_TIME < '11' THEN DURATION_CALL ELSE 0 END) AS IN_DURATION_CALL_10_11"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '11' AND CALL_START_TIME < '12' THEN DURATION_CALL ELSE 0 END) AS IN_DURATION_CALL_11_12"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '12' AND CALL_START_TIME < '13' THEN DURATION_CALL ELSE 0 END) AS IN_DURATION_CALL_12_13"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '13' AND CALL_START_TIME < '14' THEN DURATION_CALL ELSE 0 END) AS IN_DURATION_CALL_13_14"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '14' AND CALL_START_TIME < '15' THEN DURATION_CALL ELSE 0 END) AS IN_DURATION_CALL_14_15"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '15' AND CALL_START_TIME < '16' THEN DURATION_CALL ELSE 0 END) AS IN_DURATION_CALL_15_16"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '16' AND CALL_START_TIME < '17' THEN DURATION_CALL ELSE 0 END) AS IN_DURATION_CALL_16_17"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '17' AND CALL_START_TIME < '18' THEN DURATION_CALL ELSE 0 END) AS IN_DURATION_CALL_17_18"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '18' AND CALL_START_TIME < '19' THEN DURATION_CALL ELSE 0 END) AS IN_DURATION_CALL_18_19"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '19' AND CALL_START_TIME < '20' THEN DURATION_CALL ELSE 0 END) AS IN_DURATION_CALL_19_20"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '20' AND CALL_START_TIME < '21' THEN DURATION_CALL ELSE 0 END) AS IN_DURATION_CALL_20_21"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '21' AND CALL_START_TIME < '22' THEN DURATION_CALL ELSE 0 END) AS IN_DURATION_CALL_21_22"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '22' AND CALL_START_TIME < '23' THEN DURATION_CALL ELSE 0 END) AS IN_DURATION_CALL_22_23"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '23' AND CALL_START_TIME < '24' THEN DURATION_CALL ELSE 0 END) AS IN_DURATION_CALL_23_24"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '00' AND CALL_START_TIME < '01' THEN 1 ELSE 0 END) AS IN_COUNT_CALL_00_01"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '01' AND CALL_START_TIME < '02' THEN 1 ELSE 0 END) AS IN_COUNT_CALL_01_02"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '02' AND CALL_START_TIME < '03' THEN 1 ELSE 0 END) AS IN_COUNT_CALL_02_03"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '03' AND CALL_START_TIME < '04' THEN 1 ELSE 0 END) AS IN_COUNT_CALL_03_04"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '04' AND CALL_START_TIME < '05' THEN 1 ELSE 0 END) AS IN_COUNT_CALL_04_05"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '05' AND CALL_START_TIME < '06' THEN 1 ELSE 0 END) AS IN_COUNT_CALL_05_06"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '06' AND CALL_START_TIME < '07' THEN 1 ELSE 0 END) AS IN_COUNT_CALL_06_07"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '07' AND CALL_START_TIME < '08' THEN 1 ELSE 0 END) AS IN_COUNT_CALL_07_08"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '08' AND CALL_START_TIME < '09' THEN 1 ELSE 0 END) AS IN_COUNT_CALL_08_09"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '09' AND CALL_START_TIME < '10' THEN 1 ELSE 0 END) AS IN_COUNT_CALL_09_10"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '10' AND CALL_START_TIME < '11' THEN 1 ELSE 0 END) AS IN_COUNT_CALL_10_11"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '11' AND CALL_START_TIME < '12' THEN 1 ELSE 0 END) AS IN_COUNT_CALL_11_12"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '12' AND CALL_START_TIME < '13' THEN 1 ELSE 0 END) AS IN_COUNT_CALL_12_13"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '13' AND CALL_START_TIME < '14' THEN 1 ELSE 0 END) AS IN_COUNT_CALL_13_14"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '14' AND CALL_START_TIME < '15' THEN 1 ELSE 0 END) AS IN_COUNT_CALL_14_15"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '15' AND CALL_START_TIME < '16' THEN 1 ELSE 0 END) AS IN_COUNT_CALL_15_16"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '16' AND CALL_START_TIME < '17' THEN 1 ELSE 0 END) AS IN_COUNT_CALL_16_17"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '17' AND CALL_START_TIME < '18' THEN 1 ELSE 0 END) AS IN_COUNT_CALL_17_18"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '18' AND CALL_START_TIME < '19' THEN 1 ELSE 0 END) AS IN_COUNT_CALL_18_19"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '19' AND CALL_START_TIME < '20' THEN 1 ELSE 0 END) AS IN_COUNT_CALL_19_20"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '20' AND CALL_START_TIME < '21' THEN 1 ELSE 0 END) AS IN_COUNT_CALL_20_21"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '21' AND CALL_START_TIME < '22' THEN 1 ELSE 0 END) AS IN_COUNT_CALL_21_22"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '22' AND CALL_START_TIME < '23' THEN 1 ELSE 0 END) AS IN_COUNT_CALL_22_23"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'I' AND CALL_START_TIME >= '23' AND CALL_START_TIME < '24' THEN 1 ELSE 0 END) AS IN_COUNT_CALL_23_24"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '00' AND CALL_START_TIME < '01' THEN DURATION_CALL ELSE 0 END) AS OUT_DURATION_CALL_00_01"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '01' AND CALL_START_TIME < '02' THEN DURATION_CALL ELSE 0 END) AS OUT_DURATION_CALL_01_02"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '02' AND CALL_START_TIME < '03' THEN DURATION_CALL ELSE 0 END) AS OUT_DURATION_CALL_02_03"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '03' AND CALL_START_TIME < '04' THEN DURATION_CALL ELSE 0 END) AS OUT_DURATION_CALL_03_04"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '04' AND CALL_START_TIME < '05' THEN DURATION_CALL ELSE 0 END) AS OUT_DURATION_CALL_04_05"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '05' AND CALL_START_TIME < '06' THEN DURATION_CALL ELSE 0 END) AS OUT_DURATION_CALL_05_06"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '06' AND CALL_START_TIME < '07' THEN DURATION_CALL ELSE 0 END) AS OUT_DURATION_CALL_06_07"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '07' AND CALL_START_TIME < '08' THEN DURATION_CALL ELSE 0 END) AS OUT_DURATION_CALL_07_08"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '08' AND CALL_START_TIME < '09' THEN DURATION_CALL ELSE 0 END) AS OUT_DURATION_CALL_08_09"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '09' AND CALL_START_TIME < '10' THEN DURATION_CALL ELSE 0 END) AS OUT_DURATION_CALL_09_10"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '10' AND CALL_START_TIME < '11' THEN DURATION_CALL ELSE 0 END) AS OUT_DURATION_CALL_10_11"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '11' AND CALL_START_TIME < '12' THEN DURATION_CALL ELSE 0 END) AS OUT_DURATION_CALL_11_12"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '12' AND CALL_START_TIME < '13' THEN DURATION_CALL ELSE 0 END) AS OUT_DURATION_CALL_12_13"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '13' AND CALL_START_TIME < '14' THEN DURATION_CALL ELSE 0 END) AS OUT_DURATION_CALL_13_14"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '14' AND CALL_START_TIME < '15' THEN DURATION_CALL ELSE 0 END) AS OUT_DURATION_CALL_14_15"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '15' AND CALL_START_TIME < '16' THEN DURATION_CALL ELSE 0 END) AS OUT_DURATION_CALL_15_16"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '16' AND CALL_START_TIME < '17' THEN DURATION_CALL ELSE 0 END) AS OUT_DURATION_CALL_16_17"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '17' AND CALL_START_TIME < '18' THEN DURATION_CALL ELSE 0 END) AS OUT_DURATION_CALL_17_18"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '18' AND CALL_START_TIME < '19' THEN DURATION_CALL ELSE 0 END) AS OUT_DURATION_CALL_18_19"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '19' AND CALL_START_TIME < '20' THEN DURATION_CALL ELSE 0 END) AS OUT_DURATION_CALL_19_20"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '20' AND CALL_START_TIME < '21' THEN DURATION_CALL ELSE 0 END) AS OUT_DURATION_CALL_20_21"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '21' AND CALL_START_TIME < '22' THEN DURATION_CALL ELSE 0 END) AS OUT_DURATION_CALL_21_22"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '22' AND CALL_START_TIME < '23' THEN DURATION_CALL ELSE 0 END) AS OUT_DURATION_CALL_22_23"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '23' AND CALL_START_TIME < '24' THEN DURATION_CALL ELSE 0 END) AS OUT_DURATION_CALL_23_24"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '00' AND CALL_START_TIME < '01' THEN 1 ELSE 0 END) AS OUT_COUNT_CALL_00_01"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '01' AND CALL_START_TIME < '02' THEN 1 ELSE 0 END) AS OUT_COUNT_CALL_01_02"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '02' AND CALL_START_TIME < '03' THEN 1 ELSE 0 END) AS OUT_COUNT_CALL_02_03"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '03' AND CALL_START_TIME < '04' THEN 1 ELSE 0 END) AS OUT_COUNT_CALL_03_04"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '04' AND CALL_START_TIME < '05' THEN 1 ELSE 0 END) AS OUT_COUNT_CALL_04_05"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '05' AND CALL_START_TIME < '06' THEN 1 ELSE 0 END) AS OUT_COUNT_CALL_05_06"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '06' AND CALL_START_TIME < '07' THEN 1 ELSE 0 END) AS OUT_COUNT_CALL_06_07"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '07' AND CALL_START_TIME < '08' THEN 1 ELSE 0 END) AS OUT_COUNT_CALL_07_08"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '08' AND CALL_START_TIME < '09' THEN 1 ELSE 0 END) AS OUT_COUNT_CALL_08_09"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '09' AND CALL_START_TIME < '10' THEN 1 ELSE 0 END) AS OUT_COUNT_CALL_09_10"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '10' AND CALL_START_TIME < '11' THEN 1 ELSE 0 END) AS OUT_COUNT_CALL_10_11"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '11' AND CALL_START_TIME < '12' THEN 1 ELSE 0 END) AS OUT_COUNT_CALL_11_12"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '12' AND CALL_START_TIME < '13' THEN 1 ELSE 0 END) AS OUT_COUNT_CALL_12_13"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '13' AND CALL_START_TIME < '14' THEN 1 ELSE 0 END) AS OUT_COUNT_CALL_13_14"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '14' AND CALL_START_TIME < '15' THEN 1 ELSE 0 END) AS OUT_COUNT_CALL_14_15"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '15' AND CALL_START_TIME < '16' THEN 1 ELSE 0 END) AS OUT_COUNT_CALL_15_16"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '16' AND CALL_START_TIME < '17' THEN 1 ELSE 0 END) AS OUT_COUNT_CALL_16_17"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '17' AND CALL_START_TIME < '18' THEN 1 ELSE 0 END) AS OUT_COUNT_CALL_17_18"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '18' AND CALL_START_TIME < '19' THEN 1 ELSE 0 END) AS OUT_COUNT_CALL_18_19"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '19' AND CALL_START_TIME < '20' THEN 1 ELSE 0 END) AS OUT_COUNT_CALL_19_20"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '20' AND CALL_START_TIME < '21' THEN 1 ELSE 0 END) AS OUT_COUNT_CALL_20_21"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '21' AND CALL_START_TIME < '22' THEN 1 ELSE 0 END) AS OUT_COUNT_CALL_21_22"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '22' AND CALL_START_TIME < '23' THEN 1 ELSE 0 END) AS OUT_COUNT_CALL_22_23"
					+ ", SUM(CASE WHEN INOUTBOUND_CODE = 'O' AND CALL_START_TIME >= '23' AND CALL_START_TIME < '24' THEN 1 ELSE 0 END) AS OUT_COUNT_CALL_23_24"
					+ ", CALL_START_DATE"
					+ ", GETDATE()"
				+ "	FROM orkcall"
				+ "	WHERE CALL_START_DATE = Convert(varchar(10),Getdate()-1,112)"
				+ "	GROUP BY USER_ID, ZIRECXID, CALL_START_DATE");
			
			logger.debug("query: "+sb.toString());
			
			pstmt = conn.prepareStatement(sb.toString());
			result = pstmt.executeUpdate();
			
			conn.commit();
			pstmt.close();
			
			logger.debug("result: "+result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally{
				if(pstmt!=null)	 {
					try{
						pstmt.close();
					} catch(SQLException e){
						e.printStackTrace();
					}
				}
				if(conn!=null){
					try{
						conn.close();
					}catch(SQLException e){
						e.printStackTrace();
					}
				}
		}
		
		logger.info("=========== reportdailyinsert end ===========");
		
	}

}