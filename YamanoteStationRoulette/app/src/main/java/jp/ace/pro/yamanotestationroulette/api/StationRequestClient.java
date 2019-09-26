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
    public void getStationInfo(String stationName, final API.ResultListener resultListener) {
        retrofit.create(API.class)
                .getStation(ACCSESS_KEY, stationName, RAILWAY_ID)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<StationDTO>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d("getStationInfo", "onSubscribe ");

                    }

                    @Override
                    public void onSuccess(List<StationDTO> stationDTOS) {
                        // TODO ここで取得した駅情報を何かしらに使用する
                        Log.d("getStationInfo", "onSuccess ");
                        for (StationDTO stationDTO : stationDTOS) {
                            Log.d("selected station is ", stationDTO.getDcTitle());
                        }
                        resultListener.onSuccess();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("getStationInfo", "onError " + e.toString());
                        resultListener.onFailure();
                    }
                });
    }
}
