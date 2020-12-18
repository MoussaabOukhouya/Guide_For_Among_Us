package pro.guides.AmongUs.Elements;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import pro.guides.AmongUs.R;

public class Adapter extends ArrayAdapter {

    private Context mContext;
    private List<mycara> character ;
    private  int mResource;
    LayoutInflater inflater;

    public Adapter(@NonNull Context context, int resource, @NonNull List<mycara> objects) {
        super(context, resource, objects);
        this.mContext = context ;
        this.mResource = resource ;
        this.character = objects ;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null){
            convertView=inflater.from(mContext).inflate(R.layout.row,parent,false);
        }
        TextView weapname = convertView.findViewById(R.id.weapname);

        ImageView weapimage = convertView.findViewById(R.id.img);

        weapname.setText(character.get(position).getName());
        weapimage.setImageResource(character.get(position).getImage());



        return  convertView;
    }


}
