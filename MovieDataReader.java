import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.DataFormatException;

/**
 * Class to read in movies from a csv and make a List of them
 * @author Daniel Palmeter
 */
public class MovieDataReader implements MovieDataReaderInterface{

	/**
	 * Reads in a csv, creating a new Movie object holding all relevant data in each new line.
	 * @param inputFileReader the reader passed to read a specific file
	 * @return list List<MovieInterface> that contains a Movie object for each line in csv
	 * @throws IOException when file cannot be opened or there is some other error reading it
	 * @throws DataFormatException when data in a line of csv is in the incorrect format
	 */
	@Override
	public List<MovieInterface> readDataSet(Reader inputFileReader)
			throws IOException, DataFormatException {
		
		List<MovieInterface> list = new ArrayList<MovieInterface>(); // List that will be returned
		
		/*
		 * These are each variables for each relevant column in the csv corresponding to an element
		 * of its Movie object. temp refers to the fact that they are variables that are changed 
		 * every time a new line is read. 
		 */
		String tempTitle;
		Integer intYear; // proper data type that will be converted to after stored in array
		String tempYear;
		List<String> listGenres; // proper data type that will be converted to after stored in array
		String tempGenres;
		String tempDirector;
		String tempDescription;
		Float floatAvgVote; // proper data type that will be converted to after stored in array
		String tempAvgVote;
		
		BufferedReader reader = new BufferedReader(inputFileReader); // reads file

		// try-catch block to try to read file header and throw IOException if something goes wrong
		try {
			reader.readLine(); // read first line
		} catch (IOException e) {
			throw new IOException ("Error while reading file"); 
		}

		String row; // each row in file
		while ((row = reader.readLine()) != null) { // each line is set to row until end of file
			// splits each line up into an array of Strings, keeping parts of the String in double quotes as one element
			String[] split = row.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
	
			for(int i=0;i<split.length;i++) { // for each element of array
				
				if(split[i].contains("\"")) { // if it contains a double quote
					split[i] = split[i].substring(1, split[i].length()-1); // remove both double quotes
				}
				
			}
			
			if(split.length != 13) { // checks to make sure each row has correct number of elements
				throw new DataFormatException("File does not have correct format");
			}
			
			// sets each piece of data to String held at its relevant index in array
			tempTitle = split[0];
			tempYear = split[2];
			tempGenres = split[3];
			tempDirector = split[7];
			tempDescription = split[11];
			tempAvgVote = split[12];
			
			intYear = Integer.parseInt(tempYear); // changes vars into correct data types
			floatAvgVote = Float.parseFloat(tempAvgVote);
			listGenres = Arrays.asList(tempGenres.split("\\s*,\\s*")); 
			
			// makes new Movie object using above data
			Movie newMovie = new Movie(tempTitle, intYear, listGenres, tempDirector, tempDescription, floatAvgVote);
			list.add(newMovie); // adds it to list that will be returned
			
		}
		
		return list;
		
	}

}