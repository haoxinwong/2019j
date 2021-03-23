/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest04.TimerTest;

import java.util.Date;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author WarSpite
 */
public class HelloJob implements Job{
    
    public HelloJob(){
        
    }

    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        System.out.println("-----start------");
        System.out.println("Hello World! - "+new Date());
        System.out.println("------end------");
    }
    
}
