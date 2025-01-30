public class Card { 
//data variables 
// fields from the file = heart,ace,11,ah.gif
private String suit;
private int value;
private String rank;
private String picName; 

//put other 3 data variable here as private 


//contructor 
public Card() {
    suit = "heart";
    value = 10;
    rank = "ten";
    picName = "no pic"; 

}
public Card(String suit, String rank, int value, String picName){
    this.suit = suit;
    this.value = value;
    this.rank = rank;
    this.picName = picName;
}

//setters and getters 
public void setSuit(String suit){
    this.suit = suit;
}
public void setValue(int value){
    this.value = value;
}
public void setRank (String rank){
    this.rank = rank; 
}
    
public void setPicName (String picName){
    this.picName = picName;
}

public String getSuit(){
    return suit; 
}
public int getValue(){
    return value; 
}
public String getRank(){
    return rank;
} 
public String getPicName(){
    return picName;
}

public boolean equals(Card other) {
return rank.equals(other.rank) && (value == other.value);
}

public String toString(){
    return "suit: " + suit + " value: " + value + " rank: " + rank + " picName: " + picName; 
}


}
