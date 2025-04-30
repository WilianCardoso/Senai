package com.example.proxy_demo.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RealImage implements Image {

    private static final Logger log = LoggerFactory.getLogger(RealImage.class);

    private final String fileName;
    private final long size;
    private final String metadata;

    public RealImage(String fileName) {
        this.fileName = fileName;
        // Simula carregamento pesado
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        this.size = (long) (Math.random() * 10000); // Tamanho aleatório
        this.metadata = "Metadata for " + fileName;
        log.info("RealImage carregado: {}", fileName);
    }

    @Override
    public void display() {
        log.info("Exibindo imagem: {}", fileName);
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public long getSize() {
        return size;
    }

    @Override
    public String getMetadata() {
        return metadata;
    }
}
