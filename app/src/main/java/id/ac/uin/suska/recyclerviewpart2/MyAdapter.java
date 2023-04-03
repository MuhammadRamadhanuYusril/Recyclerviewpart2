package id.ac.uin.suska.recyclerviewpart2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<User> listuser;
    private RecyclerViewClickListener listener;

    public MyAdapter(ArrayList<User> listuser, RecyclerViewClickListener listener){
        this.listuser = listuser;
        this.listener = listener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView nameTxt;

        public MyViewHolder(final View view){
            super(view);
            nameTxt = view.findViewById(R.id.name);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());
        }
    }


    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        String name = listuser.get(position).getUsername();
        holder.nameTxt.setText(name);
    }

    @Override
    public int getItemCount() {
        return listuser.size();
    }

    public interface RecyclerViewClickListener{
        void onClick(View v, int possition);
    }
}
