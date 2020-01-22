package com.example.atry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class Selection916 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_selection916);

//        ImageView[] levelButton = {
//                findViewById(R.id.level9),
//                findViewById(R.id.level10),
//                findViewById(R.id.level11),
//                findViewById(R.id.level12),
//                findViewById(R.id.level13),
//                findViewById(R.id.level14),
//                findViewById(R.id.level15),
//                findViewById(R.id.level16)
//        };
//
//        for(int i = 0;i < levelButton.length;i++) {
//            levelButton[i].setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    switch(v.getId()) {
//                        case R.id.level9 :
//                            Intent intent = new Intent(Selection916.this, LevelNine.class);
//                            startActivity(intent);
//                            break;
//                        case R.id.level10 :
//                            intent = new Intent(Selection916.this, LevelTen.class);
//                            startActivity(intent);
//                            break;
//                        case R.id.level11 :
//                            intent = new Intent(Selection916.this, LevelEleven.class);
//                            startActivity(intent);
//                            break;
//                        case R.id.level12 :
//                            intent = new Intent(Selection916.this, LevelTwelve.class);
//                            startActivity(intent);
//                            break;
//                        case R.id.level13 :
//                            intent = new Intent(Selection916.this, LevelThirteen.class);
//                            startActivity(intent);
//                            break;
//                        case R.id.level14 :
//                            intent = new Intent(Selection916.this, LevelFourteen.class);
//                            startActivity(intent);
//                            break;
//                        case R.id.level15 :
//                            intent = new Intent(Selection916.this, LevelFifteen.class);
//                            startActivity(intent);
//                            break;
//                        case R.id.level16 :
//                            intent = new Intent(Selection916.this, LevelSixteen.class);
//                            startActivity(intent);
//                            break;
//
//                    }
//                }
//            });
//        }
    }
}
