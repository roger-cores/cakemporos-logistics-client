package in.cakemporos.logistics.cakemporoslogistics.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import in.cakemporos.logistics.cakemporoslogistics.R;

/**
 * Created by maitr on 31-Jul-16.
 */
public class RateCardActivity extends AppCompatActivity {
    private ImageButton home;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_card);
        //find views
        home=(ImageButton)findViewById(R.id.home_img_button_rate_card);
        //onclick
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
