package com.flow.hirework.controller;


import com.flow.hirework.dto.request.CustomExtensionRequestDto;
import com.flow.hirework.dto.response.CustomExtensionResponseDto;
import com.flow.hirework.dto.response.DefaultExtensionResponseDto;
import com.flow.hirework.repository.CustomExtensionRepository;
import com.flow.hirework.service.FileExtensionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FileExtensionController {

    private final FileExtensionService extensionService;

    @PostMapping("/api/extension")
    public ResponseEntity<HttpStatus> addCustomExtension(@Valid @RequestBody CustomExtensionRequestDto extensionDto, BindingResult bindingResult) {
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

    @GetMapping("/api/extension")
    public ResponseEntity<List<CustomExtensionResponseDto>> findAllCustomExtension() {
        return ResponseEntity.ok(extensionService.findAllCustomExtension());
    }

    @GetMapping("/api/extension/default")
    public ResponseEntity<List<DefaultExtensionResponseDto>> findAllDefaultExtension() {
        return ResponseEntity.ok(extensionService.findAllDefaultExtension());
    }

    @PatchMapping("/api/extension/{name}")
    public ResponseEntity<HttpStatus> modifyDefaultExtension(@PathVariable(name = "name") String name) {
        extensionService.modifyDefaultExtension(name);
        return ResponseEntity.ok().build();
    }
}
