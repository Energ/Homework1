package com.example.sec.homework1;

import android.graphics.drawable.Drawable;

/**
 * Created by sec on 2017-11-28.
 */

public class MusicItems {
    private Drawable album;
    private String songname;
    private String singer;

    public void setAlbum(Drawable album) {
        this.album = album ;
    }
    public void setSongname(String songname) {
        this.songname = songname;
    }
    public void setSinger(String singer) {
        this.singer = singer;
    }

    public Drawable getAlbum() {
        return this.album;
    }
    public String getSongname() {
        return this.songname;
    }
    public String getSinger() {return this.singer;}
}
