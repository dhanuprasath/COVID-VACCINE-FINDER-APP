package com.example.covidvaccine;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import org.jetbrains.annotations.NotNull;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainAdapter extends FirebaseRecyclerAdapter<MainModel,MainAdapter.myViewMolder>{

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MainAdapter(@NonNull @NotNull FirebaseRecyclerOptions<MainModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull @NotNull myViewMolder holder, int position, @NonNull @NotNull MainModel model) {
        holder.name.setText(model.getName());
        holder.date.setText(model.getDate());
        holder.time.setText(model.getTime());
        holder.contact.setText(model.getContact());
        holder.address.setText(model.getAddress());
        holder.state.setText(model.getAddress());
        holder.district.setText(model.getAddress());

        Glide.with(holder.img.getContext())
                .load(model.getH1pic())
                .placeholder(R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(R.drawable.common_google_signin_btn_icon_dark)
                .into(holder.img);
    }

    @NonNull
    @NotNull
    @Override
    public myViewMolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item,parent,false);
        return new myViewMolder(view);
    }

    class myViewMolder extends RecyclerView.ViewHolder{
        CircleImageView img;
        TextView name,date,time,address,contact,state,district;

        public myViewMolder(@NonNull @NotNull View itemView) {
            super(itemView);

            img = (CircleImageView)itemView.findViewById(R.id.img1);
            name = (TextView)itemView.findViewById(R.id.name);
            date = (TextView)itemView.findViewById(R.id.date);
            time = (TextView)itemView.findViewById(R.id.time);
            address = (TextView)itemView.findViewById(R.id.address);
            contact = (TextView)itemView.findViewById(R.id.contact);
            state = (TextView)itemView.findViewById(R.id.state);
            district = (TextView)itemView.findViewById(R.id.district);

        }
    }

}
