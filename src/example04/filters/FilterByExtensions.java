package example04.filters;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import java.util.Set;

public class FilterByExtensions implements DirectoryStream.Filter<Path> {

    private Set<String> extensions;

    public FilterByExtensions(String... extensions) {
        this.extensions = Set.of(extensions);
    }

    @Override
    public boolean accept(Path path) throws IOException {
        String filename = path.getFileName().toString();
        int indexOfDot = filename.indexOf(".");
        if (indexOfDot < 0)
            return false;

        String extension = filename.substring(indexOfDot+1);
        return extensions.contains(extension);
    }
}
