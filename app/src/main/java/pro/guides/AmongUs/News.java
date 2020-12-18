package pro.guides.AmongUs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.InterstitialAd;

public class News extends AppCompatActivity {

    private WebView mWebview ;
    private AdView adView;
    Toolbar toolbar;
    private InterstitialAd interstitialAd;


    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        toolbar =(Toolbar) findViewById(R.id.toolbar);

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

        interstitialAd = new InterstitialAd(this, "403547533942358_403612700602508");
        interstitialAd.loadAd();

        adView = new AdView(this,"403547533942358_403563317274113", AdSize.BANNER_HEIGHT_50);

        // Find the Ad Container
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);

        // Add the ad view to your activity layout
        adContainer.addView(adView);

        adView.loadAd();

        mWebview = findViewById(R.id.webview);

        mWebview.getSettings().setJavaScriptEnabled(true); // enable javascript

        mWebview.setWebViewClient(new WebViewClient());

        mWebview .loadUrl("https://innersloth.itch.io/among-us/devlog");
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(interstitialAd.isAdLoaded())
            interstitialAd.show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(adView != null)
            adView.destroy();
        if(interstitialAd != null)
            interstitialAd.destroy();
    }
}
