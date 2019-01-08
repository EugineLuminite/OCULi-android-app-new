package oculimobile.oculi.Adaptors;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import oculimobile.oculi.ObjectsToUse.ToDoItem;
import oculimobile.oculi.R;
import oculimobile.oculi.ViewModels.EventsViewFragment;

public class ToDoItemAdapter  extends ArrayAdapter<oculimobile.oculi.ObjectsToUse.ToDoItem>
{
    Context mContext;
    int mLayoutResourceId;
    EventsViewFragment.OnFragmentInteractionListener mListener;
    public ToDoItemAdapter(Context context, int layoutResourceId,  EventsViewFragment.OnFragmentInteractionListener listener)
    {
        super(context, layoutResourceId);

        mContext = context;
        mLayoutResourceId = layoutResourceId;
        mListener = listener;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        final ToDoItem currentItem = getItem(position);

        if (row == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(mLayoutResourceId, parent, false);
        }

        row.setTag(currentItem);


        final TextView camera_name = (TextView) row.findViewById(R.id.uname);
        camera_name.setText(currentItem.getCameraName());
        final TextView update_date = (TextView) row.findViewById(R.id.udata);
        update_date.setText(currentItem.getUpdateDate());
        final TextView site_name = (TextView) row.findViewById(R.id.usite);
        site_name.setText(currentItem.getUsername());
//
        final ImageView EvetTypeColor = (ImageView) row.findViewById(R.id.ucolor);

        String type = currentItem.getText();
        if(type.equals("Move") )
        {//http://tdekoning.github.io/rgba-converter/
            EvetTypeColor.setBackgroundColor(Color.parseColor("#651d32"));

        }
        else if(type.equals("Init"))
        {
            EvetTypeColor.setBackgroundColor(Color.parseColor("#ffe900"));

        }
        else if(type.equals("Day"))
        {
            EvetTypeColor.setBackgroundColor(Color.parseColor("#f6f6f9"));

        }
        else if(type.equals("Shock"))
        {
            EvetTypeColor.setBackgroundColor(Color.parseColor("#ea27c2"));

        }
        else if(type.equals("Heartbeat"))
        {
            EvetTypeColor.setBackgroundColor(Color.parseColor("#0000ff"));
        }
        else if(type.equals("Detection"))
        {
            EvetTypeColor.setBackgroundColor(Color.parseColor("#ff0000"));
        }
        else if(type.equals("Night"))
        {
            EvetTypeColor.setBackgroundColor(Color.parseColor("#141414"));
        }
        else if(type.equals("TamperOn"))
        {
            EvetTypeColor.setBackgroundColor(Color.parseColor("#44d62c"));
        }
        else if(type.equals("TamperOff"))
        {
            EvetTypeColor.setBackgroundColor(Color.parseColor("#00aa4d"));
        }
        else if(type.equals("CloakOn"))
        {
            EvetTypeColor.setBackgroundColor(Color.parseColor("#7f00ff"));
        }
        else if(type.equals("CloakOff"))
        {
            EvetTypeColor.setBackgroundColor(Color.parseColor("#327f64"));
        }
        else if(type.contains("Int"))
        {

        }
        else
        {
            EvetTypeColor.setBackgroundColor(Color.parseColor("#ffffff"));

        }
        row.setBackgroundColor(Color.parseColor("#ffffff"));
        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                MainActivity activity = (MainActivity) mContext;
//                activity.CreateItemDialog(currentItem);
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    //mListener.OnFragmentInteractionListener(holder.mItem);
                }
            }
        });

        return row;
    }

}
