// --== CS400 Project One File Header ==--
// Name: Surya Somayyajula
// CSL Username: somayyajula
// Email: somayyajula@wisc.edu
// Lecture #: 002 @1:00pm
// Notes to Grader: <any optional extra notes to your grader>
import java.util.List;
        /**
         *
         *
         *
         * This class contains all the test methods for checking the correctness of the backend
         *
         */
public class BackendDeveloperTests
{
	/**
         *This test adds 3 shows to the backend, and checks if the getter method for the number of shows works
         *
         *
         *
         *
         */
         public static boolean test1()
	 {
		try
		{
			ShowSearcherBackend test = new ShowSearcherBackend();
			IShow show = new Show("Futurama", 2002, 8, "Netflix");
			test.addShow(show);
			IShow show1 = new Show("Family Guy", 1999, 7, "Hulu");
			test.addShow(show1);
			IShow show2 = new Show("Simpsons", 1989, 9, "Disney+");
			test.addShow(show2);
			if(test.getNumberOfShows() != 3)
			{
				return false;
			}
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}


	}
	/**
         * The second test makes sure that the filter methods work correctly, and that the truth values are being updated correctly
         *
         *
         *
         *
         */
	public static boolean test2()
	{
		try
		{
			ShowSearcherBackend test = new ShowSearcherBackend();
			IShow show = new Show("Fly Guy", 2002, 8, "Netflix");
                        test.addShow(show);
			test.setProviderFilter("Netflix", false);
			if(test.getProviderFilter("Netflix") != false)
			{
				return false;
			}
			test.toggleProviderFilter("Netflix");
			if(test.getProviderFilter("Netflix") != true)
			{
				return false;
			}
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	/**
         * This method tests to see if a filtered search using the searchByTitleWord method works correctly
         *
         *
         *
         *
         */
	public static boolean test3()
	{
		try
		{
			ShowSearcherBackend test = new ShowSearcherBackend();
			IShow show = new Show("Fly Guy", 2002, 8, "Netflix");
                        test.addShow(show);
                        IShow show1 = new Show("Family Guy", 1999, 7, "Netflix");
                        test.addShow(show1);
                        IShow show2 = new Show("A Guy", 1989, 9, "Disney+");
                        test.addShow(show2);
			test.toggleProviderFilter("Disney+");
			List<IShow> sortedByWord = test.searchByTitleWord("Guy");
			if(sortedByWord.get(0) != show || sortedByWord.get(1) != show1)
			{
				return false;
			}
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	/**
         * This is similar to the last method, except the method used is searchByYear
         *
         *
         *
         *
         */
	public static boolean test4()
	{
		try
                {
                        ShowSearcherBackend test = new ShowSearcherBackend();
                        IShow show = new Show("Fly Guy", 1999, 8, "Netflix");
                        test.addShow(show);
                        IShow show1 = new Show("Family Guy", 1999, 7, "Netflix");
                        test.addShow(show1);
                        IShow show2 = new Show("A Guy", 1989, 9, "Disney+");
                        test.addShow(show2);
                        test.toggleProviderFilter("Disney+");
                        List<IShow> sortedByYear = test.searchByYear(1999);
                        if(sortedByYear.get(0) != show || sortedByYear.get(1) != show1)
                        {
                                return false;
                        }
                        return true;
                }
                catch(Exception e)
                {
                        e.printStackTrace();
                        return false;
                }
	}
	/**
         * This test sees if using multiple toggle and set filters still works on a searchByTitleWord and searchByYear search
         *
         *
         *
         *
         */
	public static boolean test5()
	{
		try
                {
                        ShowSearcherBackend test = new ShowSearcherBackend();
                        IShow show = new Show("Fly Guy", 1999, 8, "Netflix"); 
                        test.addShow(show);
                        IShow show1 = new Show("Family Guy", 1999, 7, "Netflix");
                        test.addShow(show1);
                        IShow show2 = new Show("A Guy", 1989, 9, "Disney+");
                        test.addShow(show2);
                        test.toggleProviderFilter("Disney+");
			test.setProviderFilter("Netflix", false);
                        List<IShow> sortedByYear = test.searchByYear(1999);
			List<IShow> sortedByWord = test.searchByTitleWord("Guy");
                        if(sortedByWord.size() != 0)
                        {
                                return false;
                        }
			if(sortedByYear.size() != 0)
			{
				return false;
			}
                        return true;
                }
                catch(Exception e)
                {
                        e.printStackTrace();
                        return false;
                }
	}
	/**
         * This test sees if the sort method will return null if a keyword that is given does not exist in the HashTable
         *
         *
         *
         *
         */
	public static boolean test6()
	{

		try
		{
			ShowSearcherBackend test = new ShowSearcherBackend();
			IShow show = new Show("Fly Guy", 1999, 8, "Netflix"); 
                        test.addShow(show);
                        IShow show1 = new Show("Family Guy", 1999, 7, "Netflix");
                        test.addShow(show1);
                        IShow show2 = new Show("A Guy", 1989, 9, "Disney+");
                        test.addShow(show2);
			List<IShow> sortedByWord = test.searchByTitleWord("Olive");
			if(sortedByWord != null)
			{
				return false;
			}
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
        /**
         * Does the same as the last test except it uses searchByYear
         *
         *
         *
         *
         */
	public static boolean test7()
	{
		try
                {
                        ShowSearcherBackend test = new ShowSearcherBackend();
                        IShow show = new Show("Fly Guy", 1999, 8, "Netflix"); 
                        test.addShow(show);
                        IShow show1 = new Show("Family Guy", 1999, 7, "Netflix");
                        test.addShow(show1);
                        IShow show2 = new Show("A Guy", 1989, 9, "Disney+");
                        test.addShow(show2);
                        List<IShow> sortedByWord = test.searchByYear(2002);
                        if(sortedByWord != null)
                        {
                                return false;
                        }
                        return true;
                }
                catch(Exception e)
                {
                        e.printStackTrace();
                        return false;
                }
	}
	/**
         * Code Review for Data Wrangler: Checks if the isAvailableOn method in the Show class works
         *
         *
         *
         *
         */
	public static boolean test8()
	{
		try
                {
                        IShow show = new Show("Fly Guy", 1999, 8, "Netflix");
                        if(show.isAvailableOn("Netflix") == false)
                        {
                                return false;
                        }
                        return true;
                }
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	/**
         * Code Review for Data Wrangler: Checks if the isAvailableOn method in the Show class works, in this case, with multiple providers, as opposed to one
         *
         *
         *
         *
         */
	public static boolean test9()
	{
		try
		{
			IShow show = new Show("Fly Guy", 1999, 8, "Netflix, Disney+");
                        if(show.isAvailableOn("Netflix, Disney+") == false)
                        {
                                return false;
                        }
                        return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	/**
         * Checks if all the all test methods return true or false
         *
         *
         *
         *
         */
	public static void main(String[] args)
	{
		System.out.println("test1: " + test1());
		System.out.println("test2: " + test2());
		System.out.println("test3: " + test3());
		System.out.println("test4: " + test4());
		System.out.println("test5: " + test5());
		System.out.println("test6: " + test6());
		System.out.println("test7: " + test7());
		System.out.println("test8: " + test8());
		System.out.println("test9: " + test9());
	}

}
