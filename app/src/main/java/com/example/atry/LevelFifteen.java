package com.example.atry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class LevelFifteen extends AppCompatActivity  implements View.OnTouchListener {

    Application application = com.example.atry.Application.getOurIntance();
    private long currentTime = 0, timeInvincible = 0;
    private ImageView wiz, plat1, plat2, obs1, obs2, goal;
    private FrameLayout frame;
    private Drawable wizardRight, wizardLeft, wizardRightRun, wizardLeftRun;
    private float wizardX, wizardY, jumpLimit;
    private boolean action_left, action_right, action_up, action_down, action_jump = false, jump;
    private boolean gameOver = false;

    private Timer timer = new Timer();
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.fifteen);
        wiz = (ImageView) findViewById(R.id.wiz);
        wiz.setImageDrawable(getResources().getDrawable(R.drawable.idle));
        AnimationDrawable wizIdle = (AnimationDrawable) wiz.getDrawable();
        wizIdle.start();

        frame = findViewById(R.id.frameLayout);
        obs1 = findViewById(R.id.obs1);
        obs2 = findViewById(R.id.obs2);
        goal = findViewById(R.id.goal);
        plat1 = findViewById(R.id.plat1);
        plat2 = findViewById(R.id.plat2);



        findViewById(R.id.right).setOnTouchListener(this);
        findViewById(R.id.left).setOnTouchListener(this);
        findViewById(R.id.up).setOnTouchListener(this);
        findViewById(R.id.down).setOnTouchListener(this);


        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (!gameOver) changePosition();
                        if (application.isRevived() && timeInvincible == 0){
                            wiz.setX(application.getxCoor());
                            wiz.setY(application.getyCoor());
                            timeInvincible = 1500;
                        }
                        currentTime += 20;
                    }
                });
            }
        }, 0, 20);
    }

    public void changePosition() {
        wizardX = wiz.getX();
        wizardY = wiz.getY();

        if(action_left){
            wizardX -= 10;
//            wizard.setImageDrawable(wizardLeftRun);
        }

        if(action_right){
            wizardX += 10;
//            wizard.setImageDrawable(wizardRightRun);
        }

        if(action_up){
            wizardY -= 10;
//            wizard.setImageDrawable(wizardLeftRun);
        }

        if(action_down){
            wizardY += 10;
//            wizard.setImageDrawable(wizardRightRun);
        }

        if(action_down || action_up || action_left || action_right){
            if(currentTime > timeInvincible) {
                if (Collision.checkColl(obs1, wiz) || Collision.checkColl(obs2, wiz)) {
//                Toast.makeText(getApplicationContext(), "DEAD", Toast.LENGTH_SHORT).show();
                    application.setxCoor(wizardX);
                    application.setyCoor(wizardY);
                    if (!application.isRevived()) {
                        Intent intent = new Intent(LevelFifteen.this, MiniGame.class);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(LevelFifteen.this, GameOver.class);
                        startActivity(intent);
                    }
                    gameOver = true;
                }
            }
            if (Collision.checkColl(goal, wiz)) {
                Intent intent = new Intent(LevelFifteen.this, Escaped.class);
                startActivity(intent);
                gameOver = true;
            }
        }

        if (wizardX < 0) wizardX = 0;
        if (wizardX > frame.getWidth() - wiz.getWidth()) wizardX = frame.getWidth() - wiz.getWidth();
        if (wizardY < 0) wizardY = 0;
        if (wizardY > plat1.getY() - wiz.getHeight() ) wizardY = plat1.getY() - wiz.getHeight();
        if (wizardY > plat2.getY() - wiz.getHeight() && wizardX + wiz.getWidth() > plat2.getX()) wizardY = plat2.getY() - wiz.getHeight();



        wiz.setX(wizardX);
        wiz.setY(wizardY);
    }

    @Override
    public boolean onTouch(View v, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            switch(v.getId()) {
                case R.id.left:
                    action_left = true;
                    break;
                case R.id.right:
                    action_right = true;
                    break;
                case R.id.up:
                    action_up = true;
                    break;
                case R.id.down:
                    action_down = true;
                    break;
            }
        }
        else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
            action_left = false;
            action_right = false;
            action_up = false;
            action_down = false;


//            action_jump = false;
        }
        return true;
    }
}
