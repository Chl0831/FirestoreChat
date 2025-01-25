package com.example.minipawschat.service;

import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Created on 2025-01-23 by 최윤서
 */
@Service
public class FirebaseService {

    private final Firestore firestore = FirestoreClient.getFirestore();

    public void addMessage(String roomId, String sender, String text) {
        Map<String, Object> message = new HashMap<>();
        message.put("sender", sender);
        message.put("text", text);
        message.put("timestamp", System.currentTimeMillis());

        firestore.collection("chatRooms").document(roomId)
                .collection("messages").add(message);

    }

//    public void addCalender(String roomId, String sender, String text) {
//        Map<String, Object> calender = new HashMap<>();
//    }


}
