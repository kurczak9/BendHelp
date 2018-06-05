package pl.lo3.bendhelp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class FinishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
    }


    public void openMenu(View view) {

        finish();
        Intent openMenu = new Intent(this, MenuActivity.class);

        startActivity(openMenu);

    }


}
