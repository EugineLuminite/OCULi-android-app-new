package oculimobile.oculi.Adaptors;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

import oculimobile.oculi.ActivitiesViewModels.SitesPageActivity;
import oculimobile.oculi.ObjectsToUse.Site;
import oculimobile.oculi.R;
public class SiteListAdapter extends ArrayAdapter<Site> implements Filterable
{
    Context mContext;
    int mLayoutResourceId;
    protected ArrayList<Site> OriginalList;

    public SiteListAdapter(Context context, int layoutResourceId) {
        super(context, layoutResourceId);

        mContext = context;
        mLayoutResourceId = layoutResourceId;
        OriginalList = new ArrayList<Site>();;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        final Site currentItem = getItem(position);

        if (row == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(mLayoutResourceId, parent, false);
        }

        row.setTag(currentItem);
        final TextView SiteNames = (TextView) row.findViewById(R.id.SiteNames);
        SiteNames.setText(currentItem.getName());
        final TextView instaldates = (TextView) row.findViewById(R.id.instaldates);
        //instaldates.setText(currentItem.getInstallDate());

        String dataa = currentItem.getInstallDate() ;
        if(dataa.length()>4)
        {
            String  s = str_remove(dataa);
            instaldates.setText("Install Date:" +s);
            instaldates.setTextColor(Color.parseColor("#327f64"));

        }
        if(dataa.equals("null"))
        {
            instaldates.setText("not available");
            instaldates.setTextColor(Color.parseColor("#ff0000"));
        }


        final TextView cameranumber = (TextView) row.findViewById(R.id.cameranumber);
        cameranumber.setText(currentItem.getEmail());


        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (mContext instanceof SitesPageActivity)
                {
                    SitesPageActivity activity = (SitesPageActivity) mContext;
                    //activity.SiteDialogCreation(currentItem);

                    // activity.TCP_PICTURE(EVENT);
                }

            }
        });
        return  row;
    }




    public  String str_remove(String s)
    {
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

    public Filter getFilter()
    {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint)
            {
                return null;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results)
            {

            }
        };
    }



}
