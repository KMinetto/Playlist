import album.Album;
import album.song.Song;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {

        Album album = new Album("Stormbringer", "Deep Purple");
        album.addSong("Stormbringer", 4.6);
        album.addSong("Love don't mean a thing", 4.22);
        album.addSong("Holy man", 4.3);
        album.addSong("Hold on", 5.6);
        album.addSong("Lady double dealer", 3.21);
        album.addSong("You can't do it right", 6.23);
        album.addSong("High ball shooter", 4.27);
        album.addSong("The gypsy", 4.2);
        album.addSong("Soldier of fortune", 3.13);
        albums.add(album);

        album = new Album("For those about to rock", "AC/DC");
        album.addSong("For those about to rock", 5.44);
        album.addSong("I put the finger on you", 3.25);
        album.addSong("Lets go", 3.45);
        album.addSong("Inject the venom", 3.33);
        album.addSong("Snowballed", 4.51);
        album.addSong("Evil walks", 3.45);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<>();

        albums.get(0).addToPlayList("Stormbringer", playList);
        albums.get(0).addToPlayList("Love don't mean a thing", playList);
        albums.get(0).addToPlayList("Holy man", playList);
        albums.get(0).addToPlayList("Lady double dealer", playList);
        albums.get(1).addToPlayList(1, playList);
        albums.get(1).addToPlayList(4, playList);
        albums.get(1).addToPlayList(5, playList);
        albums.get(1).addToPlayList(6, playList);

        play(playList);
    }

    private static void play(LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;

        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.isEmpty()) {
            System.out.println("There is no song in your playlist.");
        } else {
            System.out.println("Now playing " + listIterator.next());
            printMenu();
        }

        while(!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0 -> quit = true;
                case 1 -> {
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        showCurrentSong(listIterator.next());
                    } else {
                        showNoNextSong();
                        forward = false;
                    }
                }
                case 2 -> {
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        showCurrentSong(listIterator.previous());
                    } else {
                        showNoPreviousSong();
                        forward = true;
                    }
                }
                case 3 -> {
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            showCurrentSong(listIterator.previous());
                            forward = false;
                        } else {
                            showNoPreviousSong();
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            showCurrentSong(listIterator.next());
                            forward = true;
                        } else {
                            showNoNextSong();
                        }
                    }
                }
                case 4 -> {
                    if (playList.size() > 0) {
                        if (listIterator.hasNext()) {
                            showCurrentSong(listIterator.next());
                        } else if (listIterator.hasPrevious()) {
                            showCurrentSong(listIterator.previous());
                        }
                    }
                }
                case 5 -> printSongs(playList); // TODO: Print the list of all song in playlist
                case 6 -> printMenu(); // TODO: Print the menu
            }
        }
    }

    private static void printSongs(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("================================");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("================================");
    }

    private static void printMenu() {
        System.out.println("Available action in menu");
        System.out.println(
            """
            0 - Quit
            1 - Next song
            2 - Previous song
            3 - Replay current song
            4 - Remove current song
            5 - Print all songs in playlist
            6 - Print the menu
            """
        );
    }

    private static void showCurrentSong(Song song) {
        System.out.println("Now playing " + song);
    }

    private static void showNoNextSong() {
        System.out.println("You've reached the end of the playlist.");
    }
    private static void showNoPreviousSong() {
        System.out.println("You're at the start of the playlist.");
    }
}