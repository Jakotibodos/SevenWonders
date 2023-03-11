package sevenwonders.GameElements;

public interface Buildable {
    final String[] res2id = {"Coins","Clay","Ore","Stone","Wood","Cloth","Glass","Papyrus"};
    public boolean canBuild();

    public void build(Player p);

    public default String printCost(int[] cost){

        String outputString = "";

        for (int i = 0; i < 8; i++){
            int number = cost[i];
            if(number > 0){
                outputString  = outputString.concat(Integer.toString(number)+"x "+res2id[i]+" AND ");
            }
        }
        return ((outputString.length() == 0) ? "Free" : outputString.substring(0, outputString.length()-5));
    }
}
