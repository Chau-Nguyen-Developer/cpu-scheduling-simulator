import java.util.*;

public class ProcessScheduling
{
    static double avgWaitTime = 0.0;
    static double avgResponseTime = 0.0;
    static double avgTurnAroundTime = 0.0;
    static double cpu_util_rate = 0.0;
    public static void firstComeFirstServe(List<Process> list)
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
        Process firstProcess = list.get(0);

        firstProcess.setStartTime(firstProcess.getArrivalTime());
        firstProcess.setEndTime(firstProcess.getStartTime() + firstProcess.getBurstTime());
        firstProcess.setWaitTime(firstProcess.getStartTime() - firstProcess.getArrivalTime());
        //because this is non-preemptive First Come First Serve, so response time = wait time
        firstProcess.setResponseTime(firstProcess.getWaitTime());
        firstProcess.setTurnAroundTime(firstProcess.getEndTime() - firstProcess.getArrivalTime());

        // if(CPU_Simulator.numberOfProcess > 0)
        // {

        // }
        System.out.println("Test out with first process...");
        System.out.println(firstProcess.extraInfoAfterRunning());

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