package charlesroger.informanet.DepannagePackage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import charlesroger.informanet.R;

/**
 * Created by user on 13/07/2018.
 */

public class DepannagePreviewFragment  extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_SECTION_NUMBER = "section_number";

    private RecyclerView recyclerView;
    private DepannageAdapter Adapter;
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

    private OnFragmentInteractionListener mListener;
    protected boolean isVisible;

    public DepannagePreviewFragment() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment NewsGridFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DepannagePreviewFragment newInstance(int sectionNumber) {
        DepannagePreviewFragment fragment = new DepannagePreviewFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        System.out.println("Loading Fragment " + sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_depannage_recycler, container, false);
        List<Depannage> depannageList;
        /*incidentList = Data.getInstance().getDataFilteredByLevel(getArguments().getInt(ARG_SECTION_NUMBER));
        final IncidentAdapter adapter = new IncidentAdapter(incidentList);
        RecyclerView recyclerView = view.findViewById(R.id.incidentView);
        recyclerView.setAdapter(adapter);*/
        final RecyclerView recyclerView = view.findViewById(R.id.recyclerView);


      //  this.depannageAdapter = adapter;

       //  recyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(mLayoutManager);

       // refresh();

        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
           // refresh();
        } else {
            isVisible = false;
            //Fragment stored in cache: DO NOTHING
        }
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    /*public void refresh() {
        //this.depannageViewModel = Instance.getInstance().getIncidentViewModel();
        //incidentViewModel.getAllIncident().observe(this, new Observer<List<Incident>>() {
            @Override
            public void onChanged(@Nullable final List<Depannage> depannages) {
                // Update the cached copy of the words in the adapter.
                ArrayList<Depannage> filtered = new ArrayList<Incident>();
                System.out.println(depannage);
                for (Depannage d : depannages) {
                    if (i.getAdvancement() == getArguments().getInt(ARG_SECTION_NUMBER)) {
                        filtered.add(i);
                    }
                }
                incidentAdapter.setIncident(filtered);
            }
        });
    } */

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }
}
