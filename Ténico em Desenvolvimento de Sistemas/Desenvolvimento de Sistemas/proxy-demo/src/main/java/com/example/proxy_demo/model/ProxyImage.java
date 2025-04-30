package com.example.proxy_demo.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProxyImage implements Image {

    private static final Logger log = LoggerFactory.getLogger(ProxyImage.class);

    private RealImage realImage;
    private final String fileName;
    private final boolean accessAllowed;
    private static final String ADMIN_USER = "admin";

    public ProxyImage(String fileName, String userRole) {
        this.fileName = fileName;
        this.accessAllowed = ADMIN_USER.equals(userRole) || !fileName.contains("restricted");
        log.info("Proxy criado para: {}", fileName);
    }

    @Override
    public void display() {
        if (!accessAllowed) {
            log.warn("Acesso negado para imagem: {}", fileName);
            throw new SecurityException("Acesso negado a imagem " + fileName);
        }

        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public long getSize() {
        if (realImage == null) {
            return 0;
        }
        return realImage.getSize();
    }

    @Override
    public String getMetadata() {
        if (realImage == null) {
            return "Metadata não carregada (proxy)";
        }
        return realImage.getMetadata();
    }

    public boolean isCached() {
        return realImage != null;
    }
}
