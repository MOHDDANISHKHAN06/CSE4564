public class CompositionChain implements Chain {

    private Chain nextInChain;

    @Override
    public void setChainNext(Chain nextInChain) {
        this.nextInChain = nextInChain;
    }

    @Override
    public void drawArrow(int response) {
        if (response == 1) {
            System.out.println("Generating Composition Arrow");
        }
        else{
            nextInChain.drawArrow(response);
        }
    }

}
