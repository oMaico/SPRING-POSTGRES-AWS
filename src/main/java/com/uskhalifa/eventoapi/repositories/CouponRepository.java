package com.uskhalifa.eventoapi.repositories;

import com.uskhalifa.eventoapi.domain.coupon.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CouponRepository extends JpaRepository <Coupon, UUID> {
}
