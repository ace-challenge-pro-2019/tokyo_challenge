package jp.ace.pro.yamanotestationroulette;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import jp.ace.pro.yamanotestationroulette.api.API;
import jp.ace.pro.yamanotestationroulette.api.StationRequestClient;

/**
 * 駅詳細画面
 */
public class StationDetailActivity extends AppCompatActivity {

    public static final String TAG = StationDetailActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station_detail);

        Intent intent = getIntent();
        String stationName = intent.getStringExtra(IntentUtil.STATION_NAME);

        TextView textView = findViewById(R.id.stationName);
        textView.setText(stationName);

        // 選択した駅の情報を取得
        new StationRequestClient().getStationInfo(stationName, new API.ResultListener() {
            @Override
            public void onSuccess() {
                Log.d(TAG, "getStationInfo onSuccess");

            }

            @Override
            public void onFailure() {
                Log.d(TAG, "getStationInfo onFailure");
            }
        });
    }
}
