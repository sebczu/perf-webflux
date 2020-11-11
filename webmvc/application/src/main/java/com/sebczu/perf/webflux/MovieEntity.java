package com.sebczu.perf.webflux;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Movie")
@Table(name = "movie")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MovieEntity {

    @Id
    private Integer id;
    private String title;

}
