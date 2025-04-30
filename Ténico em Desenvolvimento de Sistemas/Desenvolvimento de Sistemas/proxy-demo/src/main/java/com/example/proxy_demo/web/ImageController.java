package com.example.proxy_demo.web;

import com.example.proxy_demo.model.Image;
import com.example.proxy_demo.service.ImageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("images", imageService.getImages());
        model.addAttribute("currentRole", imageService.getUserRole());
        return "index";
    }

    @PostMapping("/display")
    public String displayImage(@RequestParam String fileName, Model model) {
        try {
            Image image = imageService.findImage(fileName);
            if (image != null) {
                image.display();
                model.addAttribute("message", "Imagem exibida com sucesso: " + fileName);
            } else {
                model.addAttribute("error", "Imagem não encontrada: " + fileName);
            }
        } catch (Exception e) {
            model.addAttribute("error", "Erro ao exibir imagem: " + e.getMessage());
        }
        return index(model);
    }

    @PostMapping("/change-role")
    public String changeRole(@RequestParam String role, Model model) {
        imageService.changeUserRole(role);
        model.addAttribute("message", "Função alterada para: " + role);
        return index(model);
    }
}
