package com.healthplus.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    String b1,b2,b3,b4,b5,b6,b7,b8,b9,name1,name2,finalName1,finalName2;
    EditText playerTurn;
    int count=0;
    boolean flag=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen

        setContentView(R.layout.activity_main);

        Intent fromHome=getIntent();
        name1=fromHome.getStringExtra("name1");
        finalName1=name1;
        name2=fromHome.getStringExtra("name2");
        finalName2=name2;
        try{
            playerTurn=findViewById(R.id.playerTurn);
            playerTurn.setText(finalName1);
        }catch (Exception e){}
        try{
            init();
        }
        catch(Exception e){}
    }
    private void init(){
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);
    }
    public void Check(View view){
        Button btnCurrent=(Button) view;
        if(btnCurrent.getText().toString().equals("")){
            if(flag==true){
                playerTurn.setText(finalName2);
            }
            else{
                playerTurn.setText(finalName1);
            }

            count++;
            if(flag==true){
                btnCurrent.setText("X");
                flag=false;
            }
            else{
                btnCurrent.setText("O");
                flag=true;
            }
        }
        if(count>4){
            b1=btn1.getText().toString();
            b2=btn2.getText().toString();
            b3=btn3.getText().toString();
            b4=btn4.getText().toString();
            b5=btn5.getText().toString();
            b6=btn6.getText().toString();
            b7=btn7.getText().toString();
            b8=btn8.getText().toString();
            b9=btn9.getText().toString();

            if(b1.equals(b2) && b2.equals(b3) && !b1.equals("")){
                condition();
            }else if(b4.equals(b5) && b5.equals(b6) && !b4.equals("")){
                condition();
            }else if(b7.equals(b8) && b8.equals(b9) && !b7.equals("")){
                condition();
            }else if(b1.equals(b4) && b4.equals(b7) && !b1.equals("")){
                condition();
            }else if(b2.equals(b5) && b5.equals(b8) && !b2.equals("")){
                condition();
            }else if(b3.equals(b6) && b6.equals(b9) && !b3.equals("")){
                condition();
            }else if(b1.equals(b5) && b5.equals(b9) && !b1.equals("")){
                condition();
            }else if(b3.equals(b5) && b5.equals(b7) && !b3.equals("")){
                condition();
            }else if(!b1.equals("") && !b2.equals("") && !b3.equals("") && !b4.equals("") && !b5.equals("") && !b6.equals("") && !b7.equals("") && !b8.equals("") && !b9.equals("")){
                Intent iDraw=new Intent(MainActivity.this,Draw.class);
                iDraw.putExtra("return1",finalName1);
                iDraw.putExtra("return2",finalName2);
                startActivity(iDraw);
                finish();
            }
        }
    }
    public void condition(){
        Intent iFinal=new Intent(MainActivity.this,FinalActivity.class);
        if(flag==false){
            iFinal.putExtra("winner",finalName1);
            iFinal.putExtra("loser",finalName2);
        }
        else{
            iFinal.putExtra("winner",finalName2);
            iFinal.putExtra("loser",finalName2);
        }
        startActivity(iFinal);
        finish();
    }
}