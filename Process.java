//PROGRAMMER: CHAU NGUYEN

public class Process
{
    //INSTANCE VARIABLE
    //unique numeric process id
    private int PID;
    //the time when the process arrives (milliseconds)
    //(aka ready to be executed and enter queue to wait for its turn on the CPU)
    private int arrival_time;
    //CPU time requested by a task (milliseconds)
    private int burst_time;
    private int priorirty;
    private int start_time;
    private int end_time;
    private int wait_time;
    private int response_time;
    private int turnaround_time;

    //CONSTRUCTORS
    //Default Constructor
    public Process()
    {
        PID = 0;
        arrival_time = 0;
        burst_time = 0;
        priorirty = 0;
        start_time = 0;
        end_time = 0;
        response_time = 0;
        wait_time = 0;
        turnaround_time = 0;
    }

    //Parameterized Constructor
    public Process(int id, int arrive, int burst, int priorirty)
    {
        this.PID = id;
        this.arrival_time = arrive;
        this.burst_time = burst;
        this.priorirty = priorirty;
    }
    //INSTANCE METHODS
    //GETTER METHODS
    public int getPID()
    {
        return this.PID;
    }
    public int getArrivalTime()
    {
        return this.arrival_time;
    }
    public int getBurstTime()
    {
        return this.burst_time;
    }
    public int getPriorityNumber()
    {
        return this.priorirty;
    }
    public int getStartTime()
    {
        return this.start_time;
    }
    public int getEndTime()
    {
        return this.end_time;
    }
    public int getResponseTime()
    {
        return this.response_time;
    }
    public int getWaitTime()
    {
        return this.wait_time;
    }
    public int getTurnAroundTime()
    {
        return this.turnaround_time;
    }


    //SETTER METHODS
    public void setArrivalTime(int givenTime)
    {
        this.arrival_time = givenTime;
    }
    public void setBurstTime(int givenTime)
    {
        this.burst_time = givenTime;
    }
    public void setPriorityNumber(int givenTime)
    {
       this.priorirty = givenTime;
    }
    public void setStartTime(int givenTime)
    {
        this.start_time = givenTime;
    }
    public void setEndTime(int givenTime)
    {
        this.end_time = givenTime;
    }
    public void setResponseTime(int givenTime)
    {
        this.response_time = givenTime;
    }
    public void setWaitTime(int givenTime)
    {
        this.wait_time = givenTime;
    }
    public void setTurnAroundTime(int givenTime)
    {
        this.turnaround_time = givenTime;
    }

    //HELPER FUNCTION 
    @Override
    public String toString()
    {
        return "Process ID = " + this.PID + ", Arrival_Time = " + this.arrival_time + ", Burst_Time = " + this.burst_time + ", Priority = " + this.priorirty;
    }

    public String extraInfoAfterRunning()
    {
        return this.toString() + " Wait_Time= " + this.wait_time + " Response_Time= " + this.response_time + " Turn_around_time= " + this.turnaround_time;
    }

}