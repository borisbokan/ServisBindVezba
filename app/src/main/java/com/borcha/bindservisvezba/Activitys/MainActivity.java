package com.borcha.bindservisvezba.Activitys;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.borcha.bindservisvezba.R;
import com.borcha.bindservisvezba.Services.MyService;
import com.borcha.bindservisvezba.Services.MyService.MyBinder;

public class MainActivity extends AppCompatActivity {

     Button btnDajVreme;

    MyService myService;
    boolean isBound=false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDajVreme=(Button)findViewById(R.id.btnStarBindServis);


        startujServis();
    }

    public void startBindServis(View v){

        btnDajVreme.setText(myService.trenutnoVreme());
        Toast.makeText(this,"Datum: " + myService.trenutnoDatum(),Toast.LENGTH_LONG).show();


    }


    private void startujServis(){
        Intent intBindServis=new Intent(this, MyService.class);
        bindService(intBindServis,myConnServ, Context.BIND_AUTO_CREATE);
        isBound=true;
    }





    private ServiceConnection myConnServ=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
           MyBinder mybinder=(MyBinder) service;
           myService=mybinder.getMyService();
           isBound=true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
               if(myService!=null){
                   myService=null;
               }
        }
    };

}
