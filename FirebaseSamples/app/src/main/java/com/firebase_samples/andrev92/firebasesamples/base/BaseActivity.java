package com.firebase_samples.andrev92.firebasesamples.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Iterator;

import butterknife.ButterKnife;
import rx.Subscription;

/**
 * Created by avlad92 on 10/1/2016.
 */
public abstract class BaseActivity extends AppCompatActivity {
    private ArrayList<Subscription> mSubscriptions;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getActivityLayout());
        ButterKnife.bind(this);
        mSubscriptions = new ArrayList<>();
        addSubscriptions();
    }


    public abstract int getActivityLayout();
    public void addSubscription(Subscription subscription){
        mSubscriptions.add(subscription);
    }

    public void removeSubscription(Subscription subscription){
        subscription.unsubscribe();
        mSubscriptions.remove(subscription);
    }


    public void removeAllSubscriptions(){
        Iterator<Subscription> iterator = mSubscriptions.iterator();
        while (iterator.hasNext()){
            Subscription subscription = iterator.next();
            subscription.unsubscribe();
        }
        mSubscriptions.clear();
    }

    @Override
    protected void onDestroy() {
        removeAllSubscriptions();
        super.onDestroy();
    }

    public abstract void addSubscriptions();
}
