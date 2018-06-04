package com.ronald.playingwithwhatsapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;


public class Popups extends DialogFragment{


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.dialog_NoMessage)
                .setTitle(R.string.dialog_ErrorTitle)
                .setIcon(android.R.drawable.ic_dialog_info)

        ;

        return builder.create();
    }

}
