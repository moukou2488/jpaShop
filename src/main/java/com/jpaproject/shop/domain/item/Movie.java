package com.jpaproject.shop.domain.item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("M")
public class Movie extends Item {

    private String director;
    private String actor;

}
