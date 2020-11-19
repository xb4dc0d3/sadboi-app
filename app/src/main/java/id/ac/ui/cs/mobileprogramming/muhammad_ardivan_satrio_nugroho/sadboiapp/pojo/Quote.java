package id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.pojo;

import java.util.HashMap;
import java.util.Map;

public class Quote {

    private String pk;
    private String title;
    private String quote;
    private String quote_from;
    private String created_at;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Quote(String pk, String title, String quote, String quote_from, String created_at){
        this.pk = pk;
        this.title = title;
        this.quote = quote;
        this.quote_from = quote_from;
        this.created_at = created_at;
    }


    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getQuote_from() {
        return quote_from;
    }

    public void setQuote_from(String quote_from) {
        this.quote_from = quote_from;
    }
}
