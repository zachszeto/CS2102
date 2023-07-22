import java.util.LinkedList;

class Programme {
    LinkedList<Movie> matinee;
    LinkedList<Movie> primetime;
    LinkedList<Movie> soiree;

    Programme() {
        this.matinee = new LinkedList<Movie>();
        this.primetime = new LinkedList<Movie>();
        this.soiree = new LinkedList<Movie>();
    }

    Programme(LinkedList<Movie> matinee, LinkedList<Movie> primetime, LinkedList<Movie> soiree) {
        this.matinee = matinee;
        this.primetime = primetime;
        this.soiree = soiree;
    }

    /**
     * Compares two Programmes based on size, order, and if title and showtime are the same
     * @param aProgramme
     * @return returns true if the two Programmes are equal else false
     */
    @Override
    public boolean equals(Object aProgramme) {
        Programme Programme2 = (Programme) aProgramme;

        int numSameMatinee = 0;
        int numSamePrimeTime = 0;
        int numSameSoiree = 0;

        if (this.matinee.size() == Programme2.matinee.size()
                && this.primetime.size() == Programme2.primetime.size()
                && this.soiree.size() == Programme2.soiree.size()) {

            for (int i = 0; i < this.matinee.size(); i++) {
                if (this.matinee.get(i).title.equals(Programme2.matinee.get(i).title)
                        && this.matinee.get(i).showtime == Programme2.matinee.get(i).showtime) {
                    numSameMatinee++;
                }
            }
            for (int i = 0; i < this.primetime.size(); i++) {
                if (this.primetime.get(i).title.equals(Programme2.primetime.get(i).title)
                        && this.primetime.get(i).showtime == Programme2.primetime.get(i).showtime) {
                    numSamePrimeTime++;
                }
            }
            for (int i = 0; i < this.soiree.size(); i++) {
                if (this.soiree.get(i).title.equals(Programme2.soiree.get(i).title)
                        && this.soiree.get(i).showtime == Programme2.soiree.get(i).showtime) {
                    numSameSoiree++;
                }
            }
        }
        if (numSameMatinee == this.matinee.size() && numSamePrimeTime == this.primetime.size() && numSameSoiree == this.soiree.size()) {
            return true;
        } else {
            return false;
        }
    }
}