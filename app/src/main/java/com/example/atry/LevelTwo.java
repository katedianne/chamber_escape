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

public class LevelTwo extends AppCompatActivity implements View.OnTouchListener {

    Application application = com.example.atry.Application.getOurIntance();
    private long currentTime = 0, timeInvincible = 0;
    private ImageView wizard, wiz, obs1, obs2, goal, grnd;
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

        setContentView(R.layout.two);

        wiz = (ImageView) findViewById(R.id.wiz2);
        wiz.setImageDrawable(getResources().getDrawable(R.drawable.idle));
        AnimationDrawable wizIdle = (AnimationDrawable) wiz.getDrawable();
        wizIdle.start();

        frame = findViewById(R.id.frameLayout2);
        obs1 = findViewById(R.id.obs1);
        obs2 = findViewById(R.id.obs2);
        goal = findViewById(R.id.goal);
        grnd = findViewById(R.id.lvlgrnd);

        findViewById(R.id.right2).setOnTouchListener(this);
        findViewById(R.id.left2).setOnTouchListener(this);
        findViewById(R.id.up2).setOnTouchListener(this);
        findViewById(R.id.down2).setOnTouchListener(this);


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
            if(currentTime > timeInvincible){
                if (Collision.checkColl(obs1, wiz) || Collision.checkColl(obs2, wiz) ) {
//                Toast.makeText(getApplicationContext(), "DEAD", Toast.LENGTH_SHORT).show();
                    application.setxCoor(wizardX);
                    application.setyCoor(wizardY);
                    if(!application.isRevived()){
                        Intent intent = new Intent(LevelTwo.this, MiniGame.class);
                        startActivity(intent);
                    }else {
                        Intent intent = new Intent(LevelTwo.this, GameOver.class);
                        startActivity(intent);
                    }
                    gameOver = true;
                }
            }
            if (Collision.checkColl(goal, wiz)) {
                Intent intent = new Intent(LevelTwo.this, Escaped.class);
                startActivity(intent);
                gameOver = true;
            }
        }

        if (wizardX < 0) wizardX = 0;
        if (wizardX > frame.getWidth() - wiz.getWidth()) wizardX = frame.getWidth() - wiz.getWidth();
        if (wizardY < 0) wizardY = 0;
        if (wizardY > grnd.getY() - wiz.getHeight()) wizardY = grnd.getY() - wiz.getHeight();

//        if(wizardY + wiz.getHeight() >= obs1.getY() && wizardY <= obs1.getY() + obs1.getHeight() && wizardX)

//        if(action_jump){
//            if (!jump) {
//                wizardY += 10;
//            }
//            else {
//                wizardY -= 10;
//                if (wizardY < jumpLimit) {
//                    jump = false;
//                }
//            }
////            if(wizardY < jumpLimit && jump){
////                wizardY -= 10;
////            }else {
////                jump = false;
////                wizardY +=10;
////            }
////            wizard.setImageDrawable(wizardRightRun);
//
//        }

//        if (wizardX < 0) wizardX = 0;
//        if (wizardX > frame.getWidth() - wiz.getWidth()) {
//            wizardX = frame.getWidth() - wiz.getWidth();
//        }
//        if (jump == false && wizardY > plat1.getY() - wiz.getHeight() ){
//            while(true){
//                if(wizardX < plat1.getX() - wiz.getWidth() || wizardX > plat1.getX() + plat1.getWidth()){
//                    wizardY = grnd.getY() - wiz.getHeight();
//                    action_jump = false;
//                    break;
//                }
//                wizardY = plat1.getY() - wiz.getHeight();
//                action_jump = false;
//            }
//        }
        wiz.setX(wizardX);
        wiz.setY(wizardY);
    }
    @Override
    public boolean onTouch(View v, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            switch(v.getId()) {
                case R.id.left2:
                    action_left = true;
                    break;
                case R.id.right2:
                    action_right = true;
                    break;
                case R.id.up2:
                    action_up = true;
                    break;
                case R.id.down2:
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
