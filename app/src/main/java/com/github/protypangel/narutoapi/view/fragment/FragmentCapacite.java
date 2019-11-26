package com.github.protypangel.narutoapi.view.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.github.protypangel.narutoapi.R;
import com.github.protypangel.narutoapi.view.design2D.CapaciteLine;

import java.util.HashMap;

public class FragmentCapacite extends Fragment {
    private CapaciteLine datagramme;
    private HashMap<String, Double> puissance;
    public FragmentCapacite(HashMap<String, Double> puissance){
        this.puissance = puissance;
    }
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_capacite,container,false);
        this.datagramme = view.findViewById(R.id.lineCapacite);
        this.datagramme.setPuissance(puissance);
        this.datagramme.draw();
        return view;
    }
}
