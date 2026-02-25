public class Player {

protected int credit;
protected int vies;
public Player(){
    this.credit=2500;
    this.vies=20;
}

public void diminueCreditDe(int n){
    this.credit-=n;
}
public int getCredit(){
    return this.credit;
}
public void diminueVieDe(int n){
    this.vies-=n;
}
public int getVie(){
    return this.vies;
}





}
