package jp.ace.pro.yamanotestationroulette;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

import jp.ace.pro.yamanotestationroulette.api.API;
import jp.ace.pro.yamanotestationroulette.api.StationRequestClient;

/**
 * 駅詳細画面
 */
public class StationDetailActivity extends AppCompatActivity implements OnMapReadyCallback {

    public static final String TAG = StationDetailActivity.class.getSimpleName();

    private MapView mapView;
    private GoogleMap googleMap;

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

        mapView = findViewById(R.id.map_view);
        mapView.getMapAsync(this);
        mapView.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Log.d("test", "call onMapReady");
        this.googleMap = googleMap;
        LatLng japan = new LatLng(35.39, 139.44);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(japan));
    }
}
