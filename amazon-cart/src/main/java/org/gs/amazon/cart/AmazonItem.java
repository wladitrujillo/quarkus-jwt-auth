package org.gs.amazon.cart;

import lombok.Data;

@Data
public class AmazonItem {
    private Long id;
    private String name;
    private int quantity;
}
