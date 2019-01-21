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

/**
 * Created by Yara on 21-Jan-19.
 */

public class stepsAdapter extends RecyclerView.Adapter<stepsAdapter.stepsViewHolder> {
    String TAG= stepsAdapter.class.getSimpleName();
    private Context context;
    private List<Step> stepList;

    public stepsAdapter(Context context, List<Step> stepList) {
        this.context = context;
        this.stepList = stepList;
    }

    @Override
    public stepsAdapter.stepsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.steps_row, parent, false);
        return new stepsAdapter.stepsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(stepsAdapter.stepsViewHolder holder, int position) {
        final Step response=stepList.get(position);
        holder.tv_step_des.setText(response.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return stepList.size();
    }


    public class stepsViewHolder extends RecyclerView.ViewHolder {

        TextView tv_step_des;

        public stepsViewHolder(View itemView) {
            super(itemView);

            tv_step_des =itemView.findViewById(R.id.tv_step_des);
        }
    }

}
