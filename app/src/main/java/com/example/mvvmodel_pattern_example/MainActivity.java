package com.example.mvvmodel_pattern_example;
// https://www.geeksforgeeks.org/mvvm-model-view-viewmodel-architecture-pattern-in-android/

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mvvmodel_pattern_example.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // ViewModel updates the Model
        // after observing changes in the View

        // model will also update the view
        // via the ViewModel
        ActivityMainBinding activityMainBinding
                = DataBindingUtil.setContentView(
                this, R.layout.activity_main);
        activityMainBinding.setViewModel(
                new AppViewModel());
        activityMainBinding.executePendingBindings();
    }

    // any change in toastMessage attribute
// defined on the Button with bind prefix
// invokes this method
    @BindingAdapter({ "toastMessage" })
    public static void runMe(View view, String message)
    {
        if (message != null)
            Toast
                    .makeText(view.getContext(), message,
                            Toast.LENGTH_SHORT)
                    .show();
    }
}