package com.flow.hirework.controller;


import com.flow.hirework.dto.CustomExtensionDto;
import com.flow.hirework.service.FileExtensionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class FileExtensionController {

    private final FileExtensionService extensionService;

    @PostMapping("/api/extension")
    public ResponseEntity<HttpStatus> addCustomExtension(@Valid CustomExtensionDto extensionDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        extensionService.addCustomExtension(extensionDto);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/api/extension/{name}")
    public ResponseEntity<HttpStatus> removeCustomExtension(@PathVariable(name = "name") String name) {
        extensionService.removeCustomExtension(name);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/api/extension/{name}")
    public ResponseEntity<HttpStatus> modifyDefaultExtension(@PathVariable(name = "name") String name) {
        extensionService.modifyDefaultExtension(name);
        return ResponseEntity.ok().build();
    }
}
