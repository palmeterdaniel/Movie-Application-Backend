import java.util.List;

 * Class that stores and allows access to data about a movie. Includes a toString() method to
 * return that information formatted.
 * @author Daniel Palmeter
 */
public class Movie implements MovieInterface{
	
	String title; // data for each movie Object
	Integer year;
	List<String> genres;
	String director;
	String description;
	Float avgVote;

	/**
	 * Constructor to make a movie object with the data passed into the constructor
	 * @param title title of this movie
	 * @param year year this movie was made
	 * @param genres genres of this movie
	 * @param director director of this movie
	 * @param description description of this movie
	 * @param avgVote average vote of this movie
	 */
	public Movie(String title, Integer year, List<String> genres, String director, String description, Float avgVote) {
		this.title = title; // sets all values passed to this object
		this.year = year;
		this.genres = genres;
		this.director = director;
		this.description = description;
		this.avgVote = avgVote;
	}
	
	/**
	 * Getter to retrieve title
	 * @return title String title of this movie
	 */
	@Override
	public String getTitle() {
		return title;
	}

	/**
	 * Getter to retrieve year this movie was made
	 * @return year Integer year this movie was made
	 */
	@Override
	public Integer getYear() {
		return year;
	}

	/**
	 * Getter to retrieve list of genres
	 * @return genres List<String> of genres this movie has
	 */
	@Override
	public List<String> getGenres() {
		return genres;
	}

	/**
	 * Getter to retrieve director
	 * @return director String director of this movie
	 */
	@Override
	public String getDirector() {
		return director;
	}
	
	/**
	 * Getter to retrieve description
	 * @return description String description of this movie
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * Getter to return average vote of this movie
	 * @return avgVote Float average vote of this movie
	 */
	@Override
	public Float getAvgVote() {
		return avgVote;
	}

	/**
	 * Overrides Java's default compareTo method. Returns 0 if movies have the same average vote,
	 * 1 if this movie has a lower average vote than the one passed in, and -1 if this movie
	 * has a higher average vote than the movie passed in.
	 * @param otherMovie the other movie this movie will be compared to
	 * @return 1 if this has higher vote, -1 if lower vote, 0 if same vote
	 */
	@Override
	public int compareTo(MovieInterface otherMovie) {
		if(this.getAvgVote().equals(otherMovie.getAvgVote())) {
			return 0;
		}
		if(this.getAvgVote() < (otherMovie.getAvgVote())) {
			return 1;
		}
		else return -1;
	}
	
	/**
	 * Overrides Java's default toString method. Returns a formatted String listing all the
	 * data elements held in this movie object.
	 * @return a formatted string of all data stored in this movie object
	 */
	@Override
	public String toString() {
		
		String genresString = genres.toString(); // changes List<String> to String
		genresString = genresString.substring(1, genresString.length()-1); // takes out brackets to match rest of output string
		
		return("Title: " + title + "; " + "Year: " + year + "; " + "Genre: " + genresString + "; " + "Director: " + director +
				"; " + "Description: " + description + "; " + "Average vote: " + avgVote); // formatted list
		
	}
	
}
