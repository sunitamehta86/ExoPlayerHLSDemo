package dataClassAll;

import com.google.gson.annotations.SerializedName;

public class DataClassFirst {
    @SerializedName("data")

    private DataClassAnother dataSecond;

    public DataClassAnother getDataSecond() {
        return dataSecond;
    }


}
