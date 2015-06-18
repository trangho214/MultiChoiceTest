package paxcreation.com.multiplechoicequestionstest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import paxcreation.com.multiplechoicequestionstest.entity.Answer;

/**
 * Created by Administrator on 18/06/2015.
 */
public class ResultAdapter extends BaseAdapter {
    Context context;
    List<Answer> answers;
    LayoutInflater inflater;

    public ResultAdapter(Context context, List<Answer> answers)
    {
        this.context = context;
        this.answers = answers;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return answers.size();
    }

    @Override
    public Answer getItem(int position) {
        return answers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return null;
    }
}
