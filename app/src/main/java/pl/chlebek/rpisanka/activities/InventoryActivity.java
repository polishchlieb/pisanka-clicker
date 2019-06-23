package pl.chlebek.rpisanka.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import pl.chlebek.rpisanka.Data;
import pl.chlebek.rpisanka.R;
import pl.chlebek.rpisanka.Utils;

public class InventoryActivity extends AppCompatActivity {

    private Data _eggs = new Data("eggs");
    private int eggs = 0;

    private Data _inventory = new Data("inventory");
    private ArrayList<String> inventory;

    private void init() {
        inventory = new ArrayList<>(Arrays.asList(Utils.split(_inventory.read())));

        try {
            eggs = Integer.parseInt(_eggs.read());
        } catch(NumberFormatException e) {}
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        init();

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.activity_inventory, null);

        // Find the ScrollView
        ScrollView sv = (ScrollView) v.findViewById(R.id.scrollView1);

        // Create a LinearLayout element
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);

        // Add contents
        for(String item : inventory) {
            ImageView iv = new ImageView(this);
            if(item.equals("chest1"))
                iv.setImageResource(R.drawable.chest1);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(320, 230);
                iv.setLayoutParams(params);

//            ViewGroup.LayoutParams layoutParams = iv.getLayoutParams();
//            layoutParams.width = 100;
//            layoutParams.height = 100;

//            iv.setLayoutParams(layoutParams);

            ll.addView(iv);

//            TextView tv = new TextView(this);
//            tv.setText(item);
//            ll.addView(tv);
        }

        // Add the LinearLayout element to the ScrollView
        sv.addView(ll);

        // Display the view
        setContentView(v);
    }

}
