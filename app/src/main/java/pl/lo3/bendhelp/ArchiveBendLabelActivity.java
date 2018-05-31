package pl.lo3.bendhelp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ArchiveBendLabelActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archive_bend_label);
    }

    //TODO stworzyć listview które zapisywało by dane wprowadzone w layoucie create_bend_label,
    //TODO oraz żeby po wybramiu z niego przenosiło nas do strony zawierającej wynik obliczen

    public void openMenu(View view) {

        finish();
    }

}
