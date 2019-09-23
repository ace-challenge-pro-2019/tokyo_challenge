package jp.ace.pro.yamanotestationroulette;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class StationDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station_detail);

        Intent intent = getIntent();
        String stationName = intent.getStringExtra(IntentUtil.STATION_NAME);

        TextView textView = findViewById(R.id.stationName);
        textView.setText(stationName);
    }
}
