package com.example.atry;

import android.widget.ImageView;

public class Collision {

    public void Collision() {

    }

    public static Boolean checkColl(ImageView plat, ImageView chara) {
        if (chara.getY() + chara.getHeight() >= plat.getY() && chara.getY() <= plat.getY() + plat.getHeight() && chara.getX() + chara.getWidth() >= plat.getX() && chara.getX() <= plat.getX() + plat.getWidth()) {
            return true;
        }

        return false;
    }
}
