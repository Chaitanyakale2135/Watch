package com.Watch.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.Watch.entity.Watch;

public interface WatchService {
    List<Watch> getAllWatches();
    List<Watch> getWatchesByBrand(String brand);
    Watch getWatchById(Long id);
    Watch saveWatch(Watch watch);
    void deleteWatch(Long id);
    
   
}
