package com.example.usuario.sendmessagebutterknife;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.usuario.sendmessagebutterknife.pojo.Message;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Esta clase envía un mensaje a otra.
 *
 * @author Alfonso Chamorro Valle
 */

public class SendMessageActivity extends AppCompatActivity {

    @BindView(R.id.edtUser)
    EditText edtUser;
    @BindView(R.id.edtMessage)
    EditText edtMessage;
    @BindView(R.id.btnOK)
    Button btnOK;

    private static final String TAG = "com.example.sendmessage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        ButterKnife.bind(this);


        Log.d(TAG, "SendMessage: OnCreate()");
    }

    @OnClick(R.id.btnOK)
    public void getOnClick(View view) {
        switch (view.getId()) {
            case R.id.btnOK:
                MostrarMensaje();
                break;
        }
    }

    private void MostrarMensaje() {
        Bundle bundle = new Bundle();
        Message message = new Message(edtUser.getText().toString(), edtMessage.getText().toString());
        bundle.putSerializable("message", message);
        Intent intent = new Intent(SendMessageActivity.this, ViewMessageActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "SendMessage: OnStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "SendMessage: OnResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "SendMessage: OnPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "SendMessage: OnStop()");
    }
}