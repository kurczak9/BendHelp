package pl.lo3.bendhelp;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import io.paperdb.Paper;
import pl.lo3.bendhelp.databinding.ActivityBendDataBinding;

public class BendDataActivity extends AppCompatActivity {

    ActivityBendDataBinding binding;
    private ArrayAdapter adaptermaterial;
    PaperAdapter mAdapter;
    ListView mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bend_data);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_bend_data);


        adaptermaterial = ArrayAdapter.createFromResource(this,
                R.array.material_spinner, android.R.layout.simple_spinner_dropdown_item);

        binding.inputMaterial.setAdapter(adaptermaterial);


        if (getIntent().getStringExtra("radius") != null) {


            binding.bendRadiusInput.setText(getIntent().getStringExtra("radius"));

            binding.tubeDiameterInput.setText(getIntent().getStringExtra("diameter"));

            binding.tubeThicknessInput.setText(getIntent().getStringExtra("thickness"));

            String compareValue = getIntent().getStringExtra("material");
            if (compareValue != null) {
                binding.inputMaterial.setSelection(adaptermaterial.getPosition(compareValue));
            }

        }


//        mAdapter = new PaperAdapter(this, -1, "zapis");
//
//
//        mList.setAdapter(mAdapter);
//        Intent intent = new Intent(getApplicationContext(), BendDataActivity.class);
//
//        intent.putExtra("radius", "" + mAdapter.getItem().getBendRadius());
//        intent.putExtra("diameter", "" + mAdapter.getItem(pos).getTubeDiameter());
//        intent.putExtra("thickness", "" + mAdapter.getItem(pos).getTubeThickness());
//        intent.putExtra("material", "" + mAdapter.getItem(pos).getMaterial());


    }

    public void openMenu(View view) {

        finish();
    }

    public void openBendLabel(View view) {

        if (submitForm()) {

            saveBendSetup();
            Intent openCBL = new Intent(this, BendLabelActivity.class);
            startActivity(openCBL);
        }
    }


    public void saveBendSetup() {

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

    private void validationToast() {

        Toast.makeText(getApplicationContext(), "Please fill all blank fields", Toast.LENGTH_LONG).show();
        //TODO poprawić toast żeby pojawiał się nad przyciskami
    }

}
