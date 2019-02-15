package adapterAll;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.exoplayerhlsdemo.R;

import java.util.List;

import dataClassAll.VideoDetail;
import intefacesAll.RecycleCallBack;

public class CustomAdaptor extends RecyclerView.Adapter<CustomAdaptor.MyViewHolder> {
    List<VideoDetail> list;
    Context context;
    private int layout;
    private RecycleCallBack recycleCallBack;
    private RequestOptions requestOptions;

    public CustomAdaptor(Context context, List<VideoDetail> videos, int layout, RecycleCallBack recycleCallBack) {
        this.context = context;
        this.list = videos;
        this.layout = layout;
        this.recycleCallBack = recycleCallBack;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(layout, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, final int index) {
        Glide.with(context).load(list.get(index).getVideo_rendition_thumbnail()).into(viewHolder.videothumbnail);
        viewHolder.videoName.setText(list.get(index).getVideo_name());

        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recycleCallBack.callBack(list.get(index).getvideo_m3u8(),list.get(index).getVideo_rendition_path());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView videothumbnail;
        TextView videoName, videoDuration;
        LinearLayout linearLayout;


        public MyViewHolder(@NonNull View view) {
            super(view);

            videothumbnail = view.findViewById(R.id.videothumbnail);
            videoName = view.findViewById(R.id.videoName);
            videoDuration = view.findViewById(R.id.videoDuration);
            linearLayout = view.findViewById(R.id.linearLayout);
        }


    }
}
