package id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.model;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class StoryPosts {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name="id")
    private int id;

    @ColumnInfo(name="title")
    private String title;

    @ColumnInfo(name="content")
    private String content;

    public StoryPosts(int id, String title, String content){
        
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public String getTitle(){
        return this.title;
    }

    public String getContent(){

        return this.content;
    }
}
