package com.mentorship.javaeats.repository;

import com.mentorship.javaeats.model.PreferredPaymentSetting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreferredPaymentSettingRepository extends JpaRepository<PreferredPaymentSetting, Integer> {
}