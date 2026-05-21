```java
package com.example.service;

import com.example.model.DynamicMetric;
import com.example.repository.DynamicMetricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DynamicMetricService {

    @Autowired
    private DynamicMetricRepository dynamicMetricRepository;

    public List<DynamicMetric> getAllMetrics() {
        return dynamicMetricRepository.findAll();
    }

    public Optional<DynamicMetric> getMetricById(Long id) {
        return dynamicMetricRepository.findById(id);
    }

    public DynamicMetric createMetric(DynamicMetric metric) {
        return dynamicMetricRepository.save(metric);
    }

    public DynamicMetric updateMetric(Long id, DynamicMetric metricDetails) {
        DynamicMetric metric = dynamicMetricRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Metric not found with id: " + id));
        metric.setName(metricDetails.getName());
        metric.setValue(metricDetails.getValue());
        metric.setTimestamp(metricDetails.getTimestamp());
        return dynamicMetricRepository.save(metric);
    }

    public void deleteMetric(Long id) {
        dynamicMetricRepository.deleteById(id);
    }
}
```