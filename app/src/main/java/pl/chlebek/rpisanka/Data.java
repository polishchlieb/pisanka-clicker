package pl.chlebek.rpisanka;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import pl.chlebek.rpisanka.activities.MainActivity;

public class Data {

    public String contents;
    private String name;

    public Data(String name) {
        this.name = name;
    }

    public String read() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(MainActivity.getInstance().openFileInput(name)));
            contents = bufferedReader.readLine();
        } catch(Exception e) {
            contents = "";
        }

        return contents;
    }

    public String write(String data) {
        contents = data;

        try {
            FileOutputStream outputStream = MainActivity.getInstance().openFileOutput(name, MainActivity.getInstance().MODE_PRIVATE);
            outputStream.write(data.getBytes());
            outputStream.close();
        } catch(Exception e) {}

        return data;
    }

}
