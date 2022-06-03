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
@DiscriminatorValue("A")
public class Album extends Item {

    private String artist;
    private String etc;

}
