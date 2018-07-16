package charlesroger.informanet;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

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

    private List<Depannage> depannageList;
    private final LayoutInflater mInflater;
    private final OnItemClickListener shortListener;
    private Context cont;
    private Depannage depannage;
    private int position;

    public DepannageAdapter(Context context, OnItemClickListener shortListener) {
        mInflater = LayoutInflater.from(context);
        this.shortListener = shortListener;
        this.cont = context;
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

        Depannage a = depannageList.get(position);
        this.position = position;


        holder.getDate().setText(a.getDate());
        holder.getTitle().setText(a.getTitre());
        //holder.getIcon().setImageResource(R.drawable.emergency1);


       /* holder.getForward().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Incident incident = incidentList.get(position);
                System.out.println("Try to forward " + incident);
                if (incident.getAdvancement() < 3) {
                    incident.setAdvancement(incident.getAdvancement() + 1);
                    incidentList.remove(incident);
                    incident.changeShow();
                    setIncident(incidentList);
                    System.out.println("Forward succeed");
                }

            }
        });    */

    }

}
