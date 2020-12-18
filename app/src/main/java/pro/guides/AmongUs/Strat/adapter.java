package pro.guides.AmongUs.Strat;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import pro.guides.AmongUs.Elements.Abilities;
import pro.guides.AmongUs.Elements.Colors;
import pro.guides.AmongUs.Elements.Groups;
import pro.guides.AmongUs.Elements.Locations;
import pro.guides.AmongUs.Elements.Maps;
import pro.guides.AmongUs.Elements.Tasks;

public class adapter extends FragmentStatePagerAdapter {
    private  int nbrtabs ;
    public adapter(FragmentManager fm , int nbr){
        super(fm);
        this.nbrtabs = nbr;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){

            case  0:
                return  new Impostor();
            case  1:
                return  new Crewmate();

            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return nbrtabs;
    }
}
