package id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.pojo;

import java.util.HashMap;
import java.util.Map;

public class Story {

    private String pk;
    private String title;
    private String content;
    private String created_at;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Story(String pk, String title, String content, String created_at){
        this.pk = pk;
        this.title = title;
        this.content = content;
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

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
