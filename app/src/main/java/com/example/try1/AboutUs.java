package com.example.try1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;


public class AboutUs extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        getSupportActionBar().hide();


        Element adsElement = new Element();

//
        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setImage(R.drawable.hospital)
                .setDescription("Inspire Healthcare is a masterpiece which provides complete solution for appointment booking , consulting ,payment ,providing lab  reports ,medicine purchasing and much more." +
                        "Basically, we work to make your life more comfortable and safe during this crucial time of pandemic ." +
                        " Our Tagline 'Your Health is our concern' explains solely our project idea.")
                .addItem(new Element().setTitle("Version 1.0 "))
                .addGroup("ABOUT DEVELOPERS !")
                .addGroup("CSE Students at Dr. D Y Patil School Of Engineering & Technology, Lohegoan ,Pune")
                .addWebsite("https://www.linkedin.com/in/anukul-muley-010819178","LinkedIn Anukul Muley")
                .addWebsite("https://www.linkedin.com/in/shanmukh-kumbhar-a14155193","LinkedIn Shanmukh Kumbhar")
                .addWebsite("https://www.linkedin.com/in/hanumant-jain-621745173","LinkedIn Hanumant Jain")
                .addWebsite("https://www.linkedin.com/in/priti-maheshwari-a32b8b1bb","LinkedIn Priti Maheshwari")
                .addGroup("CONNECT WITH US!")
                .addEmail("contactus.inspirehealthcare@gmail.com")
                .addGitHub("hanumantjain/e-healthcareproject")
                //.addYoutube("UCbekhhidkzkGryM7m5Ys_w")   //Enter your youtube link here (replace with my channel link)
                .addPlayStore("com.example.try1")   //Replace all this with your package name
                //.addInstagram("Inspire  Healthcare ")    //Your instagram id
                .addItem(createCopyright())
                .create();
        setContentView(aboutPage);
    }

    private Element createCopyright() {
        Element copyright = new Element();
        @SuppressLint("DefaultLocale") final String copyrightString = String.format("Copyright %d Inspire Healthcare", Calendar.getInstance().get(Calendar.YEAR));
        copyright.setTitle(copyrightString);
        // copyright.setIcon(R.mipmap.ic_launcher);
        copyright.setGravity(Gravity.CENTER);
        copyright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AboutUs.this, copyrightString, Toast.LENGTH_SHORT).show();
            }
        });
        return copyright;
    }


    public void getDescription() {
        Element description = new Element();
        description.setGravity(Gravity.CENTER_VERTICAL);
    }
}