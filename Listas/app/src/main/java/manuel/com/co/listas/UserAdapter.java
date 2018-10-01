package manuel.com.co.listas;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import manuel.com.co.listas.modelo.User;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private static List<User> items;
    private Context context;
    private MainActivity a;

    public UserAdapter(Context context, List<User> items, MainActivity a) {
        this.context = context;
        this.items = items;
        this.a = a;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_estudiantes, parent,
                false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        User item = items.get(position);
        holder.user_id.setText(item.getId());
        holder.user_name.setText(item.getName());
        holder.user_email.setText(item.getEmail());
        holder.user_id_firebase.setText(item.getIdFirebase());
        holder.itemView.setTag(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView user_id;
        public TextView user_name;
        public TextView user_email;
        public TextView user_id_firebase;

        public ViewHolder(final View itemView) {
            super(itemView);
            user_id = (TextView) itemView.findViewById(R.id.user_id);
            user_name = (TextView) itemView.findViewById(R.id.user_name);
            user_email = (TextView) itemView.findViewById(R.id.user_email);
            user_id_firebase = (TextView) itemView.findViewById(R.id.user_idfirebase);
        }
    }
}
