package com.github.protypangel.narutoapi.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.github.protypangel.narutoapi.R;
import com.github.protypangel.narutoapi.model.personnage.Personnage;

import java.util.ArrayList;

public class FragmentDescription extends Fragment {
    private TextView birthday,village,grade;
    private ArrayList<TextView> mission;
    private Personnage personnage;
    public FragmentDescription(Personnage personnage){
        this.personnage = personnage;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_description,container,false);
        initizialize(view);
        setValue();
        return view;
    }

    private void setValue() {
        this.birthday.setText(this.birthday.getText()+this.personnage.get().birthday);
        this.village.setText(this.village.getText()+this.personnage.get().village);
        this.grade.setText(this.grade.getText()+this.personnage.get().grade);

        for(int i=0;i<=4;i++)
            this.mission.get(i).setText(this.mission.get(i).getText()+this.getMissionText(i));
    }

    private void initizialize(View view) {
        this.birthday = view.findViewById(R.id.fragment_description_birthday);
        this.village = view.findViewById(R.id.fragment_description_village);
        this.grade = view.findViewById(R.id.fragment_description_grade);

        this.mission = new ArrayList<>();
        for(int i=0;i<=4;i++)
            this.mission.add(this.getMissionTextView(i,view));
    }
    private TextView getMissionTextView(int value,View view){
        switch(value){
            case 0: return view.findViewById(R.id.fragment_description_mission_S);
            case 1: return view.findViewById(R.id.fragment_description_mission_A);
            case 2: return view.findViewById(R.id.fragment_description_mission_B);
            case 3: return view.findViewById(R.id.fragment_description_mission_C);
            case 4: return view.findViewById(R.id.fragment_description_mission_D);
            default: return null;
        }
    }
    private String getMissionText(int value){
        switch (value) {
            case 0: return this.personnage.get().mission.get("S").toString();
            case 1: return this.personnage.get().mission.get("A").toString();
            case 2: return this.personnage.get().mission.get("B").toString();
            case 3: return this.personnage.get().mission.get("C").toString();
            case 4: return this.personnage.get().mission.get("D").toString();
            default: return null;
        }
    }
}

