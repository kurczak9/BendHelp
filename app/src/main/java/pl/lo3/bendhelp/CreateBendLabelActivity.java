package pl.lo3.bendhelp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateBendLabelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_bend_label);
    }

    public void openMenu(View view) {

        finish();
    }



    private EditText bendRadius;
    private EditText tubeDiameter;
    private EditText tubeThickness;

    public void saveBendSetup(View view){

//        bendRadius = (EditText) findViewById(R.id.bendRadiusInput);
//
//        tubeDiameter = (EditText) findViewById(R.id.tubeDiameterInput);
//
//        tubeThickness = (EditText) findViewById(R.id.tubeThicknessInput);

    }

}
