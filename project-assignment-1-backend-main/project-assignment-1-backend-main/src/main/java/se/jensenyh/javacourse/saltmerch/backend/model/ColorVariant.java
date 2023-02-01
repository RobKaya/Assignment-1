package se.jensenyh.javacourse.saltmerch.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ColorVariant
{
    @JsonProperty("colorName")
    public String colorName;

    @JsonProperty("images")
    public List<String> images;

    @JsonProperty("sizes")
    public List<SizeContainer> sizes;

    public ColorVariant() {
        this.images = new ArrayList<>();
        this.sizes = new ArrayList<>();
    }

    public ColorVariant(String colorName, List<String> images, List<SizeContainer> sizes) {
        this.colorName = colorName;
        this.images = images;
        this.sizes = sizes;
    }
    
    // NOTE: you can leave this method as it is; it's used in ProductRepository.java
    public void setImagesFromCSV(String csv) throws Exception
    {
        images = new ArrayList<>(Arrays.asList(csv.split(",")));
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<SizeContainer> getSizes() {
        return sizes;
    }

    public void setSizes(List<SizeContainer> sizes) {
        this.sizes = sizes;
    }
}
