package pl.lo3.bendhelp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openCreateBendLabel(View view){

        Intent openCBL = new Intent(this, CreateBendLabelActivity.class);

        startActivity(openCBL);
    }

    public void openMenu(View view){

        Intent openM = new Intent(this, MainActivity.class);

        startActivity(openM);
    }



}
