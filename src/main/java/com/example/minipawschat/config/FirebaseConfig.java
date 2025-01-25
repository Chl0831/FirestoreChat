package com.example.minipawschat.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;

/**
 * Created on 2025-01-23 by 최윤서
 */
@Configuration
public class FirebaseConfig {

    @Value("${firebase.database.url}")
    private String firebaseUrl;

    @Value("${firebase.config.path}")
    private String firebaseConfigPath;

    @PostConstruct
    // Spring의 라이프사이클 콜백
    //애플리케이션이 실행되면 한 번만 실행되어 Firebase를 설정
    public void init() {
        try {
            //서비스 계정의 JSON 파일 로드
            FileInputStream serviceAccount = new FileInputStream(firebaseConfigPath);

            //Firebase 옵션설정 (firebase에 인증, url설정 등)
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl(firebaseUrl)
                    .build();

            //Firebase App 초기화
            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
                System.out.println("FirebaseApp 초기화");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Firebase 초기화 실패 : "+ e.getMessage());
        }
    }

}
