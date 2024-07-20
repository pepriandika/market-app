package com.pendka.marketapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener{
    // RecyclerView
    RecyclerView recyclerView;

    // Data Source
    List<Item> itemList;

    // customAdapter
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recyclerView);

        itemList = new ArrayList<>();
        Item item1 = new Item(R.drawable.fruit, "Fruits","Fresh Fruits from the Garden");
        Item item2 = new Item(R.drawable.vegitables, "Vegetables","Delicious Vegetables ");
        Item item3 = new Item(R.drawable.bread,"Bakery","Bread, Wheat and Beans");
        Item item4 = new Item(R.drawable.beverage, "Beverage","Juice, Tea, Coffee and Soda");
        Item item5 = new Item(R.drawable.milk, "Milk", "Milk, Shakes and Yogurt");
        Item item6 = new Item(R.drawable.popcorn,"Snacks","Pop Corn, Donut and Drinks");

        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);
        itemList.add(item6);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        myAdapter = new MyAdapter(itemList);
        myAdapter.setClickListener(this);

        recyclerView.setAdapter(myAdapter);


    }

    @Override
    public void onClick(View v, int position) {
        Toast.makeText(this,
                "You Choose:  " + itemList.get(position).getTitle(),
                Toast.LENGTH_SHORT).show();
    }
}