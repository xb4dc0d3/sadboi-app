package id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.model;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "storypost_table")
public class StoryPost {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    private int id;

    @ColumnInfo(name="title")
    private String title;

    @ColumnInfo(name="content")
    private String content;


    // Constructor without id
    public StoryPost(String title, String content){
        this.title = title;
        this.content = content;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getId(){

        return this.id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent(){
        return this.content;
    }
}
