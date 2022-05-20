package ru.runnerlite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.runnerlite.entities.TeamsManagement;

@Repository
public interface TeamsManagementRepository extends JpaRepository<TeamsManagement, Integer> {
}