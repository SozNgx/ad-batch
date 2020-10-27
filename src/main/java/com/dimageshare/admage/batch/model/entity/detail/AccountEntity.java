package com.dimageshare.admage.batch.model.entity.detail;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
@Data
public class AccountEntity {
    @Id
    private Long id;
}
