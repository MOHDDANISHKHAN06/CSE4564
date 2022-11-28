public class AssociationChain implements Chain {

    private Chain nextInChain;

    @Override
    public void setChainNext(Chain nextInChain) {
        this.nextInChain = nextInChain;
    }

    @Override
    public void createArrow(int response, Box b1, Box b2) {
        System.out.println("Generating Association Arrow");
        if (response != -1) {
            Arrow arrow = new JustLine();
            RightPanel.getRelationShips().add(new RelationShip(b1, b2, "Association", arrow));
        } else {
            System.out.println("No relation Ship Selected");
        }
    }
}
