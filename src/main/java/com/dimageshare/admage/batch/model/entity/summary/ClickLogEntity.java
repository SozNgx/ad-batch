package com.dimageshare.admage.batch.model.entity.summary;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "click_log")
@Data
public class ClickLogEntity {
    @Id
    @Column
    private Long id;
}
