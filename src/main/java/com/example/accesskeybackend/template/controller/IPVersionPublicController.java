package com.example.accesskeybackend.template.controller;

import com.example.accesskeybackend.template.service.IPVersionService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/web/checkIpv6Support")
@AllArgsConstructor
public class IPVersionPublicController {

    private final IPVersionService ipVersionService;

    @GetMapping("/{siteUrl}")
    public ResponseEntity<Boolean> checkIpv6ByUrl(@PathVariable String siteUrl) {
        return ResponseEntity.ok(ipVersionService.checkIpv6Support(siteUrl));
    }
}
