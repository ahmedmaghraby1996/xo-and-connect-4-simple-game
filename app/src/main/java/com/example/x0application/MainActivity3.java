package com.example.x0application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity3 extends AppCompatActivity {
Boolean player=true,win=true,over=false;
  ArrayList<Integer> rn=new ArrayList<>();
int x=0,counter=0,p1s=0,p2s=0,drow=0,l,a,round=0;
String cplayer1,cplayer2;
    ArrayList<Players> players = new ArrayList<>();
    Boolean ai =false;
ArrayList<TextView>tvs= new ArrayList<>();
TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20,t21,t22,t23,t24,t25,player1,player2,draw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        t4=findViewById(R.id.t4);
        t5=findViewById(R.id.t5);
        t6=findViewById(R.id.t6);
        t7=findViewById(R.id.t7);
        t8=findViewById(R.id.t8);
        t9=findViewById(R.id.t9);
        t10=findViewById(R.id.t10);
        t11=findViewById(R.id.t11);
        t12=findViewById(R.id.t12);
        t13=findViewById(R.id.t13);
        t14=findViewById(R.id.t14);
        t15=findViewById(R.id.t15);
        t16=findViewById(R.id.t16);
        t17=findViewById(R.id.t17);
        t18=findViewById(R.id.t18);
        t19=findViewById(R.id.t19);
        t20=findViewById(R.id.t20);
        t21=findViewById(R.id.t21);
        t22=findViewById(R.id.t22);
        t23=findViewById(R.id.t23);
        t24=findViewById(R.id.t24);
        t25=findViewById(R.id.t25);
        player1=findViewById(R.id.player1s);
        player2=findViewById(R.id.player2s);
        draw=findViewById(R.id.draw);
        Collections.addAll(tvs,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20,t21,t22,t23,t24,t25);
        cplayer1=getIntent().getStringExtra("player1");
        cplayer2=getIntent().getStringExtra("player2");
       ai= getIntent().getBooleanExtra("ai",false);
        player1.setText(cplayer1+" score: 0");
        player2.setText(cplayer2+" score: 0 ");
        draw.setText("Drows: 0");


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    public void click(View view) {
win=false; String m="";
        TextView tv = (TextView) view;

        if((tv.getText().toString().equals("1")) || (tv.getText().toString().equals("2")) || (tv.getText().toString().equals("3")) || (tv.getText().toString().equals("4")) || (tv.getText().toString().equals("5") )){

            if (player) {
                m="x";
                player = false;
                for (int i =(tvs.indexOf(tv)+20); i >=0 ; i=i-5) {
                   if(tvs.get(i).getText().toString().equals("") || tvs.get(i).getText().toString().equals("2") || tvs.get(i).getText().toString().equals("3")|| tvs.get(i).getText().toString().equals("4") ||tvs.get(i).getText().toString().equals("5") || tvs.get(i).getText().toString().equals("1")){
                       tvs.get(i).setBackground(getResources().getDrawable(R.drawable.red));
                       tvs.get(i).setText(m);
                       break;
                }}


    }

            else   {    player = true;m="o";
                for (int i =(tvs.indexOf(tv)+20); i >=0 ; i=i-5) {
                    if(tvs.get(i).getText().toString().equals("") || tvs.get(i).getText().toString().equals("2") || tvs.get(i).getText().toString().equals("3")|| tvs.get(i).getText().toString().equals("4") ||tvs.get(i).getText().toString().equals("5") || tvs.get(i).getText().toString().equals("1")){
                        tvs.get(i).setBackground(getResources().getDrawable(R.drawable.green));
                        tvs.get(i).setText("o");

                        break;
                    }}}




            if (ai==true && player==false){
    player=true;
    m="o";
            for (int i = 0; i <tvs.size() ; i++) {
                if(tvs.get(i).getText().toString().equals("x") || tvs.get(i).getText().toString().equals("o")){
                    l=i;

                }
                Collections.addAll(rn,(l+1),(l-1),(l-5),(l-6),(l-4));
                Collections.shuffle(rn);
                    for (int j = 0; j < 5; j++) {
                        if(((rn.get(j))>0) && ((rn.get(j))<25)){

                        if(rn.get(j)>=20){
                            a=1;
                           }
                        else{ a=rn.get(j)+5;
                           }

                             if (  (!(tvs.get(a).getText().toString().equals("")))&& ((tvs.get(rn.get(j)).getText().toString().equals("1") || tvs.get(rn.get(j)).getText().toString().equals("2") || tvs.get(rn.get(j)).getText().toString().equals("3") || tvs.get(rn.get(j)).getText().toString().equals("4") || tvs.get(rn.get(j)).getText().toString().equals("5"))|| tvs.get(rn.get(j)).getText().toString().equals(""))) {

                                 tvs.get(rn.get(j)).setText("o");
                                 tvs.get(rn.get(j)).setBackground(getResources().getDrawable(R.drawable.green));
                                 over=true;
                                 break;

                             }
                         }
                    } if(over==true){
                        over=false;
                        break;}
            }}






}
    else {

            Toast.makeText(this, "Insert from the top", Toast.LENGTH_SHORT).show();
            return;
        }

        for (int z = 0; z <2 ; z++) {
            if (z == 0)
                m = "x";
            else m = "o";


            for (int i = 0; i <= 20; i = i + 5) {
                for (int j = i; j < i + 4; j++) {

                    if (tvs.get(j).getText().toString().equals(m)) {

                        win = true;
                        counter++;
                        if (counter == 4)
                            break;
                    } else {
                        win = false;
                        counter = 0;
                        break;
                    }
                }
                if (counter == 4)
                    break;
            }

            if (win == false) {
                for (int i = 1; i <= 21; i = i + 5) {
                    for (int j = i; j < i + 4; j++) {

                        if (tvs.get(j).getText().toString().equals(m)) {
                            win = true;
                            counter++;
                            if (counter == 4)
                                break;
                        } else {
                            win = false;
                            counter = 0;
                            break;
                        }
                    }
                    if (counter == 4)
                        break;
                }
            }

            if (win == false) {
                for (int i = 20; i <= 24; i++) {
                    for (int j = i; j >= (i - 15); j = j - 5) {

                        if (tvs.get(j).getText().toString().equals(m)) {

                            win = true;
                            counter++;
                            if (counter == 4)
                                break;
                        } else {
                            win = false;
                            counter = 0;
                            break;
                        }
                    }
                    if (counter == 4)
                        break;
                }
            }


            if (win == false) {

                for (int i = 15; i <= 19; i++) {
                    for (int j = i; j >= (i - 15); j = j - 5) {

                        if (tvs.get(j).getText().toString().equals(m)) {

                            win = true;
                            counter++;
                            if (counter == 4)
                                break;
                        } else {
                            win = false;
                            counter = 0;
                            break;
                        }
                    }
                    if (counter == 4)
                        break;
                }
            }
            if (t21.getText().toString().equals(m) && t17.getText().toString().equals(m) && t13.getText().toString().equals(m) && t9.getText().toString().equals(m) || t7.getText().toString().equals(m) && t13.getText().toString().equals(m) && t19.getText().toString().equals(m) && t25.getText().toString().equals(m) || t19.getText().toString().equals(m) && t13.getText().toString().equals(m) && t7.getText().toString().equals(m) && t1.getText().toString().equals(m) || t5.getText().toString().equals(m) && t9.getText().toString().equals(m) && t13.getText().toString().equals(m) && t17.getText().toString().equals(m) || t2.getText().toString().equals(m) && t8.getText().toString().equals(m) && t14.getText().toString().equals(m) && t20.getText().toString().equals(m) || t4.getText().toString().equals(m) && t8.getText().toString().equals(m) && t12.getText().toString().equals(m) && t16.getText().toString().equals(m) || t10.getText().toString().equals(m) && t14.getText().toString().equals(m) && t18.getText().toString().equals(m) && t22.getText().toString().equals(m) || t6.getText().toString().equals(m) && t12.getText().toString().equals(m) && t18.getText().toString().equals(m) && t24.getText().toString().equals(m))
                counter = 4;

            if (counter == 4) {

                if (m.equals("x")) {
                    round++;
                    players.add(new Players(cplayer1, cplayer2, 1, 0,"Round "+round));
                    p1s++;
                    player1.setText(cplayer1 + " score:" + p1s);
                    Toast.makeText(this, "Player 1 win", Toast.LENGTH_SHORT).show();
                } else {
                    round++;
                    players.add(new Players(cplayer1, cplayer2, 0, 1,"Round "+round));
                    p2s++;
                    player2.setText(cplayer2 + " score:" + p2s);
                    Toast.makeText(this, "Player 2 win", Toast.LENGTH_SHORT).show();
                }
                for (TextView textView : tvs) {
                    textView.setBackground(getResources().getDrawable(R.drawable.circle));
                    textView.setText("");
                }
                t1.setText("1");
                t2.setText("2");
                t3.setText("3");
                t4.setText("4");
                t5.setText("5");
            }

        }




        for (TextView textView : tvs) {
           if (! textView.getText().toString().equals("x") && ! textView.getText().toString().equals("o"))
                    return;
        }
        Toast.makeText(this, "game over", Toast.LENGTH_SHORT).show();
        round++;
        players.add(new Players(cplayer1, cplayer2, 0, 0,"Round "+round));
        drow++;
        draw.setText("Drows :" +drow);
        for (TextView textView : tvs) {
            textView.setBackground(getResources().getDrawable(R.drawable.circle));
            textView.setText("");
        }
        t1.setText("1"); t2.setText("2"); t3.setText("3"); t4.setText("4"); t5.setText("5");
        }


//

    public void score(MenuItem item) {
        Intent in = new Intent(this,view.class);
        in.putExtra("Players",players);
        startActivity(in);
    }
}









