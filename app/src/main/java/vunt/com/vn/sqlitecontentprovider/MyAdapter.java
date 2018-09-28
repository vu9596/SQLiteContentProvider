package vunt.com.vn.sqlitecontentprovider;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<MyContact> mContacts;
    private OnItemSelectedListener mListener;

    public MyAdapter(ArrayList<MyContact> contacts, OnItemSelectedListener listener) {
        mContacts = contacts;
        mListener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_contact, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bindData(mListener, mContacts.get(position));
    }

    @Override
    public int getItemCount() {
        return mContacts != null ? mContacts.size() : 0;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView mPhoneImage;
        private ImageView mStarImage;
        private TextView mNameText;
        private TextView mPhoneText;

        public MyViewHolder(View itemView) {
            super(itemView);
            mPhoneImage = itemView.findViewById(R.id.image_phone);
            mStarImage = itemView.findViewById(R.id.image_star);
            mNameText = itemView.findViewById(R.id.text_contact_name);
            mPhoneText = itemView.findViewById(R.id.text_contact_phone);
        }

        public void bindData(final OnItemSelectedListener listener, final MyContact contact) {
            if (contact != null) {
                mNameText.setText(contact.getName());
                mPhoneText.setText(contact.getPhone());
            }

            mPhoneImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onPhoneImageSelected(contact.getPhone());
                }
            });
        }
    }

    public interface OnItemSelectedListener {
        void onPhoneImageSelected(String phoneNumber);
    }
}
