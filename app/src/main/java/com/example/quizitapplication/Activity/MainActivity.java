package com.example.quizitapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizitapplication.ModelClass.QuestionClass;
import com.example.quizitapplication.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //setting controls
    TextView tvQuesCounter, tvTimer, tvQues;

    Button btOpt1, btOpt2, btOpt3, btOpt4;
    int counter;
    CountDownTimer ctm;
    //Question list
    ArrayList<QuestionClass>quesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find view by ids
        tvQues = findViewById(R.id.tvQues);
        tvQuesCounter = findViewById(R.id.tvQuesCounter);
        tvTimer = findViewById(R.id.tvTimer);

        btOpt1 = findViewById(R.id.btOpt1);
        btOpt2 = findViewById(R.id.btOpt2);
        btOpt3 = findViewById(R.id.btOpt3);
        btOpt4 = findViewById(R.id.btOpt4);

        //get data
        quesList.add(new QuestionClass("What is the capital of Jamaica?", "Kingston","Spanish Town","Montego Bay","Ocho Rios","Kingston"));
        quesList.add(new QuestionClass("Who is Jamaica's only female Hero?", "Kedesha","Nanny of the Maroons","Portia Simpson-Miller","Robyn 'Rihanna' Fenty","Nanny of the Maroons"));
        quesList.add(new QuestionClass("Who was the first prime minister of Jamaica?", "Alexander Bustamante","Norman Manley","Christopher Dudus Coke","Bob Marley","Alexander Bustamante"));
        quesList.add(new QuestionClass("Which year did Jamaica make the FIFA World cup?", "1998","2006","2002","2018","1998"));
        quesList.add(new QuestionClass("In which month was the first case of Covid-19 confirmed in Jamaica?", "May","April","March","June","March"));
        quesList.add(new QuestionClass("In which month was Bob Marley Born?", "January","March","June","February","February"));
        quesList.add(new QuestionClass("When did Jamaica gain Independence?", "August 1962","August 1952","September 1956","June 1966","August 1962"));
        quesList.add(new QuestionClass("How many parishes are in Jamaica?", "12","13","15","14","14"));
        quesList.add(new QuestionClass("What is Usain Bolt's world record", "9.53","9.69","9.58","9.61","9.58"));
        quesList.add(new QuestionClass("Who is Jamaica's Fastest woman?", "Shelly-Ann Fraser-Pryce","Merlene Ottey","Elaine Thompson","Veronica Campbell-Brown","Elaine Thompson"));
         counter = 0;

        // adding questions into app
         loadQuestions(counter);

         tvTimer.setText("15");

         ctm =  new CountDownTimer(15 * 1000, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
                tvTimer.setText(""+ millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this, "Quiz Completed", Toast.LENGTH_SHORT).show();
            }
        };

    }

    public void loadQuestions(int n){

       final  QuestionClass q = quesList.get(n);

       tvQuesCounter.setText((n+1) + "/"+ quesList.size());

       tvTimer.setText(""+ 15);
      if(ctm != null){
          ctm.start();
      }

        tvQues.setText(" " + (n + 1) + " " +q.getQues());
        btOpt1.setText(""+q.getOpt1());
        btOpt2.setText(""+q.getOpt2());
        btOpt3.setText(""+q.getOpt3());
        btOpt4.setText(""+q.getOpt4());

        btOpt1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(btOpt1.getText().equals(q.getCorrect())){

                    if(counter < (quesList.size() - 1)){
                        ctm.cancel();
                        counter++;
                        loadQuestions(counter);
                    } else{
                        Toast.makeText(MainActivity.this, "Questions have been Completed", Toast.LENGTH_SHORT).show();
                    }

                    Toast.makeText(MainActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Incorrect Answer", Toast.LENGTH_SHORT).show();
                }
            }

        });
        btOpt2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(btOpt2.getText().equals(q.getCorrect())){
                    if(counter < (quesList.size() - 1)){
                        ctm.cancel();
                        counter++;
                        loadQuestions(counter);
                    } else{
                        Toast.makeText(MainActivity.this, "Questions have been Completed", Toast.LENGTH_SHORT).show();
                    }


                    Toast.makeText(MainActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Incorrect Answer", Toast.LENGTH_SHORT).show();
                }
            }

        }); btOpt3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(btOpt3.getText().equals(q.getCorrect())){
                    if(counter < (quesList.size() - 1)){
                        ctm.cancel();
                        counter++;
                        loadQuestions(counter);
                    } else{
                        Toast.makeText(MainActivity.this, "Questions have been Completed", Toast.LENGTH_SHORT).show();
                    }

                    Toast.makeText(MainActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Incorrect Answer", Toast.LENGTH_SHORT).show();
                }
            }

        });
        btOpt4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(btOpt4.getText().equals(q.getCorrect())){
                    if(counter < (quesList.size() - 1)) {
                        ctm.cancel();
                        counter++;
                        loadQuestions(counter);
                    } else{
                        Toast.makeText(MainActivity.this, "Questions have been Completed", Toast.LENGTH_SHORT).show();
                    }

                    Toast.makeText(MainActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Incorrect Answer", Toast.LENGTH_SHORT).show();
                }
            }

        });


    }

}