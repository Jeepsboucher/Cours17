package cours17.jeeps.a533.pratique_examen;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    public List<jobOfferModel> jobList;

    public Adapter(List<jobOfferModel> jobList) {
        this.jobList = jobList;
    }

    public interface OnClickListener {
        void onItemClick(jobOfferModel job);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View recipeView = inflater.inflate(R.layout.recycler_object, parent,false);

        ViewHolder viewHolder = new ViewHolder(recipeView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        jobOfferModel job = jobList.get(position);
        holder.title.setText(job.title);
        holder.description.setText(job.description);
        holder.salary.setText(job.salary);
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jobList.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return jobList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView description;
        TextView salary;
        Button button;

        public ViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.textView_title);
            description = itemView.findViewById(R.id.textView_description);
            salary = itemView.findViewById(R.id.textView_salary);
            button = itemView.findViewById(R.id.button_delete);
        }
    }
}
