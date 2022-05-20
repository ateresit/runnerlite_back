package ru.runnerlite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.runnerlite.entities.RefAgesCategory;

@Repository
public interface RefAgesCategoryRepository extends JpaRepository<RefAgesCategory, Integer> {
}