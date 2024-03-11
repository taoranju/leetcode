public class StringCode {

    /**
     * 可以使用双指针
     * @param title
     * @return
     */
    public String capitalizeTitle(String title) {
        String[] splits = title.split(" ");
        StringBuilder res = new StringBuilder();
        for (String s : splits) {
            if (s.length() >= 3) {
                String pre = s.substring(0, 1).toUpperCase();
                String end = s.substring(1, s.length()).toLowerCase();
                res.append(pre).append(end).append(" ");
            } else {
                res.append(s.toLowerCase()).append(" ");
            }
        }
        return res.toString().trim();
    }


}
