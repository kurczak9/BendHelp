package pl.lo3.bendhelp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }



    public void openBendData(View view){

        Intent openBD = new Intent(this, BendDataActivity.class);

        startActivity(openBD);
    }

    public void openArchiveBendSetup(View view){

        Intent openABS = new Intent(this, ArchiveBendSetupActivity.class);

        startActivity(openABS);
    }

    public void openArchiveBendLabel(View view){

        Intent openABL = new Intent(this, ArchiveBendLabelActivity.class);

        startActivity(openABL);
    }

    public void openSettings(View view){

        Intent openS = new Intent(this, SettingsActivity.class);

        startActivity(openS);
    }

}
