package jp.ace.pro.yamanotestationroulette.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * リクエスト用の共通クラス
 * <p>
 * スーパークラスとして使う
 * 東京公共交通オープンデータチャレンジ用
 */
public class RequestClient {

    // 交通チャレンジのAPIキー
    static final String ACCSESS_KEY = "28bcacf86a29fc324cc9cb0d3ea8e69bf92d1cf581649d147980e53aa920f6cd";

    // 東京公共交通オープンデータチャレンジのベースURL
    private static final String BASE_URL = "https://api-tokyochallenge.odpt.org";

    // 山手線の路線ID (odpt:Railwayのowl:sameAs)
    static final String RAILWAY_ID = "odpt.Railway:JR-East.Yamanote";

    Retrofit retrofit;

    public RequestClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

}
