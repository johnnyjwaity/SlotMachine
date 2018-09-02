package com.johnnywaity.adntest2.slotmachine;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import network.NetworkDelegate;
import network.Network;
import slotmachineserver.NetData;
import slotmachineserver.NetType;

public class MultiConfigActivity extends AppCompatActivity implements NetworkDelegate {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_config);

        Network n = new Network("10.0.0.4", 666);
        n.setNetworkDelegate(this);
        Thread t = new Thread(n);
        t.start();

        Button hostButton = findViewById(R.id.host);
        hostButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                NetData data = new NetData(NetType.Host);
                Network.sharedInstance.sendMessage(data);
            }
        });

        Button joinButton = findViewById(R.id.join);
        joinButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                createAlert().show();
            }
        });
    }

    private AlertDialog.Builder createAlert(){


        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter Game Code");
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);

        builder.setPositiveButton("Enter", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String enterText = input.getText().toString();
                int code = Integer.parseInt(enterText);
                NetData d = new NetData(NetType.Join);
                d.setiData(code);
                Network.sharedInstance.sendMessage(d);
            }
        });
        return builder;

    }


    @Override
    public void onHostMessage(NetData n) {
        final NetData d = n;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                TextView hostCode = findViewById(R.id.hostCodeDisplay);
                hostCode.setText("Your Host Code Is: " + d.getiData());
                hostCode.setVisibility(View.VISIBLE);
            }
        });

    }
}
