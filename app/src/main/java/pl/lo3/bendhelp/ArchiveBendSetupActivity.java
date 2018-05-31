package pl.lo3.bendhelp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

//TODO dodać do layoutu Archive_bend_setup floating button
//TODO zrobić żeby po wybraniu danego zapisu z list view przenosiło nas do layout create_bend_label
//TODO i zeby aplikacja miała to w pamięci

public class ArchiveBendSetupActivity extends AppCompatActivity {
    PaperAdapter mAdapter;
    ListView mList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archive_bend_setup);

        mAdapter = new PaperAdapter(this, -1);
        mList = findViewById(R.id.mList);

        //attach our Adapter to the ListView. This will populate all of the rows.
        mList.setAdapter(mAdapter);
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int pos,long id) {

                Intent intent = new Intent(getApplicationContext(),BendDataActivity.class);

//            intent.putExtra("id",""+mAdapter.getItem(pos).getId());
//            intent.putExtra("land",""+mAdapter.getItem(pos).getLand().trim());
//            intent.putExtra("city",""+mAdapter.getItem(pos).getCity().trim());
//            intent.putExtra("stop",""+mAdapter.getItem(pos).getStopName() + "(" +mAdapter.getItem(pos).getStopNumber()+")");
//            intent.putExtra("line",""+mAdapter.getItem(pos).getLineNumber());
//            intent.putExtra("from",""+mAdapter.getItem(pos).getFrom().getTime());
//            intent.putExtra("down",""+mAdapter.getItem(pos).getDown().getTime());

                startActivity(intent);
            }
        });
    }


    public void openMenu(View view) {

        finish();
    }

}
