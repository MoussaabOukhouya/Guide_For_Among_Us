package pro.guides.AmongUs.Elements;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import pro.guides.AmongUs.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Colors#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Colors extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Colors() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Colors.
     */
    // TODO: Rename and change types and number of parameters
    public static Colors newInstance(String param1, String param2) {

        Colors fragment = new Colors();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    mycara red = new mycara("Red",R.drawable.red);
    mycara blue = new mycara("Blue",R.drawable.blue);
    mycara brown = new mycara("Brown",R.drawable.brown);
    mycara cyan = new mycara("Cyan",R.drawable.cyan);
    mycara green = new mycara("Green",R.drawable.green);
    mycara lime = new mycara("Lime",R.drawable.lime);
    mycara orange = new mycara("Orange",R.drawable.orange);
    mycara pink = new mycara("Pink",R.drawable.pink);
    mycara purple = new mycara("Purple",R.drawable.purple);
    mycara yellow = new mycara("Yellow",R.drawable.yellow);
    ListView lv;
    ArrayList<mycara> weapons = new ArrayList<mycara>();

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
        View view = inflater.inflate(R.layout.fragment_colors, container, false);

        lv = view.findViewById(R.id.heavyview);

        weapons.add(red); weapons.add(blue); weapons.add(brown); weapons.add(cyan); weapons.add(green);
        weapons.add(lime); weapons.add(orange); weapons.add(pink); weapons.add(purple); weapons.add(yellow);

        Adapter adapter = new Adapter(getContext(),R.id.myyyview,weapons);
        lv.setAdapter(adapter);

        return  view;
    }
}