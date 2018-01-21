package com.example.rc.chatproj;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class ActivityReg extends AppCompatActivity {
    private EditText editName, editLog, editPass, editPass1;
    private String etName, etLog, etPass, etPass1;
    Button buttonReg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        editName = (EditText) findViewById(R.id.etName);
        editLog = (EditText) findViewById(R.id.etLog);
        editPass = (EditText) findViewById(R.id.etPass);
        editPass1 = (EditText) findViewById(R.id.etPass1);
        buttonReg = (Button) findViewById(R.id.buttonReg);


        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    register();
            }
        });
    }
    public void register (){
        initialize();
        if (!validate()) {
            Toast.makeText(this, "Niepoprawna rejestracja", Toast.LENGTH_SHORT).show();
        }
        else{
            onSignupSuccess();
        }
    }
    public void onSignupSuccess(){
        Intent successIntent = new Intent (ActivityReg.this, MainActivity.class);
        ActivityReg.this.startActivity(successIntent);
        Toast.makeText(this, "Sukces, można się zalogować!", Toast.LENGTH_LONG).show();
        // TODO: DODANIE DO BAZY
    }
    public boolean validate(){ //sprawdzanie czy poszczególne pola są wypełnione
        boolean valid = true;
        if (etName.isEmpty()) {
            editName.setError("Proszę podać Imię");
            valid = false;
        }
        if (etLog.isEmpty()||etLog.length()>20) {
        editLog.setError("Proszę podać prawidłową nazwę");
        valid=false;
        }
        if (etPass.isEmpty()||etPass.length()<7) {
            editPass.setError("Proszę podać hasło zgodne z wymogami");
            valid = false;
        }
        if (etPass1.isEmpty()) {
            editPass1.setError("Proszę potwierdzić hasło");
            valid = false;
        }
        if (!etPass.equals(etPass1)){ //Sprawdzanie czy hasła są zgodne
            editPass.setError("Hasła nie są zgodne");
            editPass1.setError("Hasła nie są zgodne");
            valid = false;
        }
        return valid;

    }
    public void initialize(){
        etName=editName.getText().toString().trim();
        etLog=editLog.getText().toString().trim();
        etPass=editPass.getText().toString().trim();
        etPass1=editPass1.getText().toString().trim();
    }


/*    private boolean validate() {
        boolean temp=true;
        final EditText etPass = (EditText) findViewById(R.id.etPass);
        final EditText etPass1 = (EditText) findViewById(R.id.etPass1);
        String pw = etPass.getText().toString();
        String pw1 = etPass1.getText().toString();
        if (!pw.equals(pw1)){
            Toast.makeText(this, "Hasła nie są takie same", Toast.LENGTH_SHORT).show();
            temp=false;
        }
        return temp;
    }
*/
}
