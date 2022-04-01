import java.util.ArrayList;
import java.util.List;

public class ShowSearcherBackendPlaceholder implements IShowSearcherBackend {
	private boolean[] providerFilter = new boolean[] {true,true,true,true};

	@Override
	public void addShow(IShow show) {
		// TODO Auto-generated method stub
	}

	@Override
	public int getNumberOfShows() {
		return 5368;
	}

	@Override
	public void setProviderFilter(String provider, boolean filter) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean getProviderFilter(String provider) {
		switch(provider) {
		case "Netflix":
			return this.providerFilter[0];
		case "Hulu":
			return this.providerFilter[1];
		case "Prime Video":
			return this.providerFilter[2];
		case "Disney+":
			return this.providerFilter[3];
		default:
			return false;
		}
	}

	@Override
	public void toggleProviderFilter(String provider) {
		switch(provider) {
		case "Netflix":
			this.providerFilter[0] = !this.providerFilter[0];
			return;
		case "Hulu":
			this.providerFilter[1] = !this.providerFilter[1];
			return;
		case "Prime Video":
			this.providerFilter[2] = !this.providerFilter[2];
			return;
		case "Disney+":
			this.providerFilter[3] = !this.providerFilter[3];
			return;
		default:
			return;
		}
	}

	@Override
	public List<IShow> searchByTitleWord(String word) {
		List<IShow> shows = new ArrayList<IShow>();

		if(word.contains("Dad")) {
			if(this.getProviderFilter("Hulu")) shows.add(new Show("American Dad!", 2005, 76, "Hulu"));
			if(this.getProviderFilter("Netflix")) shows.add(new Show("Final Fantaxy XIV: Dad of Light", 2017, 51, "Netflix"));
			if(this.getProviderFilter("Netflix") || this.getProviderFilter("Prime Video")) shows.add(new Show("Dad Stop Embarrassing Me!", 2021, 48, "Netflix,Prime Video"));
			if(this.getProviderFilter("Prime Video") || this.getProviderFilter("Disney+")) shows.add(new Show("Date My Dad", 2017, 42, "Prime Video,Disney+"));
			if(this.getProviderFilter("Hulu") || this.getProviderFilter("Netflix")) shows.add(new Show("Dinner with Dad", 2017, 36, "Hulu,Netflix"));
		}

		if(word.contains("Dead")) {
			if(this.getProviderFilter("Netflix")) shows.add(new Show("The Walking Dead", 2018, 93, "Netflix"));
			if(this.getProviderFilter("Netflix") || this.getProviderFilter("Hulu") || this.getProviderFilter("Disney+")) shows.add(new Show("Ash vs Evil Dead", 2015, 83, "Netflix,Hulu,Disney+"));
			if(this.getProviderFilter("Hulu")) shows.add(new Show("Fear the Walking Dead", 2015, 80, "Hulu"));
			if(this.getProviderFilter("Netflix") || this.getProviderFilter("Prime Video")) shows.add(new Show("Deadliest Catch", 2005, 67, "Netflix,Prime Video"));
		}
		return shows;
	}

	@Override
	public List<IShow> searchByYear(int year) {
		List<IShow> shows = new ArrayList<IShow>();

		if(year == 2017) {
			if(this.getProviderFilter("Netflix")) shows.add(new Show("Mindhunter", 2017, 51, "Netflix"));
			if(this.getProviderFilter("Prime Video")) shows.add(new Show("Community", 2017, 42, "Prime Video"));
			if(this.getProviderFilter("Hulu") || this.getProviderFilter("Netflix")) shows.add(new Show("Narcos", 2017, 36, "Hulu,Netflix"));
		}

		if(year == 2015) {
			if(this.getProviderFilter("Netflix") || this.getProviderFilter("Hulu") || this.getProviderFilter("Disney+")) shows.add(new Show("The Blacklist", 2015, 83, "Netflix,Hulu,Disney+"));
			if(this.getProviderFilter("Hulu")) shows.add(new Show("The Flash", 2015, 80, "Hulu"));
		}
		return shows;
	}

}
