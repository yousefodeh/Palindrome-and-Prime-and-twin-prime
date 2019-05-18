package com.example.project;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    Switch simpleSwitch1,simpleSwitch2,simpleSwitch3;
    private Button b;
    private EditText number;
    TextView l,l1,l2;
   	volatile  boolean s=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleSwitch1 = (Switch) findViewById(R.id.switch2);
        simpleSwitch2 = (Switch) findViewById(R.id.switch3);
        simpleSwitch3 = (Switch) findViewById(R.id.switch4);
        l=findViewById ( R.id.enter);
        l1=findViewById ( R.id.enter1);
        l2=findViewById ( R.id.enter2);
        b=findViewById ( R.id.bb);
        number=findViewById ( R.id.number );
        number.addTextChangedListener ( new TextWatcher () {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }


            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                l.callOnClick ();
                l1.callOnClick ();
                l2.callOnClick ();

            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        } );


        simpleSwitch1.setOnCheckedChangeListener(this);
        simpleSwitch2.setOnCheckedChangeListener(this);
        simpleSwitch3.setOnCheckedChangeListener(this);
        l.setOnClickListener ( this );
        l1.setOnClickListener ( this );
        l2.setOnClickListener ( this );
        b.setOnClickListener ( this );
    }

    public static boolean isPalindrome(Long integer) {
        String intStr = String.valueOf(integer);
        return intStr.equals(new StringBuilder(intStr).reverse().toString());
    }
    public static boolean isPrimeNumber(Long i) {
        int factors = 0;
        int j = 1;

        while(j <= i)
        {
            if(i % j == 0)
            {
                factors++;
            }
            j++;
        }
        return (factors == 2);
    }
    @Override
    public void onClick(View v) {

        if (v==l||v==l1||v==l2){

            String s= number.getText ().toString ();

            if (!s.isEmpty ()) {

                Long n = Long.parseLong(s);

                if (isPalindrome(n)){
                    simpleSwitch1.setChecked(true);
                    l.setText("Palindrome");

                }
                else if(!isPalindrome(n)){
                    simpleSwitch1.setChecked(false);
                    l.setText("Not Palindrome");

                }

                if (isPrimeNumber(n)){

                    StringBuilder sb = new StringBuilder(s);
                    Long n1 = Long.parseLong(sb.reverse().toString());

                    if (isPrimeNumber(n1)){
                        simpleSwitch3.setChecked(true);
                        l2.setText("A twin prime");

                    }
                    if (!isPrimeNumber(n1)){
                        simpleSwitch3.setChecked(false);
                        l2.setText("Not a twin prime");

                    }
                    simpleSwitch2.setChecked(true);
                    l1.setText("Prime");

                }
                else  if (!isPrimeNumber(n)){
                    simpleSwitch2.setChecked(false);
                    simpleSwitch3.setChecked(false);
                    l1.setText("Not Prime");
                    l2.setText("Not a twin prime");
                }
            }
            else if(s.isEmpty()){
                simpleSwitch1.setChecked(false);
                simpleSwitch2.setChecked(false);
                simpleSwitch3.setChecked(false);
                l.setText(" ");
                l1.setText(" ");
                l2.setText(" ");}


        }

        if(v==b){
            Toast.makeText ( this,"* Clear *",Toast.LENGTH_SHORT ).show();
            simpleSwitch1.setChecked(false);
            simpleSwitch2.setChecked(false);
            simpleSwitch3.setChecked(false);
            number.setText("");
            l.setText(" ");
            l1.setText(" ");
            l2.setText(" ");
        } }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
          if(  s==true){
              Toast.makeText ( this,"* ,,,, *",Toast.LENGTH_SHORT ).show();
          }
    }
}}
