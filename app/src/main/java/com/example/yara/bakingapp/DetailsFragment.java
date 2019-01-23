package com.example.yara.bakingapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yara.bakingapp.Adapters.IngredientAdapter;
import com.example.yara.bakingapp.Adapters.RecipeAdapter;
import com.example.yara.bakingapp.Adapters.stepsAdapter;
import com.example.yara.bakingapp.Data.Ingredient;
import com.example.yara.bakingapp.Data.Step;
import com.example.yara.bakingapp.Utils.ApiClient;
import com.example.yara.bakingapp.Utils.IService;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {

    List<Step>stepList=new ArrayList<>();
    List<Ingredient>ingredientList=new ArrayList<>();

    RecyclerView rv_ingredients , rv_steps ;

    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_details, container, false);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            stepList = (List<Step>) bundle.getSerializable("stepList");
            ingredientList= (List<Ingredient>) bundle.getSerializable("ingredientList");
        }

        rv_ingredients=view.findViewById(R.id.rv_ingredients);
        IngredientAdapter ingredientAdapter=new IngredientAdapter(getActivity(),ingredientList);
        rv_ingredients.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        rv_ingredients.setAdapter(ingredientAdapter);

        rv_steps=view.findViewById(R.id.rv_steps);
        stepsAdapter stepsAdapter = new stepsAdapter(getActivity(),stepList);
        rv_steps.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        rv_steps.setAdapter(stepsAdapter);


        return view;
    }

}
