//PROGRAMMER: CHAU NGUYEN
import java.util.*;
import java.io.*;


public class CPU_Simulator
{
    //GLOBAL VARIABLE 
    static int numberOfProcess = 0; 
    static List<Process> processesList = new ArrayList<>();
    static String line;
    static String parts[];
    static int numArray[];
    static boolean success_read_file = false;

    //MAIN FUNCTION
    public static void main(String[] args) throws IOException, InterruptedException
    {
        //DISCLAIMER
        System.out.println("The program currently supports only the First Come First Serve (FCFS) scheduling algorithm. " + 
        "Additional CPU scheduling algorithms are being developed and will be added to GitHub over time. " + 
        "For more details, please refer to the README.md file. Thank you for using this product. -Chau");

        //READ IN USER'S INPUT FILE
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter your .txt file (ex: test1.txt): ");
        String filepath = scan.nextLine();

        // String filePath = "test1.txt";
        if(!readFile(filepath))
        {
            System.out.println("Success_read_file = " + success_read_file);
            System.exit(1);
        }
       
        //Only go here after success reading file.
        //Test: print out processes' info to see whether data is recorded correctly.
        if(success_read_file)
        {
            if(numberOfProcess == 0)
            {
                System.out.println("No processes. Empty file.");
                //Terminate with normal flag.
                System.exit(0);
            }
            System.out.println("Original list: ");
            for(Process p: processesList)
            {
                System.out.println(p.toString());
            }

        }
        

        System.out.println("Doing First Come First Serve Sorting....");
        ProcessScheduling.firstComeFirstServe(processesList);
    }

   //return the number of processes
    public static boolean readFile(String filePath) throws IOException
    {
        numArray = new int[4];

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath)))
        { 
            while((line = reader.readLine()) != null)
            {
                ++numberOfProcess;
                parts = line.split("\\s+");
                //we know each process will have 4 given entries, so I will hardcode number 4 here
                for(int i = 0; i < 4; ++i)
                {
                    numArray[i] = Integer.parseInt(parts[i].trim());
                }
                processesList.add(new Process(numArray[0], numArray[1], numArray[2], numArray[3]));
                //nullify part array 
                for (String part: parts)
                {
                    part = "";
                } 
            }
            success_read_file = true;
            return success_read_file;
        }
        catch(FileNotFoundException e)
        {
            System.err.println(e.getMessage());
            System.out.println("File Not Found.");
            System.exit(1);
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Errors with reading file.");
            System.exit(1);
        }
        catch(NumberFormatException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Errors with converting string to number.");
            System.out.println("File has wrong format.");
            System.exit(1);
        }
        return false;
    }
    
}
