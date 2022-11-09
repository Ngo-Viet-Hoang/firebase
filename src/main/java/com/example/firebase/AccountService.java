package com.example.firebase;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class AccountService {
    public String createAccount(Account account) throws ExecutionException, InterruptedException {
        Firestore dbFireStore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFireStore.collection("users").document(account.getUsername()).set(account);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }
    public Account getAccount(String accountId) throws ExecutionException, InterruptedException {
        Firestore dbFireStore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFireStore.collection("users").document(accountId);
        ApiFuture< DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        Account account;
        if(document.exists()){
            account = document.toObject(Account.class);
            return account;
        }
        return null;
    }
    public String updateAccount(Account account){
        return "";
    }
    public String deleteAccount(String accountId){
        Firestore dbFireStore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFireStore.collection("users").document(accountId).delete();
        return "Successfully deleted" + accountId;
    }
}
