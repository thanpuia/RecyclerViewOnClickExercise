package com.msegs.test_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.msegs.test_2.adapter.RecyclerItemClickListener;
import com.msegs.test_2.adapter.RecyclerViewAdapter;
import com.msegs.test_2.entity.Test;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;
    ArrayList<Test> tests;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tests = new ArrayList<>();

        int sample = 8;
        for(int i=0;i<sample;i++){
            Test test = new Test();
            int j=i+1;
            test.setName("name"+j);
            test.setId(j);
            tests.add(test);
        }

        recyclerView = findViewById(R.id.recycler_view);

        adapter = new RecyclerViewAdapter(tests,getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.d("TAG",""+tests.get(position).getName());
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
    }
}