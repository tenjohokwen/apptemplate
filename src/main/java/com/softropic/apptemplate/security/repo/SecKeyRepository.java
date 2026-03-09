package com.softropic.apptemplate.security.repo;



import com.softropic.apptemplate.common.persistence.EntityStatus;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Spring Data JPA persistence for the SecKey entity.
 */
public interface SecKeyRepository extends JpaRepository<SecKey, Long> {

    Optional<SecKey> findOneByVersionAndBusId(final String version, final String busId);

    Optional<SecKey> findTopByBusIdAndStatusOrderByCreatedDateDesc(String busId, EntityStatus status);
}
