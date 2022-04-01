import java.io.ByteArrayInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ShowSearcherFrontend implements IShowSearcherFrontend {
	private Scanner in;
	private IShowSearcherBackend backend;

	private final String[] providerList = new String[] {"Netflix","Hulu","Prime Video","Disney+"};

	public ShowSearcherFrontend(IShowSearcherBackend backend) {
		this.backend = backend;
	}

	public ShowSearcherFrontend(String text, IShowSearcherBackend backend) {
		this.backend = backend;
		System.setIn(new ByteArrayInputStream(text.getBytes()));
	}

	/**
	 * Creates a scanner object and starts the loop to get inputs from the user.
	 */
	@Override
	public void runCommandLoop() {
		this.in = new Scanner(System.in);

		System.out.println("Welcome to the Show Searcher App!");
		System.out.println("==========");

		while(true) {
			displayCommandMenu();
			String s = this.in.nextLine();

			switch(s) {
			case "1": case "t": case "T":
				titleSearch();
				break;
			case "2": case "y": case "Y":
				yearSearch();
				break;
			case "3": case "f": case "F":
				filterProviders();
				break;
			case "4": case "q": case "Q":
				System.out.println("Show Searcher App closed.");
				this.in.close();
				return;
			default:
				System.out.println("Invalid command");
				break;
			}
		}
	}

	/**
	 * Displays the options for searching or filtering shows.
	 */
	@Override
	public void displayCommandMenu() {
		System.out.println("Command Menu:");
		System.out.println("\t1) [T] Search by title");
		System.out.println("\t2) [Y] Search by year");
		System.out.println("\t3) [F] Filter by streaming provider");
		System.out.println("\t4) [Q] Quit");

		System.out.print("Choose a command from the menu above: ");
	}

	/**
	 * Displays the current filter options for the 4 providers. If the provider is
	 * currently being searched for there is: "_x_" and if it is disabled: "___".
	 */
	public void displayFilterMenu() {
		ProviderFilter provider = (s) -> (this.backend.getProviderFilter(s) ? "_x_" : "___") + " " + s;

		System.out.println("Providers that shows are being searched for:");
		System.out.println("\t1) [N] " + provider.getState("Netflix"));
		System.out.println("\t2) [H] " + provider.getState("Hulu"));
		System.out.println("\t3) [P] " + provider.getState("Prime Video"));
		System.out.println("\t4) [D] " + provider.getState("Disney+"));
		System.out.println("\t5) [Q] Quit toggling provider filters");

		System.out.print("Choose the provider you would like to toggle the filter for: ");
	}

	/**
	 * Displays every show in the given list with the title, year, rating,
	 * and which providers it is available on.
	 * @param shows The list of shows to display
	 */
	@Override
	public void displayShows(List<IShow> shows) {
		int size = (shows == null) ? 0 : shows.size();

		System.out.println("Found " + size + "/" + this.backend.getNumberOfShows() + " matches.");
		if(size == 0) return;

		Iterator<IShow> iterator = shows.iterator();

/*		for(int i = 0; i < Math.min(size, 20); i++) {
			IShow show = shows.get(i);

			System.out.println((i+1) + ". " + show.getTitle());
			System.out.println("\t" + show.getRating() + "/100 (" + show.getYear() + ") on: " + getShowProviders(show));
		}
*/
		int i = 1;
		while(iterator.hasNext()) {
			IShow show = iterator.next();
			System.out.println(i + ". " + show.getTitle());
			System.out.println("\t" + show.getRating() + "/100 (" + show.getYear() + ") on: " + getShowProviders(show));

			i++;
		}
	}

	/**
	 * Searches the list of shows by title with the user inputed string using
	 * {@link ShowSearcherBackend#searchByTitleWord(String)}.
	 */
	@Override
	public void titleSearch() {
		System.out.print("Choose a word you would like to search for: ");
		String s = in.nextLine();
		List<IShow> shows = this.backend.searchByTitleWord(s);

		displayShows(shows);
	}

	/**
	 * Searches the list of shows by year with the user inputed string using
	 * {@link ShowSearcherBackend#searchByYear(int)}
	 */
	@Override
	public void yearSearch() {
		System.out.print("Choose a year you would like to search for: ");
		Integer year = in.nextInt(); in.nextLine();
		List<IShow> shows = this.backend.searchByYear(year);

		displayShows(shows);
	}

	/** 
	 * Displays the filter menu, then uses {@link ShowSearcherBackend#toggleProviderFilter(String)}
	 * to toggle the given provider.
	 */
	private void filterProviders() {
		while(true) {
			displayFilterMenu();
			String s = in.nextLine();

			switch(s) {
			case "1": case "n": case "N":
				this.backend.toggleProviderFilter("Netflix");
				break;
			case "2": case "h": case "H":
				this.backend.toggleProviderFilter("Hulu");
				break;
			case "3": case "p": case "P":
				this.backend.toggleProviderFilter("Prime Video");
				break;
			case "4": case "d": case "D":
				this.backend.toggleProviderFilter("Disney+");
				break;
			case "5": case "q": case "Q":
				return;
			default:
				System.out.println("Invalid command");
				break;
			}
		}
	}

	/**
	 * Gets a list of providers for the show 
	 * @param show The show to get providers for.
	 * @return A string containing every provider the given show show is available
	 * on, separated by commas.
	 */
	private String getShowProviders(IShow show) {
		String str = "";
		for(String p : this.providerList) {
			if(show.isAvailableOn(p)) {
				str += p + ", ";
			}
		}

		return (str.length() == 0) ? "" : str.substring(0, str.length()-2);
	}

	/**
	 * An interface to use in displayFilterMenu to make it easier to read. For some reason it wont
	 * let me put it inside the method even though it works fine in other compilers...
	 */
	private interface ProviderFilter {
		String getState(String provider);
	}
}
