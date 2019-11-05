package com.github.protypangel.narutoapi.model.personnage;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Personnage implements Parcelable {
    private int id;
    private String firstName,lastName,birthday,village,grade;
    private HashMap<String,Integer> mission;
    private HashMap<String,Double> puissance;

    public static Double maxPuissance = 5.0;

    private Personnage(Set set){
        this.set(set);
    }
    public void createGson(){
        //p.add(new Personnage(,"","","","","",new Integer[]{,,,,},new Double[]{0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0}));
        Gson json = new Gson();
        ArrayList<Personnage> p = new ArrayList<>();
        p.add(new Personnage(new Set(0,"Naruto","Uzumaki","10 octobre","Konoha","Genin",new Integer[]{7,1,0,0,0},new Double[]{2.0,1.5,1.0,1.0,2.0,2.0,4.0,1.0})));
        p.add(new Personnage(new Set(1,"Naruto","Uzumaki","10 octobre","Konoha","Genin",new Integer[]{7,1,1,2,0},new Double[]{3.0,2.0,1.0,1.5,3.0,3.0,4.0,1.0})));
        p.add(new Personnage(new Set(2,"Naruto","Uzumaki","10 octobre","Konoha","Genin",new Integer[]{7,1,2,6,0},new Double[]{4.0,3.5,2.0,3.0,3.5,3.5,5.0,1.5})));
        p.add(new Personnage(new Set(3,"Sazuke","Uchiwa","23 juillet","Konoha","Genin",new Integer[]{7,1,0,0,0},new Double[]{2.5,2.5,1.5,2.0,2.0,3.0,2.0,3.0})));
        p.add(new Personnage(new Set(4,"Sazuke","Uchiwa","23 juillet","Konoha","Genin",new Integer[]{7,1,0,1,0},new Double[]{3.5,2.5,1.5,2.5,3.0,3.5,3.0,3.0})));
        p.add(new Personnage(new Set(5,"Sazuke","Uchiwa","23 juillet","Konoha","Deserteur",new Integer[]{7,1,2,6,0},new Double[]{5.0,3.5,4.0,3.5,3.5,4.5,3.5,4.0})));
        p.add(new Personnage(new Set(6,"Sakura","Haruno","28 mars","Konoha","Genin",new Integer[]{7,1,0,0,0},new Double[]{1.5,1.0,3.0,3.5,0.5,1.0,1.0,4.0})));
        p.add(new Personnage(new Set(7,"Sakura","Haruno","28 mars","Konoha","Genin",new Integer[]{7,1,0,1,0},new Double[]{2.0,1.0,3.5,4.0,1.0,1.0,1.5,4.0})));
        p.add(new Personnage(new Set(8,"Sakura","Haruno","28 mars","Konoha","Genin",new Integer[]{12,9,6,7,0},new Double[]{3.0,3.0,3.5,4.0,3.0,3.0,2.5,4.0})));
        p.add(new Personnage(new Set(9,"Kakashi","Hatake","15 septembre","Konoha","Jounin",new Integer[]{197,189,413,276,38},new Double[]{5.0,4.0,4.0,4.5,3.5,4.0,3.0,5.0})));
        p.add(new Personnage(new Set(10,"Kakashi","Hatake","15 septembre","Konoha","Jounin",new Integer[]{197,189,414,277,39},new Double[]{5.0,4.5,4.0,5.0,3.5,4.5,3.0,5.0})));
        p.add(new Personnage(new Set(11,"Kakashi","Hatake","15 septembre","Konoha","Jounin",new Integer[]{197,190,414,298,42},new Double[]{5.0,4.5,4.0,5.0,3.5,4.5,3.0,5.0})));
        p.add(new Personnage(new Set(12,"Yamato","","10 aout","Konoha","Anbu",new Integer[]{80,176,400,305,35},new Double[]{4.5,4.0,3.5,4.5,3.5,4.0,3.5,3.5})));
        p.add(new Personnage(new Set(13,"Sai","","25 novembre","Konoha","Anbu",new Integer[]{-1,-1,-1,-1,-1},new Double[]{4.0,3.5,3.0,3.5,3.0,3.5,3.0,4.0})));
        String teste =  json.toJson(p);
    }

    /* Parcelable */
    protected Personnage(Parcel in) {
        this.set(new Set(in.readInt(),in.readString(),in.readString(),in.readString(),in.readString(),in.readString(),in.createIntArray(),in.createDoubleArray()));
    }
    public static final Creator<Personnage> CREATOR = new Creator<Personnage>() {
        public Personnage createFromParcel(Parcel in) {
            return new Personnage(in);
        }
        public Personnage[] newArray(int size) {
            return new Personnage[size];
        }
    };
    public int describeContents() {
        return 0;
    }
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.firstName);
        dest.writeString(this.lastName);
        dest.writeString(this.birthday);
        dest.writeString(this.village);
        dest.writeString(this.grade);
        dest.writeIntArray(writeParcelableMission());
        dest.writeDoubleArray(writeParcelablePuissance());
    }
    private int[] writeParcelableMission(){
        return new int[]{this.mission.get("D"),this.mission.get("C"),this.mission.get("B"),this.mission.get("A"),this.mission.get("S")};
    }
    private double[] writeParcelablePuissance() {
        return new double[]{this.puissance.get("Ninjutsu"),this.puissance.get("Taijutsu"),this.puissance.get("Genjutsu"),this.puissance.get("Intelligence"),this.puissance.get("Force"),this.puissance.get("Vitesse"),this.puissance.get("Energie"),this.puissance.get("Signes")};
    }
    /* Getter */
    public Get get(){
        return new Get(this.id,this.firstName,this.lastName,this.birthday,this.village,this.grade,this.mission,this.puissance);
    }
    public class Get{
        public int id;
        public String firstName,lastName,birthday,village,grade;
        public HashMap<String,Integer> mission;
        public HashMap<String,Double> puissance;
        public Get(int id,String firstName,String lastName,String birthday,String village,String grade,HashMap<String,Integer> mission,HashMap<String,Double> puissance){
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.birthday = birthday;
            this.village = village;
            this.grade = grade;
            this.mission = mission;
            this.puissance = puissance;
        }
    }
    /* Setter */
    public void set(Set set){
        this.id = set.id;
        this.firstName = set.firstName;
        this.lastName = set.lastName;
        this.birthday = set.birthday;
        this.village = set.village;
        this.grade = set.grade;
        this.mission = set.mission;
        this.puissance = set.puissance;
    }
    public class Set{
        private int id;
        private String firstName,lastName,birthday,village,grade;
        public HashMap<String,Integer> mission;
        public HashMap<String,Double> puissance;
        public Set(int id,String firstName,String lastName,String birthday,String village,String grade){
            this.mission = new HashMap<>();
            this.puissance = new HashMap<>();
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.birthday = birthday;
            this.village = village;
            this.grade = grade;
        }
        public Set(int id,String firstName,String lastName,String birthday,String village,String grade,Integer[] mission,Double[] puissance){
            this(id,firstName,lastName,birthday,village,grade);
            ArrayList<String> key = new ArrayList<>(Arrays.asList(("D,C,B,A,S,Ninjutsu,Taijutsu,Genjutsu,Intelligence,Force,Vitesse,Energie,Signes").split(",")));
            for (int i = 0; i < 5; i++) {
                this.mission.put(key.get(i),mission[i]);
            }
            for (int i = 5; i < key.size(); i++) {
                this.puissance.put(key.get(i),puissance[i-5]);
            }
        }
        public Set(int id,String firstName,String lastName,String birthday,String village,String grade,int[] mission,double[] puissance){
            this(id,firstName,lastName,birthday,village,grade);
            ArrayList<String> key = new ArrayList<>(Arrays.asList(("D,C,B,A,S,Ninjutsu,Taijutsu,Genjutsu,Intelligence,Force,Vitesse,Energie,Signes").split(",")));
            for (int i = 0; i < 5; i++) {
                this.mission.put(key.get(i),mission[i]);
            }
            for (int i = 5; i < key.size(); i++) {
                this.puissance.put(key.get(i),puissance[i-5]);
            }
        }
        public Set(int id,String firstName,String lastName,String birthday,String village,String grade,ArrayList<Integer> mission,ArrayList<Double> puissance){
            this(id,firstName,lastName,birthday,village,grade);
            ArrayList<String> key = new ArrayList<>(Arrays.asList(("D,C,B,A,S,Ninjutsu,Taijutsu,Genjutsu,Intelligence,Force,Vitesse,Energie,Signes").split(",")));
            for (int i = 0; i < 5; i++) {
                this.mission.put(key.get(i),mission.get(i));
            }
            for (int i = 5; i < key.size(); i++) {
                this.puissance.put(key.get(i),puissance.get(i-5));
            }
        }
    }
}
