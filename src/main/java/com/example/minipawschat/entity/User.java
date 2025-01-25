package com.example.minipawschat.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Created on 2025-01-24 by 최윤서
 */
@Entity
@Table(name = "tbl_user0124")
@Data
public class User {
    @Id
    private String username;
    private String password;
}
