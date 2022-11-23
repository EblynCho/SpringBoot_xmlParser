package com.bitc.xmltest.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class PharmacyFullDataDto {
    private PharmacyFullDataHeaderDto header;
    private PharmacyFullDataBodyDto body;

//    header 를 response 의 자식태그로 연결
    @XmlElement(name = "header")
    public PharmacyFullDataHeaderDto getHeader() {
        return header;
    }

    public void setHeader(PharmacyFullDataHeaderDto header) {
        this.header = header;
    }

    @XmlElement(name = "body")
    public PharmacyFullDataBodyDto getBody() {
        return body;
    }

    public void setBody(PharmacyFullDataBodyDto body) {
        this.body = body;
    }
}
