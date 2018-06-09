package pl.lo3.bendhelp;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import pl.lo3.bendhelp.databinding.ActivityFinishBinding;


public class FinishActivity extends AppCompatActivity {

    ActivityFinishBinding binding;



    //TODO zapisywać liste kątów i odległośći dla ulatwienia procesu liczenia wyniku

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_finish);

        //3,14159265

        float L1;
        float L2;
        float L3;
        float L4;

        State state = new State();
        float radius = state.getBendRadius();
        float angle1 = state.getA1();
        float angle2 = state.getA2();
        float angle3 = state.getA3();
        float angle4 = state.getA4();

        float first = (float) ((radius*angle1*6.2831853)/360);
        float second = (float) ((radius*angle2*6.2831853)/360);
        float third = (float) ((radius*angle3*6.2831853)/360);
        float fourth = (float) ((radius*angle4*6.2831853)/360);

        L1 = first + state.getX1();
        L2 = second + state.getX2();
        L3 = third + state.getX3();
        L4 = fourth + state.getX4();



        binding.firstDistance.setText(Float.toString(L1));
        binding.secondDistance.setText(Float.toString(L2));
        binding.thirdDistance.setText(Float.toString(L3));
        binding.fourthDistance.setText(Float.toString(L4));
    }





    public void openMenu(View view) {

        finish();
        Intent openMenu = new Intent(this, MenuActivity.class);

        startActivity(openMenu);

    }


}
