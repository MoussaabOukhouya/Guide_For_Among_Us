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

public class tasksAdapter extends ArrayAdapter {


    private Context mContext;
    private List<mytask> task ;
    private  int mResource;
    LayoutInflater inflater;

    public tasksAdapter(@NonNull Context context, int resource, @NonNull List<mytask> objects) {
        super(context, resource, objects);
        this.mContext = context ;
        this.mResource = resource ;
        this.task = objects ;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null){
            convertView=inflater.from(mContext).inflate(R.layout.rowtasks,parent,false);
        }
        TextView weapname = convertView.findViewById(R.id.weapname);
        TextView maps = convertView.findViewById(R.id.map);
        ImageView weapimage = convertView.findViewById(R.id.img);

        weapname.setText(task.get(position).getName());
        weapimage.setImageResource(task.get(position).getImg());
        maps.setText(task.get(position).getMaps());



        return  convertView;
    }
}
