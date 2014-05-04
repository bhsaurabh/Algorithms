/**
 * Created by saurabh on 5/4/14.
 */
public class Song implements Comparable<Song> {
    private String title, artist, rating, bpm;

    /**
     * Constructor initialises the variables for this object
     *
     * @param _title is the title of the song
     * @param _artist is the artist of the song
     * @param _rating is the rating of the song
     * @param _bpm is the bpm of the song
     */
    public Song(String _title, String _artist, String _rating, String _bpm) {
        title = _title;
        artist = _artist;
        rating = _rating;
        bpm = _bpm;
    }

    /**
     * Returns the title of the song
     *
     * @return the title of the song
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the artist of the song
     *
     * @return the artist of the song
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Returns the rating of the song
     *
     * @return the rating of the song
     */
    public String getRating() {
        return rating;
    }

    /**
     * Returns the bpm of the song
     *
     * @return the bpm of the song
     */
    public String getBpm() {
        return bpm;
    }

    /**
     * Returns a String representation of the Song object
     * System.out.println(aListOfSongs) calls toString on each member Song
     *
     * @return the title of the song
     */
    @Override
    public String toString() {
        return title;
    }

    /**
     * Method overriding for interface Comparable
     */
    public int compareTo(Song that) {
        return this.title.compareTo(that.getTitle());
    }

    /**
     * Overridden equals method, to make 2 Song objects having same titles equal
     *
     * @param aSong is the Song to be compared against
     *
     * @return true, if aSong has the same title as this Song, false otherwise
     */
    public boolean equals(Object aSong) {
        Song s = (Song) aSong;
        return getTitle().equals(s.getTitle());
    }

    /**
     * Overridden hashCode method, to make 2 equal songs have same hascode
     *
     * @return the hashCode of this object based on title
     */
    public int hashCode() {
        return title.hashCode();
    }



}
