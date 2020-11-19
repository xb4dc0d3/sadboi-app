package id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "quotepost_table")
public class SavedQuote {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    private int id;

    @ColumnInfo(name="title")
    private String title;

    @ColumnInfo(name="quote")
    private String quote;

    @ColumnInfo(name="quote_from")
    private String quote_from;

    public SavedQuote(){

    }

    public SavedQuote(String title, String quote, String quote_from){
        this.title = title;
        this.quote = quote;
        this.quote_from = quote_from;
    }

    public String getQuote_from() {
        return quote_from;
    }

    public void setQuote_from(String quote_from) {
        this.quote_from = quote_from;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
