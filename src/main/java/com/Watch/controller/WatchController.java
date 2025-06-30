package com.Watch.controller;

import com.Watch.entity.Watch;
import com.Watch.service.WatchService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/watches")
public class WatchController {
private final WatchService watchService;

public WatchController(WatchService watchService) {
    this.watchService = watchService;
}

@GetMapping
public List<Watch> getAllWatches() {
    return watchService.getAllWatches();
}

@GetMapping("/brand/{brand}")
public List<Watch> getWatchesByBrand(@PathVariable String brand) {
    return watchService.getWatchesByBrand(brand);
}

@GetMapping("/{id}")
public Watch getWatchById(@PathVariable Long id) {
    return watchService.getWatchById(id);
}

@PostMapping
public Watch addWatch(@RequestBody Watch watch) {
    return watchService.saveWatch(watch);
}

@DeleteMapping("/{id}")
public void deleteWatch(@PathVariable Long id) {
    watchService.deleteWatch(id);
}
}