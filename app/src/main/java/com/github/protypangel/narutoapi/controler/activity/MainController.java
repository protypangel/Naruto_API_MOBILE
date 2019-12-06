package com.github.protypangel.narutoapi.controler.activity;

import android.content.SharedPreferences;

import androidx.recyclerview.widget.RecyclerView;

import com.github.protypangel.narutoapi.R;
import com.github.protypangel.narutoapi.controler.recyclerView.RecyclerViewCharacter;
import com.github.protypangel.narutoapi.model.api.Link;
import com.github.protypangel.narutoapi.model.api.GetAPI;
import com.github.protypangel.narutoapi.model.personnage.Personnage;
import com.github.protypangel.narutoapi.view.activity.MainActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class MainController {

    private List<Personnage> personnages;
    private MainActivity mainActivity;
    private RecyclerViewCharacter recyclerViewCharacter;

    public MainController(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        this.getFromCache();
        if(personnages == null) {
            this.getApi();
        } else {
            setRecyclerViewCharacter(this.personnages);
        }
    }

    private void setFromCache() {
        SharedPreferences sharedPreferences = mainActivity.getSharedPreferences("shared preferences", mainActivity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("personnages", new Gson().toJson(personnages));
        editor.apply();
    }

    private void getFromCache() {
        SharedPreferences sharedPreferences = mainActivity.getSharedPreferences("shared preferences", mainActivity.MODE_PRIVATE);
        this.personnages = new Gson().fromJson(sharedPreferences.getString("personnages",null),new TypeToken<List<Personnage>>() {}.getType());
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
        this.setFromCache();
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
            public String getUrl(int position) {
                // Return the the url of the image
                return Link.image+personnages.get(position).get().image;
            }
        };
    }
}
