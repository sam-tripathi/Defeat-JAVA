package GUITools;

import java.awt.*;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.*;

class DigitalClock{

public static final int TWELVE_HOUR = 12;
public static final int TWENTY_FOUR_HOUR = 24;
private int format = 24;
private boolean displaySeconds = true;
private boolean displaySecondTick = false;

public DigitalClock() {}

// get current time

public String timeNow() {

StringBuilder time = new StringBuilder();
String format = “”;
Calendar now = Calendar.getInstance();

int hrs = now.get(Calendar.HOUR_OF_DAY);
int min = now.get(Calendar.MINUTE);
int sec = now.get(Calendar.SECOND);

if(this.getFormat() == 12){

if(hrs > 12){

hrs = hrs – 12;
format = ” p.m.”;

}else{

format = ” a.m.”;

}

time.append(hrs + “:” + zero(min));

}else{

time.append(zero(hrs) + “:” + zero(min));

}

if(this.displaySeconds){

time.append(“:” + zero(sec));

}

if(((sec % 2) !=0) && this.displaySecondTick){

return time.append(format).toString().replace(“:”, ” “);

}else{
return time.append(format).toString();
}

}

public Long timeNowUnixtime(){

return ((new Date()).getTime()/1000);

}

public String zero(int num) {

String number = (num < 10) ? (“0” + num) : (“” + num);

return number; // Add leading zero if needed

}

@Override

public String toString() {

return timeNow();

}

public void disableSeconds(){

this.displaySeconds = false;

}

public void disableSecondTick(){

this.displaySecondTick = false;

}

public void enableSecondTick(){

this.displaySecondTick = true;

}

public void enableSeconds(){

this.displaySeconds = true;

}

public int getFormat() {

return format;

}

public void setFormat(int format) {

this.format = format;

}

}