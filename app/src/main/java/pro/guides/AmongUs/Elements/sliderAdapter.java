package pro.guides.AmongUs.Elements;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.viewpager.widget.PagerAdapter;

import com.zolad.zoominimageview.ZoomInImageView;

import pro.guides.AmongUs.R;

public class sliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;
    Location[] rounds;


    public sliderAdapter(Context context , Location[] rounds) {
        this.context = context;
        this.rounds = rounds;
    }



    @Override
    public int getCount() {
        return rounds.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        return view == (NestedScrollView)object ;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slides_layout,container,false);

        ZoomInImageView imageView = view.findViewById(R.id.slider_image);
        TextView header = view.findViewById(R.id.slider_header);
        TextView desc = view.findViewById(R.id.slider_desc);

        imageView.setImageResource(rounds[position].getImage());
        header.setText(rounds[position].getName());
        desc.setText(rounds[position].getDesc());
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((NestedScrollView)object);
    }
}