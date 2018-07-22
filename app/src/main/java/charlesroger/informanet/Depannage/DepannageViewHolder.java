package charlesroger.informanet.Depannage;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import charlesroger.informanet.R;

/**
 * Created by Charles Roger on 13/07/2018.
 */

public class DepannageViewHolder extends RecyclerView.ViewHolder {

        final TextView date;
        final TextView title;
        final ImageView icon;


    public DepannageViewHolder(View view) {
            super(view);
            this.date = view.findViewById(R.id.cardDate);
            this.title = view.findViewById(R.id.cardDescription);
            this.icon = view.findViewById(R.id.icon);

        }

    public TextView getDate() {
        return date;
    }

    public void bind(final Depannage depannage, final DepannageAdapter.OnItemClickListener shortListener, final DepannageAdapter.OnItemLongClickListener longListener) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shortListener.onItemClick(depannage);
            }
        });
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return longListener.onItemLongClick(depannage);
            }
        });
    }
    public TextView getTitle() {
        return title;
    }
    public ImageView getIcon() {
        return icon;
    }
}
