
package casino.project;


public class users {
    protected String name;
    protected int coins;

    public users(String name, int coins) {
        this.name = name;
        this.coins = coins;
    }
    public String toString(){
        return name+", "+coins;
      }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }
    
}
