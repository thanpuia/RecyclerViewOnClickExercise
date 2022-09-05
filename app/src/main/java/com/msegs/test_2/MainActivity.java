package com.msegs.test_2;

import androidx.appcompat.app.AppCompatActivity;
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

        Test test = new Test();
        test.setName("name1");
        test.setId(1);
        tests.add(test);
        Test test2 = new Test();
        test2.setName("name2");
        test2.setId(2);
        tests.add(test2);

        recyclerView = findViewById(R.id.recycler_view);

        adapter = new RecyclerViewAdapter(tests,getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

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