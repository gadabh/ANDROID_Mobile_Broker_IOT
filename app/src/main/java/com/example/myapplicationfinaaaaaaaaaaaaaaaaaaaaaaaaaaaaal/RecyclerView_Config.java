package com.example.myapplicationfinaaaaaaaaaaaaaaaaaaaaaaaaaaaaal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerView_Config {
    private Context mContext ;
    private PersonnesAdapter mPersonnesAdapter;

    public void setConfig(RecyclerView recyclerView , Context context , List<Personne> personnes , List<String> Keys ){
        mContext = context ;
        mPersonnesAdapter = new PersonnesAdapter(personnes, Keys);
        recyclerView.setLayoutManager(new LinearLayoutManager( context));
        recyclerView.setAdapter(mPersonnesAdapter);
    }


    class PersonneItemView extends RecyclerView.ViewHolder {
        private TextView mTitle;
        private TextView mAuthor;
        private TextView mISBN ;
        private TextView mCategory ;

        private String Key ;


        public PersonneItemView(ViewGroup parent) {
            super(LayoutInflater.from(mContext).inflate(R.layout.personne_list_item, parent, false));
            mTitle = (TextView) itemView.findViewById(R.id.title_textView);
            mAuthor = (TextView) itemView.findViewById(R.id.author_txtView);

        }

            public void bind(Personne personne ,String key){
                mTitle.setText(personne.getDate_and_Time());
                mAuthor.setText(personne.getName());
                this.Key = key ;

            }
        }
        class PersonnesAdapter extends RecyclerView.Adapter<PersonneItemView> {
        private List<Personne> mPersonneList ;
        private List<String> mKey ;

            public PersonnesAdapter(List<Personne> mPersonneList, List<String> mKey) {
                this.mPersonneList = mPersonneList;
                this.mKey = mKey;
            }

            @NonNull
            @Override
            public PersonneItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new PersonneItemView( parent);
            }

            @Override
            public void onBindViewHolder(@NonNull PersonneItemView holder, int position) {
                holder.bind(mPersonneList.get(position),mKey.get(position));
            }

            @Override
            public int getItemCount() {
                return mPersonneList.size();
            }
        }



}
