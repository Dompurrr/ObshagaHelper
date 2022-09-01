package com.dompurrr.obshagahelper.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private Integer id;
    private String room;
    private String name;
    private String amount;
    private String comment;


}