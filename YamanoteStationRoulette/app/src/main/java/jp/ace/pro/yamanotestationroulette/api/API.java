package jp.ace.pro.yamanotestationroulette.api;

import java.util.List;

import io.reactivex.Single;
import jp.ace.pro.yamanotestationroulette.api.dto.StationDTO;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * API一覧
 */
public interface API {

    // 通信結果　汎用インターフェース
    interface ResultListener {
        void onSuccess();

        void onFailure();
    }

    // 駅情報取得結果
    interface getStationInfoResultListener {
        void onSuccess(StationDTO stationDTO);
        void onFailure();
    }

    /**
     * 駅情報を取得する
     *
     * @param AccessKey   開発者サイトにて提供されるアクセストークン
     * @param stationName 駅名（e.g. 東京、新宿、上野）
     * @param railwayId   駅が存在する路線ID (odpt:Railwayのowl:sameAs)
     * @return 駅情報
     */
    @GET("/api/v4/odpt:Station")
    Single<List<StationDTO>> getStation(
            @Query("acl:consumerKey") String AccessKey,
            @Query("dc:title") String stationName,
            @Query("odpt:railway") String railwayId);
}
