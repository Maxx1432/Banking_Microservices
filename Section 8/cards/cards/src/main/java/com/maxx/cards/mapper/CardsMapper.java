package com.maxx.cards.mapper;

import com.maxx.cards.dto.CardsDto;
import com.maxx.cards.entity.Cards;

public class CardsMapper {

    public static CardsDto mapToCardsDto(Cards cards, CardsDto cardsDto) {
        cardsDto.setCardNumber(cards.getCardNumber());
        cardsDto.setCardType(cards.getCardType());
        cardsDto.setMobileNumber(cards.getMobileNumber());
        cardsDto.setTotalLimit(cards.getTotalLimit());
        cardsDto.setAvailableLimit(cards.getAvailableLimit());
        cardsDto.setLimitUsed(cards.getLimitUsed());
        return cardsDto;
    }

    public static Cards mapToCards(CardsDto cardsDto, Cards cards) {
        cards.setCardNumber(cardsDto.getCardNumber());
        cards.setCardType(cardsDto.getCardType());
        cards.setMobileNumber(cardsDto.getMobileNumber());
        cards.setTotalLimit(cardsDto.getTotalLimit());
        cards.setAvailableLimit(cardsDto.getAvailableLimit());
        cards.setLimitUsed(cardsDto.getLimitUsed());
        return cards;
    }
}
