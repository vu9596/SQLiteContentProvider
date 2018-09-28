package vunt.com.vn.sqlitecontentprovider;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ListContactFragment extends Fragment {
    private View mView;
    private MyAdapter mAdapter;
    private ArrayList<MyContact> mMyContacts;
    private MyAdapter.OnItemSelectedListener mListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mListener = (MyAdapter.OnItemSelectedListener) activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_list_contact, container, false);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mMyContacts = new ArrayList<>();
        intView();
        initData();
    }

    private void intView() {
        RecyclerView recyclerView = mView.findViewById(R.id.recycler_list_contact);
        recyclerView.setHasFixedSize(true);
        mAdapter = new MyAdapter(mMyContacts, mListener);
        recyclerView.setAdapter(mAdapter);
    }

    private void initData() {
        MyProvider myProvider = new MyProvider(getActivity());
        mMyContacts.clear();
        mMyContacts.addAll(myProvider.getContactFormDevice());
        mAdapter.notifyDataSetChanged();
    }
}
