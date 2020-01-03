package com.example.bottomsheet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemAdapter.ItemListener{

    BottomSheetBehavior behavior;
    RecyclerView mRecyclerView;
    private ItemAdapter itemAdapter;
    CoordinatorLayout coordinatorLayout;
    Toolbar toolbar;
    View bottomSheet;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeView();


        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<String> items = new ArrayList<>();
        items.add("Item 1");
        items.add("Item 2");
        items.add("Item 3");
        items.add("Item 4");
        items.add("Item 5");
        items.add("Item 6");
        itemAdapter = new ItemAdapter(items,this);

        mRecyclerView.setAdapter(itemAdapter);
        onClickListener();
    }






    private void onClickListener() {


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });

        behavior = BottomSheetBehavior.from(bottomSheet);
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int i) {

            }

            @Override
            public void onSlide(@NonNull View view, float v) {

            }
        });

    }

    private void initializeView() {

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        coordinatorLayout = findViewById(R.id.bottomSheetLayout);
        bottomSheet = findViewById(R.id.linearBottomSheet);

        mRecyclerView = findViewById(R.id.recyclerView);


        button = findViewById(R.id.mainButton);
    }

    @Override
    public void onItemClick(String item) {
        Snackbar.make(coordinatorLayout, item + " is selected", Snackbar.LENGTH_LONG).setAction("Action", null).show();
        behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }
}
