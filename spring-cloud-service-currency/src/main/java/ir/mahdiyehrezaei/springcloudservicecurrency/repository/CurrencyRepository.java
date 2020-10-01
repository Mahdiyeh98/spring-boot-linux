package ir.mahdiyehrezaei.springcloudservicecurrency.repository;

import ir.mahdiyehrezaei.springcloudservicecurrency.domain.CurrencyValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<CurrencyValue, Integer> {
    CurrencyValue findByFromContainingAndToContaining(String from, String to);
}
