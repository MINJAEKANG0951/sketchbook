package minjaelab.sketchbook.apis;

import minjaelab.sketchbook.apis.models.ShortURLResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface ApiService
{
    @GET("util/v1/shorturl")
    Call<ShortURLResponse> getShortUrl(
            @Header("X-NCP-APIGW-API-KEY-ID") String apiKeyId,
            @Header("X-NCP-APIGW-API-KEY") String apiKey,
            @Query("url") String url
    );
}


/*

    sample request

### test
GET https://naveropenapi.apigw.ntruss.com/util/v1/shorturl?url=www.google.co.kr
X-NCP-APIGW-API-KEY-ID: 1er3i2rvr9
X-NCP-APIGW-API-KEY: N5NgjlEPK0LNyBZYlsSaKY3FyVijhuN4fGiO5N1E


    sample response

{
  "result": {
    "url": "https://me2.do/5GhQVI0T",
    "hash": "5GhQVI0T",
    "orgUrl": "http://www.google.co.kr"
  },
  "message": "ok",
  "code": "200"
}

 */