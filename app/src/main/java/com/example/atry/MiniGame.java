package com.example.atry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MiniGame extends Activity {

    Application application = com.example.atry.Application.getOurIntance();

    private Timer timer = new Timer();
    private Handler handler = new Handler();

    private TextView timerLabel;
    private ConstraintLayout bg;

    private int ten = 10;
    private float currentTap = 0;
    private float tapCount = 50;
    private boolean runTime = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_mini_game);

        timerLabel = findViewById(R.id.timerText);
        bg = findViewById(R.id.bg);

        final ImageView wizDead = (ImageView) findViewById(R.id.dead);
        wizDead.setImageResource(R.drawable.dead);
        AnimationDrawable wizDeadDrawable = (AnimationDrawable) wizDead.getDrawable();
        wizDeadDrawable.start();
        wizDead.setVisibility(View.INVISIBLE);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if(ten == -1 && runTime){
                            Intent intent = new Intent(MiniGame.this, GameOver.class);
                            startActivity(intent);
                            timer.cancel();
                            runTime = false;
                        }else {
                            timerLabel.setText("" + ten--);
                        }
                    }
                });
            }
        }, 0, 1000);

        bg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentTap != tapCount){
                    wizDead.setVisibility(View.VISIBLE);
                    currentTap++;
                    wizDead.setAlpha((float) currentTap/tapCount);
//                    Toast.makeText(getApplicationContext(), "" + currentTap/tapCount, Toast.LENGTH_SHORT).show();
                }else{
                    application.setRevived(true);
                    runTime = false;
                    switch (application.getLevel()){
                        case 1:
                            Intent intent = new Intent(MiniGame.this, LevelOne.class);
                            startActivity(intent);
                            break;
                        case 2:
                            intent = new Intent(MiniGame.this, LevelTwo.class);
                            startActivity(intent);
                            break;
                        case 3:
                            intent = new Intent(MiniGame.this, LevelThree.class);
                            startActivity(intent);
                            break;
                        case 4:
                            intent = new Intent(MiniGame.this, LevelFour.class);
                            startActivity(intent);
                            break;
                        case 5:
                            intent = new Intent(MiniGame.this, LevelFive.class);
                            startActivity(intent);
                            break;
                        case 6:
                            intent = new Intent(MiniGame.this, LevelSix.class);
                            startActivity(intent);
                            break;
                        case 7:
                            intent = new Intent(MiniGame.this, LevelSeven.class);
                            startActivity(intent);
                            break;
                        case 8:
                            intent = new Intent(MiniGame.this, LevelEight.class);
                            startActivity(intent);
                            break;
                        case 9:
                            intent = new Intent(MiniGame.this, LevelNine.class);
                            startActivity(intent);
                            break;
                        case 10:
                            intent = new Intent(MiniGame.this, LevelTen.class);
                            startActivity(intent);
                            break;
                        case 11:
                            intent = new Intent(MiniGame.this, LevelEleven.class);
                            startActivity(intent);
                            break;
                        case 12:
                            intent = new Intent(MiniGame.this, LevelTwelve.class);
                            startActivity(intent);
                            break;
                        case 13:
                            intent = new Intent(MiniGame.this, LevelThirteen.class);
                            startActivity(intent);
                            break;
                        case 14:
                            intent = new Intent(MiniGame.this, LevelFourteen.class);
                            startActivity(intent);
                            break;
                        case 15:
                            intent = new Intent(MiniGame.this, LevelFifteen.class);
                            startActivity(intent);
                            break;
                        case 16:
                            intent = new Intent(MiniGame.this, LevelSixteen.class);
                            startActivity(intent);
                            break;

                    }
                }


            }
        });

    }
}
