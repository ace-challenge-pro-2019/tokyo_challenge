package jp.ace.pro.yamanotestationroulette;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import jp.ace.pro.yamanotestationroulette.api.API;
import jp.ace.pro.yamanotestationroulette.api.StationRequestClient;
import jp.ace.pro.yamanotestationroulette.api.dto.StationDTO;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    String displayStationName;
    String stationCode;

    // 駅名表示欄
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 駅名表示
        textView = findViewById(R.id.text);
        randomStation();

        // 詳細ボタン
        Button detailButton = findViewById(R.id.detailButton);
        detailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showStationDetail(displayStationName);
            }
        });

        // 駅名更新ボタン
        Button button = findViewById(R.id.updateButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.randomStation();
            }
        });
    }

    /**
     * ランダムに駅名を変更する
     */
    private void randomStation() {
        int index = (int) (Math.random() * StationConstants.STATION_NUM);
        this.stationCode = StationConstants.STATIONS[index][0];
        this.displayStationName = StationConstants.STATIONS[index][1];

        textView.setText(this.displayStationName);
    }

    /**
     * 駅詳細画面を表示するための処理
     */
    private void showStationDetail(String stationName) {
        // 選択した駅の情報を取得
        new StationRequestClient().getStationInfo(stationName, new API.getStationInfoResultListener() {
            @Override
            public void onSuccess(StationDTO dto) {
                String stationName = dto.getDcTitle();
                double latitude = dto.getGeoLat();
                double longitude = dto.getGeoLong();
                Intent intent = IntentUtil.StationDetailActivityIntent(MainActivity.this,
                        stationName,
                        latitude,
                        longitude);
                startActivity(intent);
            }

            @Override
            public void onFailure() {
                Log.d(TAG, "駅情報取得に失敗");
                // 通信失敗時は何もしない
            }
        });
    }
}
