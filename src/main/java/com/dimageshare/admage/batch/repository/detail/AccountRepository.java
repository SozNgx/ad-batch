package com.dimageshare.admage.batch.repository.detail;

import com.dimageshare.admage.batch.model.entity.detail.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
}
