package com.example.atry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

public class Selection18 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_selection18);

        final ImageView button = findViewById(R.id.next);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Selection18.this, Selection916.class);
                startActivity(intent);
            }
        });

        ImageView[] levelButton = {
                findViewById(R.id.level1),
                findViewById(R.id.level2),
                findViewById(R.id.level3),
                findViewById(R.id.level4),
                findViewById(R.id.level5),
                findViewById(R.id.level6),
                findViewById(R.id.level7),
                findViewById(R.id.level8)
        };

        for(int i = 0;i < levelButton.length;i++) {
            levelButton[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch(v.getId()) {
                        case R.id.level1 :
                            Intent intent = new Intent(Selection18.this, LevelOne.class);
                            startActivity(intent);
                            break;
                        case R.id.level2 :
                            intent = new Intent(Selection18.this, LevelTwo.class);
                            startActivity(intent);
                            break;
                        case R.id.level3 :
                            intent = new Intent(Selection18.this, LevelThree.class);
                            startActivity(intent);
                            break;
                        case R.id.level4 :
                            intent = new Intent(Selection18.this, LevelFour.class);
                            startActivity(intent);
                            break;
                        case R.id.level5 :
                            intent = new Intent(Selection18.this, LevelFive.class);
                            startActivity(intent);
                            break;
                        case R.id.level6 :
                            intent = new Intent(Selection18.this, LevelSix.class);
                            startActivity(intent);
                            break;
                        case R.id.level7 :
                            intent = new Intent(Selection18.this, LevelSeven.class);
                            startActivity(intent);
                            break;
                        case R.id.level8 :
                            intent = new Intent(Selection18.this, LevelEight.class);
                            startActivity(intent);
                            break;

                    }
                }
            });
        }

    }
}
