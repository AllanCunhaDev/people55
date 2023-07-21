package com.people55.testePeople55.testeConfigs;


public record NewsResponseDTO(Long id, String title, String image, String content, String author, Integer date) {
    
    public NewsResponseDTO(News news){
        this(news.getId(),news.getTitle(),news.getImage(),news.getContent(),news.getAuthor(),news.getDate());
    }

}
