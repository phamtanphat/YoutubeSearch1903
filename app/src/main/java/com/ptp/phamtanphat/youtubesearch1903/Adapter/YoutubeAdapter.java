package com.ptp.phamtanphat.youtubesearch1903.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ptp.phamtanphat.youtubesearch1903.Model.Item;
import com.ptp.phamtanphat.youtubesearch1903.Model.ModelData;
import com.ptp.phamtanphat.youtubesearch1903.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class YoutubeAdapter extends ArrayAdapter<Item> {
    public YoutubeAdapter(@NonNull Context context, int resource, @NonNull List<Item> objects) {
        super(context, resource, objects);
    }
    class ViewHolder{
        ImageView img;
        TextView txtTitle;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView = layoutInflater.inflate(R.layout.dong_item_youtube,null);
            viewHolder = new ViewHolder();
            viewHolder.img = convertView.findViewById(R.id.imageviewYotube);
            viewHolder.txtTitle = convertView.findViewById(R.id.textviewTitle);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Item item = getItem(position);

        Picasso.get().load(item.getSnippet().getThumbnails().getMedium().getUrl()).into(viewHolder.img);
        viewHolder.txtTitle.setText(item.getSnippet().getTitle());

        return convertView;
    }
}
