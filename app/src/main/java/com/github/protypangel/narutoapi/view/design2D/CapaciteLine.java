package com.github.protypangel.narutoapi.view.design2D;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.github.protypangel.narutoapi.controler.canvas.DatagrammeCapacite;

import java.util.HashMap;

public class CapaciteLine extends View {
    private HashMap<String, Double> puissance;
    public CapaciteLine(Context context) {
        super(context);
    }
    public CapaciteLine(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    public CapaciteLine(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    protected void onDraw(Canvas canvas) {
        int h = super.getHeight();
        int w = super.getWidth();
        DatagrammeCapacite data = new DatagrammeCapacite(canvas, Math.min(h, w)) {
            public double getPuissanceDouble(String var) {
                return puissance.get(var);
            }
            public int getPuissanceSize() {
                return puissance.size();
            }
        };
        super.onDraw(data.getCanvas());
        this.puissance = null;
    }
    public void setPuissance(HashMap<String, Double> puissance){
        this.puissance = puissance;
    }
    public void draw(){
        invalidate();
        requestLayout();
    }
}
