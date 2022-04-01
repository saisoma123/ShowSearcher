import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class DataWranglerTests {
	public static boolean test1() { 
		try {
		Show a = new Show("Good Luck Charlie", 2000, 99, "Netflix,Hulu ");
		Show b = new Show("Bob the Builder", 1995, 63, "Hulu");
		if(!a.getTitle().equals("Good Luck Charlie")) {
			return false;
		}
		if(!a.isAvailableOn("Netflix") || b.isAvailableOn("Disney+")) {
			return false;
		
		}
		}catch(Exception e) {
			return false;
		}
		
		return true;
	}
	
	public static boolean test2() { 
		try {
			Show a = new Show("Good Luck Charlie", 2000, 99, "Netflix Hulu ");
			Show b = new Show("Bob the Builder", 1995, 63, "Hulu ");
			Show c = new Show("Bob the Builder", 1995, 63, "Hulu ");
			
			if(a.compareTo(b)<=0) {
				return false;
			}
			if(b.compareTo(a)>=0) {
				return false;
			}
			if(c.compareTo(b)!=0) {
				return false;
			}
			}catch(Exception e) {
				return false;
			}
			
			return true;
		}
	//more miscellaneous testers
	public static boolean test3() { 
		try {
			Show a = new Show("Good Luck Charlie", 2000, 99, "Netflix Hulu ");
			Show b = new Show("Bob the Builder", 1995, 63, "Hulu ");
			Show c = new Show("Bob the Builder", 1995, 63, "Hulu ");
			
			if(c.compareTo(c)!=0) {
				return false;
			}
			if(c.getRating()!=63) {
				return false;
			}
			if(a.getYear()!=2000) {
				return false;
			}
			}catch(Exception e) {
				return false;
			}
			
		return true; }
	
	public static boolean test4() {
		try {
			ShowLoader base = new ShowLoader();
			base.loadShows(null);
			}catch(FileNotFoundException e) {
				
			}
			catch(Exception e) {
				return false;
			}
			
			try {
				ShowLoader base = new ShowLoader();
				base.loadShows("This is definately not a filepath");
				}catch(FileNotFoundException e) {
					
				}
				catch(Exception e) {
					return false;
				}
			
			return true;
	}
	public static boolean test5() { 
		try {
			
			ShowLoader base = new ShowLoader();
			base.loadShows("./tv_shows.csv");
			}catch(Exception e) {
				return false;
			}
			return true;
	}
	public static boolean testBD1(){
		try{
                        ShowSearcherBackend BDtester = new ShowSearcherBackend();
                        IShow firstShow = new Show("Good Luck Charlie", 2006, 99, "Amazon Prime");
                        BDtester.addShow(firstShow);
                        return true;
                }catch(Exception e){
                        return false;
                }
	}
	public static boolean testBD2(){
		try{
                        ShowSearcherBackend BDtester = new ShowSearcherBackend();
                        IShow firstShow = new Show("Clifford", 1998, 28, "Hulu");
                        BDtester.addShow(firstShow);
                        BDtester.setProviderFilter("Hulu", false);
                        if(BDtester.getProviderFilter("Hulu") != false)
                        {
                                return false;
                        }
                        BDtester.toggleProviderFilter("Hulu");
                        if(BDtester.getProviderFilter("Hulu") != true)
                        {
                                return false;
                        }
                        return true;
                }catch(Exception e){
                        return false;
		}
	}
	public static void main(String[] args) {
		if(!test1()) {
			System.out.println("test1 fail");
		}
		if(!test2()) {
			System.out.println("test2 fail");
		}
		if(!test3()) {
			System.out.println("test3 fail");
		}
		if(!test4()) {
			System.out.println("test4 fail");
		}
		if(!test5()) {
			System.out.println("test5 fail");
		}
		if(!testBD1()){
			System.out.println("BDTest1 fail");
		}
		if(!testBD2()){
			System.out.println("BDTest2 fail");
		}
		else System.out.println("test passed");
	}
}
