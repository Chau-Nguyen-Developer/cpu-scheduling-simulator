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
    private int response_time;
    private int wait_time;
    private int turnaround_time;

    //INSTANCE METHODS
    //GETTER METHODS
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

}