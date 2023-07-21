package com.people55.testePeople55.testeConfigs;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "news")
@Entity(name = "news")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class News {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String image;
    private String content;
    private String author;
    private Integer date;

    public News(NewsRequestDTO data) {
        this.title = data.title();
        this.image = data.image();
        this.content = data.content();
        this.author = data.author();
        this.date = data.date();
    }

    public void update(News data) {
        
    }

    public Long id() {
        return null;
    }

}
