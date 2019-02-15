package dataClassAll;

import com.google.gson.annotations.SerializedName;

import java.time.Duration;
import java.util.List;

public class VideoDetail {
    @SerializedName("video_rendition_path")
    private String video_rendition_path;

    @SerializedName("video_m3u8")
    private String video_m3u8;

    @SerializedName("video_name")
    private String video_name;

    @SerializedName("video_rendition_thumbnail")
    private String video_rendition_thumbnail;

    public String getVideo_rendition_thumbnail() {
        return video_rendition_thumbnail;
    }

    public void setVideo_rendition_thumbnail(String video_rendition_thumbnail) {
        this.video_rendition_thumbnail = video_rendition_thumbnail;
    }

     public String getvideo_m3u8() {
        return video_m3u8;
    }

    public void setvideo_m3u8(String video_m3u8) {
        this.video_rendition_thumbnail = video_m3u8;
    }

    public String getVideo_rendition_path() {
        return video_rendition_path;
    }

    public void setVideo_rendition_path(String video_rendition_path) {
        this.video_rendition_path = video_rendition_path;
    }

    public String getVideo_name() {
        return video_name;
    }

    public void setVideo_name(String video_name) {
        this.video_name = video_name;
    }

//    public List<Duration> getM3u8RendtionList() {
//        return m3u8RendtionList;
//    }

//    public void setM3u8RendtionList(List<Duration> m3u8RendtionList) {
//        this.m3u8RendtionList = m3u8RendtionList;
//    }

//    @SerializedName("m3u8RendtionList")
//    private List<Duration> m3u8RendtionList;

}
