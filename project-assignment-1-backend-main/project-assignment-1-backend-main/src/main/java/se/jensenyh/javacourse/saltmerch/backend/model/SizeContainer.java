package se.jensenyh.javacourse.saltmerch.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SizeContainer
{
    @JsonProperty("size")
    public String size;

    @JsonProperty("stock")
    public int stock;

    public SizeContainer() {

    }

    public SizeContainer(String size, int stock) {
        this.size = size;
        this.stock = stock;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
