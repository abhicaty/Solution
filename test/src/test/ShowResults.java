package test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ShowResults 
{
	 private static final String EXTENSION = ".csv";
     private static final String FILENAME = "Output";
     
	 public void printDetails(UserInput userInput) 
	 {
	        for (DataSet data : userInput.dataSetList)
	            System.out.format("Distance = %s, Time = %s, Speed (calculated) = %s\n", data.distance, data.time, data.speed);
	    }

	    public boolean exportToCSV(UserInput userInput) {
	        List<String> heading = List.of("Distance", "Time", "Speed");

	        PrintWriter printWriter = null;
	        try 
	        {
	        	FileWriter fileWriter = new FileWriter(FILENAME + EXTENSION);
	            printWriter = new PrintWriter(fileWriter);
	            printWriter.println(heading.toString().replace("[", "").replace("]", ""));
	            for (DataSet dataSet : userInput.dataSetList)
	                printWriter.println(dataSet.distance + ", " + dataSet.time + ", " + dataSet.speed);
	            return true;
	        } 
	        catch (IOException e) 
	        {
	            e.printStackTrace();
	            return false;
	        } 
	        finally 
	        {
	            if (printWriter != null)
	                printWriter.close();
	        }


	    }
}
