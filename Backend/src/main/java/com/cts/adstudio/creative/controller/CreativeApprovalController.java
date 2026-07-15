package com.cts.adstudio.creative.controller;

import com.cts.adstudio.creative.dto.ApprovalRequest;
import com.cts.adstudio.creative.service.CreativeService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/api/creative-approvals")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('CREATIVE_MANAGER','ADMIN')")
public class CreativeApprovalController {

    private final CreativeService service;

    // ONLY APPROVAL API
    @PostMapping
    public ResponseEntity<?> approve(@Valid @RequestBody ApprovalRequest req) {

        return ResponseEntity.ok(
                service.approve(req.assetId(), req.decision())
        );
    }
}