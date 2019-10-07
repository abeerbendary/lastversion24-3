package com.example.abeer.quarantine.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.abeer.quarantine.R;
import com.example.abeer.quarantine.activity.MainActivity_Ex_RequestCommitteeResult;
import com.example.abeer.quarantine.activity.MainActivity_TreatmentStatement;
import com.example.abeer.quarantine.activity.dashactivity.Ex_RequestCommitteeResult;
import com.example.abeer.quarantine.activity.dashactivity.TreatmentStatement;
import com.example.abeer.quarantine.databinding.LOTSdatabinding;
import com.example.abeer.quarantine.presenter.Clickcustum;
import com.example.abeer.quarantine.viewmodel.ex_RequestCommitteeResult.SampleData_LOts;

import java.util.List;

public class MyAdapterforRecycler extends RecyclerView.Adapter<MyAdapterforRecycler.Holder> {


    List<SampleData_LOts>Sampledata_lots;
    Clickcustum clickcustum;
    Context context;

    public MyAdapterforRecycler(List<SampleData_LOts> sampledata_lots, Context context, Clickcustum clickcustum) {
        Sampledata_lots = sampledata_lots;
        this.clickcustum = clickcustum;
        this.context = context;
    }

    public MyAdapterforRecycler() {
    }



    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

     LOTSdatabinding lotsdatabinding = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()),
                R.layout.innercard, viewGroup, false);
        return new Holder(lotsdatabinding);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        SampleData_LOts sampleData_lOts = Sampledata_lots.get(i);
        holder.bind(sampleData_lOts,clickcustum);
        holder.lotsdatabinding.setClicked(clickcustum);
//        if(context instanceof MainActivity_TreatmentStatement ||context instanceof MainActivity_Ex_RequestCommitteeResult) {
//            holder.lotsdatabinding.btnGeneratLots.setVisibility(View.GONE);
//        }
   }

    @Override
    public int getItemCount() {
        return Sampledata_lots.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        LOTSdatabinding lotsdatabinding;
        public Holder(@NonNull LOTSdatabinding lotsdatabinding) {
            super(lotsdatabinding.getRoot());
            this.lotsdatabinding=lotsdatabinding;
        }
        public void bind(Object obj, final Clickcustum clickcustum) {
           lotsdatabinding.setLOTS((SampleData_LOts) obj);
           lotsdatabinding.executePendingBindings();
        }
    }
}
