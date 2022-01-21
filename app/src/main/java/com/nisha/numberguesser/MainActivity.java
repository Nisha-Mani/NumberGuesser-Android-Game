package com.nisha.numberguesser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    int numToGuess;
    public int generateRandomNumber(){
        Random randNum = new Random();
        numToGuess = randNum.nextInt(20)+1;
        return numToGuess;
    }
    public void guessButtonAction(View view){
        EditText editTextInputNum = (EditText) findViewById(R.id.editTextNumberInput);
        TextView textViewResult = (TextView) findViewById(R.id.textViewResultDisplay);
        textViewResult.setText("");
        String toastMessage="";
        int inputNum = Integer.parseInt(editTextInputNum.getText().toString());
        if(inputNum>20 && inputNum<1)
            toastMessage="Enter value between 1 and 20";
        else{
            if (inputNum > numToGuess) {
                toastMessage="Try a Lesser number!";
            } else if(inputNum < numToGuess){
                toastMessage="Try a Greater number!";
            } else{
                textViewResult.setText("That's CORRECT! Try again");
                numToGuess =generateRandomNumber();
                editTextInputNum.setText("");
            }
        }
        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}