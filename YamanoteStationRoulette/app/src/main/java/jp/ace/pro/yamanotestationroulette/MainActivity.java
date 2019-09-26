package jp.ace.pro.yamanotestationroulette;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String[] yamanoteStations = {"品川", "大崎", "五反田", "目黒", "恵比寿",
            "渋谷", "原宿", "代々木", "新宿", "新大久保",
    "高田馬場", "目白", "池袋", "大塚", "巣鴨",
    "駒込", "田端", "西日暮里", "日暮里", "鶯谷",
    "上野", "御徒町", "秋葉原", "神田", "東京",
    "有楽町", "新橋", "浜松町", "田町", "高輪ゲートウェイ"};

    // 駅名表示欄
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 駅名表示
        textView = findViewById(R.id.text);
        textView.setText(randomStation());

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
                textView.setText(randomStation());
            }
        });
    }

    /**
     * ランダムで駅名を返す
     * @return 駅名
     */
    private String randomStation() {
        return yamanoteStations[(int)(Math.random() * yamanoteStations.length)];
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
