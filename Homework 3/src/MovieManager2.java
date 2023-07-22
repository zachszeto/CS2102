import java.util.LinkedList;

class MovieManager2 {
	
	MovieManager2() {}

	/**
	 *Takes in a list of movies and categorizes them based off showtime and if they are not a simulcast
	 * @param movies
	 * @return Returns a Programme that has no simulcasts
	 */
	public Programme organizeMovies(LinkedList<Movie> movies)
	{
		LinkedList<Movie> notSimulcastMovies = new LinkedList<Movie>();
		for (Movie aMovie : movies){
			if (!aMovie.simulcast){
				notSimulcastMovies.add(aMovie);
			}
		}

		LinkedList<Movie> filteredMatinee = new LinkedList<Movie>();
		LinkedList<Movie> filteredPrimeTime = new LinkedList<Movie>();
		LinkedList<Movie> filteredSoiree = new LinkedList<Movie>();

		for (Movie notASimulcast : notSimulcastMovies){
			//Matinee
			if (700 <= notASimulcast.showtime && notASimulcast.showtime< 1200){
				filteredMatinee.add(notASimulcast);
			}
			//PrimeTime
			if (1200 <= notASimulcast.showtime && notASimulcast.showtime< 2000){
				filteredPrimeTime.add(notASimulcast);
			}
			//Soiree
			if ((2000 <= notASimulcast.showtime || notASimulcast.showtime < 200)){
				filteredSoiree.add(notASimulcast);
			}

		}
		return new Programme(filteredMatinee, filteredPrimeTime, filteredSoiree);
	}
}
