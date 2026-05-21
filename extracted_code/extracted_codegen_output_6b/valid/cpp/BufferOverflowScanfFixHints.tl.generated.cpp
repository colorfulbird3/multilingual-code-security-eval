import java.util.*;

public class ChapterManager {
    private Map<String, List<String>> chapterMap;

    public ChapterManager() {
        chapterMap = new HashMap<>();
    }

    public void addChapter(String chapter, String content) {
        chapterMap.computeIfAbsent(chapter, k -> new ArrayList<>()).add(content);
    }

    public List<String> getChapter(String chapter) {
        return chapterMap.getOrDefault(chapter, new ArrayList<>());
    }

    public Map<String, List<String>> getAllChapters() {
        return new HashMap<>(chapterMap);
    }

    public boolean removeChapter(String chapter) {
        return chapterMap.remove(chapter) != null;
    }

    public int getTotalChapters() {
        return chapterMap.size();
    }

    public static void main(String[] args) {
        ChapterManager manager = new ChapterManager();
        manager.addChapter("Introduction", "This is the introduction.");
        manager.addChapter("Chapter 1", "Content of chapter 1.");
        manager.addChapter("Chapter 2", "Content of chapter 2.");

        System.out.println("All chapters: " + manager.getAllChapters());
        System.out.println("Introduction: " + manager.getChapter("Introduction"));
        System.out.println("Total chapters: " + manager.getTotalChapters());

        manager.removeChapter("Chapter 1");
        System.out.println("After removal: " + manager.getAllChapters());
    }
}