package com.people55.testePeople55.testeConfigs;

public record NewsUpdateDTO(Long id, String title, String image, String content, String author, Integer date) {

    public NewsUpdateDTO(News data){
        this(data.getId(),data.getTitle(),data.getImage(),data.getContent(),data.getAuthor(),data.getDate());
    }
    public void update(News data) {
       
    }
}
