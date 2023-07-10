package com.example.finalpractise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemAdapter.ItemClickListener{
    TextView titleTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rvr;
        ItemAdapter adapter;

        rvr = findViewById(R.id.recyclerview);
        titleTextView = findViewById(R.id.titleTextView);
        rvr.addItemDecoration(new SpaceItemDecoration(50));
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.list_item_animation);
        LayoutAnimationController controller = new LayoutAnimationController(animation);
        controller.setDelay(0.8f);
        rvr.setLayoutAnimation(controller);
        rvr.setLayoutManager(new LinearLayoutManager(this));
        List<Item> items = new ArrayList<>();
        // Add your items to the list here
        items.add(new Item(R.drawable.into_python, "Introduction to Python", R.raw.intro));
        items.add(new Item(R.drawable.into_python, "Variables", R.raw.variables));


        adapter = new ItemAdapter(items);
        rvr.setAdapter(adapter);

    }

    @Override
    public void onItemClick(int position) {
        String currentText = titleTextView.getText().toString();
        int currentValue = Integer.parseInt(currentText);
        int updatedValue = currentValue + 10;
        titleTextView.setText(String.valueOf(updatedValue));
    }
}