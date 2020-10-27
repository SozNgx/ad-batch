package com.dimageshare.admage.batch.model.entity.summary;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "summary_acticle")
@Data
public class SummaryActicleEntity {
    @Id
    @Column(name = "summary_id")
    private Long summaryId;
}
