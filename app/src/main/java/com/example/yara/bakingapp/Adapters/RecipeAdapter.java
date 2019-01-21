package com.example.yara.bakingapp.Adapters;

import android.content.Context;
import android.os.Bundle;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yara.bakingapp.Data.Ingredient;
import com.example.yara.bakingapp.Data.Response;
import com.example.yara.bakingapp.Data.Step;
import com.example.yara.bakingapp.DetailsFragment;
import com.example.yara.bakingapp.R;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Yara on 16-Jan-19.
 */

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {
    String TAG= RecipeAdapter.class.getSimpleName();
    private Context context;
    private List<Response> resultList;
    private String servings;
    private List<Ingredient> ingredientList;
    private List<Step> stepList;

    public RecipeAdapter(Context context, List<Response> resultList) {
        this.context = context;
        this.resultList = resultList;
    }

    @Override
    public RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recipr_row, parent, false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecipeViewHolder holder, int position) {
        final Response response=resultList.get(position);
        holder.dishText.setText(response.getName());
        servings = "servings" + " " +
                String.valueOf(response.getServings());
        String imageUrl = response.getImage();
        if (!imageUrl.equals("")) {
            //Load image if present
            Picasso.with(context).load(imageUrl).into(holder.imageView);
        }
        holder.servingText.setText(servings);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stepList=response.getSteps();
                ingredientList=response.getIngredients();
                Log.d(TAG,"***"+stepList.size()+"+++"+ingredientList.size());


                DetailsFragment fragment = new DetailsFragment();
                FragmentManager fragmentManager = ((FragmentActivity)context).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Bundle bundle=new Bundle();
                bundle.putSerializable("stepList", (Serializable) stepList);
                bundle.putSerializable("ingredientList", (Serializable) ingredientList);

                fragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.frame, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public class RecipeViewHolder extends RecyclerView.ViewHolder {
        //@BindView(R.id.dish_text_view)
        TextView dishText;

       // @BindView(R.id.servings_text_view)
        TextView servingText;

       // @BindView(R.id.card_view)
        CardView cardView;

       // @BindView(R.id.dish_image_view)
        AppCompatImageView imageView;

        public RecipeViewHolder(View itemView) {
            super(itemView);
          //  ButterKnife.bind(this, itemView);
            dishText=itemView.findViewById(R.id.dish_text_view);
            servingText=itemView.findViewById(R.id.servings_text_view);
            cardView=itemView.findViewById(R.id.card_view);
            imageView=itemView.findViewById(R.id.dish_image_view);
        }
    }
}
