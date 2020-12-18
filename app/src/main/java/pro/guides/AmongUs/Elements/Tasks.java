package pro.guides.AmongUs.Elements;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.facebook.ads.InterstitialAd;

import java.util.ArrayList;

import pro.guides.AmongUs.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Tasks#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tasks extends Fragment {

    InterstitialAd interstitialAd;

    final ArrayList<mytask> tasks = new ArrayList<mytask>();
    final ArrayList<mytask> short_one = new ArrayList<mytask>();
    final ArrayList<mytask> common_one = new ArrayList<mytask>();
    final ArrayList<mytask> long_one = new ArrayList<mytask>();
    ListView lv;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Tasks() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Tasks.
     */
    // TODO: Rename and change types and number of parameters
    public static Tasks newInstance(String param1, String param2) {
        Tasks fragment = new Tasks();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tasks, container, false);
        mytask ClearAsteroids = new mytask("Clear Asteroids","Short",getString(R.string.asteroids_gameplay),getString(R.string.asteroids_maps),R.drawable.clearasteroids);
        mytask StartReactor = new mytask("Start Reactor","Long",getString(R.string.star_reactor_gameplay),getString(R.string.star_reactor_maps),R.drawable.startreactor);
        mytask SubmitScan = new mytask("Submit Scan","Long",getString(R.string.submit_scan_gameplay),getString(R.string.submit_scan_maps),R.drawable.submitscan);
        mytask SwipeCard = new mytask("Swipe Card","Common",getString(R.string.swipe_card_gameplay),getString(R.string.swipe_card_maps),R.drawable.swipecard);
        mytask EmptyGarbage = new mytask("Empty Garbage","Short",getString(R.string.empty_garbage_gameplay),getString(R.string.empty_garbage_maps),R.drawable.emptygarbage);
        mytask FixWiring = new mytask("Fix Wiring","Common",getString(R.string.fixwiring_gameplay),getString(R.string.fixwiring_maps),R.drawable.fikwiring);

        mytask[] alltasks = {ClearAsteroids,StartReactor,SubmitScan,SwipeCard,EmptyGarbage,FixWiring};

        interstitialAd = new InterstitialAd(getContext(), "403547533942358_403618640601914");
        interstitialAd.loadAd();

        for(int i = 0;i<alltasks.length;i++){
            if(alltasks[i].getType().equals("Short"))
                short_one.add(alltasks[i]);
            else if(alltasks[i].getType().equals("Long"))
                long_one.add(alltasks[i]);
            else if(alltasks[i].getType().equals("Common"))
                common_one.add(alltasks[i]);
            tasks.add(alltasks[i]);
        }

        final Button all = (Button)view.findViewById(R.id.all);
        final Button shor = (Button)view.findViewById(R.id.shor);
        final Button common = (Button)view.findViewById(R.id.commo);
        final Button lon = (Button)view.findViewById(R.id.lon);
        lv = view.findViewById(R.id.heavyview);

        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tasksAdapter adapter = new tasksAdapter(getContext(),R.id.myyyview,tasks);
                lv.setAdapter(adapter);
                all.setBackgroundResource(R.drawable.selected);
                shor.setBackgroundResource(R.drawable.unselected);
                lon.setBackgroundResource(R.drawable.unselected);
                common.setBackgroundResource(R.drawable.unselected);
            }
        });

        shor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tasksAdapter adapter = new tasksAdapter(getContext(),R.id.myyyview,short_one);
                lv.setAdapter(adapter);
                all.setBackgroundResource(R.drawable.unselected);
                shor.setBackgroundResource(R.drawable.selected);
                lon.setBackgroundResource(R.drawable.unselected);
                common.setBackgroundResource(R.drawable.unselected);
            }
        });

        common.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tasksAdapter adapter = new tasksAdapter(getContext(),R.id.myyyview,common_one);
                lv.setAdapter(adapter);
                all.setBackgroundResource(R.drawable.unselected);
                shor.setBackgroundResource(R.drawable.unselected);
                lon.setBackgroundResource(R.drawable.unselected);
                common.setBackgroundResource(R.drawable.selected);
            }
        });

        lon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tasksAdapter adapter = new tasksAdapter(getContext(),R.id.myyyview,long_one);
                lv.setAdapter(adapter);
                all.setBackgroundResource(R.drawable.unselected);
                shor.setBackgroundResource(R.drawable.unselected);
                lon.setBackgroundResource(R.drawable.selected);
                common.setBackgroundResource(R.drawable.unselected);
            }
        });


        final tasksAdapter adapter = new tasksAdapter(getContext(),R.id.myyyview,tasks);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(interstitialAd.isAdLoaded())
                    interstitialAd.show();
                Intent intent = new Intent(getContext(),taskdetails.class);
                intent.putExtra("task", (mytask) adapter.getItem(i));
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
    }
}