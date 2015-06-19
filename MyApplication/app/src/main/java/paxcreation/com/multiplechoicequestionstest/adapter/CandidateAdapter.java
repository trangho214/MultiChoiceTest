package paxcreation.com.multiplechoicequestionstest.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.List;
import java.util.zip.Inflater;

import paxcreation.com.multiplechoicequestionstest.R;
import paxcreation.com.multiplechoicequestionstest.entity.Candidate;

/**
 * Created by Administrator on 18/06/2015.
 */
public class CandidateAdapter extends BaseAdapter {
    Context context;
    List<Candidate> candidates;
    LayoutInflater inflater;
    public CandidateAdapter(Context context, List<Candidate> candidates){
        this.context = context;
        this.candidates = candidates;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return candidates.size();
    }

    @Override
    public Candidate getItem(int position) {
        return candidates.get(position);
    }

    @Override
    public long getItemId(int position) {
        return candidates.get(position).getId();
    }

    public static class ViewHolder{
        TextView txtName;
        TextView txtCreatedAt;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        Candidate currentCandidate = getItem(position);
        if(rowView == null)
        {
            rowView = inflater.inflate(R.layout.candidate_element,null);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.txtName = (TextView)rowView.findViewById(R.id.txtName_CandidateElement);
            viewHolder.txtCreatedAt= (TextView)rowView.findViewById(R.id.txtCreatedAt_CandidateElement);
            rowView.setTag(viewHolder);
        }

        ViewHolder vh =(ViewHolder)rowView.getTag();
        vh.txtName.setText(currentCandidate.getName());
        Log.d("candidate name", currentCandidate.getName());
        vh.txtCreatedAt.setText(millisecondsToDateTime(currentCandidate.getCreate_at()));
        return rowView;
    }

    private String millisecondsToDateTime(long milliseconds)
    {
//        txtTimer.setText(String.format("%02d:%02d", (durationSeconds % 3600) / 60, (durationSeconds % 60)));
        return DateFormat.getDateInstance(DateFormat.LONG).format(milliseconds);
    }
}
