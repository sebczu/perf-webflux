package com.sebczu.perf.webflux;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table("movie")
@ToString
public class MovieEntity {

    @Id
    private Integer id;
    private String title;

}
