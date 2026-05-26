```java
package com.example.service;

import com.example.model.Schema;
import com.example.repository.SchemaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SchemaManagerServiceTest {

    @Mock
    private SchemaRepository schemaRepository;

    @InjectMocks
    private SchemaManagerService schemaManagerService;

    private Schema testSchema;

    @BeforeEach
    void setUp() {
        testSchema = new Schema();
        testSchema.setId(1L);
        testSchema.setName("TestSchema");
        testSchema.setContent("CREATE TABLE test (id INT)");
    }

    @Test
    void testCreateSchema() {
        when(schemaRepository.save(any(Schema.class))).thenReturn(testSchema);

        Schema created = schemaManagerService.createSchema(testSchema);

        assertNotNull(created);
        assertEquals("TestSchema", created.getName());
        verify(schemaRepository, times(1)).save(testSchema);
    }

    @Test
    void testGetSchemaById() {
        when(schemaRepository.findById(1L)).thenReturn(Optional.of(testSchema));

        Schema found = schemaManagerService.getSchemaById(1L);

        assertNotNull(found);
        assertEquals(1L, found.getId());
        verify(schemaRepository, times(1)).findById(1L);
    }

    @Test
    void testGetSchemaByIdNotFound() {
        when(schemaRepository.findById(99L)).thenReturn(Optional.empty());

        Schema found = schemaManagerService.getSchemaById(99L);

        assertNull(found);
        verify(schemaRepository, times(1)).findById(99L);
    }

    @Test
    void testUpdateSchema() {
        Schema updatedSchema = new Schema();
        updatedSchema.setName("UpdatedSchema");
        updatedSchema.setContent("ALTER TABLE test ADD COLUMN name VARCHAR(255)");

        when(schemaRepository.findById(1L)).thenReturn(Optional.of(testSchema));
        when(schemaRepository.save(any(Schema.class))).thenReturn(updatedSchema);

        Schema result = schemaManagerService.updateSchema(1L, updatedSchema);

        assertNotNull(result);
        assertEquals("UpdatedSchema", result.getName());
        verify(schemaRepository, times(1)).findById(1L);
        verify(schemaRepository, times(1)).save(any(Schema.class));
    }

    @Test
    void testDeleteSchema() {
        when(schemaRepository.findById(1L)).thenReturn(Optional.of(testSchema));
        doNothing().when(schemaRepository).delete(testSchema);

        boolean deleted = schemaManagerService.deleteSchema(1L);

        assertTrue(deleted);
        verify(schemaRepository, times(1)).findById(1L);
        verify(schemaRepository, times(1)).delete(testSchema);
    }

    @Test
    void testDeleteSchemaNotFound() {
        when(schemaRepository.findById(99L)).thenReturn(Optional.empty());

        boolean deleted = schemaManagerService.deleteSchema(99L);

        assertFalse(deleted);
        verify(schemaRepository, times(1)).findById(99L);
        verify(schemaRepository, never()).delete(any());
    }
}
```