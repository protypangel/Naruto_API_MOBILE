package com.github.protypangel.narutoapi.controler.canvas;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

import com.github.protypangel.narutoapi.model.personnage.Personnage;

public abstract class DatagrammeCapacite {
    private Canvas canvas;
    private int hauteurReduce = 150;
    public DatagrammeCapacite(Canvas canvas, int size){
        this.canvas = canvas;
        this.drawPath((double)size,5,0.5*0.15*(double)size,0.5*0.8*(double)size);
        this.drawPathPuissance((double)size,0.5*0.65*(double)size);
    }
    private void drawPathPuissance(double size, double rayon) {
        drawPathPuissancePath(size,rayon);
        drawPathPuissancePoint(size,rayon);
    }
    private void drawPathPuissancePoint(double size, double rayon){
        Paint paint = new Paint();
        paint.setColor(Color.rgb(173,186,138));
        paint.setStyle(Paint.Style.FILL);
        for(int i=0;i<this.getPuissanceSize();i++){
            double angle = (double)i * Math.PI * (2.0 / (double)this.getPuissanceSize());
            double r = rayon / Personnage.maxPuissance;
            switch (i){
                case 0: r *= this.getPuissanceDouble("Genjutsu"); break;
                case 1: r *= this.getPuissanceDouble("Intelligence"); break;
                case 2: r *= this.getPuissanceDouble("Force"); break;
                case 3: r *= this.getPuissanceDouble("Vitesse"); break;
                case 4: r *= this.getPuissanceDouble("Energie"); break;
                case 5: r *= this.getPuissanceDouble("Signes"); break;
                case 6: r *= this.getPuissanceDouble("Ninjutsu"); break;
                case 7: r *= this.getPuissanceDouble("Taijutsu"); break;
                default: /*ERROR TOO MANY ELEMENT IN PUISSANCE*/ break;
            }
            int x = (int)(r * Math.cos(angle) + size / 2.0);
            int y = (int)(r * Math.sin(angle) + size / 2.0);
            this.canvas.drawCircle(x, y - this.hauteurReduce,20, paint);
        }
    }
    private void drawPathPuissancePath(double size, double rayon){
        Paint paint = new Paint();
        paint.setColor(Color.argb(128,173,186,138));
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);

        Path path = new Path();
        path.moveTo((int)(rayon / Personnage.maxPuissance * this.getPuissanceDouble("Genjutsu") + size / 2.0),(int)(size / 2.0) - this.hauteurReduce);
        for(int i=1;i<this.getPuissanceSize()+1;i++){
            double angle = (double)i * Math.PI * (2.0 / (double)this.getPuissanceSize());
            double r = rayon / Personnage.maxPuissance;
            switch (i % 8){
                case 0: r *= this.getPuissanceDouble("Genjutsu"); break;
                case 1: r *= this.getPuissanceDouble("Intelligence"); break;
                case 2: r *= this.getPuissanceDouble("Force"); break;
                case 3: r *= this.getPuissanceDouble("Vitesse"); break;
                case 4: r *= this.getPuissanceDouble("Energie"); break;
                case 5: r *= this.getPuissanceDouble("Signes"); break;
                case 6: r *= this.getPuissanceDouble("Ninjutsu"); break;
                case 7: r *= this.getPuissanceDouble("Taijutsu"); break;
                default: /*ERROR TOO MANY ELEMENT IN PUISSANCE*/ break;
            }
            int x = (int)(r * Math.cos(angle) + size / 2.0);
            int y = (int)(r * Math.sin(angle) + size / 2.0);
            path.lineTo(x,y - this.hauteurReduce);
        }

        this.canvas.drawPath(path, paint);
    }
    private void drawPath(double size,int lvl,double rayonMin,double rayonMax){
        Paint paint = new Paint();
        paint.setColor(Color.rgb(173,186,138));
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);
        double a = (rayonMax - rayonMin)/(double)lvl;
        int nbPoint = 8;
        for(int i=0;i<lvl;i++){
            this.canvas.drawPath(this.datagramme(size,nbPoint,a*i+rayonMin),paint);
        }
        this.canvas.drawPath(this.datagrammeLine(size,nbPoint,a * (lvl -1) + rayonMin),paint);
    }
    private Path datagramme(double size,int nbPoint,double rayon){
        Path path = new Path();
        path.moveTo((int)(rayon * Math.cos(0) + size / 2.0),(int)(rayon * Math.sin(0) + size / 2.0) - this.hauteurReduce);
        for(int i=0;i<nbPoint+1;i++){
            double angle = (double)i * Math.PI * (2.0 / (double)nbPoint);
            int x = (int)(rayon * Math.cos(angle) + size / 2.0);
            int y = (int)(rayon * Math.sin(angle) + size / 2.0);
            path.lineTo(x,y - this.hauteurReduce);
        }
        return path;
    }
    private Path datagrammeLine(double size,int nbPoint,double rayon){
        Path path = new Path();
        for(int i=0;i<nbPoint;i++){
            double angle1 = (double)i * Math.PI * (2.0 / (double)nbPoint);
            double angle2 = (double)i * Math.PI * (2.0 / (double)nbPoint) + Math.PI;
            path.moveTo((int)(rayon * Math.cos(angle1) + size / 2.0),(int)(rayon * Math.sin(angle1) + size / 2.0) - this.hauteurReduce);
            path.lineTo((int)(rayon * Math.cos(angle2) + size / 2.0),(int)(rayon * Math.sin(angle2) + size / 2.0) - this.hauteurReduce);
        }
        return path;
    }
    public Canvas getCanvas(){
        return this.canvas;
    }
    public abstract double getPuissanceDouble(String var);
    public abstract int getPuissanceSize();
}
