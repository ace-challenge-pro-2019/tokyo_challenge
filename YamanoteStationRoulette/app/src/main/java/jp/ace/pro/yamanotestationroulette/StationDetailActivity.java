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

/**
 * 駅詳細画面
 */
public class StationDetailActivity extends AppCompatActivity implements OnMapReadyCallback {

    public static final String TAG = StationDetailActivity.class.getSimpleName();

    private MapView mapView;
    private GoogleMap googleMap;
    // 緯度
    private double latitude;
    // 経度
    private double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station_detail);

        // 前の画面からの情報を受け取る
        Intent intent = getIntent();
        String stationName = intent.getStringExtra(IntentUtil.STATION_NAME);
        latitude = intent.getDoubleExtra(IntentUtil.LATITUDE, 0);
        longitude = intent.getDoubleExtra(IntentUtil.LONGITUDE, 0);

        TextView textView = findViewById(R.id.stationName);
        textView.setText(stationName);

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
        // 選んだ駅の座標を指定
        LatLng latLng = new LatLng(latitude, longitude);
        // ズームレベル
        // 1：ワールド
        // 5：陸地/大陸
        // 10：市
        // 15：通り
        // 20：建物
        float zoomLevel = 15;
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoomLevel));
    }
}
