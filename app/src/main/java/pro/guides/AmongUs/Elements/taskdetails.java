package pro.guides.AmongUs.Elements;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.InterstitialAd;

import pro.guides.AmongUs.R;

public class taskdetails extends AppCompatActivity {

    TextView gameplay;
    ImageView taskImage;
    mytask task;
    Toolbar toolbar;
    TextView barname;
    private InterstitialAd interstitialAd;
    private AdView adView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taskdetails);

        Intent intent = getIntent();
        task = (mytask) intent.getSerializableExtra("task");

        interstitialAd = new InterstitialAd(this, "403547533942358_403620517268393");
        interstitialAd.loadAd();

        adView = new AdView(this,"403547533942358_403635903933521", AdSize.BANNER_HEIGHT_50);

        // Find the Ad Container
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);

        // Add the ad view to your activity layout
        adContainer.addView(adView);

        adView.loadAd();

        toolbar = findViewById(R.id.toolbar);
        barname = findViewById(R.id.barName);

        barname.setText(task.getName());

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_ios_24);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }


        taskImage = (ImageView) findViewById(R.id.taskimage);
        gameplay = (TextView) findViewById(R.id.gameplay);

        taskImage.setImageResource(task.getImg());
        gameplay.setText(task.getGameplay());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(interstitialAd.isAdLoaded())
            interstitialAd.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(interstitialAd!=null)
        interstitialAd.destroy();
        if(adView != null)
            adView.destroy();
    }
}