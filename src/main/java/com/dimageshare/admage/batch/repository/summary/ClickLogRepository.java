package com.dimageshare.admage.batch.repository.summary;

import com.dimageshare.admage.batch.model.entity.summary.ClickLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClickLogRepository extends JpaRepository<ClickLogEntity, Long> {
}
