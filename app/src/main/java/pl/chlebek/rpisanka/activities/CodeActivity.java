package pl.chlebek.rpisanka.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import pl.chlebek.rpisanka.Data;
import pl.chlebek.rpisanka.R;
import pl.chlebek.rpisanka.Utils;

public class CodeActivity extends AppCompatActivity {

    private Data _eggs = new Data("eggs");
    private int eggs = 0;

    private Data _codes = new Data("codes");
    private ArrayList<String> codes;

    private void init() {
        codes = new ArrayList<>(Arrays.asList(Utils.split(_codes.read())));

        try {
            eggs = Integer.parseInt(_eggs.read());
        } catch (NumberFormatException e) {}
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);
        init();

        findViewById(R.id.okbutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _v) {
                String input = ((EditText) findViewById(R.id.code)).getText().toString();

                if(input.equals("piotreee")) {
                    if (codes.contains("piotreee"))
                        Toast.makeText(CodeActivity.this, "juz to uzyles nubie", Toast.LENGTH_SHORT).show();
                    else {
                        _eggs.write(String.valueOf(eggs += 2137));

                        codes.add("piotreee");
                        _codes.write(Utils.join(codes));

                        Toast.makeText(CodeActivity.this, "Dodano 2137 coinsow", Toast.LENGTH_SHORT).show();
                    }

                }
                else if(input.equals("oko nub")) {
                    if (codes.contains("oko nub"))
                        Toast.makeText(CodeActivity.this, "juz to uzyles nubie", Toast.LENGTH_SHORT).show();
                    else {
                        _eggs.write(String.valueOf(eggs += 1945));

                        codes.add("oko nub");
                        _codes.write(Utils.join(codes));

                        Toast.makeText(CodeActivity.this, "Dodano 1945 coinsow", Toast.LENGTH_SHORT).show();
                    }
                }
                else if(input.equals("innocent"))
                    _eggs.write(String.valueOf(eggs += 1000000));
                else if(!input.isEmpty())
                    Toast.makeText(CodeActivity.this, "co to za zaklecia?!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        init();
    }

}
