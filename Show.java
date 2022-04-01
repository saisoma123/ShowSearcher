public class Show implements IShow {
        // can change to null values depending on group implementation
        private String title = "";
        private int year = 0;
        private int rating = 0;
        private String providers = "";
        
        public Show(String title, int year, int rating, String providers){
                this.title = title;
                this. year = year;
                this.rating = rating;
                this.providers = providers;
        }
        public String getTitle(){
                return this.title;
        }
        public int getYear(){
                return this.year;
        }
        public int getRating(){
                return this.rating;
        }
        public boolean isAvailableOn(String provider){
                String tempProviders = providers;
                String[] a = tempProviders.split(",");
		String[] searchProviders = provider.split(",");
		for(int i=0; i<searchProviders.length;i++){
			boolean hasFound = false;
			for(int j=0; j<a.length;j++){
				if(a[j].equals(searchProviders[i])){
					hasFound = true;
				}
			}
			if(!hasFound){
				return false;
			}
		}
		return true;
        }
        
		@Override
		public int compareTo(IShow o) {
			if(rating>o.getRating()) {
				return 1;
			}
			if(rating<o.getRating()) {
				return -1;
			}
			return 0;
		}


}
