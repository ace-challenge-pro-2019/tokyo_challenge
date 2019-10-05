package jp.ace.pro.yamanotestationroulette.api;

import android.util.Log;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import jp.ace.pro.yamanotestationroulette.api.dto.StationDTO;

/**
 * 駅情報取得API
 */
public class StationRequestClient extends RequestClient {

    /**
     * 駅情報取得
     * @param stationName 駅名
     * @param resultListener 通信成否コールバック
     */
    public void getStationInfo(String stationName, final API.getStationInfoResultListener resultListener) {
        retrofit.create(API.class)
                .getStation(ACCSESS_KEY, stationName, RAILWAY_ID_YAMANOTE)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<StationDTO>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d("getStationInfo", "onSubscribe ");

                    }

                    @Override
                    public void onSuccess(List<StationDTO> stationDTOS) {
                        Log.d("getStationInfo", "onSuccess ");
                        // リスト型で受け取るが、路線＋駅名で検索しているので一意になる想定
                        if (stationDTOS.size() == 1) {
                            Log.d("selected station is ", stationDTOS.get(0).getDcTitle());
                            resultListener.onSuccess(stationDTOS.get(0));
                        } else {
                            // レスポンスに複数の駅情報がある場合はエラー扱いとする
                            Log.d("getStationInfo", "onSuccess : ResponseError");
                            resultListener.onFailure();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("getStationInfo", "onError " + e.toString());
                        resultListener.onFailure();
                    }
                });
    }
}
