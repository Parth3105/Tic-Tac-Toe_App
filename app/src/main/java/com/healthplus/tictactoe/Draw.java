package com.healthplus.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class Draw extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen

        setContentView(R.layout.activity_draw);

        Button newGame=findViewById(R.id.newGame);
        Button restart=findViewById(R.id.restart);
        Button swipe=findViewById(R.id.swipe);
        Button exit=findViewById(R.id.left);


        Intent fromMain=getIntent();
        String player1=fromMain.getStringExtra("return1");
        String player2=fromMain.getStringExtra("return2");

        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iNew=new Intent(Draw.this,HomePage.class);
                startActivity(iNew);
                finish();
            }
        });

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iPrevious=new Intent(Draw.this,MainActivity.class);
                iPrevious.putExtra("name1",player1);
                iPrevious.putExtra("name2",player2);
                startActivity(iPrevious);
                finish();
            }
        });
        swipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String flag="swipe";
                Intent iPreviousSwipe=new Intent(Draw.this,MainActivity.class);
                iPreviousSwipe.putExtra("name1",player2);
                iPreviousSwipe.putExtra("name2",player1);
                startActivity(iPreviousSwipe);
                finish();
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });
    }
}