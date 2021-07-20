package com.example.tictok.Stream;


        import android.content.Context;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.AdapterView;
        import android.widget.ImageView;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;
        import androidx.recyclerview.widget.StaggeredGridLayoutManager;


        import com.bumptech.glide.Glide;
        import com.example.tictok.R;

        import java.util.ArrayList;
        import java.util.List;

public class StreamAdapter extends RecyclerView.Adapter<StreamAdapter.ViewHolder> {
    String TAG="MyAdapter";
    private Context context;
    private AdapterView.OnItemClickListener mListen;
    private List<String> list=new ArrayList<>();

    public StreamAdapter(Context context){
        this.context=context;
        //list 可以用来显示文字
        for(int i=0;i<100;i++) list.add(String.format("%s",i));
    }
    @Override
    public StreamAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.items_stream,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StreamAdapter.ViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView mImageView;
        public ViewHolder(View itemView){
            super(itemView);
            mImageView=(ImageView) itemView.findViewById(R.id.iv);
        }
        public void onBind(int position){
            if(position%3==0){
                mImageView.setImageResource(R.drawable.num0);
//                Glide.with(context).load(R.drawable.num3).into(mImageView);
            }
            else if(position%3==1){
                mImageView.setImageResource(R.drawable.num4);
//                Glide.with(context).load(R.drawable.num4).into(mImageView);
            }
            else{
                mImageView.setImageResource(R.drawable.num5);
//                Glide.with(context).load(R.drawable.num5).into(mImageView);
            }

            Log.d(TAG, "onBind: "+ ViewGroup.LayoutParams.MATCH_PARENT);

        }
    }
}
