package jp.ace.pro.yamanotestationroulette;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // タイトルを非表示にします。
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // splash.xmlをViewに指定します。
        setContentView(R.layout.activity_splash_screen);
        Handler hdl = new Handler();
        // 500ms遅延させてsplashHandlerを実行します。
        hdl.postDelayed(new splashHandler(), 1000);
    }
    class splashHandler implements Runnable {
        public void run() {
            // スプラッシュ完了後に実行するActivityを指定します。
            Intent intent = new Intent(getApplication(), MainActivity.class);
            startActivity(intent);
            // SplashActivityを終了させます。
            SplashScreenActivity.this.finish();
        }
    }
}
