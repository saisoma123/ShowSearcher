import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.io.File;

public class ShowLoader implements IShowLoader {

	public List<IShow> loadShows(String filepath) throws FileNotFoundException {
		try {
			// if(filepath.equals(null)) throw new FileNotFoundException();
			File tvShows = new File(filepath);
			Scanner csv = new Scanner(tvShows, "UTF-8");
			int TITLE = 2;
			int YEAR = 3;
			int RATING = 5;
			// Providers span from 6(Netflix), 7(Hulu), 8(Prime Video), 9(Disney+)
			int PROVIDERS = 6;
			// only using .io.* to read first line through canvas specs
			// no instructions on import statements
			String firstLine = null;
			firstLine = csv.nextLine();
			String[] header = firstLine.split(",");
			for (int i = 0; i < header.length; i++) {
				if (header[i].equals("Title")) {
					TITLE = i;
				}
				if (header[i].equals("Year")) {
					YEAR = i;
				} else if (header[i].equals("Rotten Tomatoes")) {
					RATING = i;
				} else if (header[i].equals("Netflix")) {
					PROVIDERS = i;
				}
			}

			String title = "";
			int year = 0;
			// use the numerator
			int rating = 0;
			String providers = "";
			String line = "";
			// keep track of where each thing is within the csv file
			// indexes

			List<IShow> showStorage = new ArrayList<IShow>();

			// skip first line

			String[] rotTom;
			String[] temp;

			do {
				line = csv.nextLine();

				temp = line.split(",");
				title = checkForQuotesCommas(temp);
				int counter = 0;
				int index = title.length() - 1;
				if (index > 0) {
					while (title.charAt(index) == '*') {
						counter++;
						index--;
					}
				}
				title = title.substring(0, title.length() - counter);
				year = Integer.parseInt(temp[YEAR + counter]);
				rotTom = temp[RATING + counter].split("/");
				rating = Integer.parseInt(rotTom[0]);
				if (Integer.parseInt(temp[PROVIDERS + counter]) == 1) {
					providers += "Netflix,";
				}
				if (Integer.parseInt(temp[PROVIDERS + counter + 1]) == 1) {
					providers += "Hulu,";
				}
				if (Integer.parseInt(temp[PROVIDERS + counter + 2]) == 1) {
					providers += "Prime Video,";
				}
				if (Integer.parseInt(temp[PROVIDERS + counter + 3]) == 1) {
					providers += "Disney+,";
				}
				if(providers.length()>0) {
					providers = providers.substring(0,providers.length()-1);
				}
				showStorage.add(new Show(title, year, rating, providers));
				// reset providers after adding a show
				providers = "";
			} while (csv.hasNextLine());

			csv.close();
			return showStorage;
		} catch (Exception e) {
			throw new FileNotFoundException();
		}
	}

	private String checkForQuotesCommas(String[] temp) {
		String showName = "";
		int numQuotes = countOpenQuotes(temp[2]);
		if (numQuotes == 0) {
			showName = temp[2];
		} else if (numQuotes % 2 == 0) {
			showName = temp[2].substring(numQuotes / 2, temp[2].length() - numQuotes / 2);
		} else if (numQuotes % 2 != 0) {
			int i = 2;
			while (temp[i].charAt(temp[i].length() - 1) != '"') {
				i++;
				showName += temp[i];
			}
			// communicates how many spaces forward the other values are within the array
			for (int j = 2; j < i; j++) {
				showName += "*";
			}
		}

		return showName;
	}

	private int countOpenQuotes(String a) {
		int counter = 0;
		while (a.charAt(counter) == '"') {
			counter++;
		}
		return counter;
	}
}
