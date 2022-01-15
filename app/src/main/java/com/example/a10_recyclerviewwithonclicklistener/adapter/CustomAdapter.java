package com.example.a10_recyclerviewwithonclicklistener.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a10_recyclerviewwithonclicklistener.MainActivity;
import com.example.a10_recyclerviewwithonclicklistener.R;
import com.example.a10_recyclerviewwithonclicklistener.model.Member;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

private  List<Member> members;
private MainActivity activity;

    public CustomAdapter(List<Member> members, MainActivity activity) {
        this.members = members;
        this.activity = activity;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout_view,parent,false);
        return new CustomHolderView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Member member = members.get(position);
        if (holder instanceof CustomHolderView){
            LinearLayout lay_click = ((CustomHolderView) holder).click; // click qilishimiz uchun kerak.

            TextView firstName = ((CustomHolderView) holder).first_name;
            TextView lastName = ((CustomHolderView) holder).last_name;

            firstName.setText(member.getFirstName());
            lastName.setText(member.getLastName());

            lay_click.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    activity.openItemDetails(member);
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return members.size();
    }
    private class CustomHolderView extends RecyclerView.ViewHolder{

        View view;
        TextView first_name, last_name;
        LinearLayout click;
        public CustomHolderView(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            first_name = itemView.findViewById(R.id.firstName);
            last_name = itemView.findViewById(R.id.lastName);
            click = itemView.findViewById(R.id.click);// bosganimizda kirish uchun
        }
    }
}
