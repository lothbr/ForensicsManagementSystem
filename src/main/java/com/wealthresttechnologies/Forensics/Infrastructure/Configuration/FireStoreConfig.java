package com.wealthresttechnologies.Forensics.Infrastructure.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class FireStoreConfig {

    @Bean
    public Firestore firestore() throws IOException {
        // Load service account key from resources
        InputStream serviceAccount = getClass().getResourceAsStream("/firestoreCredentials.json");
        if (serviceAccount == null) {
            throw new IOException("Service account key file not found");
        }

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        // Initialize Firebase only once
        if (FirebaseApp.getApps().isEmpty()) {
            FirebaseApp.initializeApp(options);
        }

        return FirestoreClient.getFirestore();
    }
}