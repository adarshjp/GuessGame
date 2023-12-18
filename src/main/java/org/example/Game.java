package org.example;

public class Game {
    private int randomNumber;
    private int userGuess;
    private int guessCount;
    private GAMESTATE gameState;
    private final int minRange;
    private final int maxRange;
    public Game(int minRange,int maxRange){
        this.minRange=minRange;
        this.maxRange=maxRange;
        this.randomNumber=generateRandomNumber();
        this.guessCount=0;
        this.gameState=GAMESTATE.PLAYING
    }
    private enum GAMESTATE{
        PLAYING,WON,LOST;
    }
    private enum GUESS{
        TOO_HIGH, TOO_LOW, CORRECT, INVALID;
    }
    private int generateRandomNumber(){
        return (int) (Math.random() * (maxRange - minRange + 1)) + minRange;
    }
    private void getGuess(int userInput){
        this.userGuess=userInput;
    }
    private GUESS checkGuess(int guess){
        guessCount++;
        userGuess=guess;
        if(guess<minRange || guess>maxRange)  return GUESS.INVALID;
        else if(guess==randomNumber) {
            gameState=GAMESTATE.WON;
            return GUESS.CORRECT;
        }
        else if(guess<randomNumber) return GUESS.TOO_LOW;
        else return  GUESS.TOO_HIGH;
    }
    private int increaseCount(){
        guessCount++;
        return guessCount;
    }
    private boolean isGameOver(){
        return gameState==GAMESTATE.WON || gameState==GAMESTATE.LOST;
    }
    private int getGuessCount(){
        return guessCount;
    }
    public GAMESTATE getGameState() {
        return gameState;
    }

    public void reset() {
        randomNumber = generateRandomNumber();
        guessCount = 0;
        gameState = GAMESTATE.PLAYING;
    }
}
