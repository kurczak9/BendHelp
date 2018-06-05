package pl.lo3.bendhelp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ArchiveBendLabelActivity extends AppCompatActivity {

    PaperAdapter mAdapter;
    ListView mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archive_bend_label);

        mAdapter = new PaperAdapter(this, -1,"zapis2");
        mList = findViewById(R.id.mListlebel);


        mList.setAdapter(mAdapter);
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int pos, long id) {

                Intent intent = new Intent(getApplicationContext(), BendLabelActivity.class);

                intent.putExtra("x1", "" + mAdapter.getItem(pos).getX1());
                intent.putExtra("x2", "" + mAdapter.getItem(pos).getX2());
                intent.putExtra("x3", "" + mAdapter.getItem(pos).getX3());
                intent.putExtra("x4", "" + mAdapter.getItem(pos).getX4());
                intent.putExtra("a1", "" + mAdapter.getItem(pos).getA1());
                intent.putExtra("a2", "" + mAdapter.getItem(pos).getA2());
                intent.putExtra("a3", "" + mAdapter.getItem(pos).getA3());
                intent.putExtra("a4", "" + mAdapter.getItem(pos).getA4());

                startActivity(intent);
            }
        });

    }


    public void openMenu(View view) {

        finish();
    }

}
