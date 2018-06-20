package pl.lo3.bendhelp;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import io.paperdb.Paper;
import pl.lo3.bendhelp.databinding.ActivityFinishBinding;


public class FinishActivity extends AppCompatActivity {

    ActivityFinishBinding binding;

    double stalaKurczaka = 0.00872664625;

    //TODO poprawić rysunek

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_finish);

        State BendData = Paper.book().read("zapis");
        State BendLabel = Paper.book().read("zapis2");

        float L1;
        float L2;
        float L3;
        float L4;

        float radius = BendData.getBendRadius();

        L1 = (float) (((radius*BendLabel.getA1()*stalaKurczaka)/2)+BendLabel.getX1());
        L2 = (float) (((radius*BendLabel.getA1()*stalaKurczaka)/2)+((radius*BendLabel.getA2()*stalaKurczaka)/2)+BendLabel.getX2());
        L3 = (float) (((radius*BendLabel.getA2()*stalaKurczaka)/2)+((radius*BendLabel.getA3()*stalaKurczaka)/2)+BendLabel.getX3());
        L4 = (float) (((radius*BendLabel.getA3()*stalaKurczaka)/2)+((radius*BendLabel.getA4()*stalaKurczaka)/2)+BendLabel.getX4());

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
