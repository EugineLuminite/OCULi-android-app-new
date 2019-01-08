package oculimobile.oculi.Adaptors;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import oculimobile.oculi.ActivitiesViewModels.UnitsPageActivity;
import oculimobile.oculi.ObjectsToUse.Units;
import oculimobile.oculi.R;

public class UnitListAdapter extends ArrayAdapter<Units>
{

    Context mContext;
    int mLayoutResourceId;
    public UnitListAdapter(Context context, int layoutResourceId)
    {
        super(context, layoutResourceId);

        mContext = context;
        mLayoutResourceId = layoutResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        final Units currentItem = getItem(position);

        if (row == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(mLayoutResourceId, parent, false);
        }

        row.setTag(currentItem);
        final TextView UNITNAME = (TextView) row.findViewById(R.id.UNITname);
        UNITNAME.setText(currentItem.getName());

        final TextView UNITSITENAME = (TextView) row.findViewById(R.id.UNITsitename);
        UNITSITENAME.setText("Site: "+currentItem.getmSiteName());

        final TextView UNITLASCON = (TextView) row.findViewById(R.id.UNITlastcon);
        String dataa = currentItem.getLastContact() ;
        if(dataa.length()>4)
        {
            String  s = str_remove(currentItem.getLastContact());
            UNITLASCON.setText(s);
            UNITLASCON.setTextColor(Color.parseColor("#327f64"));
            //#327f64
        }
        if(dataa.equals("null"))
        {
            UNITLASCON.setTextColor(Color.parseColor("#ff0000"));
            UNITLASCON.setText("not available");
        }


        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (mContext instanceof UnitsPageActivity)
                {
                    UnitsPageActivity activity = (UnitsPageActivity) mContext;
                    //activity.SiteDialogCreation(currentItem);


                }

            }
        });
        return  row;
    }

    public  String str_remove(String s)
    {
        //System.out.println("time:"+s);
        try
        {

            String string = s;
            StringBuilder sb = new StringBuilder(string);
            sb.deleteCharAt(10);
            sb.delete(15,s.length()); //23
            String SECOND= sb.substring(10,sb.length());
            String FIRST = sb.substring(0,10);
            //System.out.println("old = " + FIRST +" " + SECOND);
            return  FIRST +" " + SECOND;

        }
        catch (Exception ex)
        {
            return  s;
        }
    }

}
