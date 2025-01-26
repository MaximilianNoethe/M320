package ch.noseryoung.backend_team7.domain.dish;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing {@link Dish} entities.
 * Extends {@link JpaRepository} to provide CRUD operations and query methods.
 */
@Repository
public interface DishRepository extends JpaRepository<Dish, Integer> {
}