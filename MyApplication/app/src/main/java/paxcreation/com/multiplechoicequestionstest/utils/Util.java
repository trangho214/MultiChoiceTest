package paxcreation.com.multiplechoicequestionstest.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.net.ConnectException;
import java.util.List;

import paxcreation.com.multiplechoicequestionstest.entity.Candidate;
import paxcreation.com.multiplechoicequestionstest.entity.MultiChoiceQuestion;
import paxcreation.com.multiplechoicequestionstest.interfaces.IDialog;

/**
 * Created by Administrator on 16/06/2015.
 */
public class Util {
    public static void showConfirmationDialog(Context context, String title, String message, boolean isYesNo,String positiveText, String negativeText,final IDialog iDialog){
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, positiveText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                iDialog.dimissDialog(true);// 1 ---> ok ; 0 --> cancel
            }
        });
        if(isYesNo) {
            alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, negativeText, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    iDialog.dimissDialog(false);
                }
            });
        }
        alertDialog.show();
    }
}
