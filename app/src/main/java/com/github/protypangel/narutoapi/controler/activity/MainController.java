package com.github.protypangel.narutoapi.controler.activity;

import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

import com.github.protypangel.narutoapi.R;
import com.github.protypangel.narutoapi.controler.recyclerView.RecyclerViewCharacter;
import com.github.protypangel.narutoapi.model.api.Link;
import com.github.protypangel.narutoapi.model.api.GetAPI;
import com.github.protypangel.narutoapi.model.personnage.Personnage;
import com.github.protypangel.narutoapi.view.activity.MainActivity;

import java.util.List;

public class MainController {

    private List<Personnage> personnages;
    private MainActivity mainActivity;
    private RecyclerViewCharacter recyclerViewCharacter;

    public MainController(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        this.getApi();
    }
    private void getApi(){
        new GetAPI() {
            public void successful(List<Personnage> personnages) {
                // Save the list of personnage
                saveListOfPersonnage(personnages);
                // Set the recyclerView with this list
                setRecyclerViewCharacter(personnages);
            }
        };
    }
    public void saveListOfPersonnage(List<Personnage> personnages){
        this.personnages = personnages;
    }
    public Personnage getPersonnage(int position){
        return this.personnages.get(position);
    }
    public void setRecyclerViewCharacter(final List<Personnage> personnages){
        RecyclerView recyclerView = mainActivity.findViewById(R.id.recyclerViewCharacter);
        this.recyclerViewCharacter = new RecyclerViewCharacter(personnages.size(),mainActivity.getApplicationContext(),recyclerView) {
            public void clickListener(int position) {
                mainActivity.otherActivity(personnages.get(position));
            }
            public String getName(int position) {
                // Return the full name of the personnage
                return personnages.get(position).get().firstName + " " + personnages.get(position).get().lastName;
            }
            public String getUrl(int position) {
                // Return the the url of the image
                return Link.image+personnages.get(position).get().image;
            }
        };
    }
}
