package com.thiagomatheusms.materialdesign;

import android.support.design.button.MaterialButton;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.thiagomatheusms.materialdesign.Utils.Mask;

public class RegisterActivity extends AppCompatActivity {

    private TextInputLayout mTextInputLayoutName, mTextInputLayoutPhone, mTextInputLayoutEmail,
            mTextInputLayoutNeighborhood, mTextInputLayoutPassword, mTextInputLayoutAdress, mTextInputLayoutNumber;
    private TextInputEditText mEditTextName, mEditTextPhone, mEditTextEmail, mEditTextNeighborhood, mEditTextPassword,
            mEditTextAdress, mEditTextNumber;
    private MaterialButton mButtonCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mTextInputLayoutName = findViewById(R.id.textInputLayout_registerName);
        mTextInputLayoutEmail = findViewById(R.id.textInputLayout_registerEmail);
        mTextInputLayoutPhone = findViewById(R.id.textInputLayout_registerPhone);
        mTextInputLayoutNeighborhood = findViewById(R.id.textInputLayout_registerNeighborhood);
        mTextInputLayoutPassword = findViewById(R.id.textInputLayout_registerPassword);
        mTextInputLayoutAdress = findViewById(R.id.textInputLayout_registerAdress);
        mTextInputLayoutNumber = findViewById(R.id.textInputLayout_registerStreetNumber);


        mEditTextName = findViewById(R.id.editText_registerName);
        mEditTextEmail = findViewById(R.id.editText_registerEmail);
        mEditTextPhone = findViewById(R.id.editText_phone);
        mEditTextNeighborhood = findViewById(R.id.editeText_registerNeighborhood);
        mEditTextPassword = findViewById(R.id.editText_registerPassword);
        mEditTextAdress = findViewById(R.id.editText_registerAdress);
        mEditTextNumber = findViewById(R.id.editeText_registerStreetNumber);

        mEditTextPhone.addTextChangedListener(Mask.insert("(##)####-####", mEditTextPhone));

        mButtonCreate = findViewById(R.id.btn_registerCreate);
        mButtonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateEditText();
            }
        });

    }


    private void validateEditText() {
        if (mEditTextName.getText().toString().isEmpty()) {
            mTextInputLayoutName.setErrorEnabled(true);
            mTextInputLayoutName.setError(getResources().getText(R.string.java_register_activity_invalid_name));
        } else {
            mTextInputLayoutName.setErrorEnabled(false);
        }

        if (mEditTextPhone.getText().toString().isEmpty()) {
            mTextInputLayoutPhone.setErrorEnabled(true);
            mTextInputLayoutPhone.setError(getResources().getText(R.string.java_register_activity_invalid_phone));
        } else {
            mTextInputLayoutPhone.setErrorEnabled(false);
        }

        if (mEditTextEmail.getText().toString().isEmpty()) {
            mTextInputLayoutEmail.setErrorEnabled(true);
            mTextInputLayoutEmail.setError(getResources().getText(R.string.java_register_activity_invalid_email));
        } else {
            mTextInputLayoutEmail.setErrorEnabled(false);
        }

        if (mEditTextPassword.getText().toString().length() < 8) {
            mTextInputLayoutPassword.setErrorEnabled(true);
            mTextInputLayoutPassword.setError(getResources().getText(R.string.java_register_activity_invalid_password));
        } else {
            mTextInputLayoutPassword.setErrorEnabled(false);
        }

        if (mEditTextAdress.getText().toString().isEmpty()) {
            mTextInputLayoutAdress.setErrorEnabled(true);
            mTextInputLayoutAdress.setError(getResources().getText(R.string.java_register_activity_invalid_adress));
        } else {
            mTextInputLayoutAdress.setErrorEnabled(false);
        }

        if (mEditTextAdress.getText().toString().isEmpty()) {
            mTextInputLayoutAdress.setErrorEnabled(true);
            mTextInputLayoutAdress.setError(getResources().getText(R.string.java_register_activity_invalid_adress));
        } else {
            mTextInputLayoutAdress.setErrorEnabled(false);
        }

        if (mEditTextNeighborhood.getText().toString().isEmpty()) {
            mTextInputLayoutNeighborhood.setErrorEnabled(true);
            mTextInputLayoutNeighborhood.setError(getResources().getText(R.string.java_register_activity_invalid_adress));
        } else {
            mTextInputLayoutNeighborhood.setErrorEnabled(false);
        }

        if (mEditTextNumber.getText().toString().isEmpty()) {
            mTextInputLayoutNumber.setErrorEnabled(true);
            mTextInputLayoutNumber.setError(getResources().getText(R.string.java_register_activity_invalid_adress));
        } else {
            mTextInputLayoutNumber.setErrorEnabled(false);
        }
    }
}
