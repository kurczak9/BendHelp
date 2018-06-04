package pl.lo3.bendhelp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.List;

import io.paperdb.Paper;


/*
 * Very basic Custom Adapter that takes state name,capital pairs out of a csv
 * file from the assets and uses those values to build a List of State objects.
 * Overrides the default getView() method to return a TextView with the state name.
 * 
 * ArrayAdapter - a type of Adapter that works a lot like ArrayList.
 */
public class PaperAdapter extends ArrayAdapter<State> implements Filterable {
	Context ctx;

	//We must accept the textViewResourceId parameter, but it will be unused
	//for the purposes of this example.
	public PaperAdapter(Context context, int textViewResourceId) {
		super(context, textViewResourceId);
		
		//Store a reference to the Context so we can use it to load a file from Assets.
		this.ctx = context;
		
		//Load the data.
		loadArrayFromPaper();

	}
	
	
	
	/*
	 * getView() is the method responsible for building a View out of a some data that represents
	 * one row within the ListView. For this example our row will be a single TextView that
	 * gets populated with the state name.
	 * (non-Javadoc)
	 * @see android.widget.ArrayAdapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	@Override
	public View getView(final int pos, View convertView, final ViewGroup parent){
		/*
		 * Using convertView is important. The system will pass back Views that have been
		 * created but scrolled off of the top (or bottom) of the screen, and thus are no
		 * longer being shown on the screen. Since they are unused, we can "recycle" them
		 * instead of creating a new View object for every row, which would be wasteful, 
		 * and lead to poor performance. The diference may not be noticeable in this
		 * small example. But with larger more complex projects it will make a significant
		 * improvement by recycling Views rather than creating new ones for each row.
		 */
		TextView mView = (TextView)convertView;
		//If convertView was null then we have to create a new TextView.
		//If it was not null then we'll re-use it by setting the appropriate
		//text String to it.
		if(null == mView){ 
			mView = new TextView(parent.getContext());
			mView.setTextSize(28);
		}
		
		//TODO cały opis zapisanych parametrów
        String bendR = (Float.toString(getItem(pos).getBendRadius()));
		String tubeD = (Float.toString(getItem(pos).getTubeDiameter()));
		String tubeT = (Float.toString(getItem(pos).getTubeThickness()));
		String Material = ((getItem(pos).getMaterial()));

        mView.setText(bendR+"/"+tubeD+"x"+tubeT+"/"+Material);

		return mView;
	}
	
	/*
	 * Helper method that loads the data from the Paper.book and builds
	 * each row into a State object which then gets added to the Adapter.
	 */
	private void loadArrayFromPaper(){
		// Get list of item
		List<String> allKeys = Paper.book().getAllKeys();
		State cur;

        //TODO odczytywanie listy zpaisanych pozycji
		/*for (int i = 0; i <allKeys.size() ; i++) {
            //Create a State object for each Key.
            cur = Paper.book().read(String.valueOf(i+1));
            //Add the State object to the ArrayList (in this case we are the ArrayList).
            this.add(cur);
        }*/
		cur = Paper.book().read("zapis");
		//Add the State object to the ArrayList (in this case we are the ArrayList).
		this.add(cur);

	}

}
