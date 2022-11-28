public class InheritanceChain implements Chain {

    private Chain nextInChain;

    @Override
    public void setChainNext(Chain nextInChain) {
        this.nextInChain = nextInChain;
    }

    @Override
    public void drawArrow(int response) {
        if (response == 0) {
            System.out.println("Drawing inheritance");

            Arrow arrow = new InheritanceDecoration(new JustLine());
            RightPanel.getRelationShips().add(new RelationShip(b1, b2, "Inheritance", arrow));
            RightPanel.rightPanel.updateRightPanel();
        } else {
            nextInChain.drawArrow(response);
        }
    }

}
