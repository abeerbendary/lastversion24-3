package com.example.abeer.quarantine.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.abeer.quarantine.R;
import com.example.abeer.quarantine.viewmodel.sampleWithDraw.Barcod_Card;
import com.example.abeer.quarantine.databinding.Itemsbacodbinding;
import java.util.List;

public class AdapterBarcod extends RecyclerView.Adapter<AdapterBarcod.Holder> {
    List<Barcod_Card> Barcod_Cards;
    Context context;

    public AdapterBarcod(List<Barcod_Card> barcod_Cards, Context context) {
        Barcod_Cards = barcod_Cards;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterBarcod.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Itemsbacodbinding Itemsbacodbinding = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()),
                R.layout.card_barcode, viewGroup, false);
     return new AdapterBarcod.Holder(Itemsbacodbinding);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterBarcod.Holder holder, int i) {
        Barcod_Card Barcod_Card=Barcod_Cards.get(i);
        holder.bind(Barcod_Card);
        if(Barcod_Cards.size()==1){
            holder.Itemsbacodbinding.linearLayout3.setVisibility(View.GONE);
        }else {
            holder.Itemsbacodbinding.linearLayout3.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return Barcod_Cards.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        Itemsbacodbinding  Itemsbacodbinding;
        public Holder(Itemsbacodbinding itemsbacodbinding) {
            super(itemsbacodbinding.getRoot());
            this.Itemsbacodbinding=itemsbacodbinding;
        }
        public void bind(Object obj) {

            Itemsbacodbinding.setCardBarcod((Barcod_Card) obj);
            Itemsbacodbinding.executePendingBindings();
        }
    }
}
