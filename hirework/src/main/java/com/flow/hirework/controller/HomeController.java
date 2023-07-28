package com.flow.hirework.controller;

import com.flow.hirework.repository.CustomExtensionRepository;
import com.flow.hirework.service.FileExtensionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final FileExtensionService service;
    private final CustomExtensionRepository customExtensionRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("defaultExtensionList", service.findAllDefaultExtension());
        model.addAttribute("customExtensionList", service.findAllCustomExtension());
        model.addAttribute("count", customExtensionRepository.count());

        return "home";
    }
}
