package pro.guides.AmongUs.Elements;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.InterstitialAd;

import pro.guides.AmongUs.R;

public class details extends AppCompatActivity {

    Toolbar toolbar;
    InterstitialAd interstitialAd;
    private AdView adView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        toolbar = findViewById(R.id.toolbar);
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
        adView = new AdView(this,"403547533942358_403635593933552", AdSize.BANNER_HEIGHT_50);

        // Find the Ad Container
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);

        // Add the ad view to your activity layout
        adContainer.addView(adView);

        adView.loadAd();

        interstitialAd = new InterstitialAd(this, "403547533942358_403624250601353");
        interstitialAd.loadAd();

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
        if(interstitialAd != null)
            interstitialAd.destroy();
        if(adView != null)
            adView.destroy();
    }
}