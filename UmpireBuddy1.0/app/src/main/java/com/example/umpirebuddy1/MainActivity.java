package com.example.umpirebuddy1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private int numStrikes = 0;
private int numBalls = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /// wire up the button
        /// get the button
        ///get what happens when the user clicls

        Button btnStrikes = (Button) findViewById(R.id.btnStrike);
        btnStrike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numStrikes += 1;
                if (numStrikes > 2) {
                    numStrikes = 0;
                    numBalls = 0;
                    textViewWalkOut = "OUT";
                }
                updateControlStates();
            }
        });
        Button btnBalls = (Button) findViewById(R.id.btnBalls);

        btnBalls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numBalls += 1;
                if (numBalls > 3) {
                    numBalls = 0;
                    numStrikes = 0;
                    textViewWalkOut = "WALK";
                }
                updateControlStates();

            }
        });
        Button btnReset = findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numStrikes = 0;
                numBalls = 0;
                updateControlStates();
            }
        });
        Button btnAbout = findViewById(R.id.btnAbout);
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewAbout = "Umpire Buddy 2.0 - Byron Nave";
                updateControlStates();
            }
        });

        Button btnExit = findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                homeIntent.addCategory(Intent.CATEGORY_HOME);
                homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
            }


        });

    }







    private void updateControlStates(){
        TextView textViewStrikes = findViewById(R.id.numStrikes);
        textViewStrikes.setText(String.valueOf(numStrikes));
        TextView textViewBalls = findViewById(R.id.numBalls);
        textViewBalls.setText(String.valueOf(numBalls));
        TextView textViewAbout = findViewById(R.id.textViewAbout);
        textViewStrikes.setText(String.valueOf(textViewAbout));
        TextView textViewWalkOut = findViewById(R.id.textViewWalkOut);
        textViewStrikes.setText(String.valueOf(textViewWalkOut));

    }
}
