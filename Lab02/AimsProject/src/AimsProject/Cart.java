package AimsProject;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    int qtyOrdered = 0;
    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if(qtyOrdered < MAX_NUMBERS_ORDERED){
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("DVD has been added!");
        } else System.out.println("Items ordered are full!");
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        for(int i = 0; i < qtyOrdered; i++){
            if(itemsOrdered[i].getTitle() == disc.getTitle()){
                for(int j = i; j < qtyOrdered; j++){
                    itemsOrdered[j] = null;
                }
                i--;
                qtyOrdered--;
                System.out.println("DVD has been deleted!");
            }
        }
    }
    public float totalCost(){
        float sum = 0;
        for(int i = 0; i < qtyOrdered; i++){
            sum += itemsOrdered[i].getCost();
        }
        return sum;
    }

    public void printCart(){
        for(int i = 0; i < qtyOrdered; i++){
            System.out.print(i+1 + " " + itemsOrdered[i].getTitle() + " " + itemsOrdered[i].getCost() + "\n");
        }
    }
}
