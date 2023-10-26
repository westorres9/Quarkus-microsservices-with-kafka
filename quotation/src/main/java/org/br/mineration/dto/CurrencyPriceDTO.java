package org.br.mineration.dto;

public class CurrencyPriceDTO {

    public USDBRL USDBRL;

    public CurrencyPriceDTO() {
    }

    public CurrencyPriceDTO(org.br.mineration.dto.USDBRL USDBRL) {
        this.USDBRL = USDBRL;
    }

    public org.br.mineration.dto.USDBRL getUSDBRL() {
        return USDBRL;
    }

    public void setUSDBRL(org.br.mineration.dto.USDBRL USDBRL) {
        this.USDBRL = USDBRL;
    }
}
