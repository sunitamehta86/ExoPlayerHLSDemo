package dataClassAll;

import com.google.gson.annotations.SerializedName;

public class VideoList {
    @SerializedName("data")
    private DataClassFirst dataFirst;

    public DataClassFirst getDataFirst() {
        return dataFirst;
    }

}
