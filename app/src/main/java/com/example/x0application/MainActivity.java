package com.example.x0application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    boolean player = true, done = false,ai=false ;
    TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9,xop1,xop2,xodrow;
    TableLayout tl;
    int player1s = 0,round=0;
    int player2s = 0,drows=0;
    ArrayList<Players> players = new ArrayList<>();
    String player1, player2;
    ArrayList<TextView> tvs = new ArrayList<>();
    ArrayList<Integer> copy = new ArrayList<>();



    boolean check = false, continure = false, won = false, lost = false,remove=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tl = findViewById(R.id.tl);
        tv1 = findViewById(R.id.nu1);
        tv2 = findViewById(R.id.nu2);
        tv3 = findViewById(R.id.nu3);
        tv4 = findViewById(R.id.nu4);
        tv5 = findViewById(R.id.nu5);
        tv6 = findViewById(R.id.nu6);
        tv7 = findViewById(R.id.nu7);
        tv8 = findViewById(R.id.nu8);
        tv9 = findViewById(R.id.nu9);
        xop1=findViewById(R.id.xop1);
        xop2=findViewById(R.id.xop2);
        xodrow=findViewById(R.id.xodrow);
    Collections.addAll(tvs,tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9);
    ai=getIntent().getBooleanExtra("ai",false);
      player1= getIntent().getStringExtra("player1");
      player2=getIntent().getStringExtra("player2");
      xop1.setText(player1+" score : 0");
        xop2.setText(player2+" score :0");
        xodrow.setText("Drows : 0");
//        for (TextView tv : tvs) {
//            Toast.makeText(this, tvs.indexOf(tv)+"", Toast.LENGTH_SHORT).show();
//
//        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    public void click(View view) {


        won = false;
        continure = false;
        check = false;

        TextView tv = (TextView) view;
        if (tv.getText().toString() == "") {
            if (player) {
                if(ai==false)
                player = false;
            tv.setText("X");}
            else if(ai==false)
            {player=true;
            tv.setText("O");}

        }

        else {
            Toast.makeText(this, "Already submitted", Toast.LENGTH_SHORT).show();
            return;
        }

        if ((tv2.getText().toString() == "X" && tv5.getText().toString() == "X" && tv8.getText().toString() == "X") || (tv1.getText().toString() == "X" && tv2.getText().toString() == "X" && tv3.getText().toString() == "X") || (tv1.getText().toString() == "X" && tv4.getText().toString() == "X" && tv7.getText().toString() == "X") || (tv1.getText().toString() == "X" && tv5.getText().toString() == "X" && tv9.getText().toString() == "X") || (tv3.getText().toString() == "X" && tv6.getText().toString() == "X" && tv9.getText().toString() == "X") || (tv7.getText().toString() == "X" && tv8.getText().toString() == "X" && tv9.getText().toString() == "X") || (tv7.getText().toString() == "X" && tv5.getText().toString() == "X" && tv3.getText().toString() == "X") || (tv4.getText().toString() == "X" && tv5.getText().toString() == "X" && tv6.getText().toString() == "X")) {
            player1s++;
            xop1.setText(player1+"score : "+player1s);
            Toast.makeText(this, player1 + " won", Toast.LENGTH_SHORT).show();
            round++;
            players.add(new Players(player1, player2, 1, 0,"Round "+round));
//            if((tv2.getText().toString() == "X" && tv5.getText().toString() == "X" && tv8.getText().toString() == "X"))
//            YoYo.with(Techniques.Shake).duration(2500).playOn(tv2);

            for (int i = 0; i < tvs.size(); i++)
                tvs.get(i).setText("");

        }

        else if ((tv2.getText().toString() == "O" && tv5.getText().toString() == "O" && tv8.getText().toString() == "O") || (tv1.getText().toString() == "O" && tv2.getText().toString() == "O" && tv3.getText().toString() == "O") || (tv1.getText().toString() == "O" && tv4.getText().toString() == "O" && tv7.getText().toString() == "O") || (tv1.getText().toString() == "O" && tv5.getText().toString() == "O" && tv9.getText().toString() == "O") || (tv3.getText().toString() == "O" && tv6.getText().toString() == "O" && tv9.getText().toString() == "O") || (tv7.getText().toString() == "O" && tv8.getText().toString() == "O" && tv9.getText().toString() == "O") || (tv7.getText().toString() == "O" && tv5.getText().toString() == "O" && tv3.getText().toString() == "O") || (tv4.getText().toString() == "O" && tv5.getText().toString() == "O" && tv6.getText().toString() == "O")) {
            player2s++;
            xop2.setText(player2 + " score : " + player2s);
            Toast.makeText(this, player2 + " won", Toast.LENGTH_SHORT).show();
            for (int i = 0; i < tvs.size(); i++)
                tvs.get(i).setText("");
            round++;
            players.add(new Players(player1, player2, 0, 1,"Round "+round));}
