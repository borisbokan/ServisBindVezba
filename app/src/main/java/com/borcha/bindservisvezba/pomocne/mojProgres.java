package com.borcha.bindservisvezba.pomocne;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

@SuppressLint("ValidFragment")
public class mojProgres extends DialogFragment{
    Context cont;
    ProgressDialog proDia;
    CharSequence naslov;
    CharSequence poruka;


    public mojProgres(Context _cont,CharSequence _naslov){
        cont=_cont;
        naslov=_naslov;

    }
    public mojProgres(Context _cont,CharSequence _naslov,CharSequence _poruka){
        cont=_cont;
        naslov=_naslov;
        poruka=_poruka;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(false);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        proDia=new ProgressDialog(cont);
        proDia.setTitle(naslov);
        proDia.setMessage(poruka);
        proDia.setIndeterminate(true);
        proDia.setCancelable(false);
        proDia.show();

        return proDia;



    }

    public void setPoruka(CharSequence _poruka){
        if(proDia!=null){

            proDia.setMessage(_poruka);
        }

    }


    public void stopMojProgres(){

        this.dismiss();
    }
}
