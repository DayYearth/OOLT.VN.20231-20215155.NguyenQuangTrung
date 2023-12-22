public class Cart {
    public static final int MAX_NUMBERS_ORDER = 20;
    private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDER];
    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if (qtyOrdered == MAX_NUMBERS_ORDER) {
            System.out.println("The cart is almost full");
            return;
        }

        itemOrdered[qtyOrdered] = disc;
        qtyOrdered++;

        System.out.println("The disc has been added");
    }

    public void addDigitalVideoDisc(DigitalVideoDisc[] disc) {
        for (int i = 0; i < disc.length; i++){
            addDigitalVideoDisc(disc[i]);
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        int idToMove = -1;
        for (int i = 0; i < qtyOrdered; i++){
            if (itemOrdered[i] == disc){
                idToMove = i;
                break;
            }
        }
        if (idToMove < 0) {
            System.out.println("System cannot find the disc, remove fail");
            return;
        }
        for (int i = idToMove; i < qtyOrdered - 1; i++){
            itemOrdered[i] = itemOrdered[i + 1];
        }
        qtyOrdered--;
        System.out.println("The disc has been removed");
    }

    public float totalCost(){
        float sum = 0;
        for (int i = 0; i < qtyOrdered; i++){
            sum += itemOrdered[i].getCost();
        }

        return sum;
    }
}
