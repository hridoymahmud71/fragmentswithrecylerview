package hridoy.aiz.fragmentswithrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonListViewHolder> {

    ArrayList<Person> personArrayList;

    public PersonAdapter(Context context, ArrayList<Person> personArrayList) {
        this.personArrayList = personArrayList;
    }

    public class PersonListViewHolder extends RecyclerView.ViewHolder{

        TextView tvName;
        public PersonListViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
        }
    }

    @NonNull
    @Override
    public PersonAdapter.PersonListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);

        return new PersonListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.PersonListViewHolder holder, int position) {
        holder.itemView.setTag(personArrayList.get(position));
        holder.tvName.setText(personArrayList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return personArrayList.size();
    }
}
