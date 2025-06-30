package com.Watch;



import com.Watch.entity.Watch;
import com.Watch.repository.WatchRepository;
import com.Watch.service.WatchServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class WatchServiceImplTest {

    @Mock
    private WatchRepository watchRepository;

    @InjectMocks
    private WatchServiceImpl watchService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllWatches() {
        // Arrange
        List<Watch> watches = new ArrayList<>();
        watches.add(new Watch());
        when(watchRepository.findAll()).thenReturn(watches);

        // Act
        List<Watch> result = watchService.getAllWatches();

        // Assert
        assertEquals(1, result.size());
        verify(watchRepository, times(1)).findAll();
    }

    @Test
    void getWatchesByBrand() {
        // Arrange
        String brand = "Rolex";
        List<Watch> watches = new ArrayList<>();
        watches.add(new Watch());
        when(watchRepository.findByBrand(brand)).thenReturn(watches);

        // Act
        List<Watch> result = watchService.getWatchesByBrand(brand);

        // Assert
        assertEquals(1, result.size());
        verify(watchRepository, times(1)).findByBrand(brand);
    }

    @Test
    void getWatchById() {
        // Arrange
        Long id = 1L;
        Watch watch = new Watch();
        when(watchRepository.findById(id)).thenReturn(Optional.of(watch));

        // Act
        Watch result = watchService.getWatchById(id);

        // Assert
        assertNotNull(result);
        verify(watchRepository, times(1)).findById(id);
    }

    @Test
    void getWatchById_NotFound() {
        // Arrange
        Long id = 1L;
        when(watchRepository.findById(id)).thenReturn(Optional.empty());

        // Act
        Watch result = watchService.getWatchById(id);

        // Assert
        assertNull(result);
        verify(watchRepository, times(1)).findById(id);
    }

    @Test
    void saveWatch() {
        // Arrange
        Watch watch = new Watch();
        when(watchRepository.save(any(Watch.class))).thenReturn(watch);

        // Act
        Watch result = watchService.saveWatch(watch);

        // Assert
        assertNotNull(result);
        verify(watchRepository, times(1)).save(watch);
    }

    @Test
    void deleteWatch() {
        // Arrange
        Long id = 1L;

        // Act
        watchService.deleteWatch(id);

        // Assert
        verify(watchRepository, times(1)).deleteById(id);
    }
}

