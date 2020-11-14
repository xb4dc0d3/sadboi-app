package id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.pojo;

import com.google.gson.annotations.SerializedName;

public class Story {

    @SerializedName("title")
    private String title;

    @SerializedName("content")
    private String content;

    @SerializedName("created_at")
    private String created_at;


    public Story(String title, String content, String created_at){

        this.title = title;
        this.content = content;
        this.created_at = created_at;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
