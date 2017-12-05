package com.example.sec.homework1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by sec on 2017-11-28.
 */

public class MusicInformation extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_info);

        TextView tvTitle = (TextView)findViewById(R.id.item_songName);
        TextView tvArtist = (TextView)findViewById(R.id.item_singer);
        ImageView iv = (ImageView)findViewById(R.id.item_albumImage);

        Intent intent = getIntent(); // 보내온 Intent를 얻는다
        tvTitle.setText(intent.getStringExtra("title"));
        tvArtist.setText(intent.getStringExtra("artist"));
        iv.setImageResource(intent.getIntExtra("img", 0));
    }
}