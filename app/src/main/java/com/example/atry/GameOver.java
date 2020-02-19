package com.example.atry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Selection;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class GameOver extends AppCompatActivity {

    Application application = com.example.atry.Application.getOurIntance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_game_over);

        ImageView back, retry;

        back = findViewById(R.id.back);
        retry = findViewById(R.id.retry);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameOver.this, Selection18.class);
                startActivity(intent);
            }
        });

        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                application.setRevived(false);
                switch (application.getLevel()){
                    case 1:
                        Intent intent = new Intent(GameOver.this, LevelOne.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(GameOver.this, LevelTwo.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(GameOver.this, LevelThree.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(GameOver.this, LevelFour.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(GameOver.this, LevelFive.class);
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(GameOver.this, LevelSix.class);
                        startActivity(intent);
                        break;
                    case 7:
                        intent = new Intent(GameOver.this, LevelSeven.class);
                        startActivity(intent);
                        break;
                    case 8:
                        intent = new Intent(GameOver.this, LevelEight.class);
                        startActivity(intent);
                        break;
                    case 9:
                        intent = new Intent(GameOver.this, LevelNine.class);
                        startActivity(intent);
                        break;
                    case 10:
                        intent = new Intent(GameOver.this, LevelTen.class);
                        startActivity(intent);
                        break;
                    case 11:
                        intent = new Intent(GameOver.this, LevelEleven.class);
                        startActivity(intent);
                        break;
                    case 12:
                        intent = new Intent(GameOver.this, LevelTwelve.class);
                        startActivity(intent);
                        break;
                    case 13:
                        intent = new Intent(GameOver.this, LevelThirteen.class);
                        startActivity(intent);
                        break;
                    case 14:
                        intent = new Intent(GameOver.this, LevelFourteen.class);
                        startActivity(intent);
                        break;
                    case 15:
                        intent = new Intent(GameOver.this, LevelFifteen.class);
                        startActivity(intent);
                        break;
                    case 16:
                        intent = new Intent(GameOver.this, LevelSixteen.class);
                        startActivity(intent);
                        break;

                }
            }
        });


    }

}
