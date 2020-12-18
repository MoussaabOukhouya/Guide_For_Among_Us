package pro.guides.AmongUs.Elements;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.ads.AdSettings;
import com.facebook.ads.InterstitialAd;

import pro.guides.AmongUs.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Maps#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Maps extends Fragment {

    CardView card1;
    CardView card2;
    CardView card3;
    private InterstitialAd interstitialAd;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Maps() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Maps.
     */
    // TODO: Rename and change types and number of parameters
    public static Maps newInstance(String param1, String param2) {
        Maps fragment = new Maps();
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
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_maps, container, false);
        Button jump = (Button)view.findViewById(R.id.butt_one);
        Button dive = (Button)view.findViewById(R.id.butt_two);
        Button grab = (Button)view.findViewById(R.id.button_three);

        interstitialAd = new InterstitialAd(getContext(), "403547533942358_403556487274796");
        interstitialAd.loadAd();


        card1 = (CardView) view.findViewById(R.id.card1);
        card2 = (CardView) view.findViewById(R.id.card2);
        card3 = (CardView) view.findViewById(R.id.card3);

        final TextView jumpT = (TextView)view.findViewById(R.id.jump);
        final TextView diveT = (TextView)view.findViewById(R.id.dive);
        final TextView grabT = (TextView)view.findViewById(R.id.grab);

        jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grabT.setVisibility(View.GONE);
                diveT.setVisibility(View.GONE);
                jumpT.setVisibility(View.VISIBLE);

                card1.setVisibility(View.VISIBLE);
                card2.setVisibility(View.GONE);
                card3.setVisibility(View.GONE);

                if(interstitialAd.isAdLoaded())
                    interstitialAd.show();
                interstitialAd.loadAd();

            }
        });

        grab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jumpT.setVisibility(View.GONE);
                diveT.setVisibility(View.GONE);
                grabT.setVisibility(View.VISIBLE);

                card1.setVisibility(View.GONE);
                card2.setVisibility(View.GONE);
                card3.setVisibility(View.VISIBLE);

                if(interstitialAd.isAdLoaded())
                    interstitialAd.show();
                interstitialAd.loadAd();

            }
        });

        dive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grabT.setVisibility(View.GONE);
                jumpT.setVisibility(View.GONE);
                diveT.setVisibility(View.VISIBLE);

                card1.setVisibility(View.GONE);
                card2.setVisibility(View.VISIBLE);
                card3.setVisibility(View.GONE);

                if(interstitialAd.isAdLoaded())
                    interstitialAd.show();
                interstitialAd.loadAd();

            }
        });



        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(interstitialAd != null)
            interstitialAd.destroy();
    }
}