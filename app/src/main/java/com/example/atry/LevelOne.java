package com.example.atry;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class LevelOne extends AppCompatActivity implements View.OnTouchListener {

    private ImageView wizard, wiz, grnd, obs, goal;
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

        setContentView(R.layout.one);

        wiz = (ImageView) findViewById(R.id.wizard);
        wiz.setImageDrawable(getResources().getDrawable(R.drawable.idle));
        AnimationDrawable wizIdle = (AnimationDrawable) wiz.getDrawable();
        wizIdle.start();

        wizard = findViewById(R.id.wizard);
        frame = findViewById(R.id.frameLayout);
        grnd = findViewById(R.id.platform1);
        goal = findViewById(R.id.goal);
        obs = findViewById(R.id.obbslvl1);
        wizardLeft = getResources().getDrawable(R.drawable.idle);
        wizardRight = getResources().getDrawable(R.drawable.idle);

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
                    }
                });
            }
        }, 0, 20);
    }

    public void changePosition(){
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
            if (Collision.checkColl(obs, wiz) ) {
                Toast.makeText(getApplicationContext(), "DEAD", Toast.LENGTH_SHORT).show();
                gameOver = true;
            }
            if (Collision.checkColl(goal, wiz)) {
                Toast.makeText(getApplicationContext(), "FINISHED", Toast.LENGTH_SHORT).show();
                gameOver = true;
            }
        }

        if (wizardX < 0) wizardX = 0;
        if (wizardX > frame.getWidth() - wiz.getWidth()) wizardX = frame.getWidth() - wiz.getWidth();
        if (wizardY < 0) wizardY = 0;
        if (wizardY > grnd.getY() - wiz.getHeight()) wizardY = grnd.getY() - wiz.getHeight();

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
//
//        if (wizardX < 0) wizardX = 0;
//        if (wizardX > frame.getWidth() - wiz.getWidth()) wizardX = frame.getWidth() - wiz.getWidth();
//
//        if (wizardX >= 0 && wizardX <= plat2.getX() - wiz.getWidth()) {
////            if (wizardY < plat1.getY()) {
////                action_jump = true;
////            }
//             if (wizardY >= plat1.getY() - wiz.getHeight()) {
//                action_jump = false;
//                wizardY = plat1.getY() - wiz.getHeight();
//            }
//        }
//        else if (wizardX >= plat2.getX() && wizardX <= frame.getWidth() - wiz.getWidth()) {
////            if (wizardY < plat2.getY()) {
////                action_jump = true;
////            }
//             if (wizardY >= plat2.getY() - wiz.getHeight()) {
//                action_jump = false;
//                wizardY = plat2.getY() - wiz.getHeight();
//            }
//        }
//        else if (wizardY >= plat2.getY() - wiz.getHeight()) {
//            action_jump = true;
//            jumpLimit = wiz.getY();
//            Toast.makeText(getApplicationContext(), "Hello", Toast.LENGTH_SHORT).show();
//        }
//        else if (wizardX > plat2.getX() - wiz.getWidth() && wizardY > plat2.getY() - wiz.getHeight()) {
//            wizardX = plat2.getX() - wiz.getWidth();
//        }

//        if (wizardX < 0) wizardX = 0;
//        if (wizardX < plat2.getX() && wizardY < plat2.getY()){
//            wizardY = plat1.getY() - wiz.getHeight();
//            action_jump = false;
//        }
//        if (wizardX > frame.getWidth() - wiz.getWidth()) wizardX = frame.getWidth() - wiz.getWidth();
//
//        if (wizardX > plat2.getX() - wiz.getWidth() && wizardY > plat2.getY() - wiz.getHeight()) {
//            wizardX = plat2.getX() - wiz.getWidth();
//        }
//
//        if (wizardY > plat1.getY() - wiz.getHeight()){
//            wizardY = plat1.getY() - wiz.getHeight();
//            action_jump = false;
//        }
//
//        if (wizardX > plat2.getX() && wizardY < plat2.getY() - wiz.getHeight()) {
//            wizardY = plat2.getY() - wiz.getHeight();
//            action_jump = false;
//        }
//
//
//
//        if (wizardY < plat2.getY() - wiz.getHeight() && wizardX > plat2.getX() - wiz.getWidth()) {
//            wizardY = plat2.getY() - wiz.getHeight();
//            action_jump = false;
//        }
//
//        if (wizardY > plat1.getY() - wiz.getHeight()) {
//            wizardY = plat1.getY() - wiz.getHeight();
//            action_jump = false;
//        }

//        else if (wizardY < plat2.getY() - wiz.getHeight() && wizardX > plat2.getX() + plat2.getWidth() - wiz.getX()) {
//            wizardX = plat2.getX() + plat2.getWidth() - wiz.getX();
//        }
//        if (wizardY > plat1.getY() - wiz.getHeight() ) {
//            wizardY = plat1.getY() - wiz.getHeight();
//            action_jump = false;
//        }

//        if (wizardY > frame.getY()+frame.getHeight()-plat1.getHeight()) wizardY = frame.getY()+frame.getHeight()-plat1.getHeight();

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
