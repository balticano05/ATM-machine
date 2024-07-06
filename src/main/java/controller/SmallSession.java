package controller;

import entity.Card;

public interface SmallSession {

    public void handleCardSession();

    public void handlePinCodeSession(Card foundCard);

}
