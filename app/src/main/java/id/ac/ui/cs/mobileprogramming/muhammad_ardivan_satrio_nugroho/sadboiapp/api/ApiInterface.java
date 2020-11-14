package id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.api;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.pojo.Story;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("story_array.json")
    Call<List<Story>> getMovies();
}
