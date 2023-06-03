package com.healthplus.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen


        setContentView(R.layout.activity_home_page);

        Button playBtn=findViewById(R.id.playBtn);
        EditText player1=findViewById(R.id.player1);
        EditText player2=findViewById(R.id.player2);

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(player1.getText().toString()) || TextUtils.isEmpty(player2.getText().toString())){
                    Toast.makeText(HomePage.this, "Please enter the names!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent iPlay=new Intent(HomePage.this,MainActivity.class);
                    iPlay.putExtra("name1",player1.getText().toString());
                    iPlay.putExtra("name2",player2.getText().toString());
                    startActivity(iPlay);
                }
            }
        });

    }
}