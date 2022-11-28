public class AssociationChain implements Chain {

    private Chain nextInChain;

    @Override
    public void setChainNext(Chain nextInChain) {
        this.nextInChain = nextInChain;
    }

    @Override
    public void drawArrow(int response) {
        System.out.println("Generating Association Arrow");
        if (response != -1) {
            Arrow arrow = new JustLine();
            // arrow.drawLine(response, response, response, response);
        }
    }
}
