package org.sample.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class sampleController {

    @GetMapping("/api/sample/{id}")
    public ResponseEntity<Map<String, String>> sampleGet(@RequestParam String id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(null);
    }

    @PostMapping("/api/sample")
    public ResponseEntity<Map<String, String>> samplePost(@RequestBody Map<String, String> request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(request);
    }
}
