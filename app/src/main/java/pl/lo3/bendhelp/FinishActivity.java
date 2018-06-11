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

    double stalaKurczaka = 0.0174532925;

    //TODO zapisywać liste kątów i odległośći dla ulatwienia procesu liczenia wyniku

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

        L1 = (float) ((BendData.getBendRadius()*BendLabel.getA1()*stalaKurczaka)+BendLabel.getX1());
        L2 = (float) ((BendData.getBendRadius()*BendLabel.getA2()*stalaKurczaka)+BendLabel.getX2());
        L3 = (float) ((BendData.getBendRadius()*BendLabel.getA3()*stalaKurczaka)+BendLabel.getX3());
        L4 = (float) ((BendData.getBendRadius()*BendLabel.getA4()*stalaKurczaka)+BendLabel.getX4());

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
