package cours17.jeeps.a533.pratique_examen;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivityQ2 extends AppCompatActivity {
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_q2);

        setListener();
    }


    public void setListener() {
        findViewById(R.id.button_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(context);

                dialog.setContentView(R.layout.dialog_q2);

                Button dialogOk = dialog.findViewById(R.id.btn_ok);

                dialogOk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "Vroom", Toast.LENGTH_LONG).show();
                    }
                });

                Button dialogCancel = dialog.findViewById(R.id.btn_cancel);

                dialogCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "It’s treason then", Toast.LENGTH_LONG).show();
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }
}
