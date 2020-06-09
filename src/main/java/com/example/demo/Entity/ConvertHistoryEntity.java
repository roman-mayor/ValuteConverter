package com.example.demo.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "covertHistory")
public class ConvertHistoryEntity extends BaseEntity {


    @Column(name = "fromValute")
    private String fromValute;

    @Column(name = "toValute")
    private String toValute;

    @Column(name = "fromSum")
    private int fromSum;

    @Column(name = "convertResult")
    private double convertResult;

    public ConvertHistoryEntity(String fromValute, String toValute, int fromSum, double convertResult) {
        this.fromValute = fromValute;
        this.toValute = toValute;
        this.fromSum = fromSum;
        this.convertResult = convertResult;
    }
}
