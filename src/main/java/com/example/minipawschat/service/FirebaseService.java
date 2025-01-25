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

    public void getMessages(String roomId) throws ExecutionException, InterruptedException {
        QuerySnapshot snapshot = firestore.collection("chatRooms").document(roomId)
                .collection("messages").orderBy("timestamp").get().get();
        //orderBy("timestamp") : 메시지를 시간 순으로 정렬하여 가지고 옴

        for (QueryDocumentSnapshot document : snapshot) {
            System.out.println("Sender: " + document.getString("sender"));
            System.out.println("Message: " + document.getString("text"));
            System.out.println("Time: " + document.getLong("timestamp"));
        }
    }

    //실시간 연동 -> js로 옮겨야함.
//    public void listenForNewMessages(String roomId) throws ExecutionException, InterruptedException {
//        firestore.collection("chatRooms").document(roomId)
//                .collection("messages").addSnapshotListener((snapshot, e) -> {
//                    if (e != null) {
//                        System.out.println("리스너 오류 : "+e.getMessage());
//                        return;
//                    }
//
//                    for (QueryDocumentSnapshot document : snapshot) {
//                        System.out.println("새메시지: " + document.getString("text"));
//                    }
//                });
//    }

}
