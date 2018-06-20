package pl.lo3.bendhelp;

import android.content.Intent;
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

    public void openAbout(View view) {

        Intent open = new Intent(this, AboutMeActivity.class);

        startActivity(open);
    }

    public void openHelp(View view) {

        Intent open = new Intent(this, HelpActivity.class);

        startActivity(open);


    }
}