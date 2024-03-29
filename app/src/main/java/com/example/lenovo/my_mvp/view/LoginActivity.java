package com.example.lenovo.my_mvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lenovo.my_mvp.R;
import com.example.lenovo.my_mvp.presenter.ILoginPresenter;
import com.example.lenovo.my_mvp.presenter.LoginPresenterCompl;

public class LoginActivity extends AppCompatActivity implements ILoginView, View.OnClickListener {

    private Button mLogin;
    private Button mClear;
    private EditText mName;
    private EditText mPassWord;

    ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLogin = findViewById(R.id.btn_login);
        mClear = findViewById(R.id.btn_clear);
        mName = findViewById(R.id.et_name);
        mPassWord = findViewById(R.id.et_password);

        mLogin.setOnClickListener(this);
        mClear.setOnClickListener(this);

        loginPresenter = (ILoginPresenter) new LoginPresenterCompl(this);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        String name = mName.getText().toString();
        String password = mPassWord.getText().toString();

        switch (id) {
            case R.id.btn_login:
                loginPresenter.doLogin(name, password);
                break;
            case R.id.btn_clear:
                loginPresenter.clear();
                break;
        }

    }

    @Override
    public void onClearText() {
        mName.setText("");
        mPassWord.setText("");
        Toast.makeText(this, "clear", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginResult(Boolean result, int code) {
        mLogin.setEnabled(true);
        mClear.setEnabled(true);
        if (result) {
            Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
        }
    }
}
