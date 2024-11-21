package WordCounterPlus;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

public class Seacher implements FileVisitor {
    private final PathMatcher matcher;
    private ArrayList<String> filePaths = new ArrayList<>();

    public Seacher(String ext){
        matcher = FileSystems.getDefault().getPathMatcher("glob:" +ext);
    }

    public void judgeFile(@NotNull Path file) throws IOException{
        Path name = file.getFileName();
        if(name!=null && matcher.matches(name)){
            filePaths.add(file.toRealPath().toString());
        }
    }

    @Override
    public @NotNull FileVisitResult postVisitDirectory(Object dir, @Nullable IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Object dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
        judgeFile((Path) file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Object file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    public ArrayList<String> getFilePaths(){
        return filePaths;
    }
}
