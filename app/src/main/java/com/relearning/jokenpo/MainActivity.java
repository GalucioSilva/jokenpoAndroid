package com.relearning.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectStone(View view){
        this.selectedOption("Stone");
    }
    public void selectPaper(View view){
        this.selectedOption("Paper");
    }
    public void selectScissors(View view){
        this.selectedOption("Scissors");
    }

    public void selectedOption(String option){

        String [] options = {"Stone", "Paper","Scissors"};
        int num = new Random().nextInt(3);
        String appOption=options[num];
        System.out.println(appOption);
        ImageView imageResult = findViewById(R.id.resultImage);
        TextView appText = findViewById(R.id.AppText);
        TextView ResultText = findViewById(R.id.ResultText);
        switch(appOption){
            case "Stone":
                imageResult.setImageResource(R.drawable.pedra);
                appText.setText("O App Escolheu Pedra");
                break;
            case "Paper":
                imageResult.setImageResource(R.drawable.papel);
                appText.setText("O App Escolheu Papel");
                break;
            case "Scissors":
                imageResult.setImageResource(R.drawable.tesoura);
                appText.setText("O App Escolheu Tesoura");
                break;
        }
        if(
                (appOption=="Stone"&&option=="Scissors")||
                (appOption=="Paper"&&option=="Stone")||
                (appOption=="Scissors"&&option=="Paper"))
        {
            ResultText.setText("Você Perdeu");
        }else if(
                (option=="Stone"&&appOption=="Scissors")||
                (option=="Paper"&&appOption=="Stone")||
                (option=="Scissors"&&appOption=="Paper")
        ){
            ResultText.setText("Você Ganhou");
        }else{
            ResultText.setText("Empatou");
        }
    }
}