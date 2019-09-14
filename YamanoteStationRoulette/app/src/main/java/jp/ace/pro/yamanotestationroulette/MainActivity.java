package jp.ace.pro.yamanotestationroulette;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> yamanote = new ArrayList<>();
        yamanote.add("渋谷");
        yamanote.add("新宿");
        yamanote.add("池袋");
        yamanote.add("品川");
        yamanote.add("日暮里");

        String station = yamanote.get(0);

        TextView textView = (TextView) findViewById(R.id.text);

        textView.setText(station);

    }


}
