package com.oriensolutions.bottomnavigationbar1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {

    MeowBottomNavigation bottomNavigation;

    RelativeLayout setting_layout, home_layout, profile_layout, main_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        setting_layout = findViewById(R.id.setting_layout);
//        home_layout = findViewById(R.id.home_layout);
//        profile_layout = findViewById(R.id.profile_layout);


        main_layout = findViewById(R.id.main_layout);

//        setting_layout.setVisibility(View.GONE);
//        home_layout.setVisibility(View.VISIBLE);
//        profile_layout.setVisibility(View.GONE);


        bottomNavigation = findViewById(R.id.bottomNavigation);

        //For Default Fragment
        replace(new HomeFragment());

        bottomNavigation.show(2, true);// this is for default layout

        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.baseline_settings_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.baseline_home_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.baseline_person_24));

        meownavigation();
        main_layout.setBackgroundColor(Color.parseColor("#FFFFFFFF"));

    }//=============================ON create End=====================================

    private void meownavigation() {

        bottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {


                switch (model.getId()) {
                    case 1:
                        replace(new SettingFragment());
//                        setting_layout.setVisibility(View.VISIBLE);
//                        home_layout.setVisibility(View.GONE);
//                        profile_layout.setVisibility(View.GONE);

                        main_layout.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                        break;
                    case 2:
                        replace(new HomeFragment());
//                        setting_layout.setVisibility(View.GONE);
//                        home_layout.setVisibility(View.VISIBLE);
//                        profile_layout.setVisibility(View.GONE);

                        main_layout.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                        break;
                    case 3:
                        replace(new ProfileFragment());
//                        setting_layout.setVisibility(View.GONE);
//                        home_layout.setVisibility(View.GONE);
//                        profile_layout.setVisibility(View.VISIBLE);

                        main_layout.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                        break;
                }

                return null;
            }
        });

    }

    private void replace(Fragment fragment) {

//        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framelayout, fragment);
        transaction.commit();

    }

}//=============================Code End=====================================