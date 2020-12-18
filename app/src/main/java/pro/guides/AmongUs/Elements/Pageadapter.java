package pro.guides.AmongUs.Elements;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class Pageadapter extends FragmentStatePagerAdapter {
    private  int nbrtabs ;
    public Pageadapter(FragmentManager fm , int nbr){
        super(fm);
        this.nbrtabs = nbr;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){

            case  0:
                return  new Maps();
            case  1:
                return  new Groups();
            case  2:
                return  new Colors();
            case  3:
                return  new Locations();
            case  4:
                return  new Abilities();
            case  5:
                return  new Tasks();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return nbrtabs;
    }
}
