package pl.chlebek.rpisanka.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import pl.chlebek.rpisanka.Data;
import pl.chlebek.rpisanka.R;
import pl.chlebek.rpisanka.Utils;

public class ShopActivity extends AppCompatActivity {

    private Data _eggs = new Data("eggs");
    private int eggs = 0;

    private Data _inventory = new Data("inventory");
    private ArrayList<String> inventory;

    private void init() {
        inventory = new ArrayList<>(Arrays.asList(_inventory.read().split(",")));

        try {
            eggs = Integer.parseInt(_eggs.read());
        } catch(NumberFormatException e) {}
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        findViewById(R.id.buy_chest1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _v) {
                // price: 100 eggs
                // infinite times
                if(eggs >= 100) {
                    _eggs.write(String.valueOf(eggs -= 100));
                    inventory.add("chest1");
                    _inventory.write(Utils.join(inventory));
                    Toast.makeText(ShopActivity.this, "kupiono", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        init();
    }
}
