package jp.ace.pro.yamanotestationroulette;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;

public class IntentUtil {

    // 駅名
    public static final String STATION_NAME = "STATION_NAME";
    // 緯度
    public static final String LATITUDE = "LATITUDE";
    // 経度
    public static final String LONGITUDE = "LONGITUDE";

    /**
     * 駅詳細画面へ遷移するインテント
     *
     * @param context     コンテキスト
     * @param stationName 駅名
     * @param latitude    緯度
     * @param longitude   経度
     * @return インテント
     */
    public static Intent StationDetailActivityIntent(@NonNull Context context, String stationName, double latitude, double longitude) {
        Intent intent = new Intent(context, StationDetailActivity.class);
        intent.putExtra(STATION_NAME, stationName);
        intent.putExtra(LATITUDE, latitude);
        intent.putExtra(LONGITUDE, longitude);
        return intent;
    }
}
