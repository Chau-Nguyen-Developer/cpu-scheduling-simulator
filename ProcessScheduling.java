//PROGRAMMER: CHAU NGUYEN
import java.util.*;

public class ProcessScheduling
{
    static double avgWaitTime = 0.0;
    static double avgResponseTime = 0.0;
    static double avgTurnAroundTime = 0.0;
    static double idleTime = 0.0;
    static double cpu_util_rate = 0.0;
    public static void firstComeFirstServe(List<Process> list) throws InterruptedException
    {
        //Sort by their arrival time in ascending order
        list.sort(Comparator.comparing(Process::getArrivalTime));
        System.out.println("Finish sorting in arrival time.");
        for(Process p: list)
        {
            System.out.println(p.toString());
        }

        //Calculate first job first and use that as the base for others.
        //Before running FCFS, already guarantee have at least one process.
        Process currentProcess = list.get(0);

        currentProcess.setStartTime(currentProcess.getArrivalTime());
        currentProcess.setEndTime(currentProcess.getStartTime() + currentProcess.getBurstTime());
        currentProcess.setWaitTime(currentProcess.getStartTime() - currentProcess.getArrivalTime());
        //because this is non-preemptive First Come First Serve, so response time = wait time
        currentProcess.setResponseTime(currentProcess.getWaitTime());
        currentProcess.setTurnAroundTime(currentProcess.getEndTime() - currentProcess.getArrivalTime());
        Process previousProcess = currentProcess;


        for (int i = 1; i < CPU_Simulator.numberOfProcess; ++i)
        {
            currentProcess = list.get(i);
            if(currentProcess.getArrivalTime() >= previousProcess.getEndTime())
            {
                currentProcess.setStartTime(currentProcess.getArrivalTime());
                idleTime = currentProcess.getArrivalTime() - previousProcess.getEndTime();
            }
            else
            {
                currentProcess.setStartTime(previousProcess.getEndTime());
            }
            currentProcess.setEndTime(currentProcess.getStartTime() + currentProcess.getBurstTime()); 
            currentProcess.setWaitTime(currentProcess.getStartTime() - currentProcess.getArrivalTime());
            //because this is non-preemptive First Come First Serve, so response time = wait time
            currentProcess.setResponseTime(currentProcess.getWaitTime());
            currentProcess.setTurnAroundTime(currentProcess.getEndTime() - currentProcess.getArrivalTime());

            previousProcess = currentProcess;
        }
        
        //PRINT OUT THE PROGRESS OF RUNNING TASKS
        System.out.println("Test out with first come first serve...");
        for (Process p: list)
        {
            System.out.println("Process ID = " + p.getPID() + " is running...");
            Thread.sleep(p.getBurstTime());
            if(Thread.interrupted())
            {
                throw new InterruptedException();
            }
            System.out.println("Done...");
            System.out.println(p.extraInfoAfterRunning());
        }
        
        //PRINT OUT THE ANALYSIS 
        // static double avgWaitTime = 0.0;
        // static double avgResponseTime = 0.0;
        // static double avgTurnAroundTime = 0.0;
        // static double cpu_util_rate = 0.0;
        for (Process p: list)
        {
            avgWaitTime += p.getWaitTime();
            avgResponseTime += p.getResponseTime();
            avgTurnAroundTime += p.getTurnAroundTime();
        }

        double denominator = CPU_Simulator.numberOfProcess * 1.0;
        avgWaitTime = avgWaitTime / denominator; //turn the denominator to double to prevent integer division
        avgResponseTime = avgResponseTime / denominator;
        avgTurnAroundTime = avgTurnAroundTime / denominator;

        System.out.println("Average Wait Time: " + avgWaitTime);
        System.out.println("Average Response Time: " + avgResponseTime);
        System.out.println("Average Turn Around Time: " + avgTurnAroundTime);
        //get the end time of last process minus the starting time of first process
        double totalRunTime = list.get(CPU_Simulator.numberOfProcess - 1).getEndTime() - list.get(0).getStartTime();
        System.out.println("% CPU Utilization Rate: " + (totalRunTime - idleTime) / (totalRunTime));
    }

    public static void shortestJobFirst(List<Process> processes)
    {
        //Sort by their burst time
    }

    public static void preemptivePriorityScheduling(List<Process> processes)
    {
        //Sort by their priority
        //Low number means higher priority
    }

    public static void roundRobin(List<Process> processes, int timeQuantum)
    {

    }

}