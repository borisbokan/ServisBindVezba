package com.borcha.bindservisvezba.Services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.borcha.bindservisvezba.pomocne.Datumi;

public class MyService extends Service {

    final private  IBinder myBinder=new MyBinder();
    public MyService() {}

    @Override
    public IBinder onBind(Intent intent) {
       return myBinder;
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

    public class MyBinder extends Binder {
        public MyService getMyService(){
            return MyService.this;
        }
    }
}
