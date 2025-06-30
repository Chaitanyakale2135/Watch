package com.Watch.service;

import com.Watch.entity.Watch;
import com.Watch.repository.WatchRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchServiceImpl implements WatchService {
    private final WatchRepository watchRepository;

    public WatchServiceImpl(WatchRepository watchRepository) {
        this.watchRepository = watchRepository;
    }

    @Override
    public List<Watch> getAllWatches() {
        return watchRepository.findAll();
    }

    @Override
    public List<Watch> getWatchesByBrand(String brand) {
        return watchRepository.findByBrand(brand);
    }

    @Override
    public Watch getWatchById(Long id) {
        return watchRepository.findById(id).orElse(null);
    }

    @Override
    public Watch saveWatch(Watch watch) {
        return watchRepository.save(watch);
    }

    @Override
    public void deleteWatch(Long id) {
        watchRepository.deleteById(id);
    }

    

	
	
	
}