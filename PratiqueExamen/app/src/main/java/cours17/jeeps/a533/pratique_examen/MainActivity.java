package cours17.jeeps.a533.pratique_examen;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    final Context context = this;
    List<jobOfferModel> jobList = new ArrayList<>();

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        for(Integer i = 1;i <= 3;i++) {
            jobOfferModel job = new jobOfferModel();
            job.description = "job " + i.toString();
            job.salary = i.toString();
            job.title = "Titre de l'emploi " + i;
            jobList.add(job);
        }

        adapter = new Adapter(jobList);
        recyclerView.setAdapter(adapter);

    }
}
