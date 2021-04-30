package com.dummy.rest.stock.entity.dummy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class DummyEntity {
    @Id
    private Long id;
    private int userId;
    private String title;
    private String body;
}
