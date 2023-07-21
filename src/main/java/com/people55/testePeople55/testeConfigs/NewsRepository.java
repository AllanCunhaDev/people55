package com.people55.testePeople55.testeConfigs;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {

    void save(Optional<News> newsUpdate);


    
}
