package com.example.api.service;

import com.example.api.domain.Coupon;
import com.example.api.repository.AppliedUserRepository;
import com.example.api.repository.CouponCountRepository;
import com.example.api.repository.CouponRepository;
import com.example.api.producer.CouponCreateProducer;
import org.springframework.stereotype.Service;

@Service
public class ApplyService {

    private final CouponRepository couponRepository;

    private final CouponCountRepository couponCountRepository;

    private final CouponCreateProducer couponCreateProducer;

    private final AppliedUserRepository appliedUserRepository;

    public ApplyService(CouponRepository couponRepository,
        CouponCountRepository couponCountRepository,
        CouponCreateProducer couponCreateProducer,
        AppliedUserRepository appliedUserRepository
    ) {
        this.couponRepository = couponRepository;
        this.couponCountRepository = couponCountRepository;
        this.couponCreateProducer = couponCreateProducer;
        this.appliedUserRepository = appliedUserRepository;
    }

    public void apply(Long userId) {

        Long apply = appliedUserRepository.add(userId);
//        long count = couponRepository.count();

        if (apply != 1) {
            return;
        }

        Long count = couponCountRepository.increment();

        if (count > 100) {
            return;
        }

        // couponRepository.save(new Coupon(userId));
        couponCreateProducer.create(userId);
    }
}
