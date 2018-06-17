package pl.lo3.bendhelp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class ArchiveBendSetupActivity extends AppCompatActivity {
    PaperAdapter mAdapter;
    ListView mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archive_bend_setup);

        mAdapter = new PaperAdapter(this, -1, "zapis");
        mList = findViewById(R.id.mList);


        mList.setAdapter(mAdapter);
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int pos, long id) {

                Intent intent = new Intent(getApplicationContext(), BendDataActivity.class);

                intent.putExtra("radius", "" + mAdapter.getItem(pos).getBendRadius());
                intent.putExtra("diameter", "" + mAdapter.getItem(pos).getTubeDiameter());
                intent.putExtra("thickness", "" + mAdapter.getItem(pos).getTubeThickness());
                intent.putExtra("material", "" + mAdapter.getItem(pos).getMaterial());

                startActivity(intent);
            }
        });
    }


    public void openMenu(View view) {

        finish();

    }

}
