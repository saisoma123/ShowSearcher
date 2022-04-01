// --== CS400 Project One File Header ==--
// Name: Surya Somayyajula
// CSL Username: somayyajula
// Email: somayyajula@wisc.edu
// Lecture #: 002 @1:00pm
// Notes to Grader: <any optional extra notes to your grader>
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;
/**
 *
 *
 *
 * This contains the full implementation the ShowSearcherBackend
 *
 */
public class ShowSearcherBackend implements IShowSearcherBackend
{
	private HashTableSortedSets<String,IShow> set1; //This HashTable maps a keyword to TV titles that include the keyword
	private HashTableSortedSets<Integer,IShow> set2; //This HashTable maps a year to TV titles that were produced in that year
	private int size; //Keeps track of the number of additions to the 2 Hash Tables
	private HashMap<String, Boolean> providers; //This HashTable maps providers to whether or not they are off or on
	private String[] providersList = new String[4];
	/**
 	 *
 	 *
 	 *
 	 * This constructor constructs the Hash Tables, and puts the providers and their values 
 	 *
 	 */

	public ShowSearcherBackend()
	{
		set1 = new HashTableSortedSets<String, IShow>();
		set2 = new HashTableSortedSets<Integer,IShow>();
		providers = new HashMap<String, Boolean>();
		size = 0;
		providers.put("Netflix", true);
		providers.put("Hulu", true);
		providers.put("Prime Video", true);
		providers.put("Disney+", true);
		providersList[0] = "Netflix";
		providersList[1] = "Hulu";
		providersList[2] = "Prime Video";
		providersList[3] = "Disney+";
	}
        /**
         *
         *
         * Takes the show title and takes every keyword and maps it to the show, and does the same thing with years
         *
         *
         */
	public void addShow(IShow show)
	{
		String showTitle = show.getTitle();
		String[] split  = showTitle.split(" ");
		for(String k: split)
		{
			set1.add(k, show);
		}
		set2.add(show.getYear(), show);
		size++;

	}
        /**
         *
         * Getter method for the size field
         *
         *
         *
         */
	public int getNumberOfShows()
	{
		return size;
	}
        /**
         *
         * Sets a provider key to a certain boolean value
         *
         *
         *
         */
	public void setProviderFilter(String provider, boolean filter)
	{
		providers.remove(provider); //otherwise put would not be able to put in repeat key
		providers.put(provider, filter);

	}
	/**
         *
         * Gets a true or false based on a provider filter 
         *
         *
         *
         */
	public boolean getProviderFilter(String provider)
	{
		return providers.get(provider);
	}
	/**
         * Negates the boolean value that is associated with a specific provider
         *
         *
         *
	 *
         */
	public void toggleProviderFilter(String provider)
	{
		boolean value = providers.remove(provider);
		providers.put(provider, !value);
	}
	/**
         *  Returns a list of shows that contain a common keyword
         *
         *
         *
         */ 
        public List<IShow> searchByTitleWord(String word)
	{
		if(set1.containsKey(word))
		{
			List<IShow> titles = set1.get(word); //Gets the list with all shows that have that common given keyword
                	Set<IShow> filtered = new HashSet<IShow>(); //The set that will be used that has the filtered search list
                	for(String filter: providers.keySet())
                	{
                        	for(int i = 0; i < titles.size(); i++)
                        	{
                                	if(providers.get(filter) && titles.get(i).isAvailableOn(filter) == true) // If a particular filter is on and if a show is available on a provider
                                	{
                                        	filtered.add(titles.get(i)); //Adds to the filtered set, if the same show is added, it will not happen
                                	}
                        	}
                	}
                	ArrayList<IShow> convert = new ArrayList<IShow>(filtered); //Converts HashSet to ArrayList
                	Collections.sort(convert, Collections.reverseOrder()); //Sorts in descending order
                	return convert;
		}
		else
		{
			return null;
		}
	}
	/**
         *  Returns a list of shows that contain a common year
         *
         *
         *
         */ 
	public List<IShow> searchByYear(int year)
	{
		if(set2.containsKey(year))
		{
			List<IShow> titles = set2.get(year); //Gets the list with all shows that were produced in the same year
                	Set<IShow> filtered = new HashSet<IShow>(); //The set that will be used that has the filtered search
                	for(String filter: providers.keySet())
                	{
                        	for(int i = 0; i < titles.size(); i++)
                        	{
                                	if(providers.get(filter) && titles.get(i).isAvailableOn(filter) == true)//The rest of this code is the same as searchByTitleWord
                                	{
                                        	filtered.add(titles.get(i));
                                	}
                        	}
                	}
             		ArrayList<IShow> convert = new ArrayList<IShow>(filtered); //Converts HashSet to ArrayList
                	Collections.sort(convert, Collections.reverseOrder()); //Sorts in descending order
                	return convert;
		}
		else
		{
			return null;
		}

	}


}
