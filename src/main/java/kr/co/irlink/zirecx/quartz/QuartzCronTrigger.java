package kr.co.irlink.zirecx.quartz;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.CronScheduleBuilder.*;


public class QuartzCronTrigger implements ServletContextListener {
	
	public QuartzCronTrigger() throws Exception {
		try{
			
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			
			scheduler.start();
			
			JobDetail job = newJob(ReportDailyInsert.class).withIdentity("job1","group1").build();
			
			
			/**********************************************************/
			//quartz 시간 설정 
			// 0/1 * * * * ?  //매 1초
			// 0 0/1 * * * ?  //매 1분
			// 0 * * * * ?    //매 1분
			// 0 0 0/1 * * ?  //매 1시간 간격
			// 0 0 0 * * ?    //매일 0시마다 
			// 0 0 0 1 * ?    //매월 1일마다 
			// 0 0 0 1,10,20 * ? //매월 1,10,20일마다 
			/**********************************************************/
			
			
			Trigger trigger = newTrigger()
				.withIdentity("trigger1","group1")
				/*.startNow()
				.withSchedule(simpleSchedule()
				.withIntervalInSeconds(5)
				.repeatForever())*/
				//.withSchedule(cronSchedule("0 0 2 * * ?"))
				
				//매 2시마다 실행 
				.withSchedule(cronSchedule("0 0 2 * * ?"))
				
				
				.build();
				
			scheduler.scheduleJob(job, trigger);
			//Thread.sleep(30000);
			//scheduler.shutdown();
			
		}catch(SchedulerException se){
			se.printStackTrace();
		}/*catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
	}
	
	public void contextDestroyed(ServletContextEvent arg0) {
	// TODO Auto-generated method stub
	
	}
	
	public void contextInitialized(ServletContextEvent arg0) {
	// TODO Auto-generated method stub
	
	}
	
}