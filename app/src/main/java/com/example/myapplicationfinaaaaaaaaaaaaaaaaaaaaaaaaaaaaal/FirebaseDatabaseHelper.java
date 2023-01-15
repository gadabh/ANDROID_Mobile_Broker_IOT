package com.example.myapplicationfinaaaaaaaaaaaaaaaaaaaaaaaaaaaaal;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper {


    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferencePerson;
    private List<Personne> personnes =new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<Personne> personnes , List<String> keys );
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();


    }


    public FirebaseDatabaseHelper(){
        mDatabase=FirebaseDatabase.getInstance();
        mReferencePerson= mDatabase.getReference("Personnes");

    }
    public void readPersonnes(final DataStatus dataStatus){
        mReferencePerson.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                personnes.clear();
                List<String> keys =new ArrayList<>();
                for (DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Personne personne = keyNode.getValue(Personne.class);
                    personnes.add(personne);

                }
                dataStatus.DataIsLoaded(personnes,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


}
