package dataClassAll;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataClassAnother {
    public List<VideoDetail> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<VideoDetail> newslist) {
        this.newslist = newslist;
    }

    @SerializedName("newslist")

    private List<VideoDetail> newslist;
}
