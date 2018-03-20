package com.example.moksh;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.moksh.loginandregister.R;

import java.util.List;

/**
 * Created by moksh on 21/3/18.
 */

    public class CampList extends ArrayAdapter<camps> {

        private Activity context;
        private List<camps> camps;

        public CampList(Activity context,List<camps> camps) {
            super(context, R.layout.layout_camp_list,camps);
            this.context=context;
            this.camps = camps;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View listViewItem = inflater.inflate(R.layout.layout_camp_list,null,true);

            TextView textViewEventname = (TextView) listViewItem.findViewById(R.id.textViewEventname);
            TextView textViewDescription = (TextView) listViewItem.findViewById(R.id.textViewDesc);
            TextView textViewOrzanizorName = (TextView) listViewItem.findViewById(R.id.textViewOrganizername);
            TextView textViewOrzanizorPhoneNo = (TextView) listViewItem.findViewById(R.id.textViewOrganizerPhoneNo);


            camps camp = camps.get(position);

            textViewEventname.setText(camp.getEventName());
            textViewDescription.setText(camp.getDescription());
            textViewOrzanizorName.setText(camp.getOrganizerName());
            textViewOrzanizorPhoneNo.setText(camp.getMobNo());

            return listViewItem;

        }
    }

