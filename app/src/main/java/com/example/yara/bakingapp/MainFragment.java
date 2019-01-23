package com.example.yara.bakingapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yara.bakingapp.Adapters.RecipeAdapter;
import com.example.yara.bakingapp.Data.Response;
import com.example.yara.bakingapp.Utils.ApiClient;
import com.example.yara.bakingapp.Utils.IService;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private static final String TAG = MainFragment.class.getSimpleName();
//    @BindView(R.id.rv_recipe)
    RecyclerView recipeRecyclerView;
    LinearLayoutManager linearLayoutManager;
    RecipeAdapter recipeAdapter;
    IService apiInterface;
    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_main, container, false);
//        ButterKnife.bind(this, view);
        recipeRecyclerView=view.findViewById(R.id.rv_recipe);
        apiInterface = ApiClient.getClient().create(IService.class);
        recipeRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        getRecipes();
        return view;
    }

    private void getRecipes() {

        Call<List<Response>> call = apiInterface.getRecipes();
        call.enqueue(new Callback<List<Response>>() {
            @Override
            public void onResponse(Call<List<Response>> call, retrofit2.Response<List<Response>> response) {
              List<Response> list=response.body();
                recipeAdapter=new RecipeAdapter(getActivity(),list);
                Log.d(TAG,""+list.size());
                recipeRecyclerView.setAdapter(recipeAdapter);
            }

            @Override
            public void onFailure(Call<List<Response>> call, Throwable t) {
                Log.e(TAG,t.getMessage());

            }
        });



    }

}
