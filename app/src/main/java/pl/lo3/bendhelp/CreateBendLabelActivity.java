package pl.lo3.bendhelp;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import io.paperdb.Paper;
import pl.lo3.bendhelp.databinding.ActivityCreateBendLabelBinding;

public class CreateBendLabelActivity extends AppCompatActivity {

    ActivityCreateBendLabelBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_bend_label);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_bend_label);


        if(getIntent().getStringExtra("x1") != null){


            binding.x1.setText(getIntent().getStringExtra("x1"));

            binding.x2.setText(getIntent().getStringExtra("x2"));

            binding.x3.setText(getIntent().getStringExtra("x3"));

            binding.x4.setText(getIntent().getStringExtra("x4"));

            binding.a1.setText(getIntent().getStringExtra("a1"));

            binding.a2.setText(getIntent().getStringExtra("a2"));

            binding.a3.setText(getIntent().getStringExtra("a3"));

            binding.a4.setText(getIntent().getStringExtra("a4"));

        }

    }



    public void openMenu(View view) {

        finish();
    }

    public void saveCBL(){

        State state = new State();
        state.setX1(Float.parseFloat(binding.x1.getText().toString().trim()));
        state.setX2(Float.parseFloat(binding.x2.getText().toString().trim()));
        state.setX3(Float.parseFloat(binding.x3.getText().toString().trim()));
        state.setX4(Float.parseFloat(binding.x4.getText().toString().trim()));
        state.setA1(Float.parseFloat(binding.a1.getText().toString().trim()));
        state.setA2(Float.parseFloat(binding.a2.getText().toString().trim()));
        state.setA3(Float.parseFloat(binding.a3.getText().toString().trim()));
        state.setA4(Float.parseFloat(binding.a4.getText().toString().trim()));
        Paper.book().write("zapis2", state);

    }

    /**
     * Validating form
     */
    private boolean submitForm() {

      //  if (!validatex1()) {
     //       return false;
     //   }


        return true;

    }

//    private boolean validateBendRadius() {
//        if (binding.bendRadiusInput.getText().toString().trim().isEmpty()) {
//            // inputLayoutLine.setError(getString(R.string.err_msg_line));
//            requestFocus(binding.bendRadiusInput);
//            validationToast();
//            return false;
//        }
//        //else {
//        // binding.inputLayoutLine.setErrorEnabled(false);
//        //}
//        return true;
//    }



    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    public void openFinish(View view){

        if(submitForm()){

            saveCBL();

            Intent openCBL = new Intent(this, CreateBendLabelActivity.class);

            startActivity(openCBL);
        }
    }

}
