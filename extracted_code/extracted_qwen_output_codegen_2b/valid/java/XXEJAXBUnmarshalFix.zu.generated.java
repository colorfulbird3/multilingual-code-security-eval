package com.example.datamodel.service;

import com.example.datamodel.model.DataRecord;
import com.example.datamodel.repository.DataRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DataProcessingService {

    @Autowired
    private DataRecordRepository repository;

    @Transactional
    public DataRecord processData(DataRecord record) {
        record.setProcessedAt(LocalDateTime.now());
        record.setStatus("PROCESSED");
        return repository.save(record);
    }

    public Optional<DataRecord> findById(Long id) {
        return repository.findById(id);
    }

    public List<DataRecord> findAll() {
        return repository.findAll();
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public DataRecord updateData(Long id, DataRecord updatedRecord) {
        return repository.findById(id)
                .map(record -> {
                    record.setData(updatedRecord.getData());
                    record.setStatus(updatedRecord.getStatus());
                    record.setProcessedAt(LocalDateTime.now());
                    return repository.save(record);
                })
                .orElseThrow(() -> new RuntimeException("Record not found with id: " + id));
    }
}