import java.util.Scanner;

interface Factory{
    public Operation create(Scanner scanner) throws FactoryException;
}
