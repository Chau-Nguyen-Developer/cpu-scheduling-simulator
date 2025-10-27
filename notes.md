### Notes
##### What is under the hood of ...?
 
Doing research about what is under the hood of ```processes.sort(Comparator.comparing(Process::getArrivalTime))```

```processess.sort``` delegates the sorting task to Collections.sort(), which use TimSort() algorithm. 
TimSort is a modified merge sort algo.  

These two are equivalent:  

```
processes.sort(someComparator); 
```
```
Collections.sort(processes, someComparator);
```
Internally, it looks like this:
```
Comparator<Process> comparator = (p1, p2) -> Integer.compare(p1.getArrivalTime(), p2.getArrivalTime())
```

```p1::getArrivalTime()``` is the same as ```p1 -> p1.getArrivalTime()```

Explicitly (not using lambdas)
```
Comparator<Process> comparator = new Comparator<>()
{
    @Override
    public int compare(Process p1, Process p2)
    {
        return Integer.compare(p1.getArrivalTime(), p2.getArrivalTime());
    }
};

Collections.sort(processes, comparator);
```