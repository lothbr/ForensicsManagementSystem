package com.wealthresttechnologies.Forensics.Infrastructure.Services;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.wealthresttechnologies.Forensics.Data.Entities.Clients;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class ClientService {

    private final Firestore firestore;

    public ClientService(Firestore firestore){
        this.firestore = firestore;
    }
    public String saveClients(Clients client) throws ExecutionException, InterruptedException {
        DocumentReference docRef = firestore.collection("Clients").document(client.getId());
        ApiFuture<WriteResult> result = docRef.set(client);
        return "Client saved at: " + result.get().getUpdateTime();
    }
}
