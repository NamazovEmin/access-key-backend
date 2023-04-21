package com.example.accesskeybackend.template.controller;

import java.util.Collections;
import java.util.Map;

import com.example.accesskeybackend.template.service.IPVersionService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/web/checkIpv6Support")
@AllArgsConstructor
public class IPVersionPublicController {

    private final IPVersionService ipVersionService;

    @GetMapping
    public ResponseEntity<Map<String, Boolean>> checkIpv6ByUrl(@RequestParam("url") String siteUrl) {
        return ResponseEntity.ok(Collections.singletonMap("success", ipVersionService.checkIpv6SupportV1(siteUrl)));
    }
}
