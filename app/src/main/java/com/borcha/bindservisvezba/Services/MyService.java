package com.borcha.bindservisvezba.Services;

import android.app.ProgressDialog;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.UiThread;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.ThemedSpinnerAdapter;

import com.borcha.bindservisvezba.pomocne.Datumi;
import com.borcha.bindservisvezba.pomocne.mojProgres;

public class MyService extends Service {





    final private  IBinder myBinder=new MyBinder();
    private ProgressDialog progres;

    public MyService() {}

    @Override
    public IBinder onBind(Intent intent) {
       return myBinder;
    }




    public class MyBinder extends Binder {
        public MyService getMyService(){
            return MyService.this;
        }
    }

    public String trenutnoVreme(){
        long longDate=System.currentTimeMillis();
        Datumi dat=new Datumi();
        String datum=dat.vremeIZMilisek(longDate);
        return datum;
    }

    public String trenutnoDatum(){
        long longDate=System.currentTimeMillis();
        Datumi dat=new Datumi();
        String datum=dat.datumIZMilisek(longDate);
        return datum;
    }




}
