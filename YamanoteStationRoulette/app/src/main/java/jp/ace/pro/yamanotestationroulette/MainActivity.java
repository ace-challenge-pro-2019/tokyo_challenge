package jp.ace.pro.yamanotestationroulette;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String displayStationName;
    String stationCode;

    // 駅名表示欄
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 駅名表示
        textView = findViewById(R.id.selectedStationTextView);
        randomStation();

        // 詳細ボタン
        Button detailButton = findViewById(R.id.detailButton);
        detailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToStationDetailActivity();
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
     * ランダムで駅名を返す
     * @return 駅名
     */
    private void randomStation() {
        StationConstants sc = new StationConstants();
        int index = (int)(Math.random() * sc.STATION_NUM);
        this.stationCode = sc.STATIONS[index][0];
        this.displayStationName = sc.STATIONS[index][1];

        textView.setText(this.displayStationName);
//        return this.displayStationName;
    }

    /**
     * 駅詳細画面へ遷移する
     */
    private void goToStationDetailActivity() {
        Intent intent = IntentUtil.StationDetailActivityIntent(MainActivity.this);
        intent.putExtra(IntentUtil.STATION_NAME, textView.getText());
        startActivity(intent);
    }
}
