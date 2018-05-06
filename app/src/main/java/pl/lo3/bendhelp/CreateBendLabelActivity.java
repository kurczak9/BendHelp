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

        //Intent openM = new Intent(this, MainActivity.class);

        //startActivity(openM);

        finish();
    }



    private EditText bendRadius;
    private EditText tubeDiameter;
    private EditText tubeThickness;

    public void saveBendSetup(View view){

        bendRadius = (EditText) findViewById(R.id.bendRadiusInput);
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.TOP| Gravity.LEFT, 0, 0);
        toast.makeText(CreateBendLabelActivity.this, bendRadius.getText(), toast.LENGTH_SHORT).show();

        tubeDiameter = (EditText) findViewById(R.id.tubeDiameterInput);
        Toast toast2 = new Toast(getApplicationContext());
        toast2.setGravity(Gravity.TOP| Gravity.LEFT, 0, 0);
        toast2.makeText(CreateBendLabelActivity.this, tubeDiameter.getText(), toast.LENGTH_SHORT).show();

        tubeThickness = (EditText) findViewById(R.id.tubeThicknessInput);
        Toast toast3 = new Toast(getApplicationContext());
        toast3.setGravity(Gravity.TOP| Gravity.LEFT, 0, 0);
        toast3.makeText(CreateBendLabelActivity.this, tubeThickness.getText(), toast.LENGTH_SHORT).show();

    } //dodałem toast żeby sprawdzić czy działa pobranie danych z plaintext

}
