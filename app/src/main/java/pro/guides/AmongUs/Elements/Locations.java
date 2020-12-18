package pro.guides.AmongUs.Elements;

import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.ads.InterstitialAd;

import pro.guides.AmongUs.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Locations#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Locations extends Fragment {

    LinearLayout dotsLayout;
    sliderAdapter sliderAdapter;
    TextView[] dots;
    Button check;
    ImageButton next;
    ViewPager viewPager;
    int currPosition;
    InterstitialAd interstitialAd;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Locations() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Locations.
     */
    // TODO: Rename and change types and number of parameters
    public static Locations newInstance(String param1, String param2) {
        Locations fragment = new Locations();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Location admin = new Location("Admin", getString(R.string.admin), R.drawable.admin);
        Location cafeteria = new Location("Cafeteria", getString(R.string.cafeteria), R.drawable.cafeteria);
        Location security = new Location("Security", getString(R.string.security), R.drawable.security);
        Location exterior = new Location("Exterior", getString(R.string.exterior), R.drawable.exterior);
        Location storage = new Location("Storage", getString(R.string.storage), R.drawable.storage);

        final Location[] locations = {admin, cafeteria, security, exterior, storage};

        View view = inflater.inflate(R.layout.fragment_locations, container, false);
        interstitialAd = new InterstitialAd(getContext(), "403547533942358_403613410602437");
        interstitialAd.loadAd();
        showAdWithDelay();

        sliderAdapter = new sliderAdapter(getContext(), locations);
        viewPager = view.findViewById(R.id.slider);
        dotsLayout = view.findViewById(R.id.dots);
        next = view.findViewById(R.id.next);

        sliderAdapter = new sliderAdapter(getContext(), locations);
        viewPager.setAdapter(sliderAdapter);
        adddots(0);
        viewPager.addOnPageChangeListener(changeListener);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = currPosition + 1;
                viewPager.setCurrentItem(currPosition + 1);
                if (x > viewPager.getCurrentItem()) {
                    viewPager.setCurrentItem(0);
                    currPosition = 0;
                }
            }
        });

        next.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        v.getBackground().setColorFilter(0xe0f47521, PorterDuff.Mode.SRC_ATOP);
                        v.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        v.getBackground().clearColorFilter();
                        v.invalidate();
                        break;
                    }
                }
                return false;
            }
        });


        return view;
    }

    private void showAdWithDelay() {
        /**
         * Here is an example for displaying the ad with delay;
         * Please do not copy the Handler into your project
         */
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // Check if interstitialAd has been loaded successfully
                if(interstitialAd == null || !interstitialAd.isAdLoaded()) {
                    return;
                }
                // Check if ad is already expired or invalidated, and do not show ad if that is the case. You will not get paid to show an invalidated ad.
                if(interstitialAd.isAdInvalidated()) {
                    return;
                }
                // Show the ad
                interstitialAd.show();
            }
        }, 1000 * 60 * 2); // Show the ad after 15 minutes
    }


    private void adddots(int position) {

        dotsLayout.removeAllViews();
        dots = new TextView[5];
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(getContext());
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0) {
            dots[position].setTextColor(getResources().getColor(R.color.colorAccent));
        }

    }


    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            if (viewPager.getCurrentItem() == viewPager.getAdapter().getCount())
                viewPager.setCurrentItem(0);
        }

        @Override
        public void onPageSelected(final int position) {
            adddots(position);
            currPosition = position;

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(interstitialAd != null)
            interstitialAd.destroy();

    }
}
