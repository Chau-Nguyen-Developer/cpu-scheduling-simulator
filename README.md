# CPU Scheduling Simulator  
This program stmulates the following CPU scheduling algorirthms:  
1. First Come First Serve (FCFS)  
2. Shortest Job First (SJF)
3. Preemptive Priority Scheduling  
4. Round Robin (RR) 

The task information will be read from an input file witht the following format
```  
Pid Arrival_Time Burst_Time Priority
```

All fields are integer type.   
Unit for time: milliseconds  
```Pid``` is a unique numberic process ID  
```Arrival_Time``` is the time when the task arrives  
```Burst_Time``` is the CPU time requested by a task  
```Priority``` is the priority associated with each task. Low numbers = High priority.  

Note: For RR algorithm, you need to define a Time-Quantum.  

### Task  
Create a simple user interface to ask user for input.txt file, a scheduling algorithn, and Time Quantum if Round Robin is chosen.  

Print progress of task every unit time (millisecond).
Once all tasks are completed, the program should compute and print:
* Average waiting time
* Average response time
* Average turn-around time
* CPU Utilization Rate 

### Draft Outline
#### Part 1
[✔] Read from file  
[✔] Populate info to each process instances
#### Part 2. First Come First Serve
[]Sort pocesses based on their arrive time. Use map to look them up fast?  
[]Create the scheme who go first and who go next  
[]Wait time of a process = its arrival time + the burst time of the one before it (if it has predecessor)  
[]Response time = wait time  
[]Process time = Burst time    

#### Part 3. Shortest-Job First

#### Part 4. Round Robin with Quantum Time = 50

#### Part 5. Create prompt to ask users for their file 

#### Part 6. Create prompt to ask users which algorithm they want
