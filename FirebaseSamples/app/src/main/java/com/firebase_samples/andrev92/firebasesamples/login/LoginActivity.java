package com.firebase_samples.andrev92.firebasesamples.login;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.firebase_samples.andrev92.firebasesamples.R;
import com.firebase_samples.andrev92.firebasesamples.base.BaseActivity;
import com.jakewharton.rxbinding.widget.RxTextView;

import butterknife.BindView;
import rx.Subscription;
import rx.functions.Action1;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.et_log_user)
    EditText etUserName;

    @BindView(R.id.et_password)
    EditText etPassword;

    @BindView(R.id.btn_log)
    Button btnLogin;

    @BindView(R.id.btn_register)
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public int getActivityLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void addSubscriptions() {
        addSubscription(RxTextView.textChanges(etUserName)
                .subscribe(user->{
                    if(user.length() == 0)
                        btnLogin.setEnabled(false);
                    else
                        btnLogin.setEnabled(true);
                }));
    }


}
