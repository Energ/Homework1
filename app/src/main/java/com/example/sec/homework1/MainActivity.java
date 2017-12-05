package com.example.sec.homework1;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Song> al = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.musicList);
        MusicAdapter musicAdapter = new MusicAdapter();

        listView.setAdapter(musicAdapter);

        musicAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_library_music_black_24dp), "좋니", "윤종신");
        musicAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_library_music_black_24dp), "선물", "멜로망스");
        musicAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_library_music_black_24dp), "바보야", "허각");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MusicItems item = (MusicItems) parent.getItemAtPosition(position);

                String singer = item.getSinger();
                String songname = item.getSongname();
                Drawable album = item.getAlbum();

                Intent intent = new Intent(getApplicationContext(), MusicInformation.class);
                intent.putExtra("img", al.get(position).img);
                intent.putExtra("title", al.get(position).title);
                intent.putExtra("artist", al.get(position).artist);
            }
        });
    }
}

class Song {
    String title = "";
    int img;
    String artist = "";
    public Song(String title, int img, String artist) {
        super();
        this.title = title;
        this.img = img;
        this.artist = artist;
    }
    public Song() {}
}