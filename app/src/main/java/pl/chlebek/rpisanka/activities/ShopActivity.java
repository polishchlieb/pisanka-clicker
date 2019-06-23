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

    private Data _multiplier = new Data("multiplier");
    private int multiplier = 1;

    private void init() {
        inventory = new ArrayList<>(Arrays.asList(Utils.split(_inventory.read())));

        try {
            eggs = Integer.parseInt(_eggs.read());
        } catch(NumberFormatException e) {}

        try {
            multiplier = Integer.parseInt(_multiplier.read());
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

        findViewById(R.id.buy_multiplier).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _v) {
                if(eggs >= 1000) {
                    _eggs.write(String.valueOf(eggs -= 1000));
                    _multiplier.write(String.valueOf(multiplier += 1));
                    Toast.makeText(ShopActivity.this, "kupiono", Toast.LENGTH_SHORT).show();
                }
            }
        });

        findViewById(R.id.image_chest1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ShopActivity.this, "100 pisan", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.image_multiplier).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ShopActivity.this, "1000 pisan", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        init();
    }
}
