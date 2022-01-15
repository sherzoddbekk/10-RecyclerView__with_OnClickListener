package com.example.a10_recyclerviewwithonclicklistener;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.example.a10_recyclerviewwithonclicklistener.adapter.CustomAdapter;
import com.example.a10_recyclerviewwithonclicklistener.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        List<Member> members = prepareMemberList();
        refreshAdapter(members);

    }
    private void initView(){
        context = this;
        recyclerView = findViewById(R.id.recycleViewMain);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));
    }
    private void refreshAdapter(List<Member> members) {
        CustomAdapter adapter = new CustomAdapter(members, this);
        recyclerView.setAdapter(adapter);
    }
    public  void openItemDetails(Member member){
        Log.d("@@@@@", "item list clicked : " + member.getFirstName());
    }
    private List<Member> prepareMemberList(){
        List<Member> members = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            members.add(new Member("Sherzod " + i,"Jurabekov " + i));
        }
        return members;
    }
}