import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

/**
 * Created by saurabh on 5/4/14.
 */
public class Jukebox {
    // create ArrayList of Song objects
    private ArrayList<Song> songList;

    /**
     * Constructor initialises the data members of the Jukebox object
     */
    public Jukebox() {
        this.songList = new ArrayList<Song>();
    }

    /**
     * Comparator for comparing songs by Artist
     */
    private class ArtistCompare implements Comparator<Song> {
        public int compare(Song one, Song two) {
            return one.getArtist().compareTo(two.getArtist());
        }
    }

    /**
     * Comparator for comparing songs by Beats Per Minute
     */
    private class BPMCompare implements Comparator<Song> {
        public int compare(Song one, Song two) {
            return one.getBpm().compareTo(two.getBpm());
        }
    }

    /**
     * Calls the necessary methods in the correct order
     */
    public void go() {
        getSongs();
        System.out.println(songList);
        Collections.sort(songList);
        System.out.println(songList);


        // remove duplicates, use a Set
        TreeSet<Song> songSet = new TreeSet<Song>();
        songSet.addAll(songList);
        System.out.println(songSet);

        // use Comparators
        ArtistCompare artistCompare = new ArtistCompare();
        Collections.sort(songList, artistCompare);
        System.out.println(songList);
    }

    /**
     * Get the songs from a file
     * Create Song objects and append to the songList ArrayList
     */
    public void getSongs() {
        try {
            File file = new File("SongList.txt");
            BufferedReader reader  = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                addSong(line);
            }
        } catch (Exception e) {
            System.err.println("Error in reading file.");
            e.printStackTrace();
        }
    }

    /**
     * Create a new Song object from a line of text
     * Append this object to the ArrayList
     *
     * @param line is the line having 4 tokens of the Song object
     */
    private void addSong(String line) {
        String[] tokens = line.split("/");
        Song nextSong = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
        songList.add(nextSong);
    }

    /**
     * Application entry point
     */
    public static void main(String[] args) {
        new Jukebox().go();
    }
}
