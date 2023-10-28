package AimsProject;


public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;
    // Get Number of List DVD
    public int getQtyOrdered() {
        return qtyOrdered;
    }

    public void setQtyOrdered(int n) {
        qtyOrdered += n;
    }
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if(qtyOrdered < 20) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");
        }
        else {
            System.out.println("The cart is almost full");
        }
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for(int i = 0; i < qtyOrdered; i++) {
            if(itemsOrdered[i].getTitle() == disc.getTitle()) {
                for(int j = i; j < qtyOrdered; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                i--;
                qtyOrdered--;
                System.out.println("The disc has been removed");
            }
        }
    }
    public float totalCost() {
        float total = 0;
        for(int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }

    public void printCart(){
        for(int i = 0; i < qtyOrdered; i++){
            System.out.print(i+1 + " " + itemsOrdered[i].getTitle() + " " + itemsOrdered[i].getCost() + "\n");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList){
        int m = dvdList.length;
        if(m + this.getQtyOrdered() > 20){
            System.out.print("The cart is full!");
            return;
        } else{
            for(int i = 0; i < m; i++){
                addDigitalVideoDisc(dvdList[i]);
            }
            System.out.println("The list DVD has been added!");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2){
        if(this.getQtyOrdered() > 20){
            System.out.println("The cart is full!");
        } else{
            itemsOrdered[this.getQtyOrdered()] = dvd1;
            setQtyOrdered(1);
            itemsOrdered[this.getQtyOrdered()] = dvd2;
            setQtyOrdered(1);
            System.out.println("The disc has been added");
        }
    }
    public void printCart(){
        for(int i = 0; i < qtyOrdered; i++){
            System.out.print(i+1 + " " + itemsOrdered[i].getTitle() + " " + itemsOrdered[i].getCost() + "\n");
        }
    }
}