if(ai==true) {
    continure = false;
    for (int i = 0; i < tvs.size(); i++) {
        if (tvs.get(i).getText().toString().equals("")) {
            tvs.get(i).setText("O");
            if ((tv2.getText().toString() == "O" && tv5.getText().toString() == "O" && tv8.getText().toString() == "O") || (tv1.getText().toString() == "O" && tv2.getText().toString() == "O" && tv3.getText().toString() == "O") || (tv1.getText().toString() == "O" && tv4.getText().toString() == "O" && tv7.getText().toString() == "O") || (tv1.getText().toString() == "O" && tv5.getText().toString() == "O" && tv9.getText().toString() == "O") || (tv3.getText().toString() == "O" && tv6.getText().toString() == "O" && tv9.getText().toString() == "O") || (tv7.getText().toString() == "O" && tv8.getText().toString() == "O" && tv9.getText().toString() == "O") || (tv7.getText().toString() == "O" && tv5.getText().toString() == "O" && tv3.getText().toString() == "O") || (tv4.getText().toString() == "O" && tv5.getText().toString() == "O" && tv6.getText().toString() == "O")) {
                player2s++;
                xop2.setText(player2 + " score : " + player2s);
                round++;
                players.add(new Players(player1, player2, 0, 1,"Round "+round));
                Toast.makeText(this, player2 + " won", Toast.LENGTH_SHORT).show();
                for (int j = 0; j < tvs.size(); j++) {
                    tvs.get(j).setText("");
                    check = true;
                }
            } else {
                tvs.get(i).setText("");
            }

        }
    }
    if (check == false) {
        for (int i = 0; i < tvs.size(); i++) {
            if (tvs.get(i).getText().equals("")) {
                tvs.get(i).setText("X");
                if ((tv2.getText().toString() == "X" && tv5.getText().toString() == "X" && tv8.getText().toString() == "X") || (tv1.getText().toString() == "X" && tv2.getText().toString() == "X" && tv3.getText().toString() == "X") || (tv1.getText().toString() == "X" && tv4.getText().toString() == "X" && tv7.getText().toString() == "X") || (tv1.getText().toString() == "X" && tv5.getText().toString() == "X" && tv9.getText().toString() == "X") || (tv3.getText().toString() == "X" && tv6.getText().toString() == "X" && tv9.getText().toString() == "X") || (tv7.getText().toString() == "X" && tv8.getText().toString() == "X" && tv9.getText().toString() == "X") || (tv7.getText().toString() == "X" && tv5.getText().toString() == "X" && tv3.getText().toString() == "X") || (tv4.getText().toString() == "X" && tv5.getText().toString() == "X" && tv6.getText().toString() == "X")) {
                    tvs.get(i).setText("O");
                    continure = true;


                    break;
                } else {
                    tvs.get(i).setText("");

                }
            }
        }
    }
    if (continure == false && check == false) {

        if (tv5.getText().equals("")) {
            tv5.setText("O");
            return;
        }


        for (int i = 0; i < tvs.size(); i++) {
            if (tvs.get(i).getText().toString().equals("")) {
                tvs.get(i).setText("O");

//                    if (i < 8 && (tvs.get(i + 1).getText().toString().equals(""))) {
//                        tvs.get(i + 1).setText("O");
//                        remove = true;
//                    }
                if ((tv2.getText().toString() == "O" && tv5.getText().toString() == "O" && tv8.getText().toString() == "O") || (tv1.getText().toString() == "O" && tv2.getText().toString() == "O" && tv3.getText().toString() == "O") || (tv1.getText().toString() == "O" && tv4.getText().toString() == "O" && tv7.getText().toString() == "O") || (tv1.getText().toString() == "O" && tv5.getText().toString() == "O" && tv9.getText().toString() == "O") || (tv3.getText().toString() == "O" && tv6.getText().toString() == "O" && tv9.getText().toString() == "O") || (tv7.getText().toString() == "O" && tv8.getText().toString() == "O" && tv9.getText().toString() == "O") || (tv7.getText().toString() == "O" && tv5.getText().toString() == "O" && tv3.getText().toString() == "O") || (tv4.getText().toString() == "O" && tv5.getText().toString() == "O" && tv6.getText().toString() == "O")) {


                    won = true;
                    for (int j = 0; j < copy.size(); j++) {
                        tvs.get(copy.get(j)).setText("");
                    }
                    tvs.get(i).setText("O");
                    copy.clear();
                    break;

                } else {
                    copy.add(i);

//                        tvs.get(i).setText("");
//                        Toast.makeText(this, i+"", Toast.LENGTH_SHORT).show();
//                        if (i < 8 && remove == true) {
//                            remove = false;
//                            Toast.makeText(this, "me5", Toast.LENGTH_SHORT).show();
//                            tvs.get(i + 1).setText("");

                }

            }

        }
        if (won == false) {

            for (int j = 0; j < copy.size(); j++) {
                tvs.get(copy.get(j)).setText("");

            }
            copy.clear();
        }

        if (won == false) {
            for (int z = 0; z < tvs.size(); z++) {
                if (tvs.get(z).getText().toString().equals("")) {

                    tvs.get(z).setText("O");
                    break;
                }

            }
        }
    }}

    if (!(tv1.getText() == "") && !(tv2.getText() == "") && !(tv3.getText() == "") && !(tv4.getText() == "") && !(tv5.getText() == "") && !(tv6.getText() == "") && !(tv7.getText() == "") && !(tv8.getText() == "") && !(tv9.getText() == "")) {
        Toast.makeText(this, "game over", Toast.LENGTH_SHORT).show();
        for (int i = 0; i < tvs.size(); i++)
            tvs.get(i).setText("");
        drows++;
        xodrow.setText("Drows : " + drows);
        round++;
                players.add(new Players(player1, player2, 0, 0,"Round "+round));
    }

        }
    public void score(MenuItem item) {
        Intent in = new Intent(this,view.class);
        in.putExtra("Players",players);
        startActivity(in);
    }


}
