package com.example.kevin.project_phase1;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;

public class colorGradient {
    public float[] hsv1;
    public float[] hsv2;
    public String name;

    public colorGradient(float[]hsv1, float[] hsv2, String name){
        this.hsv1=hsv1;
        this.hsv2=hsv2;
        this.name=name;
    }

    public GradientDrawable getLRGradient(){
        int colorLeft=Color.HSVToColor(hsv1);
        int colorRight=Color.HSVToColor(hsv2);
        GradientDrawable d = new GradientDrawable(
                GradientDrawable.Orientation.LEFT_RIGHT, new int[] {colorLeft, colorRight});
        return d;
    }
}
