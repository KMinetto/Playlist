package album;

import album.song.Song;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    /**
     * Add a song in the list
     * @param title String
     * @param duration double
     * @return boolean
     */
    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {
            this.songs.add(new Song(title, duration));
            return true;
        }

        return false;
    }

    /**
     * Add a song to the playlist thaks to the track number
     * @param trackNumber int
     * @param playList LinkedList<Song>
     * @return boolean
     */
    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        int index = trackNumber - 1;
        if (index >= 0 && index <= songs.size()) {
            playList.add(songs.get(index));
            return true;
        }

        return false;
    }

    /**
     * Add a song to the playlist thanks to the title
     * @param title String
     * @param playList LinkedList<Song>
     * @return boolean
     */
    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song existingSong = findSong(title);
        if (existingSong != null) {
            playList.add(existingSong);
            return true;
        }

        return false;
    }

    /**
     * Return the song thanks to the title in the list
     * @param title String
     * @return Song
     */
    public Song findSong(String title) {
        for (Song song : this.songs) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                return song;
            }
        }

        return null;
    }
}
