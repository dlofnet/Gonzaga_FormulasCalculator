package com.example.gonzaga_formulascalculator.View;

import android.os.Bundle;

import com.example.gonzaga_formulascalculator.databinding.ActivityPhysicsStraightBinding;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gonzaga_formulascalculator.View.ui.main1.SectionsPagerAdapter;

public class PhysicsStraight extends AppCompatActivity {

    private ActivityPhysicsStraightBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPhysicsStraightBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);
    }
}