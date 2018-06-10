package net.atshq.firebasecloudmessagewithcloudfunction;

import android.accessibilityservice.GestureDescription;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessaging;

import javax.sql.StatementEvent;

public class MainActivity extends AppCompatActivity {

    private EditText etMessage;
    private DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etMessage=findViewById(R.id.etMessage);
        dbRef=FirebaseDatabase.getInstance().getReference().child("Root").child("Message");

        String key = dbRef.push().getKey();
        dbRef=dbRef.child(key);
        FirebaseMessaging.getInstance().subscribeToTopic("allUser");

    }

    public void sendClick(View view) {
        String msg = etMessage.getText().toString();

        if(TextUtils.isEmpty(msg)){
            etMessage.setError("Empty Field Found ....");
        }else {
            String time =String.valueOf(System.currentTimeMillis());
            dbRef.push().setValue(new ModelClass(msg,time));
            etMessage.setText("");
        }
    }
}
