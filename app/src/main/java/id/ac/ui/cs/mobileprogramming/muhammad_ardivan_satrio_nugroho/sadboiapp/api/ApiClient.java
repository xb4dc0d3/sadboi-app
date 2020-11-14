package id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static String BASE_URL ="http://165.22.108.118:9000/all-stories/";
    private static Retrofit retrofit;
    public static Retrofit getClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
