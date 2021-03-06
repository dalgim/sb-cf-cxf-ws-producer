package com.dalgim.sample.soap.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

/**
 * Created by Mateusz Dalgiewicz on 25.03.2017.
 */
@MappedSuperclass
@Getter
@Setter
public abstract class AbstractEntity {

    @Id
    @GeneratedValue
    private Long id;
    private final String uuid;

    public AbstractEntity() {
        uuid = UUID.randomUUID().toString();
    }
}
