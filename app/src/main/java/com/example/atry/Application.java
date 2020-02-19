package com.example.atry;

public class Application extends android.app.Application {

    private static final Application ourIntance = new Application();

    public static Application getOurIntance() {
        return ourIntance;
    }

    private int level;
    private float xCoor;
    private float yCoor;
    private boolean isRevived;

    public boolean isRevived() {
        return isRevived;
    }

    public void setRevived(boolean revived) {
        isRevived = revived;
    }

    public float getxCoor() {
        return xCoor;
    }

    public void setxCoor(float xCoor) {
        this.xCoor = xCoor;
    }

    public float getyCoor() {
        return yCoor;
    }

    public void setyCoor(float yCoor) {
        this.yCoor = yCoor;
    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}
