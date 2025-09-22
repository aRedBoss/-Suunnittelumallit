package visitor;

import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private String searchPattern;
    private List<File> matchedFiles;

    public SearchVisitor(String searchPattern) {
        this.searchPattern = searchPattern;
        this.matchedFiles = new ArrayList<>();
    }

    public List<File> getMatchedFiles() {
        return matchedFiles;
    }

    @Override
    public void visit(File file) {
        if (file.getName().contains(searchPattern)) {
            matchedFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
    }
}

