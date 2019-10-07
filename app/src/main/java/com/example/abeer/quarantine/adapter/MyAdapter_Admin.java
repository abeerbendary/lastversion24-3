package com.example.abeer.quarantine.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abeer.quarantine.R;
import com.example.abeer.quarantine.model.User_class;

import java.util.List;
public class MyAdapter_Admin extends RecyclerView.Adapter<MyAdapter_Admin.Holder>{
        customListener customListener;
        public interface customListener {
            public void on_name_ClickListner(int id);
        }
        public void setCustomListner(customListener listener) {
            this.customListener = listener;
        }
        List<User_class>data_user;
        Activity Activity;
    public MyAdapter_Admin(List<User_class> name, Activity activity) {
            this.data_user = name;
            this.Activity= activity;
        }
        @Override
        public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view =Activity.getLayoutInflater().inflate(R.layout.cust_item,parent,false);
            Holder holder=new Holder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(Holder holder, final int position) {
            holder.Item_List.setText(data_user.get(position).getName());
            holder.Item_List.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int id = data_user.get(position).getUser_Id();
                    try {
                        if(customListener!=null) {
                            customListener.on_name_ClickListner(id);
                        }
                    }catch (Exception ex){
                        Toast.makeText(Activity, ex.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }

        @Override
        public int getItemCount() {
            return data_user.size();
        }


        public class Holder extends RecyclerView.ViewHolder {
            TextView Item_List;
            public Holder(View itemView) {
                super(itemView);
                Item_List=itemView.findViewById(R.id.text_item);
            }
        }
 }
