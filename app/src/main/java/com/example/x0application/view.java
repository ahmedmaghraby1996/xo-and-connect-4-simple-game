package com.example.x0application;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class view extends AppCompatActivity {
ListView lv ;

    PlayerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        lv=findViewById(R.id.lv);
        ArrayList<Players> players = (ArrayList<Players>) getIntent().getSerializableExtra("Players");

         adapter = new PlayerAdapter(this,players);
            lv.setAdapter(adapter);

    }
        class PlayerAdapter extends ArrayAdapter<Players>{

            public PlayerAdapter(@NonNull Context context, ArrayList<Players> players) {
                super(context,0,players);
            }

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                ViewHolder holder;
                if (convertView==null) {
                    convertView = getLayoutInflater().inflate(R.layout.custom_player, parent, false);

                    holder = new ViewHolder();
                    holder.player1=convertView.findViewById(R.id.player1);
                    holder.player2=convertView.findViewById(R.id.player2);
                    holder.ply1=convertView.findViewById(R.id.p1s);
                    holder.ply2=convertView.findViewById(R.id.p2s);
                    holder.round=convertView.findViewById(R.id.round);
                    convertView.setTag(holder);
                }

                else{
                    holder= (ViewHolder) convertView.getTag();
                }



                holder.player1.setText(getItem(position).getP1name());
                holder.player2.setText(getItem(position).getP2name());
                holder.ply1.setText(getItem(position).getPlayer1()+"");
                holder.ply2.setText(getItem(position).getPlayer2()+"");
                holder.round.setText(getItem(position).getRound()+"");
                return convertView;

            }

            class ViewHolder{
                TextView player1,player2,ply1,ply2,round;
            }

    }

}