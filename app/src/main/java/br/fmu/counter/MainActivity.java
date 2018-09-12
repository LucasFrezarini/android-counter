package br.fmu.counter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private Button btnCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent it = this.getIntent();
        Bundle bundle = it.getExtras();

        this.btnCounter = this.findViewById(R.id.btn_activity_1);

        if(bundle != null) {
            int count = bundle.getInt("count", 0);
            this.btnCounter.setText(String.valueOf(count));
        }
    }

    public void next(View view) {
        Intent it = new Intent(this, Activity2.class);
        Bundle params = new Bundle();


        int count = Integer.parseInt(btnCounter.getText().toString());

        params.putInt("count", ++count);

        it.putExtras(params);
        startActivity(it);
    }
}
