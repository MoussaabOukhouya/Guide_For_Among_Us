package pro.guides.AmongUs.Elements;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkAds;
import com.google.android.material.tabs.TabLayout;

import pro.guides.AmongUs.R;

public class Guide extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    private AdView adView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        AudienceNetworkAds.initialize(this);

        adView = new AdView(this, "403547533942358_403548090608969", AdSize.BANNER_HEIGHT_50);

        // Find the Ad Container
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);

        // Add the ad view to your activity layout
        adContainer.addView(adView);

        // Request an ad
        adView.loadAd();

        toolbar =(Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout)findViewById(R.id.mytablayout);

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



        final ViewPager viewPager = (ViewPager)findViewById(R.id.myviewpager);
        final Pageadapter pageadapter = new Pageadapter(getSupportFragmentManager(),tabLayout.getTabCount()) ;
        viewPager.setAdapter(pageadapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));



        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });

    }



}