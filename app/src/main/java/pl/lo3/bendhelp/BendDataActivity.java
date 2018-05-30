package pl.lo3.bendhelp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

import io.paperdb.Paper;

public class BendDataActivity extends AppCompatActivity {

    public State cur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bend_data);

        loadArrayFromPaper();

        if(cur!=null){

            EditText bendRadius = (EditText) findViewById(R.id.bendRadiusInput);
            bendRadius.setText((int) cur.getBendRadius());

            EditText tubeDiameter = (EditText) findViewById(R.id.tubeDiameterInput);
            tubeDiameter.setText((int) cur.getTubeDiameter());

        }

        Spinner input_material = (Spinner) findViewById(R.id.input_material);

        ArrayAdapter adaptermaterial = ArrayAdapter.createFromResource(this,
                R.array. material_spinner, android.R.layout.simple_spinner_dropdown_item);

        input_material.setAdapter(adaptermaterial);

    }

    public void openMenu(View view) {

        finish();
    }

    public void openCreateBendLabel(View view){

        saveBendSetup();

        Intent openCBL = new Intent(this, CreateBendLabelActivity.class);

        startActivity(openCBL);
    }


    private void loadArrayFromPaper(){
        // Get list of item
        List<String> allKeys = Paper.book().getAllKeys();


        for (int i = 0; i <allKeys.size() ; i++) {
            //Create a State object for each Key.
            cur = Paper.book().read(String.valueOf(i+1));
            //Add the State object to the ArrayList (in this case we are the ArrayList).
        }

    }




    public void saveBendSetup(){

         EditText bendRadius;
         EditText tubeDiameter;
         EditText tubeThickness;
         EditText material;

        bendRadius = (EditText) findViewById(R.id.bendRadiusInput);
        tubeDiameter = (EditText) findViewById(R.id.tubeDiameterInput);
        tubeThickness = (EditText) findViewById(R.id.tubeThicknessInput);
       // material = (EditText) findViewById(R.id.material);

        State state = new State();

        state.setBendRadius(Float.parseFloat(bendRadius.getText().toString().trim()));
        state.setTubeDiameter(Float.parseFloat(tubeDiameter.getText().toString().trim()));
        state.setTubeThickness(Float.parseFloat(tubeThickness.getText().toString().trim()));

        Paper.book().write("zapis", state);

    }

}
