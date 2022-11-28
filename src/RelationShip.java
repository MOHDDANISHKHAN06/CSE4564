public class RelationShip {
    String type;
    Box b1;
    Box b2;
    Arrow arrow;

    RelationShip(Box b1, Box b2, String type, Arrow arrow) {
        this.b1 = b1;
        this.b2 = b2;
        this.type = type;
        this.arrow = arrow;
    }

}
