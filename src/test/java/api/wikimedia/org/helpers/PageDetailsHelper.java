package api.wikimedia.org.helpers;

public class PageDetailsHelper {

    /**
     * Return Page Key for a provided Page Title
     *
     * @param title - title as a String
     * @return - page key as a String
     */
    public static String getPageKeyFromTitle(String title) {
        String[] titleSplit = title.split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < titleSplit.length - 1; i++) {
            sb.append(titleSplit[i]);
            sb.append("_");
        }
        String pageKey = sb.toString();

        return pageKey.concat(titleSplit[titleSplit.length - 1]);
    }
}
