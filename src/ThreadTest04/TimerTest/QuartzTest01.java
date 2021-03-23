/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest04.TimerTest;

import java.util.Date;
import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.DateBuilder.evenSecondDateAfterNow;
import static org.quartz.JobBuilder.newJob;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import org.quartz.Trigger;
import static org.quartz.TriggerBuilder.newTrigger;
import org.quartz.impl.StdSchedulerFactory;

/**
 * quartz 学习
 * @author WarSpite
 */
public class QuartzTest01 {
    public void run() throws Exception{
        //1.创建Scheduler的工厂
        SchedulerFactory sf = new StdSchedulerFactory();
        //2.从工厂中获取调度器
        Scheduler sched = sf.getScheduler();
   
        //3.创建JobDetail
        JobDetail job = newJob(HelloJob.class).withIdentity("job1","group1").build();
        
        //时间
        Date runTime = evenSecondDateAfterNow();
        
        //4.触发器
        //Trigger trigger = newTrigger().withIdentity("trigger1","group1").startAt(runTime).build();
        Trigger trigger = newTrigger().withIdentity("trigger1","group1").startAt(runTime)
                .withSchedule(simpleSchedule().withIntervalInMinutes(5).withRepeatCount(3)).build();
        //5.注册任务和触发条件
        sched.scheduleJob(job,trigger);
        
        //6.启动
        sched.start();
        try{
            //等500秒后停止
            Thread.sleep(500L*1000L);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        //停止
        sched.shutdown(true);
    }
    public static void main(String[] args) throws Exception{
        
        QuartzTest01 example = new QuartzTest01();
        example.run();
        
    }
}
