package test;

	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.PrintWriter;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Scanner;
	

	public class Measure 
	{
		 private static final String EXTENSION = ".csv";
         private static final String FILENAME = "Output";

	    public static UserInput calculateSpeed(UserInput userInput) 
	       {
	        for(DataSet data : userInput.dataSetList)
	        {
	            data.speed = data.distance / data.time;
	        }
	        return userInput;
	    }

	    public static void main(String[] args) 
	    {
	        List<DataSet> dataSets = new ArrayList<>();
	        Scanner scanf = new Scanner(System.in);
	        System.out.println("Enter the size of the Data Set");
	        int n = scanf.nextInt();
	        for (int i = 0; i < n; i++) 
	            {
	            System.out.println("Enter distance (KM) and Time (Hr) - %s".formatted(i + 1));
	            dataSets.add (new DataSet(scanf.nextDouble(), scanf.nextDouble()));
	            }
	        scanf.close();

	        UserInput userInput = new UserInput();
	        userInput.dataSetList = dataSets;
	        ShowResults showResults = new ShowResults();
	        if ( showResults.exportToCSV(calculateSpeed(userInput))) 
	        {
	        	 showResults.printDetails(userInput);
	            System.out.println("Successfully Exported the file: " + FILENAME + EXTENSION);
	        } 
	        else
	            System.out.println("Something went wrong. Check logs for more details");
	    }   
	}

