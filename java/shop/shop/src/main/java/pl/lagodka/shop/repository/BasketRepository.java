package pl.lagodka.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import pl.lagodka.shop.model.dao.Basket;

import java.util.Optional;

public interface BasketRepository extends JpaRepository<Basket, Long>, RevisionRepository<Basket, Long, Integer> {

    Optional<Basket> findByProductIdAndUserId(Long productId, Long userId);

    Optional<Basket> findByUserId(Long userId);

    Optional<Basket> deleteByUserId(Long userId);

    Optional<Basket> deleteByProductIdAndUserId(Long productId, Long userId);
}
