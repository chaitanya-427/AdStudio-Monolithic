package com.cts.adstudio.creative.controller;

import com.cts.adstudio.creative.entity.CreativeAsset;
import com.cts.adstudio.creative.service.CreativeService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/api/creative-assets")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('CREATIVE_MANAGER','ADMIN')")
public class CreativeAssetController {

    private final CreativeService service;

    // ✅ ONLY UPLOAD HERE ✅
    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    public ResponseEntity<?> upload(
            @RequestParam("file") MultipartFile file,
            @RequestParam Long brandId,
            @RequestParam String assetName,
            @RequestParam CreativeAsset.AssetType assetType,
            @RequestParam Integer width,
            @RequestParam Integer height
    ) throws Exception {

        return ResponseEntity.ok(
                service.uploadManual(file, brandId, assetName, assetType, width, height)
        );
    }

    // ✅ GET ALL
    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
 @PutMapping(value = "/{assetId}", consumes = "multipart/form-data")
public ResponseEntity<?> updateAsset(
        @PathVariable Long assetId,
        @RequestParam(required = false) MultipartFile file,
        @RequestParam String assetName,
        @RequestParam CreativeAsset.AssetType assetType,
        @RequestParam Integer width,
        @RequestParam Integer height
) throws Exception {

    return ResponseEntity.ok(
            service.updateWithFile(assetId, file, assetName, assetType, width, height)
    );
}
@DeleteMapping("/{assetId}")
public ResponseEntity<?> deleteAsset(@PathVariable Long assetId) {

    service.delete(assetId);

    return ResponseEntity.ok("Asset deleted successfully");
}
}