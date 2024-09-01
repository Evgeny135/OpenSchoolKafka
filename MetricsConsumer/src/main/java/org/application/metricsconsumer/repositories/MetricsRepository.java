package org.application.metricsconsumer.repositories;

import org.application.metricsconsumer.model.Metric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetricsRepository extends JpaRepository<Metric, Long> {
}
