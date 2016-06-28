package com.epicodus.bogglesolitaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GameActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    @Bind(R.id.welcome) EditText mWelcome;
    @Bind(R.id.lettersGrid) GridView mLettersGrid;
    @Bind(R.id.generateButton) Button mGenerateButton;
    private String[] letters = new String[] {"A", "B", "C", "D", "E",
            "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O",
            "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z"};
    private ArrayList<String> randomLetters = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        ButterKnife.bind(this);



        mGenerateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            do {
                Random random = new Random();
                int randomNum = random.nextInt(letters.length);
                String theLetter = letters[randomNum];
                Log.d(TAG, theLetter);
                randomLetters.add(theLetter);
                ArrayAdapter adapter = new ArrayAdapter(GameActivity.this, android.R.layout.simple_list_item_1, randomLetters);
                mLettersGrid.setAdapter(adapter);
                }while (randomLetters.size() <8);
            }
        });



        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        mWelcome.setText("Welcome " + username);
    }
}
