package com.hibernate.models.mappingCollections;

import javax.persistence.Embeddable;

@Embeddable
public class Phone_lazy_collections {
    private String type;
    private String areaCode;
    private String number;

    public Phone_lazy_collections() {
    }

    public Phone_lazy_collections(String type, String areaCode, String number) {
        this.type = type;
        this.areaCode = areaCode;
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
