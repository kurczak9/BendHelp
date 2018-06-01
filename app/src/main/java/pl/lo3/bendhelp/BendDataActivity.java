package pl.lo3.bendhelp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import io.paperdb.Paper;

public class BendDataActivity extends AppCompatActivity {

    public State cur;

    EditText bendRadius;
    EditText tubeDiameter;
    EditText tubeThickness;
    EditText material;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bend_data);

        bendRadius = (EditText) findViewById(R.id.bendRadiusInput);
        tubeDiameter = (EditText) findViewById(R.id.tubeDiameterInput);
        tubeThickness = (EditText) findViewById(R.id.tubeThicknessInput);
        //material = (EditText) findViewById(R.id.material);

        //loadArrayFromPaper();

        //paper
        //if(cur!=null){
        if(getIntent().getStringExtra("radius") != null){


            EditText bendRadius = (EditText) findViewById(R.id.bendRadiusInput);
            bendRadius.setText(getIntent().getStringExtra("radius"));

            EditText tubeDiameter = (EditText) findViewById(R.id.tubeDiameterInput);
            tubeDiameter.setText(getIntent().getStringExtra("diameter"));

            EditText tubeThickness = (EditText) findViewById(R.id.tubeThicknessInput);
            tubeThickness.setText(getIntent().getStringExtra("thickness"));

        }


        //spinnner
        Spinner input_material = (Spinner) findViewById(R.id.input_material);

        ArrayAdapter adaptermaterial = ArrayAdapter.createFromResource(this,
                R.array. material_spinner, android.R.layout.simple_spinner_dropdown_item);

        input_material.setAdapter(adaptermaterial);

    }

    public void openMenu(View view) {

        finish();
    }

    public void openCreateBendLabel(View view){

        if(submitForm()){

        saveBendSetup();

        Intent openCBL = new Intent(this, CreateBendLabelActivity.class);

        startActivity(openCBL);
        }
    }


//    private void loadArrayFromPaper(){
//        // Get list of item
//        List<String> allKeys = Paper.book().getAllKeys();
//
//
//        for (int i = 0; i <allKeys.size() ; i++) {
//            //Create a State object for each Key.
//            cur = Paper.book().read(String.valueOf(i+1));
//            //Add the State object to the ArrayList (in this case we are the ArrayList).
//        }
//
//    }




    public void saveBendSetup(){

        State state = new State();

        state.setBendRadius(Float.parseFloat(bendRadius.getText().toString().trim()));
        state.setTubeDiameter(Float.parseFloat(tubeDiameter.getText().toString().trim()));
        state.setTubeThickness(Float.parseFloat(tubeThickness.getText().toString().trim()));

        Paper.book().write("zapis", state);

    }

    /**
     * Validating form
     */
    private boolean submitForm() {

        if (!validateBendRadius()) {
            return false;
        }

        if (!validateTubeDiameter()) {
            return false;
        }

        if (!validateTubeThinckness()) {
            return false;
        }

        return true;

    }

    private boolean validateBendRadius() {
        if (bendRadius.getText().toString().trim().isEmpty()) {
           // inputLayoutLine.setError(getString(R.string.err_msg_line));
            requestFocus(bendRadius);
            validationToast();
            return false;
        }
        //else {
           // binding.inputLayoutLine.setErrorEnabled(false);
        //}
        return true;
    }

    private boolean validateTubeDiameter() {
        if (tubeDiameter.getText().toString().trim().isEmpty()) {
            // inputLayoutLine.setError(getString(R.string.err_msg_line));
            requestFocus(tubeDiameter);
            validationToast();
            return false;
        }
        //else {
        // binding.inputLayoutLine.setErrorEnabled(false);
        //}
        return true;
    }

    private boolean validateTubeThinckness() {
        if (tubeThickness.getText().toString().trim().isEmpty()) {
            // inputLayoutLine.setError(getString(R.string.err_msg_line));
            requestFocus(tubeThickness);
            validationToast();
            return false;
        }
        //else {
        // binding.inputLayoutLine.setErrorEnabled(false);
        //}
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private void validationToast(){

        Toast.makeText(getApplicationContext(),"Please fill all blank fields",Toast.LENGTH_LONG).show();
        //TODO poprawić toast żeby pojawiał się nad przyciskami
    }

}
