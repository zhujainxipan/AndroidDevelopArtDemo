package com.example.annuoaichengzhang.androiddevelopartdemo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/**
 * Created by niehongtao on 16/4/13.
 */
public class MyAlertDialogFragment extends DialogFragment {

    /**
     * 这不是单例
     * @param title
     * @return
     */
    public static MyAlertDialogFragment newInstance(int title) {
        MyAlertDialogFragment frag = new MyAlertDialogFragment();
        Bundle args = new Bundle();
        args.putInt("title", title);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int title = getArguments().getInt("title");

        return new AlertDialog.Builder(getActivity())
                .setIcon(R.mipmap.ic_launcher)
                .setTitle(title + "")
                .setPositiveButton("ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                ((DialogActivity)getActivity()).doPositiveClick();
                            }
                        }
                )
                .setNegativeButton("no",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                ((DialogActivity)getActivity()).doNegativeClick();
                            }
                        }
                )
                .create();
    }
}
