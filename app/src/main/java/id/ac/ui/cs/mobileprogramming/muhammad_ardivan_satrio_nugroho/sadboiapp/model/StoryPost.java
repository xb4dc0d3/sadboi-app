package id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.model;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class StoryPost {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    private int id;

    @ColumnInfo(name="title")
    private String title;

    @ColumnInfo(name="content")
    private String content;

    public StoryPost(int id, String title, String content){

        this.id = id;
        this.title = title;
        this.content = content;
    }

    public int getId(){

        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public String getContent(){
        return this.content;
    }
}
