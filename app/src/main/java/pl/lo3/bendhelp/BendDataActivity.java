package pl.lo3.bendhelp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class BendDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bend_data);

        Spinner input_material = (Spinner) findViewById(R.id.input_material);

        ArrayAdapter adaptermaterial = ArrayAdapter.createFromResource(this,
                R.array. material_spinner, android.R.layout.simple_spinner_dropdown_item);

        input_material.setAdapter(adaptermaterial);

//        String WartoscDomyslna = "Black Steel";
//        if (WartoscDomyslna!= null) {
//
//
//            input_material.setSelection(adapterStop.getPosition(WartoscDomyslna));
//        }


    }

    public void openMenu(View view) {

        finish();
    }

    public void openCreateBendLabel(View view){

        Intent openCBL = new Intent(this, CreateBendLabelActivity.class);

        startActivity(openCBL);
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
