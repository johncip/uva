/**
 * A box is a sorted list of dimensions. Can have a link to a child box, that
 * is, the one contained by it.
 */
class Box implements Comparable<Box> {
    String name;
    Integer[] dims;
    int holds;
    Box child; // the box directly inside of this

    public Box(String name, int n, String dimensions) {
        this.name = name;
        this.dims = new Integer[n];

        String[] split = dimensions.split(" ");
        for (int i = 0; i < split.length; i++)
            dims[i] = Integer.parseInt(split[i]);

        Util.sort(dims);
    }

    /**
     * Returns true if box a fits inside of box b (all dims are lt_eq);
     */
    public boolean fitsIn(Box that) {
        for (int i = 0; i < dims.length; i++)
            if (this.dims[i] >= that.dims[i])
                return false;

        return true;
    }

    /**
     * Prints the boxes contained by this one, from smallest to self.
     */
    public String children() {
        if (child == null)
            return name;
        else
            return child.children() + " " + name;
    }

    /*
     * (non-Javadoc)
     * 
     * Boxes are sorted lexicographically according to their respective elements
     * (we are assuming elements have already been sorted).
     * 
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Box that) {
        for (int i = 0; i < dims.length; i++) {
            if (dims[i] > that.dims[i])
                return 1;
            if (dims[i] < that.dims[i])
                return -1;
        }

        return 0;
    }
}
