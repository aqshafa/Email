package com.example.email;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText toEmail = null;
    private EditText emailSubject = null;
    private EditText emailBody = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toEmail = findViewById(R.id.toEmail);
        emailSubject = findViewById(R.id.subject);
        emailBody = findViewById(R.id.emailBody);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_clear:
                toEmail.setText("");
                emailBody.setText("");
                emailSubject.setText("");
                break;
            case R.id.menu_send:
                String to = toEmail.getText().toString();
                String subject = emailSubject.getText().toString();
                String message = emailBody.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[] {to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_EMAIL, message);

                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client"));
                break;
        }
        return true;
    }
}
