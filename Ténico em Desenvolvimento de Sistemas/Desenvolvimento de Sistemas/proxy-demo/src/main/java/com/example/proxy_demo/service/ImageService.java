package com.example.proxy_demo.service;

import com.example.proxy_demo.model.Image;
import com.example.proxy_demo.model.ProxyImage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageService {

    private final List<Image> images = new ArrayList<>();
    private String currentUserRole = "user";

    public ImageService() {
        // Inicializa com algumas imagens
        images.add(new ProxyImage("nature.jpg", currentUserRole));
        images.add(new ProxyImage("city.jpg", currentUserRole));
        images.add(new ProxyImage("restricted_admin.jpg", currentUserRole));
        images.add(new ProxyImage("animal.jpg", currentUserRole));
    }

    public List<Image> getImages() {
        return new ArrayList<>(images);
    }

    public Image findImage(String fileName) {
        return images.stream()
                .filter(img -> img.getFileName().equals(fileName))
                .findFirst()
                .orElse(null);
    }

    public void changeUserRole(String role) {
        this.currentUserRole = role;
        // Atualiza os proxies com a nova role
        for (int i = 0; i < images.size(); i++) {
            Image img = images.get(i);
            if (img instanceof ProxyImage) {
                images.set(i, new ProxyImage(img.getFileName(), currentUserRole));
            }
        }
    }

    public String getUserRole() {
        return currentUserRole;
    }
}
