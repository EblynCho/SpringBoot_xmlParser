package com.bitc.xmltest.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "body")
public class PharmacyFullDataBodyDto {
    private int numOfRows;
    private int pageNo;
    private int totalCount;
//    자식태그가 있는 타입은 클래스로 만들어 줌
    private PharmacyFullDataItemsDto items;

    @XmlElement
    public int getNumOfRows() {
        return numOfRows;
    }

    public void setNumOfRows(int numOfRows) {
        this.numOfRows = numOfRows;
    }

    @XmlElement
    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    @XmlElement
    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    //   클래스 애들만 name 넣어주면 됨
    @XmlElement(name = "items")
    public PharmacyFullDataItemsDto getItems() {
        return items;
    }

    public void setItems(PharmacyFullDataItemsDto items) {
        this.items = items;
    }
}
