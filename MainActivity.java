package com.drivespace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button bLogout;
    EditText etName, etAge, etUsername;
    UserLocalStorage userLocalStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.etName);
        etAge = (EditText) findViewById(R.id.etAge);
        etUsername = (EditText) findViewById(R.id.etUsername);

        bLogout = (Button) findViewById(R.id.bLogout);

        bLogout.setOnClickListener(this);

        userLocalStorage = new UserLocalStorage(this);

    }

    @Override
    protected void onStart() {
        super.onStart();

        if (authenticate() == true){
            displayUserDetails();
        }

    }

    private boolean authenticate(){
        return userLocalStorage.getUserLoggedIn();
    }

    private void displayUserDetails(){
        User user = userLocalStorage.getLoggedInUser();

        etUsername.setText(user.username);
        etName.setText(user.name);
        etAge.setText(user.age + "");

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.bLogout:
                userLocalStorage.clearUserData();
                userLocalStorage.setUserLoggedIn(false);

                startActivity(new Intent(this,Login.class));

                break;
        }
    }
}