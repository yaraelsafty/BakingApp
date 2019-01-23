package com.example.yara.bakingapp.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yara.bakingapp.Data.Step;
import com.example.yara.bakingapp.DetailsFragment;
import com.example.yara.bakingapp.R;
import com.example.yara.bakingapp.VedioFragment;

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

                VedioFragment fragment = new VedioFragment();
                FragmentManager fragmentManager = ((FragmentActivity)context).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Bundle bundle=new Bundle();
                bundle.putString("stepDescription",response.getDescription());
                bundle.putString("stepURL",response.getVideoURL());
                bundle.putString("thumbnailUrl",response.getThumbnailURL());

                fragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.frame, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

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
