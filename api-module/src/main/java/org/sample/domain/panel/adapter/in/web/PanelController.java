package org.sample.domain.panel.adapter.in.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/panel")
public class PanelController {

//    @GetMapping("/{id}")
//    public ResponseEntity<Map<String, String>> sampleGet(@RequestParam String id) {
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(null);
//    }

    @GetMapping("/{id}") // http://localhost:8000/panel/4
    public String samplePathVariable(@PathVariable("id") String id) {
        return id;
    }

    @GetMapping("/param") // http://localhost:8000/panel/param?id=4
    public String sampleGet(@RequestParam("id") String id) {
        return id;
    }

    @GetMapping("/")
    public String test() {
        return "ok";
    }

    @PostMapping("/api/sample")
    public ResponseEntity<Map<String, String>> samplePost(@RequestBody Map<String, String> request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(request);
    }
}
