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

    private Data eggs = new Data("eggs");
    private int count = 0;

    private static MainActivity instance;
    public static MainActivity getInstance() {
        return instance;
    }

    private void init() {
        try {
            count = Integer.parseInt(eggs.read());
        } catch(NumberFormatException e) {}

        counter.setText(String.valueOf(count));
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
                counter.setText(eggs.write(String.valueOf(count += 1)));
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
