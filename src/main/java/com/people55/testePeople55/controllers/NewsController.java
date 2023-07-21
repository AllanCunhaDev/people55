package com.people55.testePeople55.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.people55.testePeople55.testeConfigs.News;
import com.people55.testePeople55.testeConfigs.NewsRepository;
import com.people55.testePeople55.testeConfigs.NewsRequestDTO;
import com.people55.testePeople55.testeConfigs.NewsResponseDTO;

@RestController
@RequestMapping("news")
public class NewsController {

    @Autowired
    private NewsRepository newsRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping()
    public List<NewsResponseDTO> findAll() {
        List<NewsResponseDTO> result = newsRepository.findAll().stream().map(NewsResponseDTO::new).toList();
        return result;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(value = "/{id}")
    public NewsResponseDTO findById(@PathVariable Long id) {
        News result = newsRepository.findById(id).get();
        NewsResponseDTO dto = new NewsResponseDTO(result);
        return dto;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping()
    public void saveNews(@RequestBody NewsRequestDTO data) {
        News newsData = new News(data);
        newsRepository.save(newsData);
        return;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping()
    public void updateNews(@RequestBody News data) {
        System.out.println(data);
        News newsData = newsRepository.getReferenceById(data.id());
        newsData.update(data);
        return;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteNews(@PathVariable News id) {
        newsRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
