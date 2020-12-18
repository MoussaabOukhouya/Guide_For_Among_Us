package pro.guides.AmongUs.Elements;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.ads.InterstitialAd;

import pro.guides.AmongUs.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Abilities#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Abilities extends Fragment {

    LinearLayout sabotage;
    LinearLayout kill;
    LinearLayout report;
    LinearLayout admin;
    LinearLayout vent;
    LinearLayout security;
    InterstitialAd interstitialAd;
    InterstitialAd interstitialAd2;




    Button all;
    Button crew;
    Button impo;

    Button read;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Abilities() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Abilities.
     */
    // TODO: Rename and change types and number of parameters
    public static Abilities newInstance(String param1, String param2) {
        Abilities fragment = new Abilities();
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
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_abilities, container, false);

        report = (LinearLayout)view.findViewById(R.id.report);
        kill = (LinearLayout)view.findViewById(R.id.kill);
        sabotage = (LinearLayout)view.findViewById(R.id.sabotage);
        vent = (LinearLayout)view.findViewById(R.id.venta);
        admin = (LinearLayout)view.findViewById(R.id.admina);
        security = (LinearLayout)view.findViewById(R.id.security);

        interstitialAd = new InterstitialAd(getContext(), "403547533942358_403616660602112");
        interstitialAd.loadAd();

        interstitialAd2 = new InterstitialAd(getContext(), "403547533942358_403617843935327");
        interstitialAd2.loadAd();




        all = (Button)view.findViewById(R.id.all);
        crew = (Button)view.findViewById(R.id.crew);
        impo = (Button)view.findViewById(R.id.impo);

        read = (Button)view.findViewById(R.id.readmore);

        final TextView sabo = (TextView) view.findViewById(R.id.saboa);
        final TextView adma = (TextView)view.findViewById(R.id.admia);
        final TextView killa = (TextView)view.findViewById(R.id.killa);
        final TextView venta = (TextView)view.findViewById(R.id.vent);
        final TextView repo = (TextView)view.findViewById(R.id.repora);
        final TextView sec = (TextView)view.findViewById(R.id.securitya);

        impo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(interstitialAd.isAdLoaded())
                    interstitialAd.show();
                interstitialAd.loadAd();
              admin.setVisibility(View.GONE);
              security.setVisibility(View.GONE);

              sabo.setVisibility(View.GONE);
              adma.setVisibility(View.GONE);
              killa.setVisibility(View.GONE);
              venta.setVisibility(View.GONE);
              repo.setVisibility(View.GONE);
              sec.setVisibility(View.GONE);

              kill.setVisibility(View.VISIBLE);
              vent.setVisibility(View.VISIBLE);
              sabotage.setVisibility(View.VISIBLE);
              report.setVisibility(View.VISIBLE);

              impo.setBackgroundResource(R.drawable.selected);
              crew.setBackgroundResource(R.drawable.unselected);
              all.setBackgroundResource(R.drawable.unselected);

              read.setVisibility(View.GONE);


            }
        });

        crew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(interstitialAd.isAdLoaded())
                    interstitialAd.show();
                    interstitialAd.loadAd();

                kill.setVisibility(View.GONE);
                vent.setVisibility(View.GONE);
                sabotage.setVisibility(View.GONE);

                sabo.setVisibility(View.GONE);
                adma.setVisibility(View.GONE);
                killa.setVisibility(View.GONE);
                venta.setVisibility(View.GONE);
                repo.setVisibility(View.GONE);
                sec.setVisibility(View.GONE);

                report.setVisibility(View.VISIBLE);
                admin.setVisibility(View.VISIBLE);
                security.setVisibility(View.VISIBLE);

                impo.setBackgroundResource(R.drawable.unselected);
                crew.setBackgroundResource(R.drawable.selected);
                all.setBackgroundResource(R.drawable.unselected);

                read.setVisibility(View.GONE);


            }
        });

        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kill.setVisibility(View.VISIBLE);
                vent.setVisibility(View.VISIBLE);
                sabotage.setVisibility(View.VISIBLE);
                report.setVisibility(View.VISIBLE);
                admin.setVisibility(View.VISIBLE);
                security.setVisibility(View.VISIBLE);

                sabo.setVisibility(View.GONE);
                adma.setVisibility(View.GONE);
                killa.setVisibility(View.GONE);
                venta.setVisibility(View.GONE);
                repo.setVisibility(View.GONE);
                sec.setVisibility(View.GONE);

                impo.setBackgroundResource(R.drawable.unselected);
                all.setBackgroundResource(R.drawable.selected);
                crew.setBackgroundResource(R.drawable.unselected);

                read.setVisibility(View.GONE);

            }
        });


        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sabo.setVisibility(View.GONE);
                adma.setVisibility(View.GONE);
                killa.setVisibility(View.GONE);
                venta.setVisibility(View.GONE);
                repo.setVisibility(View.VISIBLE);
                sec.setVisibility(View.GONE);
                read.setVisibility(View.GONE);
            }
        });

        sabotage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sabo.setVisibility(View.VISIBLE);
                adma.setVisibility(View.GONE);
                killa.setVisibility(View.GONE);
                venta.setVisibility(View.GONE);
                repo.setVisibility(View.GONE);
                sec.setVisibility(View.GONE);
                read.setVisibility(View.VISIBLE);
            }
        });

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sabo.setVisibility(View.GONE);
                adma.setVisibility(View.VISIBLE);
                killa.setVisibility(View.GONE);
                venta.setVisibility(View.GONE);
                repo.setVisibility(View.GONE);
                sec.setVisibility(View.GONE);
                read.setVisibility(View.GONE);
            }
        });

        kill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sabo.setVisibility(View.GONE);
                adma.setVisibility(View.GONE);
                killa.setVisibility(View.VISIBLE);
                venta.setVisibility(View.GONE);
                repo.setVisibility(View.GONE);
                sec.setVisibility(View.GONE);
                read.setVisibility(View.GONE);
            }
        });

        security.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sabo.setVisibility(View.GONE);
                adma.setVisibility(View.GONE);
                killa.setVisibility(View.GONE);
                venta.setVisibility(View.GONE);
                repo.setVisibility(View.GONE);
                sec.setVisibility(View.VISIBLE);
                read.setVisibility(View.GONE);
            }
        });

        vent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sabo.setVisibility(View.GONE);
                adma.setVisibility(View.GONE);
                killa.setVisibility(View.GONE);
                venta.setVisibility(View.VISIBLE);
                repo.setVisibility(View.GONE);
                sec.setVisibility(View.GONE);
                read.setVisibility(View.GONE);
            }
        });


        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), details.class);
                if(interstitialAd2.isAdLoaded())
                    interstitialAd2.show();
                startActivity(intent);
            }
        });


        return view;
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        if(interstitialAd != null)
            interstitialAd.destroy();
        if(interstitialAd2 != null)
            interstitialAd2.destroy();
    }
}