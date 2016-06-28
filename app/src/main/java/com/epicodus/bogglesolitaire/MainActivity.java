package com.epicodus.bogglesolitaire;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    @Bind(R.id.username) EditText mUsername;
    @Bind(R.id.playButton) Button mPlayButton;
    @Bind(R.id.gameTitle) TextView mGameTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        Typeface caviarDreamFont = Typeface.createFromAsset(getAssets(), "fonts/CaviarDreams.ttf");
        mGameTitle.setTypeface(caviarDreamFont);

        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = mUsername.getText().toString();
                Log.d(TAG, username);

                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });

    }
}
