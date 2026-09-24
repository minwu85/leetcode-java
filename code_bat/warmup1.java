package code_bat;

public class Warmup1 {
/*
    SleepIn
    sleepIn(false, false) → true
    sleepIn(true, false) → false
    sleepIn(false, true) → true
    */
    public boolean sleep(boolean weekday, boolean vacation) {
        if (!weekday || vacation) {
            return true;
        } else {
            return false;
        }
    }

    public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
    if (!aSmile && !bSmile) {
        return true;
    } 
    if (aSmile && bSmile) {
        return true;
    }
        return false;
    }

    public int sumDouble(int a, int b) {
        if (a==b){
            return (a+b)+(a+b);
        }
        return a+b;
    }
}
    
