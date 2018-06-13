package com.example.exoli.myapplication.res;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.exoli.myapplication.R;

import java.util.ArrayList;

public class GUAdapter extends ArrayAdapter<GameUser> {

    private Context context;
    private int res;

    public GUAdapter(Context context, int res, ArrayList<GameUser> gameUsers) {
        super(context, res, gameUsers);
        this.context = context;
        this.res = res;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the persons information
        String name = getItem(position).getName();
        Float score = getItem(position).getScore();
        String diff = getItem(position).getDifficulty();

        //Create the person object with the information
        GameUser person = new GameUser(name,score,diff);

        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(res,parent,false);

        TextView txtName = (TextView) convertView.findViewById(R.id.user_name);
        TextView txtScore = (TextView) convertView.findViewById(R.id.user_score);
        TextView txtDiff = (TextView) convertView.findViewById(R.id.user_location);

        txtName.setText(name);
        txtScore.setText(score.toString());
        txtDiff.setText(diff);

        return convertView;
    }
}
