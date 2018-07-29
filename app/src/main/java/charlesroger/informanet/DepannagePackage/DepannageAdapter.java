package charlesroger.informanet.DepannagePackage;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import charlesroger.informanet.R;

/**
 * Created by Charles Roger on 13/07/2018.
 */

public class DepannageAdapter extends RecyclerView.Adapter<DepannageViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(Depannage depannage);
    }

    public interface OnItemLongClickListener {
        boolean onItemLongClick(Depannage depannage);
    }

    private List<DepannageBis> depannageList;

    private Context cont;
    private Depannage depannage;
    private int position;

    public DepannageAdapter(List<DepannageBis> depannageBisList) {
        this.depannageList = depannageBisList;
    }
    @Override
    public int getItemCount() {
        if (depannageList != null)
            return depannageList.size();
        else return 0;
    }

    @Override
    public DepannageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.depannage_preview, parent, false);
        DepannageViewHolder ivh = new DepannageViewHolder(v);
        return ivh;
    }

    @Override
    public void onBindViewHolder(DepannageViewHolder holder, final int position) {

        DepannageBis a = depannageList.get(position);
        this.position = position;


        holder.getDate().setText(a.getDate());
        holder.getTitle().setText(a.getTitre());
        //holder.getAvatar().setImageBitmap(a);
        holder.description.setText(a.getDescription());

    }

}
