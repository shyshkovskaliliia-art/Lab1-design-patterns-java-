package com.patterns.behavioral.Iterator;

import java.util.ArrayList;
import java.util.List;

public class Playlist implements IterableGroup {
    private List<Song> songs = new ArrayList<>();

    public void addSong(Song song) {
        songs.add(song);
    }

    @Override
    public Iterator createIterator() {
        return new SongIterator(songs);
    }
}
