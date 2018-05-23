package pl.lo3.bendhelp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CreateBendLabelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_bend_label);
    }

    public void openMenu(View view) {

        finish();
    }

}
