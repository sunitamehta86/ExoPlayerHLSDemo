package intefacesAll;

import dataClassAll.VideoList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {
    //    @FormUrlEncoded
//    @POST("/CueStageTesting/playlist?")
//    Call<VideoList> doCreateUserWithoutField(@Body ApiField apiField);

    @FormUrlEncoded
    @POST("/CueStageTesting/playlist?")
    Call<VideoList> doCreateUserWithField(@Field("accessToken") String token, @Field("lang") String language);

    @FormUrlEncoded
    @POST("/CueStageTesting/playlist?")
    Call doCreate(@Field("accessToken") String token, @Field("lang") String language);

}
