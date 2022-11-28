public class CompositionChain implements Chain {

    private Chain nextInChain;

    @Override
    public void setChainNext(Chain nextInChain) {
        this.nextInChain = nextInChain;
    }

    @Override
    public void createArrow(int response, Box b1, Box b2) {
        if (response == 1) {
            System.out.println("Generating Composition Arrow");

            Arrow arrow = new CompostionDecoration(new JustLine());
            RightPanel.getRelationShips().add(new RelationShip(b1, b2, "Association", arrow));
        } else {
            nextInChain.createArrow(response, b1, b2);
        }
    }

}
