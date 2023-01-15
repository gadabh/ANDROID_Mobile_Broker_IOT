package com.example.myapplicationfinaaaaaaaaaaaaaaaaaaaaaaaaaaaaal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView=(RecyclerView) findViewById(R.id.reyclerview_personne);
        new  FirebaseDatabaseHelper().readPersonnes(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Personne> personnes, List<String> keys) {
                new RecyclerView_Config().setConfig(mRecyclerView , MainActivity.this, personnes ,keys);
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });
    }
}