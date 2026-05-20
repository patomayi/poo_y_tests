class Post1 {
    String user;
    String content;
    int favs;
    int retweets;

    // escriu el codi aqui
    // Constructor de la clase Post
    public Post1(String user, String content, int favs, int retweets) {
        this.user = user;
        this.content = content;
        this.favs = favs;
        this.retweets = retweets;
    }
}

public class Solution2 {
    public static void main(String[] args) {
        Post1 post1 = new Post1("@realdonaltrump", "Make America Great Again #MAGA", 10000000, 2000000);
        Post1 post12 = new Post1("@realdonaltrump", "You are fake news", 325646, 5986587);
        Post1 post13 = new Post1("@realdonaltrump", "Global warming is a HOAX", 1000, 200);

        String format = "------------------------------------\n| %-32s |\n| %-32s |\n| <3 %-12d   & %-12d |\n------------------------------------\n";
        System.out.format(format, post1.user, post1.content, post1.retweets, post1.favs);
        System.out.format(format, post12.user, post12.content, post12.retweets, post12.favs);
        System.out.format(format, post13.user, post13.content, post13.retweets, post13.favs);
    }
}