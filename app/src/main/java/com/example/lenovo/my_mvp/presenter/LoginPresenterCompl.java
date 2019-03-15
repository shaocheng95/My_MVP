package com.example.lenovo.my_mvp.presenter;

import com.example.lenovo.my_mvp.model.User;
import com.example.lenovo.my_mvp.view.ILoginView;

public class LoginPresenterCompl implements ILoginPresenter {
    private ILoginView loginView;
    private User user;

    public LoginPresenterCompl(ILoginView loginView) {
        this.loginView = loginView;
        user = new User("张三", "123456");
    }

    @Override
    public void clear() {
        loginView.onClearText();
    }

    @Override
    public void doLogin(String name, String password) {
        boolean result = false;
        int code = 0;
        if (name.equals(user.getName()) && password.equals(user.getPassword())) {
            result = true;
            code = 1;
        } else {
            result = false;
            code = 0;
        }
        loginView.onLoginResult(result, code);
    }
}
