package com.flow.hirework.repository;

import com.flow.hirework.domain.CustomExtension;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomExtensionRepository extends JpaRepository<CustomExtension, Long> {

    // 차단된 파일 확장자인지 확인하거나 이미 있는 파일 확장자인지 필터링하기 위한 메서드
    boolean existsByName(String name);

    Optional<CustomExtension> findByName(String name);
}
