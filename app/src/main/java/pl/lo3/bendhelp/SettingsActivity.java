package pl.lo3.bendhelp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    //TODO stworzyć ustawienia tak jak w prototypie

    public void openMenu(View view) {

        finish();
    }

}
