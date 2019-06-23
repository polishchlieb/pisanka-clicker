package pl.chlebek.rpisanka.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import pl.chlebek.rpisanka.Data;
import pl.chlebek.rpisanka.R;

public class MainActivity extends AppCompatActivity {

    private TextView counter;

    private Data _eggs = new Data("eggs");
    private int eggs = 0;

    private Data _multiplier = new Data("multiplier");
    private int multiplier = 1;

    private static MainActivity instance;
    public static MainActivity getInstance() {
        return instance;
    }

    private void init() {
        try {
            eggs = Integer.parseInt(_eggs.read());
        } catch(NumberFormatException e) {}

        counter.setText(String.valueOf(eggs));

        try {
            multiplier = Integer.parseInt(_multiplier.read());
        } catch(NumberFormatException e) {}
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counter = findViewById(R.id.counter);
        instance = this;

        init();

        findViewById(R.id.egg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _v) {
                counter.setText(_eggs.write(String.valueOf(eggs += multiplier)));
            }
        });

        findViewById(R.id.code).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _v) {
                startActivity(new Intent(MainActivity.this, CodeActivity.class));
            }
        });

        findViewById(R.id.inventory).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _v) {
                startActivity(new Intent(MainActivity.this, InventoryActivity.class));
            }
        });

        findViewById(R.id.shop).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View _v) {
                startActivity(new Intent(MainActivity.this, ShopActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        init();
    }

}
