package com.sodoma.ecommerce.repository;


import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.sodoma.ecommerce.entity.Album;
import com.sodoma.ecommerce.entity.AlbumVariation;
import com.sodoma.ecommerce.entity.AlbumVariation.Format;

@SpringBootTest
@ActiveProfiles("test")
class AlbumVariationRepositoryTest {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private AlbumVariationRepository variationRepository;

    @Test
    void testDisplayNameAndSkuGenerated() {
        // Criar produto Album
        Album album = new Album();
        album.setName("Akashica");
        album.setTitle("Akashica Deluxe");
        album.setReleaseYear(2022);
        album.addLabel("Altera Pars");
        album = albumRepository.save(album);

        // Criar variação (Vinil)
        AlbumVariation variation = new AlbumVariation();
        variation.setProduct(album);
        variation.setFormat(Format.VINYL);
        variation.setPrice(new BigDecimal("120.00"));
        variation.setStock(50);

        variation.ensureSku();
        variation = variationRepository.save(variation);

        // Garantir que DisplayName veio certo
        assertThat(variation.getDisplayName())
            .isEqualTo("Vinil Akashica");

        // Garantir que SKU foi gerado e persistido
        assertThat(variation.getSku())
            .isNotBlank()
            .startsWith("ALB-")
            .contains("VIN");

        // Buscar novamente do banco para ver se SKU é fixo
        AlbumVariation loaded = variationRepository.findById(variation.getId()).orElseThrow();
        assertThat(loaded.getSku()).isEqualTo(variation.getSku());
        
        System.out.println("=============================");
        System.out.println(variation.getDisplayName());
        System.out.println("=============================");
        System.out.println(variation.getSku());
        System.out.println("=============================");

    }
}
