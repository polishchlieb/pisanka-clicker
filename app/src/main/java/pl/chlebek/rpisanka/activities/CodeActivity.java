package pl.chlebek.rpisanka.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pl.chlebek.rpisanka.Data;
import pl.chlebek.rpisanka.R;
import pl.chlebek.rpisanka.Utils;

public class CodeActivity extends AppCompatActivity {

    private Data eggs = new Data("eggs");
    private int count = 0;

    private Data codes = new Data("codes");
    private ArrayList<String> used;

    private void init() {
        used = new ArrayList<>(Arrays.asList(Utils.split(codes.read())));

        try {
            count = Integer.parseInt(eggs.read());
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

                switch (input) {
                    case "piotreee":
                        if (!used.contains("piotreee")) {
                            eggs.write(String.valueOf(count += 2137));
                            used.add("piotreee");
                            codes.write(Utils.join(used));
                            Toast.makeText(CodeActivity.this, "Dodano 2137 coinsow", Toast.LENGTH_SHORT).show();
                            break;
                        }
                    default:
                        Toast.makeText(CodeActivity.this, "Kod zostal juz przez ciebie uzyty lub jest niepoprawny", Toast.LENGTH_SHORT).show();
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
