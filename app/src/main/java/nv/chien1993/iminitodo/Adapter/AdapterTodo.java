package nv.chien1993.iminitodo.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import nv.chien1993.iminitodo.Model.ToDoItem;
import nv.chien1993.iminitodo.R;

public class AdapterTodo extends RecyclerView.Adapter<AdapterTodo.ViewHolder> {


    private Context context;
    private List<ToDoItem> list;

    private ClickItemRcv clickItemRcv;
    public interface ClickItemRcv{
        void onClickItemRcv(int posItem);
    }

    public AdapterTodo(Context context, ClickItemRcv clickItemRcv, List<ToDoItem> list) {
        this.context = context;
        this.clickItemRcv = clickItemRcv;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_todo, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.title.setText(list.get(i).getmTodo_title());
        viewHolder.des.setText(list.get(i).getmTodo_des());

    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView title;
        private TextView des;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            des = itemView.findViewById(R.id.des);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int po = getAdapterPosition();
            clickItemRcv.onClickItemRcv(po);
        }
    }
}
