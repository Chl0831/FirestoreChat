// Firebase 모듈 가져오기
import { initializeApp } from "https://www.gstatic.com/firebasejs/11.2.0/firebase-app.js";
import { getFirestore } from "https://www.gstatic.com/firebasejs/11.2.0/firebase-firestore.js";

// Firebase 설정 정보
const firebaseConfig = {
    apiKey: "AIzaSyDOjts_ehNi6wwwnxse6zDshU_Q58kmus4",
    authDomain: "minipaws-47208.firebaseapp.com",
    databaseURL: "https://minipaws-47208-default-rtdb.firebaseio.com",
    projectId: "minipaws-47208",
    storageBucket: "minipaws-47208.firebasestorage.app",
    messagingSenderId: "914587937694",
    appId: "1:914587937694:web:aa1249014b4eb58dbac48f",
    measurementId: "G-F0PW3TDJ8H"
};

// Firebase 앱 초기화 및 Firestore 가져오기
const app = initializeApp(firebaseConfig);
const db = getFirestore(app);

// `db` 객체를 내보내기(export)
export { db };