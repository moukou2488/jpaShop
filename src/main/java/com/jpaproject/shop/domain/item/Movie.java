package com.jpaproject.shop.domain.item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@SuperBuilder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("M")
public class Movie extends Item {

    private String director;
    private String actor;

}
