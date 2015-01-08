
import java.util.Scanner;

/**
 *
 * @author Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 */
public class FilterFactory implements Factory {

    private int filterSize;
    private BlockGenerator bgen;

    public FilterFactory() {
        filterSize = 3;
        bgen = new XBlockGenerator(filterSize);
    }

    /**
     *
     * @param scanner
     * @return
     * @throws FactoryException
     */
    @Override
    public Operation create(Scanner scanner) throws FactoryException {
        //Make sure we only read the filter line due to 2 optional params!
        Scanner sc = new Scanner(scanner.nextLine());

        //Ensure filter name
        if (!sc.hasNext()) {
            throw new FactoryException("Insufficient parameter (filtername)");
        }

        String filterName = sc.next();

        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                filterSize = sc.nextInt();
                if (filterSize < 3 || (filterSize % 2 == 0)) {
                    throw new FactoryException("Filtersize must be odd and greater 1");
                }
            } else {
                bgen = choseBlockGenerator(sc.next().trim(), filterSize);
            }
        }

        return choseFilter(filterName, bgen);
    }

    /**
     * Chose filter by name and return instance
     *
     * @param name
     * @param bgen
     * @return
     * @throws FactoryException
     */
    private FilterOperation choseFilter(String name, BlockGenerator bgen) throws FactoryException {
        if ("median".equals(name)) {
            return new MedianOperation(bgen);
        } else if ("average".equals(name)) {
            return new AverageOperation(bgen);
        } else {
            throw new FactoryException("Unknown Filter: " + name);
        }
    }

    /**
     * Chose BlockGenerator by name and return instance with size
     * @param name
     * @param size
     * @return
     * @throws FactoryException
     */
    private BlockGenerator choseBlockGenerator(String name, int size) throws FactoryException {
        if ("x".equals(name)) {
            return new XBlockGenerator(size);
        } else if ("symmetric".equals(name)) {
            return new SymmetricBlockGenerator(size);
        } else if ("circular".equals(name)) {
            return new CircularBlockGenerator(size);
        } else if ("replicate".equals(name)) {
            return new ReplicateBlockGenerator(size);
        } else {
            throw new FactoryException("Unknown BlockGenerator: " + name);
        }
     }

}
