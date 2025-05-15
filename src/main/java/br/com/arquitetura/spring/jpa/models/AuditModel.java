package br.com.arquitetura.spring.jpa.models;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditModel {

    @CreatedDate
    @Column(name = "date_registered", nullable = false, updatable = false)
    private LocalDateTime dateRegistered;

    @CreatedBy
    @Size(max = 20)
    @Column(length = 20, name = "user_registered", nullable = false, updatable = false)
    private String userRegistered;

    @LastModifiedDate
    @Column(name = "date_changed")
    private LocalDateTime dateChanged;

    @LastModifiedBy
    @Size(max = 20)
    @Column(length = 20, name = "user_changed")
    private String userChanged;

    public LocalDateTime getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(LocalDateTime dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public String getUserRegistered() {
        return userRegistered;
    }

    public void setUserRegistered(String userRegistered) {
        this.userRegistered = userRegistered;
    }

    public LocalDateTime getDateChanged() {
        return dateChanged;
    }

    public void setDateChanged(LocalDateTime dateChanged) {
        this.dateChanged = dateChanged;
    }

    public String getUserChanged() {
        return userChanged;
    }

    public void setUserChanged(String userChanged) {
        this.userChanged = userChanged;
    }
}
