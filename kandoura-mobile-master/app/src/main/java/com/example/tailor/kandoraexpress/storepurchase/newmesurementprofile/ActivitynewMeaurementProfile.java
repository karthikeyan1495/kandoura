package com.example.tailor.kandoraexpress.storepurchase.newmesurementprofile;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.ActivityNewneasurementprofileBinding;
import com.example.tailor.kandoraexpress.storepurchase.newmesurementprofile.viewmodal.NewmeasurementprofileVm;

public class ActivitynewMeaurementProfile extends AppCompatActivity {

    ActivityNewneasurementprofileBinding binding;
    NewmeasurementprofileVm newmeasurementprofileVm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bindview();
    }

    private void bindview() {

        binding= DataBindingUtil.setContentView(this, R.layout.activity_newneasurementprofile);
        newmeasurementprofileVm=new NewmeasurementprofileVm(this,binding);
        binding.setNewmesurementprofileVm(newmeasurementprofileVm);
        pushscreen(new BodyMeasurement());

        MeasurementTypeClickAction();
    }

    private void MeasurementTypeClickAction() {


        binding.measurementType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final PopupMenu popupMenu=new PopupMenu(getApplicationContext(),v);

                popupMenu.getMenuInflater().inflate(R.menu.newmesurementprofile_menu,popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        int id=item.getItemId();

                        if(R.id.bodymesurement==id){
                            binding.measurementType.setText("Body Measurement");
                            pushscreen(new BodyMeasurement());

                        }else {
                            binding.measurementType.setText("Kandora Measurement");
                            pushscreen(new KandoraMeasurement());
                        }

                        return true;
                    }
                });


                popupMenu.show();

            }
        });

    }

    private void pushscreen(Fragment fragment) {

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.measurement_layout, fragment)
                .commit();

    }


}
