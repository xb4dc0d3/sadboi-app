package id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.api;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.pojo.Quote;
import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.pojo.Story;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("all-stories")
    Call<List<Story>> getStories();

    @GET("all-quotes")
    Call<List<Quote>> getQuotes();
}
