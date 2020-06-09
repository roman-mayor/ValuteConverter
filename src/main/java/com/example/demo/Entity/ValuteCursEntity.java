package com.example.demo.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "base_currency")
public class ValuteCursEntity extends BaseEntity{

    @Column(name = "num_code")
    private int NumCode;

    @Column (name = "char_code")
    private String char_code;

    @Column(name = "nominal")
    private int nominal;

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private String value;

    public ValuteCursEntity(int numCode, String char_code, int nominal, String name, String value) {
        this.NumCode = numCode;
        this.char_code = char_code;
        this.nominal = nominal;
        this.name = name;
        this.value = value;
    }
}
