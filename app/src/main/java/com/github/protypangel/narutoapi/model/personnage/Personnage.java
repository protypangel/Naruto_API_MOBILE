package com.github.protypangel.narutoapi.model.personnage;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Personnage implements Parcelable {
    private int id;
    private String firstName,lastName,grade,image,village,birthday;
    private HashMap<String,Integer> mission;
    private HashMap<String,Double> puissance;

    public static final Double maxPuissance = 5.0;

    private Personnage(Set set){
        this.set(set);
    }
    /* Parcelable */
    protected Personnage(Parcel in) {
        this.set(new Set(in.readInt(),in.readString(),in.readString(),in.readString(),in.readString(),in.readString(),in.readString(),in.createIntArray(),in.createDoubleArray()));
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
        dest.writeString(this.image);
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
        return new Get(this.id,this.firstName,this.lastName,this.birthday,this.village,this.grade,this.image,this.mission,this.puissance);
    }
    public class Get{
        public int id;
        public String firstName,lastName,birthday,village,grade,image;
        public HashMap<String,Integer> mission;
        public HashMap<String,Double> puissance;
        public Get(int id,String firstName,String lastName,String birthday,String village,String grade,String image,HashMap<String,Integer> mission,HashMap<String,Double> puissance){
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.birthday = birthday;
            this.village = village;
            this.grade = grade;
            this.mission = mission;
            this.puissance = puissance;
            this.image = image;
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
        this.image = set.image;
    }
    public class Set{
        private int id;
        private String firstName,lastName,birthday,village,grade,image;
        private HashMap<String,Integer> mission;
        private HashMap<String,Double> puissance;
        public Set(int id,String firstName,String lastName,String birthday,String village,String grade,String image){
            this.mission = new HashMap<>();
            this.puissance = new HashMap<>();
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.birthday = birthday;
            this.village = village;
            this.grade = grade;
            this.image = image;
        }
        public Set(int id,String firstName,String lastName,String birthday,String village,String grade,String image,Integer[] mission,Double[] puissance){
            this(id,firstName,lastName,birthday,village,grade,image);
            ArrayList<String> key = new ArrayList<>(Arrays.asList(("D,C,B,A,S,Ninjutsu,Taijutsu,Genjutsu,Intelligence,Force,Vitesse,Energie,Signes").split(",")));
            for (int i = 0; i < 5; i++) {
                this.mission.put(key.get(i),mission[i]);
            }
            for (int i = 5; i < key.size(); i++) {
                this.puissance.put(key.get(i),puissance[i-5]);
            }
        }
        public Set(int id,String firstName,String lastName,String birthday,String village,String grade,String image,int[] mission,double[] puissance){
            this(id,firstName,lastName,birthday,village,grade,image);
            ArrayList<String> key = new ArrayList<>(Arrays.asList(("D,C,B,A,S,Ninjutsu,Taijutsu,Genjutsu,Intelligence,Force,Vitesse,Energie,Signes").split(",")));
            for (int i = 0; i < 5; i++) {
                this.mission.put(key.get(i),mission[i]);
            }
            for (int i = 5; i < key.size(); i++) {
                this.puissance.put(key.get(i),puissance[i-5]);
            }
        }
        public Set(int id,String firstName,String lastName,String birthday,String village,String grade,String image,ArrayList<Integer> mission,ArrayList<Double> puissance){
            this(id,firstName,lastName,birthday,village,grade,image);
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
