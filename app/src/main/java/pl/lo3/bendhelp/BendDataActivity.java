package pl.lo3.bendhelp;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import pl.lo3.bendhelp.databinding.ActivityBendDataBinding;

import io.paperdb.Paper;

public class BendDataActivity extends AppCompatActivity {

    ActivityBendDataBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bend_data);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_bend_data);


        ArrayAdapter adaptermaterial = ArrayAdapter.createFromResource(this,
                R.array. material_spinner, android.R.layout.simple_spinner_dropdown_item);

        binding.inputMaterial.setAdapter(adaptermaterial);



        if(getIntent().getStringExtra("radius") != null){


            binding.bendRadiusInput.setText(getIntent().getStringExtra("radius"));

            binding.tubeDiameterInput.setText(getIntent().getStringExtra("diameter"));

            binding.tubeThicknessInput.setText(getIntent().getStringExtra("thickness"));

            String compareValue = getIntent().getStringExtra("material");
            if (compareValue != null) {
                binding.inputMaterial.setSelection(adaptermaterial.getPosition(compareValue));
            }

        }




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
        state.setBendRadius(Float.parseFloat(binding.bendRadiusInput.getText().toString().trim()));
        state.setTubeDiameter(Float.parseFloat(binding.tubeDiameterInput.getText().toString().trim()));
        state.setTubeThickness(Float.parseFloat(binding.tubeThicknessInput.getText().toString().trim()));
        state.setMaterial(binding.inputMaterial.getSelectedItem().toString().trim());

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
        if (binding.bendRadiusInput.getText().toString().trim().isEmpty()) {
           // inputLayoutLine.setError(getString(R.string.err_msg_line));
            requestFocus(binding.bendRadiusInput);
            validationToast();
            return false;
        }
        //else {
           // binding.inputLayoutLine.setErrorEnabled(false);
        //}
        return true;
    }

    private boolean validateTubeDiameter() {
        if (binding.tubeDiameterInput.getText().toString().trim().isEmpty()) {
            // inputLayoutLine.setError(getString(R.string.err_msg_line));
            requestFocus(binding.tubeDiameterInput);
            validationToast();
            return false;
        }
        //else {
        // binding.inputLayoutLine.setErrorEnabled(false);
        //}
        return true;
    }

    private boolean validateTubeThinckness() {
        if (binding.tubeThicknessInput.getText().toString().trim().isEmpty()) {
            // inputLayoutLine.setError(getString(R.string.err_msg_line));
            requestFocus(binding.tubeThicknessInput);
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
