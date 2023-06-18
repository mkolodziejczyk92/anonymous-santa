package io.mkolodziejczyk92.anonymoussanta.data.repository;

import io.mkolodziejczyk92.anonymoussanta.data.entity.Family;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyRepository extends JpaRepository<Family, Long> {

}
