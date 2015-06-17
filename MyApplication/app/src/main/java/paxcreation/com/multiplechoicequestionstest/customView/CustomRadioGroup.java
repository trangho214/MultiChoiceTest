package paxcreation.com.multiplechoicequestionstest.customView;

import android.content.Context;
import android.view.View;
import android.widget.RadioGroup;

/**
 * Created by Administrator on 16/06/2015.
 */
public class CustomRadioGroup extends RadioGroup implements RadioGroup.OnCheckedChangeListener{
    public OnRadioButtonListener onRadioButtonListener;

    public CustomRadioGroup(Context context) {
        super(context);
    }

    public CustomRadioGroup(Context context, OnRadioButtonListener onRadioButtonListener) {
        super(context);
        this.onRadioButtonListener = onRadioButtonListener;
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        View radioButton = group.findViewById(checkedId);
        int index = group.indexOfChild(radioButton);
        onRadioButtonListener.onRadioListener(index);
    }

    public interface OnRadioButtonListener{
        void onRadioListener(int position);
    }
}
