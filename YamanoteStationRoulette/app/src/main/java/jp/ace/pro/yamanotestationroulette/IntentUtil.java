package jp.ace.pro.yamanotestationroulette;

import android.content.Context;
import android.content.Intent;

public class IntentUtil {

    public static final String STATION_NAME = "STATION_NAME";

    public static Intent StationDetailActivityIntent(Context context) {
        return new Intent(context, StationDetailActivity.class);
    }
}
