package com.example.x0application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity  {
EditText player1,player2;
CheckBox xo,connectfour;
Boolean ai=false;
Switch mobile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        player1=findViewById(R.id.etplayer1);
        player2=findViewById(R.id.etplayer2);
        mobile=findViewById(R.id.mobile);
        xo=findViewById(R.id.xo);
        connectfour=findViewById(R.id.connectfour);
        xo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(connectfour.isChecked())
                connectfour.setChecked(false);

            }
        });
        connectfour.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(xo.isChecked())
                    xo.setChecked(false);

            }
        });

    mobile.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(mobile.isChecked()){
                ai=true;
                player2.setText("Mobile");
               player2.setEnabled(false);}
            else{
                ai=false;
                player2.setText("");
                player2.setEnabled(true);
        }}
    });
    }

    public void start(View view) {
if(player1.getText().toString().equals("") || player2.getText().toString().equals("")){
    Toast.makeText(this, "Insert players names", Toast.LENGTH_SHORT).show();
    return;}
        if(xo.isChecked()){

        Intent in = new Intent(this,MainActivity.class);
        in.putExtra("ai",ai);
        in.putExtra("player1",player1.getText().toString());
        in.putExtra("player2",player2.getText().toString());
        startActivity(in);
    }
    else if(connectfour.isChecked()){

            Intent in = new Intent(this,MainActivity3.class);
            in.putExtra("player1",player1.getText().toString());
            in.putExtra("player2",player2.getText().toString());
            in.putExtra("ai",ai);
            startActivity(in);

        }
    else Toast.makeText(this, "Choose a game", Toast.LENGTH_SHORT).show();


    }

}