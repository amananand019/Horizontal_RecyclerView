package com.example.recyclerviewhorizontal;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.io.PipedOutputStream;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import de.hdodenhof.circleimageview.CircleImageView;

public class HorizontalRecyclerViewAdapter extends RecyclerView.Adapter<HorizontalRecyclerViewAdapter.ViewHolder>{
    private static final String TAG = "HorizontalRecyclerViewA";

    private Context mContext;
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mNames = new ArrayList<>();


    public HorizontalRecyclerViewAdapter(Context mContext, ArrayList<String> mImageUrls, ArrayList<String> mNames) {
        this.mContext = mContext;
        this.mImageUrls = mImageUrls;
        this.mNames = mNames;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_grid_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called. ");

        //Glide without using RequestOptions

//        Glide.with(mContext)
//                .asBitmap()
//                .load(mImageUrls.get(position))
//                .into(holder.image);

        //Glide using RequestOptions
        //Using RequestOptions is better because it will prevent the app to disorient while screen is rotated.
        //also if some problem occurs it will show the default picture in the placeholder rather then a blank screen.
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background);

        Glide.with(mContext)
                .load(mImageUrls.get(position))
                .apply(requestOptions)
                .into(holder.image);

        holder.name.setText(mNames.get(position));

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + mNames.get(position));
                Toast.makeText(mContext, mNames.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageUrls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView image;
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.image = itemView.findViewById(R.id.image_widget);
            this.name = itemView.findViewById(R.id.name_widget);
        }
    }
}
