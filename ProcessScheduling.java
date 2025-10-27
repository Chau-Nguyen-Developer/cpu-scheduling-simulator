import java.util.*;

public class ProcessScheduling
{
    public static void firstComeFirstServe(List<Process> processes)
    {
        //Sort by their arrival time in ascending order
        processes.sort(Comparator.comparing(Process::getArrivalTime));
        System.out.println("Finish sorting in arrival time.");
        for(Process p: processes)
        {
            System.out.print(p.toString());
        }

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