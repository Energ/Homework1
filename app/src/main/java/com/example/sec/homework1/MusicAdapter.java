package com.example.sec.homework1;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sec on 2017-11-28.
 */

public class MusicAdapter extends BaseAdapter {
    private ArrayList<MusicItems> listViewItemList = new ArrayList<MusicItems>() ;

    public MusicAdapter(){}

    public int getCount() {return listViewItemList.size() ; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.music_adapter, parent, false);
        }
        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        ImageView albumImageView = (ImageView) convertView.findViewById(R.id.item_albumImage);
        TextView songnameTextView = (TextView) convertView.findViewById(R.id.item_songName);
        TextView singerTextView = (TextView) convertView.findViewById(R.id.item_singer);

        MusicItems listViewItem = listViewItemList.get(position);

        albumImageView.setImageDrawable(listViewItem.getAlbum());
        songnameTextView.setText(listViewItem.getSongname());
        singerTextView.setText(listViewItem.getSinger());

        return convertView;
    }
    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) {
        return position ;
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position) ;
    }

    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(Drawable album, String songname, String singer) {
        MusicItems items = new MusicItems();

        items.setAlbum(album);
        items.setSongname(songname);
        items.setSinger(singer);

        listViewItemList.add(items);

    }

}
