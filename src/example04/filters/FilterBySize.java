package example04.filters;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;

public class FilterBySize implements DirectoryStream.Filter<Path> {
    private long size;

    public FilterBySize(long size) {
        this.size = size;
    }

    @Override
    public boolean accept(Path path) throws IOException {
        return path.toFile().length() < size;
    }
}
