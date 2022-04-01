// --== CS400 Project One File Header ==--
// Name: Surya Somayyajula
// CSL Username: somayyajula
// Email: somayyajula@wisc.edu
// Lecture #: 002 @1:00pm
// Notes to Grader: <any optional extra notes to your grader>

        /**
         *
         *
         *
         * This is a placeholder class for the Show object
         *
         */
public class ShowHolder implements IShow
{
	private String title; 
	private int year;
	private int rating;
	private String providers;
	/**
         *
         *
         *
         * Constructs a ShowHolder object with the necessary attributes 
         *
         */
	public ShowHolder(String title, int year, int rating, String providers)
	{
		this.title = title;
		this.year = year;
		this.rating = rating;
		this.providers = providers;

	}
	/**
         *
         *
         *
         * Getter for the title field
         *
         */
	public String getTitle()
	{
		return title;
	}
        /**
         *
         *
         *
         * Getter for the year field
         *
         */
	public int getYear()
	{
		return year;
	}
        /**
         *
         *
         *
         * Getter for the rating field
         *
         */
	public int getRating()
	{
		return rating;
	}
        /**
         *
         *
         *
         * Checks if the providers string contains the given provider
         *
         */
	public boolean isAvailableOn(String provider)
	{
		return providers.contains(provider);
	}
        /**
         *
         *
         *
         * Compares show ratings for descending order
         *
         */
	public int compareTo(IShow show)
	{
		return show.getRating() - this.getRating(); 
	}	
}
