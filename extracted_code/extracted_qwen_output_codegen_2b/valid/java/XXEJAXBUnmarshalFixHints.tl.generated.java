package com.example.datamodel.service;

import java.util.*;
import java.util.stream.*;

public class DataProcessingService {
    
    public List<String> processData(List<String> input) {
        if (input == null || input.isEmpty()) {
            return Collections.emptyList();
        }
        
        return input.stream()
                .filter(Objects::nonNull)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(String::toUpperCase)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
    
    public Map<String, Long> countOccurrences(List<String> data) {
        if (data == null || data.isEmpty()) {
            return Collections.emptyMap();
        }
        
        return data.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                    String::toLowerCase,
                    Collectors.counting()
                ));
    }
    
    public Optional<String> findLongestString(List<String> data) {
        if (data == null || data.isEmpty()) {
            return Optional.empty();
        }
        
        return data.stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparingInt(String::length));
    }
    
    public List<String> filterByLength(List<String> data, int minLength, int maxLength) {
        if (data == null || data.isEmpty()) {
            return Collections.emptyList();
        }
        
        return data.stream()
                .filter(Objects::nonNull)
                .filter(s -> s.length() >= minLength && s.length() <= maxLength)
                .collect(Collectors.toList());
    }
}