package css.cis3334hailey.voldhaileyfinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by haileyvold on 5/8/17.
 */


public class PlantAdapter extends ArrayAdapter<Plant> {

    private List<Plant> plantList;
    private Context context;
    private int layoutResource;


    public PlantAdapter(Context context, int resource, List<Plant> plantList) {
        super(context, resource, plantList);
        this.context = context;
        this.layoutResource = resource;
        this.plantList = plantList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Plant plant = plantList.get(position);
        View view;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.plant_row_layout, null);

        TextView tvName=(TextView)view.findViewById(R.id.textViewName);
        tvName.setText(plant.getName());
        return(view);
    }


}
