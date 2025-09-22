package visitor;

public class Main {
    public static void main(String[] args) {

        File file1 = new File("document.txt", 5);
        File file2 = new File("image.png", 15);
        File file3 = new File("notes.txt", 3);

        Directory dir1 = new Directory("Documents");
        Directory dir2 = new Directory("Images");

        dir1.addElement(file1);
        dir1.addElement(file3);
        dir2.addElement(file2);

        Directory root = new Directory("Root");
        root.addElement(dir1);
        root.addElement(dir2);

        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);
        System.out.println("Total size: " + sizeVisitor.getTotalSize() + " MB");

        SearchVisitor searchVisitor = new SearchVisitor(".txt");
        root.accept(searchVisitor);
        System.out.println("Matched files:");
        for (File f : searchVisitor.getMatchedFiles()) {
            System.out.println("- " + f.getName());
        }
    }
}

