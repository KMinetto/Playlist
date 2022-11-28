package album.song;

/**
 * class Song
 */
public class Song {

    private String title;
    private double duration;

    /**
     * Song constructor
     * @param title String
     * @param duration double
     */
    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return this.title + ": " + this.duration;
    }

    public String getTitle() {
        return title;
    }
}
