package com.sodoma.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sodoma.ecommerce.entity.Album;

public interface AlbumRepository extends JpaRepository<Album, Long>{

}
