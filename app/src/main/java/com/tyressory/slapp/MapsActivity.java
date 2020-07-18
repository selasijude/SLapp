package com.tyressory.slapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;


public class MapsActivity extends AppCompatActivity {

    ToggleButton shuttleStatus;
    TextView noStd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        shuttleStatus = (ToggleButton) findViewById(R.id.shuttleStatus);
        noStd = (TextView) findViewById(R.id.studentsCount) ;
        shuttleStatus.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    // Display shuttle full
                    Toast.makeText(MapsActivity.this, "Shuttle is full", Toast.LENGTH_SHORT).show();


                } else{
                    //Display space in shuttle
                    Toast.makeText(MapsActivity.this, "There is available space in shuttle", Toast.LENGTH_SHORT).show();

                }
            }
        });




    }




    // On back pressed
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Really Exit?")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        MapsActivity.super.onBackPressed();
                    }
                }).create().show();
    }

    //ends here



    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.logout:
                Logout();
                return true;

            case R.id.driverProfile:
                Intent intentProfile = new Intent(this, ProfileActivity.class);
                startActivity(intentProfile);
                return true;
            case R.id.driverTerms:
                Intent intentTerms = new Intent(this, DriverTermsActivity.class);
                startActivity(intentTerms);
                return true;

            case R.id.driverSettings:
                Intent intentSettings = new Intent(this, DriverSettingsActivity.class);
                startActivity(intentSettings);
                return true;
        }

        return true;
    }


    public void Logout(){
        Intent intentLogout = new Intent(this, MainActivity.class);
        startActivity(intentLogout);
    }

}
