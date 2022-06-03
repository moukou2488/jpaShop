package com.jpaproject.shop.domain.item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("B")
public class Book extends Item {

    private String author;
    private String isbn;

}
