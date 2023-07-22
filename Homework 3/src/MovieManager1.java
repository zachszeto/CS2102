import java.util.LinkedList;

class MovieManager1 {

	MovieManager1() {}

	/**
	 *Takes in a list of movies and categorizes them based off showtime and if they are not a simulcast
	 * @param movies
	 * @return Returns a Programme that has no simulcasts
	 */
	public Programme organizeMovies(LinkedList<Movie> movies) {
		Programme notSimulcastProgramme = new Programme();

		for (Movie aMovie : movies){
			//Matinee
			if (700 <= aMovie.showtime && aMovie.showtime< 1200 && !aMovie.simulcast){
				notSimulcastProgramme.matinee.add(aMovie);
			}
			//PrimeTime
			if (1200 <= aMovie.showtime && aMovie.showtime< 2000 && !aMovie.simulcast ){
				notSimulcastProgramme.primetime.add(aMovie);
			}
			//Soiree
			if ((2000 <= aMovie.showtime || aMovie.showtime < 200) && !aMovie.simulcast){
				notSimulcastProgramme.soiree.add(aMovie);
			}
		}
		return notSimulcastProgramme;
	}
}
